package model;

/**
 * Created by Maksim on 10/31/2017.
 */
public class Shop {

    private String name;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Shop() {
    }

    public Shop(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
