package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Before;
import org.junit.Test;

public class EditRecipePageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        PageParameters parameters = new PageParameters();
        parameters.add("recipe", 1L);
        getTester().startPage(EditRecipePage.class, parameters);
    }

    @Test
    public void renders() throws Exception {
        getTester().assertRenderedPage(EditRecipePage.class);

    }
}