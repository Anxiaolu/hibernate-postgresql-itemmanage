package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "Item")
@SessionScoped

public class Item implements Serializable {

	private int id;
	private int parent_id;

	private String name;
	private int total;
	private int stock;

	public Item() {
	}

	public Item(int parent_id, String name, int total, int stock) {
		super();
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

	public void saveItem() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		SessionFactory factory = config.buildSessionFactory();
		Session session = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			Item item = new Item(this.getParent_id(), this.getName(), this.getTotal(), this.getStock());
			session.persist(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}
	}

}
