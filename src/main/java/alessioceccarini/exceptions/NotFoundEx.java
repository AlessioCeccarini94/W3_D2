package alessioceccarini.exceptions;

public class NotFoundEx extends RuntimeException {
	public NotFoundEx(long id) {
		super("L'evento " + id + " non è stato trovato");
	}
}
