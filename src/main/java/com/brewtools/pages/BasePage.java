package com.brewtools.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class BasePage extends WebPage {

    public BasePage(final PageParameters parameters) {
        super(parameters);

    }
}
