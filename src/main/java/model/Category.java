package model;

/**
 * Created by Maksim on 11/9/2017.
 */
public class Category {

	private long id;
	private String name;

	public Category() {
	}

	public Category(long id, String name) {
		this(name);
		this.id = id;
	}

	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
