package demo.test1.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class PrescriptionDao {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public PrescriptionDao() {
		
	}
	public static void create(Prescription obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	public static List<Prescription> display(){
		String query = "select e from Prescription e";
		List<Prescription> pres = null;
		
		try(Session session = getSessionFactory().openSession()){
			Query<Prescription> q = session.createQuery(query,Prescription.class);
			pres = q.getResultList();
		}
		return pres;
	}
	public static void delete(int id) {
		
		try(Session session = getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.delete(session.get(Prescription.class, id));
			session.getTransaction().commit();
		}
	}
	
	public static void update(int id) {
		try(Session session = getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.update(session.get(Prescription.class, id));
			session.getTransaction().commit();
		}
	}
	/*public static void tblUpdate(int id,String newEm) {
		String query = "update Prescription e set e.patientEmail = :newEm where e.patientName = :nm";
		try(Session session = getSessionFactory().openSession()){
			Query q = session.createQuery(query);
			session.getTransaction().begin();
			q.setParameter("newEm", newEm);
			q.setParameter("nm", id);
			System.out.println(q.executeUpdate());
			session.getTransaction().commit();
		}
	}*/

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}