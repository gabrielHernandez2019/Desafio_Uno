package cl.previred.consultadatos.exceptions;

public class JsonException extends Exception {

	/**
	 * @author Gabriel Hernández
	 * 
	 * Clase para manejar excepciones personalizadas
	 * 
	 */
	private static final long serialVersionUID = -3217269633389402656L;

	public JsonException(String message) {
		super(message);
	}

	public JsonException(String message, Throwable e) {
		super(message, e);
	}
}