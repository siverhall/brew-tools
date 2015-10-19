package com.brewtools.modules;

import com.google.code.guice.repository.configuration.JpaRepositoryModule;
import com.google.code.guice.repository.configuration.RepositoryBinder;

public class RepositoryModule extends JpaRepositoryModule {

    public RepositoryModule() {
        super("hibernate-manager");
    }

    @Override
    protected void bindRepositories(RepositoryBinder binder) {

    }
}
