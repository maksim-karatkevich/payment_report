package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.handler.ResultHandler;

/**
  Created by Maksim on 10/31/2017.
 */
public class AbstractDAO {

	private DBConnector connector = new DBConnector();
	private Connection connection;
	private PreparedStatement prepStmt = null;

	public <T> T getEntity(String query, List<Object> parameters, ResultHandler handler) {
		List<T> entityList = this.getEntityList(query, parameters, handler);
		int size = entityList.size();
		if (size == 0) {
			throw new IllegalStateException("No any matches");
		}
		if (size > 1) {
			throw new IllegalStateException(String.format("Entity not unique. Entity count : %s", size));
		}
		return entityList.get(0);
	}

	public <T> List<T> getEntityList(String query, List<Object> parameters, ResultHandler handler) {

		List<T> entities = new ArrayList<T>();
		connection = connector.getConnection();
		ResultSet resultSet = executeSelect(query, parameters);
		try {
			while (resultSet.next()) {
				T entity = (T) handler.handle(resultSet);
				entities.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return entities;
	}

	private int updateEntity(String query, List<Object> parameters) {
		connection = connector.getConnection();
		int result = 0;
		try {
			prepStmt = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (prepStmt != null) {
			setQueryParameters(prepStmt, parameters);
			try {
				result = prepStmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	int insertEntity(String query, List<Object> parameters) {
		return updateEntity(query, parameters);
	}

	private ResultSet executeSelect(String query, List<Object> parameters) {

		ResultSet resultSet = null;
		try {
			prepStmt = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (prepStmt != null) {
			setQueryParameters(prepStmt, parameters);
			try {
				resultSet = prepStmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}

	private void setQueryParameters(PreparedStatement prepStmt, List<Object> parameters) {
		for (int i = 0; i < parameters.size(); i++) {
			try {
				Object param = parameters.get(i);
				prepStmt.setObject(i + 1, param);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

