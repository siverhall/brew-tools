package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewRecipePageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        getTester().startPage(NewRecipePage.class);
    }

    @Test
    public void renders() throws Exception {
        getTester().assertRenderedPage(NewRecipePage.class);

    }
}