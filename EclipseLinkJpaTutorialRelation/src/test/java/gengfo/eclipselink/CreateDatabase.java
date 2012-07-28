package gengfo.eclipselink;


import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DROP_AND_CREATE;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;


public class CreateDatabase {

	public static void main(String[] args) {
		Map properties = new HashMap();

		// Add in properties to have the database re-created
		properties.put(DDL_GENERATION, DROP_AND_CREATE);
		// properties.put(TARGET_DATABASE, TargetDatabase.Oracle10);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("people", properties);

		EntityManager em = emf.createEntityManager();
		new SchemaManager(JpaHelper.getServerSession(emf)).createSequences();

		em.getTransaction().begin();

		new SamplePopulation().persistAll(em);

		em.getTransaction().commit();

		em.close();
	}
}

