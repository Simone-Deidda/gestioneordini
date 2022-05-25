package it.prova.gestioneordini.exceptions;

public class CannotDeleteOrdineContainingArticoliException extends RuntimeException{

	public CannotDeleteOrdineContainingArticoliException() {
		super();
		
	}

	public CannotDeleteOrdineContainingArticoliException(String message) {
		super(message);
		
	}

}
