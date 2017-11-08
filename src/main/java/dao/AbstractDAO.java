package dao;

import java.sql.*;
import java.util.List;

/**
 * Created by Maksim on 10/31/2017.
 */
public class AbstractDAO {

    private DBConnector connector = new DBConnector();
    private Connection connection;
    private PreparedStatement prepStmt = null;

    private ResultSet executeQuery(String query, List<Object> parameters)  {
        ResultSet resultSet = null;
        try {
            prepStmt = connector.getConnection().prepareStatement(query);
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
//        return getPrepareStatement().executeQuery();
    }

    protected boolean execute(String query) throws SQLException {
        return getPrepareStatement().execute(query);
    }

    protected int executeUpdate(String query) throws SQLException {
        return getPrepareStatement().executeUpdate();
    }

    private void setQueryParameters(PreparedStatement prepStmt, List<Object> parameters) {
            for (int i = 0; i < parameters.size(); i++) {
                try {
                    Object param = parameters.get(i);
                    prepStmt.setObject(i + 1, param);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}

