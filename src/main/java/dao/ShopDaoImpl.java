package dao;

import model.Event;
import model.Shop;
import sun.swing.BakedArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by Maksim on 10/31/2017.
 */
public class ShopDaoImpl extends AbstractDAO implements DBDao {

    public void create(Object o) {
        Shop shop = (Shop) o;
        String name = shop.getName();
        List<Object> parameters = new BakedArrayList()
        try {
            execute("INSERT INTO shop (name) SELECT ? WHERE NOT EXISTS (SELECT * FROM shop WHERE name = ?))");
//            PreparedStatement preparedStatement = getConnection()
//                    .prepareStatement("INSERT INTO shop (name) SELECT ? WHERE NOT EXISTS (SELECT * FROM shop WHERE name = ?)");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, name);
//            preparedStatement.execute();
            System.out.println();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Shop get(Object o) {
        String name = (String) o;
        long id = -1;
        try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("SELECT id FROM shop WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Shop(name, id);
    }

    public void update(Object o) {
//        todo: not needed yet
    }

    public void remove(Object o) {
//        todo: not needed yet
    }


}
