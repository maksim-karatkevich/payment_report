package dao;

import model.Event;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maksim on 10/31/2017.
 */
public class EventDaoImpl extends MysqlExecutor implements DBDao {

    public void create(Object o) {
        Event event = (Event) o;
        String date = event.getDate().toString();
        String sum;
        try {
            preparedStatement.executeQuery("INSERT INTO event(date,sum,)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Object o) {

    }

    public void remove(Object o) {

    }
}
