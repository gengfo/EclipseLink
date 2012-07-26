package gengfo.eclipselink;

import gengfo.eclipselink.model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.UnitOfWork;

public class SessionEventTest {
	
	
	public static void main(String args[]){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(TodoTest.PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		Session session = ((JpaEntityManager) em.getDelegate()).getSession();

		UnitOfWork uow = session.acquireUnitOfWork();
		uow.beginEarlyTransaction();
		
		Todo todo = new Todo();
		todo.setSummary("abc");
		Todo todoClone = (Todo) uow.registerObject(todo);
		todoClone.setDescription("hello");
		
		
		uow.commit();
		
		System.out.println("Done");
		
	}

}
