package dao.handler;

import model.Category;
import model.Shop;
import sun.plugin2.main.server.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maksim on 11/9/2017.
 */
public class CategoryResultHandlerImpl implements ResultHandler {

    public Object handle(ResultSet t) throws SQLException {
        Category shop = new Category();
        shop.setId(t.getLong(1));
        shop.setName(t.getString(2));
        return shop;
    }
}
