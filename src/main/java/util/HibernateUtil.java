package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		sessionFactory = config.buildSessionFactory();
	}

	// 获取sessionFactory
	public static SessionFactory getsessionFactionary() {
		return sessionFactory;
	}

	// 获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	// 关闭Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
