package com.prasad.recipe.exception;

public class RecipeNotFoundException extends RuntimeException {

	/* The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new recipe not found exception.
	 *
	 * @param message the message
	 */
	public RecipeNotFoundException(String message) {
		super(message);
	}
}
