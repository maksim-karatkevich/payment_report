import dao.CategoryDAOImpl;
import dao.EventDAOImpl;
import dao.ShopDAOImpl;
import model.Event;
import model.Shop;
import org.testng.Assert;
import org.testng.annotations.Test;

import model.Category;

import java.util.Date;

/**
 * Created by Maksim on 10/31/2017.
 */
public class MainTest {

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
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Category category = new Category("Other", min + (int) (Math.random() * ((max - min) + 1)));
        int res = CategoryDAO.persist(category);
        Assert.assertEquals(11, res);
    }

    @Test
    public void persistEventTest() {
        ShopDAOImpl shopDAO = new ShopDAOImpl();
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        EventDAOImpl eventDAO = new EventDAOImpl();
        Shop shop = shopDAO.findByName("Aliexpress");
        Category category = categoryDAO.findByName("Other");
        Event event = new Event(shop, category, 2.2, new Date());
    }

}
