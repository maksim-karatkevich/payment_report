import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.CategoryDAOImpl;
import dao.EventDAOImpl;
import dao.ShopDAOImpl;
import model.Category;
import model.Event;
import model.Shop;

/**
 * Created by Maksim on 10/31/2017.
 */
public class DAOTest {

	@Test
	public void getEntityByNameTest() {
		CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();
		String name = "Food";
		Category Category = CategoryDAO.findByName(name);
		Assert.assertNotNull(Category);
	}

	@Test
	public void getEntityByIdTest() {
		CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();
		long id = 1;
		Category Category = CategoryDAO.findById(id);
		Assert.assertNotNull(Category);
	}

	@Test
	public void persistCategoryTest() {
		CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();
		Category category = new Category("Food");
		int res = CategoryDAO.persist(category);
	}

	@Test
	public void persistShopTest() {
		ShopDAOImpl CategoryDAO = new ShopDAOImpl();
		Shop shop = new Shop("Krasavik Cafe");
		int res = CategoryDAO.persist(shop);
	}

	@Test
	public void persistEventTest() throws ParseException {
		ShopDAOImpl shopDAO = new ShopDAOImpl();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = simpleDateFormat.parse("9.11.2017");
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
		EventDAOImpl eventDAO = new EventDAOImpl();
		Shop shop = shopDAO.findByName("Krasavik Cafe");
		Category category = categoryDAO.findByName("Food");
		Event event = new Event(shop, category, 40, date);
		eventDAO.persist(event);
	}

	@Test
	public void findEventTest() {
		EventDAOImpl eventDAO = new EventDAOImpl();
		Event event = eventDAO.findByDate("2017-11-10");
		Assert.assertNotNull(event);
	}

	@Test
	public void findEventByPeriodTest() {
		EventDAOImpl eventDAO = new EventDAOImpl();
		List<Event> event = eventDAO.findByPeriod("01.11.2017","30.11.2017");
	}

	@Test
	public void setCommentTest() {
		EventDAOImpl eventDAO = new EventDAOImpl();
		eventDAO.setComment("Another Test Comment", 3);
	}
}
