package service;

import dao.ShopDaoImpl;
import model.Event;

/**
 * Created by Maksim on 11/1/2017.
 */
public class EnventService {
    ShopDaoImpl shopDao = new ShopDaoImpl();


    public void saveEvent(Event event) {
        shopDao.persist(event.getShop());
    }

    public Event getEvent(int id) {

        return null;
    }

    public void updateEvent(Event event) {

    }
}
