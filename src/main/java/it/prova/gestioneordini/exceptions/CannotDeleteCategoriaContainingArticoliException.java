package it.prova.gestioneordini.exceptions;

public class CannotDeleteCategoriaContainingArticoliException extends RuntimeException {

	public CannotDeleteCategoriaContainingArticoliException() {
		super();
		
	}

	public CannotDeleteCategoriaContainingArticoliException(String message) {
		super(message);
		
	}
	
}
