package com.brewtools.modules;

import com.brewtools.BrewApplication;
import com.brewtools.services.*;
import com.google.inject.servlet.ServletModule;
import org.apache.wicket.protocol.http.WebApplication;

public class BrewToolsModule extends ServletModule {

    @Override
    protected void configureServlets() {
        install(new RepositoryModule("hibernate-manager"));

        bind(MaltService.class).to(MaltServiceImpl.class);
        bind(MaltTypeService.class).to(MaltTypeServiceImpl.class);
        bind(RecipeService.class).to(RecipeServiceImpl.class);

        bind(WebApplication.class).to(BrewApplication.class);
    }
}
