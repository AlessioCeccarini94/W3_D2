package alessioceccarini;

import alessioceccarini.dao.EventsDAO;
import alessioceccarini.entities.Event;
import alessioceccarini.entities.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
	private static final EntityManagerFactory entityManagerFactory =
			Persistence.createEntityManagerFactory("eventmanagementpu");

	public static void main(String[] args) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EventsDAO ed = new EventsDAO(entityManager);

		Event wedding = new Event
				("Wedding", LocalDate.of(2026, 10, 15), EventType.PRIVATO, 120);


		Event birthday = new Event
				("Birthday", LocalDate.of(2026, 7, 10), EventType.PRIVATO, 120);


		Event footballGame = new Event
				("Roma-Stoccarda", LocalDate.of(2026, 1, 22), EventType.PUBBLICO, 50000);


		Event skyDay = new Event
				("Sky Party", LocalDate.of(2026, 2, 3), EventType.PUBBLICO, 400);


		ed.save(wedding);
		ed.save(birthday);
		ed.save(footballGame);
		ed.save(skyDay);
	}
}
