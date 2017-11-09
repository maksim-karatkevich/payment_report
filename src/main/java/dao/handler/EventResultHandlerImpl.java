package dao.handler;

import model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maksim on 11/9/2017.
 */
public class EventResultHandlerImpl implements ResultHandler <Event> {

    public Event handle(ResultSet t) throws SQLException {
        Event event = new Event();
        event.setId(t.getLong(1));
        event.setDate(t.getDate(2));
        event.setSum(t.getDouble(3));




        return null;
    }
}
