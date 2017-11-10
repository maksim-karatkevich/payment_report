package dao;

import java.util.ArrayList;
import java.util.List;

import dao.handler.EventResultHandlerImpl;
import model.Event;

/**
 * Created by Maksim on 10/31/2017.
 */
public class EventDAOImpl extends AbstractDAO {
    private EventResultHandlerImpl eventResultHandler = new EventResultHandlerImpl();

    public int persist(Event event) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(new java.sql.Date(event.getDate().getTime()));
        parameters.add(event.getSum());
        parameters.add(event.getCategory().getId());
        parameters.add(event.getShop().getId());
        String query = "INSERT INTO event(date,sum,category_id,shop_id) VALUES (?,?,(SELECT id FROM category WHERE id = ?),(SELECT id FROM shop WHERE id = ?))";
        return insertEntity(query, parameters);
    }
    public Event findById(long id) {
        String query = "SELECT event.id, event.date, event.sum, event.shop_id, shop.name, event.category_id, category.name FROM event inner join category on event.category_id=category.id inner join shop on event.shop_id=shop.id WHERE event.id = ?";
        return find(id, query);
    }

    public Event findByDate(String date) {
        String query = "SELECT event.id, event.date, event.sum, event.shop_id, shop.name, event.category_id, category.name FROM event inner join category on event.category_id=category.id inner join shop on event.shop_id=shop.id WHERE event.date = ?";
        return find(date, query);
    }

    public List<Event> findByPeriod(String start, String end) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(start);
        parameters.add(end);
        String query = "SELECT event.id, event.date, event.sum, event.shop_id, shop.name, event.category_id, category.name FROM event inner join category on event.category_id=category.id inner join shop on event.shop_id=shop.id WHERE date between ? AND ?";
        return getEntityList(query, parameters, eventResultHandler);
    }

    public int setComment(String comment, long id) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(comment);
		parameters.add(id);
		String query = "UPDATE event SET comments=? WHERE id=?";
		return insertEntity(query, parameters);
	}

    private Event find(Object parameter, String query) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(parameter);
        return getEntity(query, parameters, eventResultHandler);
    }

}
