package model;

import java.io.Serializable;

public class Item implements Serializable {

	private int id;
	private int parent_id;
	private String name;
	private int total;
	private int stock;

	public Item() {

	}

	public Item(int id, int parent_id, String name, int total, int stock) {
		// super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.total = total;
		this.stock = stock;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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

}
