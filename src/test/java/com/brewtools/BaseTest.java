package com.brewtools;

import com.brewtools.pages.BasePage;
import com.brewtools.services.HopSpecService;
import com.brewtools.services.MaltService;
import com.brewtools.services.MaltTypeService;
import com.brewtools.services.RecipeService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class BaseTest {

    private WicketTester tester;
    @Mock
    protected RecipeService recipeService;
    @Mock
    protected MaltService maltService;
    @Mock
    protected MaltTypeService maltTypeService;
    @Mock
    protected HopSpecService hopSpecService;

    protected final WicketTester getTester() {
        return tester;
    }

    @Before
    public void setUpApplication() throws Exception {
        final Injector injector = Guice.createInjector(new TestModule());

        BrewApplication application = new BrewApplication();
        application.getComponentInstantiationListeners().add(
                new GuiceComponentInjector(application, injector));
        tester = new WicketTester(application);
    }

    private class TestModule extends AbstractModule {


        @Override
        protected void configure() {
            bind(RecipeService.class).toInstance(recipeService);
            bind(MaltService.class).toInstance(maltService);
            bind(MaltTypeService.class).toInstance(maltTypeService);
            bind(HopSpecService.class).toInstance(hopSpecService);
        }

    }
    protected void pageRenders(Class<? extends BasePage> clazz) {
        getTester().assertRenderedPage(clazz);
    }

}
