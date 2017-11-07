package dao;

import model.Event;
import model.Shop;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Maksim on 10/31/2017.
 */
public class EventDaoImpl extends AbstractDAO implements DBDao {

    public void create(Object o) {
        Event event = (Event) o;
        Date eventDate = event.getDate();
        double sum = event.getSum();
        long shopId = event.getShop().getId();
        java.sql.Date date = new java.sql.Date(eventDate.getTime());
        String paymentCategory = event.getPaymentCategory();
        try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("INSERT INTO event(date,sum,payment_category,shop_id) VALUES (?,?,?,(SELECT id FROM shop WHERE id = ?))");
            preparedStatement.setDate(1, date);
            preparedStatement.setDouble(2, sum);
            preparedStatement.setString(3, paymentCategory);
            preparedStatement.setLong(4, shopId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event get(Object o) {
        return null;
    }

    public void update(Object o) {

    }

    public void remove(Object o) {

    }
}
