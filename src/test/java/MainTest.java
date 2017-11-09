import org.testng.Assert;
import org.testng.annotations.Test;

import dao.ShopDaoImpl;
import model.Shop;

/**
 * Created by Maksim on 10/31/2017.
 */
public class MainTest {

    @Test
    public void getEntityByNameTest() {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        String name = "Aliexpress";
        Shop shop = shopDao.findByName(name);
        Assert.assertNotNull(shop);
    }

    @Test
    public void getEntityByIdTest() {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        long id = 1;
        Shop shop = shopDao.findById(id);
        Assert.assertNotNull(shop);
    }

    @Test
    public void persistShopTest() {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Shop shop = new Shop("Aliexpress", min + (int)(Math.random() * ((max - min) + 1)));
        int res = shopDao.persist(shop);
        Assert.assertEquals(1, res);
    }
}
