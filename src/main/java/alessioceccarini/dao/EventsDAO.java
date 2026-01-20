package alessioceccarini.dao;

import alessioceccarini.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {
	private final EntityManager entityManager;

	public EventsDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//METODI
	public void save(Event newEvent) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(newEvent);
		transaction.commit();
		System.out.println("L'evento " + newEvent + " è stato aggiunjto");
	}
}
