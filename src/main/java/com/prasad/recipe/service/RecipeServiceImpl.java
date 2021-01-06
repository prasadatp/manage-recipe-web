/**
 * 
 */
package com.prasad.recipe.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.prasad.recipe.exception.RecipeNotFoundException;
import com.prasad.recipe.model.Recipe;
import com.prasad.recipe.repository.RecipeRepository;

/**
 * @author pnakkala
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	private static final Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);

	@Autowired
	RecipeRepository repository;

	@Override
	public Recipe save(Recipe recipe) {
		log.debug("inside save method:");
		recipe.setUserName(getLoggedInUserName());
		return repository.save(recipe);
	}

	@Override
	public Recipe update(Recipe recipe) {
		log.debug("inside update method:");
		this.getById(recipe.getId());
		recipe.setUserName(getLoggedInUserName());
		return this.save(recipe);

	}

	@Override
	public String deleteById(Integer id) {
		log.debug("inside delete method:");
		this.getById(id);
		repository.deleteById(id);
		return "Recipe deleted";
	}

	@Override
	public List<Recipe> findAll() {
		log.debug("inside findAll method:");
		return repository.findAll();
	}

	@Override
	public Recipe getById(Integer id) {
		log.debug("inside getById method:");
		Optional<Recipe> optionalRecipe = repository.findById(id);
		if (optionalRecipe.isPresent()) {
			return optionalRecipe.get();
		} else {
			throw new RecipeNotFoundException("Recipe not fond by given ID: " + id);
		}

	}

	@Override
	public List<Recipe> findByUserName(String userName) {
		log.debug("inside findByUserName method:");
		return repository.findByUserName(userName);
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
