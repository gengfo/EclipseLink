package gengfo.eclipselink;

import gengfo.eclipselink.model.Todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.TestCase;

public class TodoTest extends TestCase {

	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;

	public void testTodo() {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
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
