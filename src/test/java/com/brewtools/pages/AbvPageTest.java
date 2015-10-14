package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbvPageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        getTester().startPage(AbvPage.class);
    }

    @Test
    public void renders() throws Exception {
        getTester().assertRenderedPage(AbvPage.class);
    }

    @Test
    public void submit_called_when_fields_are_filled_in() throws Exception {
        FormTester form = getTester().newFormTester("form");
        form.setValue("og:input", "1.055");
        form.setValue("fg:input", "1.010");
        form.submit();

        getTester().assertNoErrorMessage();
    }
}