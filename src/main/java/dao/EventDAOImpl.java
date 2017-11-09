package dao;

import dao.handler.EventResultHandlerImpl;
import model.Category;
import model.Event;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//    select event.id, event.date, event.sum, event.shop_id, shop.name, event.category_id, category.name from event join category on event.category_id=category.id inner join shop on event.shop_id=shop.id
    public Event findById(long id) {
        String query = "SELECT event.id, event.date, event.sum, event.shop_id, shop.name, event.category_id, category.name FROM event inner join category on event.category_id=category.id inner join shop on event.shop_id=shop.id";
//        String query = "SELECT * FROM Category WHERE id = ?";
        return find(id, query);
    }

    private Event find(Object parameter, String query) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(parameter);
        return getEntity(query, parameters, eventResultHandler);
    }

}
