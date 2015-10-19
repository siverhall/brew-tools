package com.brewtools.services.repos;

import com.brewtools.dataobjects.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
