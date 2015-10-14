package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartPageTest extends BaseTest {

    @Test
    public void page_renders() throws Exception {
        getTester().startPage(StartPage.class);
        getTester().assertRenderedPage(StartPage.class);
    }
}