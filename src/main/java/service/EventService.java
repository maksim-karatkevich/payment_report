package service;

import java.util.List;

import dao.CategoryDAOImpl;
import dao.EventDAOImpl;
import dao.ShopDAOImpl;
import model.Event;

/**
 * Created by Maksim on 11/1/2017.
 */
public class EventService {

	private ShopDAOImpl shopDao = new ShopDAOImpl();
	private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
	private EventDAOImpl eventDAO = new EventDAOImpl();

	public void saveEvent(Event event) {
		categoryDAO.persist(event.getCategory());
		long categoryId = categoryDAO.findByName(event.getCategory().getName()).getId();
		shopDao.persist(event.getShop());
		long shopId = shopDao.findByName(event.getShop().getName()).getId();
		event.getCategory().setId(categoryId);
		event.getShop().setId(shopId);
		eventDAO.persist(event);
	}

	public List<Event> getEventsByPeriod(String start, String end) {
		return eventDAO.findByPeriod(start, end);
	}

	public Event getEvent(int id) {

		return null;
	}

	public void updateEvent(Event event) {

	}
}
