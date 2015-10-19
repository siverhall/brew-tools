package com.brewtools.services;

import com.brewtools.dataobjects.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe save(Recipe recipe);

    Recipe load(Long id);

    List<Recipe> getRecipes();
}
