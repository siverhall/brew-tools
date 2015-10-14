package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class MashingPageTest extends BaseTest {

    private MashingPage page;

    @Before
    public void setUp() throws Exception {
        page = getTester().startPage(MashingPage.class);

    }

    @Test
    public void renders() throws Exception {
        pageRenders(MashingPage.class);
    }

    @Test
    public void form_requires_grain_weight() throws Exception {
        submitForm("", "0");
        getTester().assertContains(page.getString("grainWeight.Required"));
    }

    @Test
    public void form_required_preboil_volume() throws Exception {
        submitForm("0", "");
        getTester().assertContains(page.getString("preboilVol.Required"));
    }

    @Test
    public void form_fields_require_number_inputs() throws Exception {
        submitForm("error", "error");
        getTester().assertContains(page.getString("grainWeight.IConverter.Double"));
        getTester().assertContains(page.getString("preboilVol.IConverter.Double"));
    }

    private void submitForm(String grain, String preboil) {
        FormTester form = getTester().newFormTester("form");
        form.setValue("grainWeight", grain);
        form.setValue("preboilVol", preboil);
        form.submit();
    }
}