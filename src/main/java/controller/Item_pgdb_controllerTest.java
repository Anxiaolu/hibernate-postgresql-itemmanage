package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Item;

@ManagedBean(name = "ItemBean")
@ApplicationScoped
public class Item_pgdb_controllerTest {

	private SessionFactory SessionFactory;
	private Session session;
	private Transaction transaction;

	public void saveItem() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		SessionFactory factory = config.buildSessionFactory();
		Session session = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			Item item = new Item();
			item.setName("张三");
			item.setParent_id(0);
			item.setStock(50);
			item.setTotal(100);
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
