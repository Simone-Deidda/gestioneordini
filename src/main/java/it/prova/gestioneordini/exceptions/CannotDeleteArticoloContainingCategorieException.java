package it.prova.gestioneordini.exceptions;

public class CannotDeleteArticoloContainingCategorieException extends RuntimeException{
	public CannotDeleteArticoloContainingCategorieException() {
		super();
		
	}

	public CannotDeleteArticoloContainingCategorieException(String message) {
		super(message);
		
	}
	
}
