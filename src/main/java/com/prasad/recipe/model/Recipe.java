/**
 * 
 */
package com.prasad.recipe.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author pnakkala
 *
 */
@Entity
public class Recipe {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 5,max = 50,  message = "Enter between 5 and 50 Characters...")
	private String name;
	private boolean veg;
	private Timestamp creationTimestamp;
	@Positive(message = "Please enter positive number")
	private Integer suitableForNoOfPeople;
	@Size(min = 50,max = 250, message = "Enter between 50 and 250 Characters...")
	private String ingredientsList;
	@Size(min = 50,max = 250, message = "Enter between 50 and 250 Characters...")
	private String cookingInstructions;
	private String userName;
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
	 * @return the creationTimestamp
	 */
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}
	/**
	 * @param creationTimestamp the creationTimestamp to set
	 */
	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
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
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return String.format(
				"Recipe [id=%s, name=%s, veg=%s, creationTimestamp=%s, suitableForNoOfPeople=%s, ingredientsList=%s, cookingInstructions=%s, userName=%s]",
				id, name, veg, creationTimestamp, suitableForNoOfPeople, ingredientsList, cookingInstructions,
				userName);
	}

}
