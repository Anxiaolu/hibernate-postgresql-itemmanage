package controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import model.Item;

public class Query_items {

	private SessionFactory SessionFactory;
	private Session session;
	private Transaction transaction;

	@Test
	public void queryitems() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from item");
		List<Item> items = query.getResultList();
		Iterator it = items.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			System.out.println(item.getName()+","+item.getStock()+","+item.getTotal());
		}
		session.getTransaction().commit();
		session.close();
	}
}
