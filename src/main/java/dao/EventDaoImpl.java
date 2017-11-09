package dao;

/**
 * Created by Maksim on 10/31/2017.
 */
public class EventDaoImpl extends AbstractDAO {

    public void persist(Object o) {
//        Event event = (Event) o;
//        Date eventDate = event.getDate();
//        double sum = event.getSum();
//        long shopId = event.getShop().getId();
//        java.sql.Date date = new java.sql.Date(eventDate.getTime());
//        String paymentCategory = event.getPaymentCategory();
//        try {
//            PreparedStatement preparedStatement = getConnection()
//                    .prepareStatement("INSERT INTO event(date,sum,payment_category,shop_id) VALUES (?,?,?,(SELECT id FROM shop WHERE id = ?))");
//            preparedStatement.setDate(1, date);
//            preparedStatement.setDouble(2, sum);
//            preparedStatement.setString(3, paymentCategory);
//            preparedStatement.setLong(4, shopId);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

//    public Event find(Object o) {
//        return null;
//    }
//
//    public void update(Object o) {
//
//    }
//
//    public void remove(Object o) {
//
//    }
}
