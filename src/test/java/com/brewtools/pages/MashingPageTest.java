package com.brewtools.pages;

import com.brewtools.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class MashingPageTest extends BaseTest {

    @Test
    public void renders() throws Exception {
        pageRenders(MashingPage.class);
    }
}