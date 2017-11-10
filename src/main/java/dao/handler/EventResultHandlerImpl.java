package dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Category;
import model.Event;
import model.Shop;

/**
 * Created by Maksim on 11/9/2017.
 */
public class EventResultHandlerImpl implements ResultHandler<Event> {

	public Event handle(ResultSet t) throws SQLException {
		Event event = new Event();
		event.setId(t.getLong(1));
		event.setDate(t.getDate(2));
		event.setSum(t.getDouble(3));
		event.setShop(new Shop(t.getLong(4), t.getString(5)));
		event.setCategory(new Category(t.getLong(6), t.getString(7)));
		return event;
	}
}
