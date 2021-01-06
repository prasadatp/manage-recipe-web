package com.prasad.recipe.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prasad.recipe.model.Recipe;
import com.prasad.recipe.service.RecipeService;
import com.prasad.recipe.util.RecipeUtil;
import com.prasad.recipe.web.dto.RecipeDTO;

@Controller
public class WebController {

	private static final Logger log = LoggerFactory.getLogger(WebController.class);
	@Autowired
	RecipeService service;
	private String recipe = "recipe";
	private String redirectToRecipesListPage="redirect:/recipes-list";

	@GetMapping(value = "/recipes-list")
	public String showRecipes(ModelMap modelMap) {
		String userName = getLoggedInUserName();
		List<Recipe> listOfRecipes = service.findByUserName(userName);
		List<RecipeDTO> listOfRecipesWithDTOs = RecipeUtil.createRecipesDTOsListFromRecipes(listOfRecipes);
		modelMap.put("recipes", listOfRecipesWithDTOs);
		modelMap.put("userName", getLoggedInUserName());

		return "recipes-list";
	}

	@GetMapping(value = "/add-recipe")
	public String showAddRecipePage(ModelMap modelMap) {
		modelMap.put(recipe, new RecipeDTO());
		return recipe;
	}

	@PostMapping(value = "/add-recipe")
	public String addRecipe(ModelMap modelMap, @Valid RecipeDTO recipeDTO, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}

		service.save(RecipeUtil.createRecipeFromRecipeDTO(recipeDTO));
		return redirectToRecipesListPage;
	}

	@GetMapping(value = "/update-recipe")
	public String showUpdateRecipePage(@RequestParam int id, ModelMap model) {
		model.put(recipe, service.getById(id));
		return recipe;
	}

	@PostMapping(value = "/update-recipe")
	public String updateRecipe(ModelMap model, @Valid RecipeDTO recipeDTO, BindingResult result) {
		if (result.hasErrors()) {
			return recipe;
		}
		service.update(RecipeUtil.createRecipeFromRecipeDTO(recipeDTO));
		return redirectToRecipesListPage;
	}

	@GetMapping(value = "/delete-recipe")
	public String deleteRecipe(@RequestParam int id) {
		service.deleteById(id);
		return redirectToRecipesListPage;
	}

	private String getLoggedInUserName() {
		log.info("insied getLoggedInUserName");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

}
