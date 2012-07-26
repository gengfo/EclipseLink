package gengfo.eclipselink;

import gengfo.eclipselink.model.Todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventAdapter;

public class SessionEventTest1 {
	

	public static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;
	
	public static void main(String args[]){


		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		Session mySession = ((JpaEntityManager) em.getDelegate()).getSession();
		
		SessionEventAdapter myEventListener = new SessionEventAdapter() {
		     // Listen for PostCommitUnitOfWork events
		     public void postCommitUnitOfWork(SessionEvent event) {
		         // Call the handler routine
		         System.out.println("postCommitUnitOfWork");
		     }
		     
		     public void preLogin(SessionEvent event) {
		         // Call the handler routine
		         System.out.println("preLogin");
		     }
		 };
		 
		 mySession.getEventManager().addListener(myEventListener);

		// Read the existing entries and write to console
		Query q = em.createQuery("select t from Todo t");
		List<Todo> todoList = q.getResultList();
		for (Todo todo : todoList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + todoList.size());

		// Create new todo
		em.getTransaction().begin();
		Todo todo = new Todo();
		
		todo.setSummary("f1");
		todo.setDescription("f2");
		em.persist(todo);
		em.getTransaction().commit();
		
		Query q1 = em.createQuery("select t from Todo t");
		List<Todo> todoList1 = q1.getResultList();
		for (Todo todo1 : todoList) {
			System.out.println(todo1);
		}
		System.out.println("Size: " + todoList1.size());

		em.close();
	}

}
