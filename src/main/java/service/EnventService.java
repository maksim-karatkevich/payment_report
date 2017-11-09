package service;

import dao.ShopDAOImpl;
import model.Event;

/**
 * Created by Maksim on 11/1/2017.
 */
public class EnventService {
    ShopDAOImpl shopDao = new ShopDAOImpl();


    public void saveEvent(Event event) {
        shopDao.persist(event.getShop());
    }

    public Event getEvent(int id) {

        return null;
    }

    public void updateEvent(Event event) {

    }
}
