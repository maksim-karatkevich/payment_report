package dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Shop;

/**
 * Created by Maksim_Karatkevich on 11/9/2017.
 */
public class ShopResultHandlerImpl implements ResultHandler {

	public Object handle(ResultSet t) throws SQLException {
		Shop shop = new Shop();
		shop.setId(t.getLong(1));
		shop.setName(t.getString(2));
		return shop;
	}
}
