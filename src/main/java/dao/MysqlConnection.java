package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


/**
 * Created by Maksim on 10/31/2017.
 */
public class MysqlConnection {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop";
    private static final String ID = "root";
    private static final String PASS = "root";
    protected PreparedStatement preparedStatement;


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getPrepareStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
