package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientPageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        getTester().startPage(IngredientPage.class);
    }

    @Test
    public void renders() throws Exception {
        getTester().assertRenderedPage(IngredientPage.class);
    }
}