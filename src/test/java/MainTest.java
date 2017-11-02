import dao.EventDaoImpl;
import dao.ShopDaoImpl;
import model.Event;
import model.Shop;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Maksim on 10/31/2017.
 */
public class MainTest {

    @Test
    public void testSomeStaff() {
        EventDaoImpl eventDao = new EventDaoImpl();
        Shop shop = new Shop("Aliexpress", 11);
        Event event = new Event(1.1, new Date(), shop, "payment");
        eventDao.create(event);

    }
}
