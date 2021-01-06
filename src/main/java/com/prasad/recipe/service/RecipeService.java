/**
 * 
 */
package com.prasad.recipe.service;

import java.util.List;

import com.prasad.recipe.model.Recipe;

/**
 * @author pnakkala
 *
 */
public interface RecipeService {
	public Recipe save(Recipe recipe); 
	public Recipe update(Recipe recipe);
	public String deleteById(Integer id);
	public List<Recipe> findAll(); 
	public Recipe getById(Integer id); 
	public List<Recipe> findByUserName(String userName);

}
