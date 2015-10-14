package com.brewtools.modules;

import com.brewtools.BrewApplication;
import com.google.inject.servlet.ServletModule;
import org.apache.wicket.protocol.http.WebApplication;

public class BrewToolsModule extends ServletModule {

    @Override
    protected void configureServlets() {

        bind(WebApplication.class).to(BrewApplication.class);
    }
}
