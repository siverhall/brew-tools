package com.brewtools.services.repos;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaltRepo extends JpaRepository<Malt, Long> {
    List<Malt> findByRecipe(Recipe recipe);
}
