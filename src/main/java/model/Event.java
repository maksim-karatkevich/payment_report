package model;

import java.util.Date;

/**
 * Created by Maksim on 10/31/2017.
 */
public class Event {

	private long id;
	private double sum;
	private Date date;
	private Shop shop;
	private Category category;

	private String comment;

	public Event() {
	}

	public Event(Shop shop, Category category, double sum, Date date) {
		this.sum = sum;
		this.date = date;
		this.shop = shop;
		this.category = category;
	}

	public Event(Shop shop, Category category, double sum, Date date, String comment) {
		this(shop, category, sum, date);
		this.comment = comment;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
