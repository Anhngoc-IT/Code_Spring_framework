package VTI.Utils;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import VTI.entity.Department;
import VTI.entity.Parameters;

import org.hibernate.Session;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration conf;
	private SessionFactory sessionFactory;

	private HibernateUtils() {
		conf();
	}

	// phương thức để khi báo ra đối tượng conf
	private void conf() {

		// load conf
		conf = new Configuration();
		conf.configure("hibernate.cfg.xml");

		// add entity
		conf.addAnnotatedClass(Department.class);
		conf.addAnnotatedClass(Parameters.class);

	}

	// Phương thức này là thiết kế singleton mẫu để lấy đối tượng HibernateUtil

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	// Phương thức này có SessionFactory.
	private SessionFactory buildSessionFactory() {

		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					                         .applySettings(conf.getProperties())
					                         .build();

			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;

	}
	
	// this method closes FACTORY session
	
	public void closeFactory() {
		if(null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
	
	// Phương thức này được mở phiên từ SessionFactory.
	
	public Session openSession() {
		
		buildSessionFactory();
		
		return sessionFactory.openSession();
		
	}

}
