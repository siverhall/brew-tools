package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartPageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        getTester().startPage(StartPage.class);
    }

    @Test
    public void page_renders() throws Exception {
        pageRenders(StartPage.class);
    }

    @Test
    public void link_to_mash_page_in_navigation() throws Exception {
        getTester().assertBookmarkablePageLink("mashLink", MashingPage.class, new PageParameters());
    }
}