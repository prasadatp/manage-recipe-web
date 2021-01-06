package com.prasad.recipe.web.dto;

import java.util.Date;

public class RecipeDTO {
	private Integer id;
	private String name;
	private boolean veg;
	private Date creationDate;
	private Integer suitableForNoOfPeople;
	private String ingredientsList;	
	private String cookingInstructions;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the veg
	 */
	public boolean isVeg() {
		return veg;
	}
	/**
	 * @param veg the veg to set
	 */
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the suitableForNoOfPeople
	 */
	public Integer getSuitableForNoOfPeople() {
		return suitableForNoOfPeople;
	}
	/**
	 * @param suitableForNoOfPeople the suitableForNoOfPeople to set
	 */
	public void setSuitableForNoOfPeople(Integer suitableForNoOfPeople) {
		this.suitableForNoOfPeople = suitableForNoOfPeople;
	}
	/**
	 * @return the ingredientsList
	 */
	public String getIngredientsList() {
		return ingredientsList;
	}
	/**
	 * @param ingredientsList the ingredientsList to set
	 */
	public void setIngredientsList(String ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	/**
	 * @return the cookingInstructions
	 */
	public String getCookingInstructions() {
		return cookingInstructions;
	}
	/**
	 * @param cookingInstructions the cookingInstructions to set
	 */
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}
	@Override
	public String toString() {
		return String.format(
				"RecipeDTO [id=%s, name=%s, veg=%s, creationDate=%s, suitableForNoOfPeople=%s, ingredientsList=%s, cookingInstructions=%s]",
				id, name, veg, creationDate, suitableForNoOfPeople, ingredientsList, cookingInstructions);
	}


}
