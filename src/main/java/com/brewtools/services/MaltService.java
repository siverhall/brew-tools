package com.brewtools.services;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.Recipe;

import java.util.List;

public interface MaltService {
    void save(Malt malt);

    List<Malt> findByRecipe(Recipe recipe);

    void delete(Malt malt);
}
