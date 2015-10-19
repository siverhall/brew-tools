package com.brewtools.services;

import com.brewtools.services.repos.RecipeRepo;

import javax.inject.Inject;

public class RecipeServiceImpl implements RecipeService {

    @Inject
    private RecipeRepo repo;
}
