/**
 * 
 */
package com.prasad.recipe.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.prasad.recipe.model.Recipe;
import com.prasad.recipe.web.dto.RecipeDTO;

/**
 *
 *
 */
public class RecipeUtil {
	
	private RecipeUtil() {
		super();
	}
	public static RecipeDTO createRecipeDTOFromRecipe(Recipe recipe) {
		RecipeDTO recipeDTO = new RecipeDTO();		
		recipeDTO.setId(recipe.getId());
		recipeDTO.setName(recipe.getName());
		recipeDTO.setVeg(recipe.isVeg());
		recipeDTO.setCreationDate(new Date(recipe.getCreationTimestamp().getTime()));
		recipeDTO.setSuitableForNoOfPeople(recipe.getSuitableForNoOfPeople());
		recipeDTO.setIngredientsList(recipe.getIngredientsList());
		recipeDTO.setCookingInstructions(recipe.getCookingInstructions());
		return recipeDTO;
	}
	public static Recipe createRecipeFromRecipeDTO(RecipeDTO recipeDTO) {
		Recipe recipe = new Recipe();		
		recipe.setId(recipeDTO.getId());
		recipe.setName(recipeDTO.getName());
		recipe.setVeg(recipeDTO.isVeg());
		recipe.setCreationTimestamp(new Timestamp(System.currentTimeMillis()));
		recipe.setSuitableForNoOfPeople(recipeDTO.getSuitableForNoOfPeople());
		recipe.setIngredientsList(recipeDTO.getIngredientsList());
		recipe.setCookingInstructions(recipeDTO.getCookingInstructions());
		return recipe;
	}
	public static List<RecipeDTO> createRecipesDTOsListFromRecipes(List<Recipe> listOfRecipes) {
		List<RecipeDTO> listOfRecipesWithDTOs = new ArrayList<>();
		listOfRecipes.forEach(recipe -> {
			RecipeDTO recipeDTO = new RecipeDTO();
			recipeDTO.setId(recipe.getId());
			recipeDTO.setName(recipe.getName());
			recipeDTO.setVeg(recipe.isVeg());
			recipeDTO.setCreationDate(new Date(recipe.getCreationTimestamp().getTime()));
			recipeDTO.setSuitableForNoOfPeople(recipe.getSuitableForNoOfPeople());
			recipeDTO.setIngredientsList(recipe.getIngredientsList());
			recipeDTO.setCookingInstructions(recipe.getCookingInstructions());
			listOfRecipesWithDTOs.add(recipeDTO);
		});
		return listOfRecipesWithDTOs;
	}

}
