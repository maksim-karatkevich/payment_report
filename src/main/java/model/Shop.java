package model;

import java.util.List;

/**
 * Created by Maksim on 10/31/2017.
 */
public class Shop {

    private int id;
    private String name;
    private String paymentCategory;

    public Shop() {
    }

    public Shop(int id, String name, String paymentCategory) {
        this.id = id;
        this.name = name;
        this.paymentCategory = paymentCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }
}
