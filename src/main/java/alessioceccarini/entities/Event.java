package alessioceccarini.entities;

// Creare classe event con:
// id (long) -->PK
// titolo(string)
// data evento(LocalDate)
// tipo evento(enum)-->PUBBLICO,PRIVATO
// numeroPartecipanti(int)

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "event_date")
	private LocalDate date;
	@Column(name = "event_type")
	@Enumerated(EnumType.STRING)
	private EventType eventType;
	@Column(name = "N._of_people")
	private int numbOfPeople;

	public Event() {
	}

	public Event(String title, LocalDate date, EventType eventType, int numbOfPeople) {
		this.title = title;
		this.date = date;
		this.eventType = eventType;
		this.numbOfPeople = numbOfPeople;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public int getNumbOfPeople() {
		return numbOfPeople;
	}

	public void setNumbOfPeople(int numbOfPeople) {
		this.numbOfPeople = numbOfPeople;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", title='" + title + '\'' +
				", date=" + date +
				", eventType=" + eventType +
				", numbOfPeople=" + numbOfPeople +
				'}';
	}
}
