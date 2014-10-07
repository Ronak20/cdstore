package com.uottawa.cdstore.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration()
					.addAnnotatedClass(com.uottawa.cdstore.model.CdDrive.class)
					.addAnnotatedClass(com.uottawa.cdstore.model.Address.class)
					.addAnnotatedClass(
							com.uottawa.cdstore.model.PurchaseOrder.class)
					.addAnnotatedClass(
							com.uottawa.cdstore.model.PurchaseOrderItem.class)
					.addAnnotatedClass(
							com.uottawa.cdstore.model.PurchaseOrderItemId.class)
					.addAnnotatedClass(
							com.uottawa.cdstore.model.VisitEvent.class)
					.setProperty("hibernate.dialect",
							"org.hibernate.dialect.MySQLDialect")
					.setProperty("hibernate.connection.driver_class",
							"com.mysql.jdbc.Driver")
					.setProperty("hibernate.connection.username", "root")
					.setProperty("hibernate.connection.password", "root")
					.setProperty("hibernate.connection.pool_size", "1")
					.setProperty("hibernate.connection.url",
							"jdbc:mysql://localhost:3306/cdstore")
					.setProperty("hibernate.current_session_context_class",
							"thread")
					.setProperty("hibernate.format_sql", "true")
					.setProperty("hibernate.autoregister_listeners", "false")
					.setProperty("hibernate.show_sql", "true")
					.setProperty("hibernate.connection.autocommit", "true");

			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}