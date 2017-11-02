package model;

import java.util.Date;

/**
 * Created by Maksim on 10/31/2017.
 */
public class Event {

    private double sum;
    private Date date;
    private Shop shop;
    private String paymentCategory;
    private long id;
    public Event() {
    }

    public Event(double sum, Date date, Shop shop, String paymentCategory) {
        this.sum = sum;
        this.date = date;
        this.shop = shop;
        this.paymentCategory = paymentCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }
}
