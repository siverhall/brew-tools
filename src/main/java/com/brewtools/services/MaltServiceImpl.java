package com.brewtools.services;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.repos.MaltRepo;

import javax.inject.Inject;
import java.util.List;

public class MaltServiceImpl implements MaltService {

    @Inject
    private MaltRepo repo;

    @Override
    public void save(Malt malt) {
        if (malt.getAmount() != null && malt.getType() != null) {
            repo.save(malt);
        }
    }

    @Override
    public List<Malt> findByRecipe(Recipe recipe) {
        return repo.findByRecipe(recipe);
    }

    @Override
    public void delete(Malt malt) {
        repo.delete(malt);
    }
}
