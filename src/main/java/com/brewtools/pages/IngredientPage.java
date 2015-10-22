package com.brewtools.pages;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public class IngredientPage extends BasePage {

    public IngredientPage(PageParameters parameters) {
        super(parameters);
        add(new MaltTypePanel("adminMaltTypes"));
        add(new HopSpecPanel("adminHops"));
    }

}
