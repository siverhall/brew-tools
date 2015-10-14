package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MashingPageTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        startPage(MashingPage.class);

    }

    @Test
    public void renders() throws Exception {
        pageRenders(MashingPage.class);
    }


}