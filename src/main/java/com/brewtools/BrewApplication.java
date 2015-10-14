package com.brewtools;

import com.brewtools.pages.MashingPage;
import com.brewtools.pages.StartPage;
import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class BrewApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return StartPage.class;
    }

    @Override
    protected void init() {
        super.init();
        mountPage("mash", MashingPage.class);
    }

    @Override
    protected IConverterLocator newConverterLocator() {
        ConverterLocator locator = new ConverterLocator();
        locator.set(Double.class, new CustomDoubleConverter());
        return locator;
    }
}
