package com.brewtools.modules;

import com.brewtools.services.repos.MaltRepo;
import com.brewtools.services.repos.MaltTypeRepo;
import com.brewtools.services.repos.RecipeRepo;
import com.google.code.guice.repository.configuration.JpaRepositoryModule;
import com.google.code.guice.repository.configuration.RepositoryBinder;

public class RepositoryModule extends JpaRepositoryModule {

    private String persistence;

    public RepositoryModule(String persistence) {
        super(persistence);
        this.persistence = persistence;
    }

    @Override
    protected void bindRepositories(RepositoryBinder binder) {
        binder.bind(MaltRepo.class).to(persistence);
        binder.bind(MaltTypeRepo.class).to(persistence);
        binder.bind(RecipeRepo.class).to(persistence);
    }
}
