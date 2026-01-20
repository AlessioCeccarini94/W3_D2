package alessioceccarini.dao;

import alessioceccarini.entities.Event;
import alessioceccarini.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {
	private final EntityManager entityManager;

	public EventsDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//METODI:
	//1) SALVA IN DB
	public void save(Event newEvent) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(newEvent);
		transaction.commit();
		System.out.println("L'evento " + newEvent + " è stato aggiunjto");
	}

	//2) CERCA TRAMITE ID
	public Event searchByID(long eventID) {
		Event search = entityManager.find(Event.class, eventID);
		if (search == null) throw new NotFoundEx(eventID);
		return search;
	}

	//3) ELIMINARE
	public void deleteEvent(long eventId) {
		Event searched = this.searchByID(eventId);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(searched);
		transaction.commit();
		System.out.println("L'evento " + eventId + " è stato rimosso");
	}
}
