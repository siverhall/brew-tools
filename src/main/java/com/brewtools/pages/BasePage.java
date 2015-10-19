package com.brewtools.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class BasePage extends WebPage {

    public BasePage(final PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink<Void>("homeLink", StartPage.class));
        add(new BookmarkablePageLink<Void>("mashLink", MashingPage.class));
        add(new BookmarkablePageLink<Void>("abvLink", AbvPage.class));
        add(new BookmarkablePageLink<Void>("recipeLink", NewRecipePage.class));

    }
}
