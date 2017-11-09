package dao;

import java.util.ArrayList;
import java.util.List;

import dao.handler.ShopResultHandlerImpl;
import model.Shop;

/**
 * Created by Maksim on 10/31/2017.
 */
public class ShopDaoImpl extends AbstractDAO implements ShopDAO<Shop> {

	private ShopResultHandlerImpl shopResultHandler = new ShopResultHandlerImpl();

	public int persist(Shop shop) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(shop.getName());
		parameters.add(shop.getName());
		String query = "INSERT INTO shop (name) SELECT ? WHERE NOT EXISTS (SELECT * FROM shop WHERE name = ?)";
		return insertEntity(query, parameters);
	}

	public Shop findByName(String name) {
		String query = "SELECT * FROM shop WHERE name = ?";
		return find(name, query);
	}

	public Shop findById(long id) {
		String query = "SELECT * FROM shop WHERE id = ?";
		return find(id, query);
	}

	public int update(Shop o) {
		return -1;
	}

	public int remove(Shop o) {
		return -1;
	}

	private Shop find(Object parameter, String query) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(parameter);
		return getEntity(query, parameters, shopResultHandler);
	}

}
