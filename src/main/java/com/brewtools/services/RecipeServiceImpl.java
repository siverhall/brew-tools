package com.brewtools.services;

import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.repos.RecipeRepo;

import javax.inject.Inject;
import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    @Inject
    private RecipeRepo repo;

    @Override
    public Recipe save(Recipe recipe) {
        return repo.save(recipe);
    }

    @Override
    public Recipe load(Long id) {
        return repo.findOne(id);
    }

    @Override
    public List<Recipe> getRecipes() {
        return repo.findAll();
    }
}
