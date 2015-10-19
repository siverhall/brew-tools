package com.brewtools.pages;

import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.RecipeService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.inject.Inject;
import java.util.List;

public class RecipeStartPage extends BasePage {

    @Inject
    private RecipeService recipeService;

    public RecipeStartPage(PageParameters parameters) {
        super(parameters);

        add(new RecipeForm("form", createModel()));

        add(new ListView<Recipe>("recipeList", getRecipes()) {
            @Override
            protected void populateItem(ListItem<Recipe> item) {
                BookmarkablePageLink<Void> link = new BookmarkablePageLink<>("recipeLink",
                        EditRecipePage.class, getRecipeParam(item.getModelObject()));
                link.add(new Label("recipeName", new PropertyModel<>(item.getModel(), "name")));
                item.add(link);
            }
        });
    }

    private class RecipeForm extends Form<Recipe> {

        public RecipeForm(String id, IModel<Recipe> model) {
            super(id, model);
            add(new RequiredTextField<>("name", new PropertyModel<>(getModel(), "name")));
        }

        @Override
        protected void onSubmit() {
            Recipe recipe = recipeService.save(getModelObject());
            setResponsePage(new EditRecipePage(getRecipeParam(recipe)));
        }

    }

    private PageParameters getRecipeParam(Recipe recipe) {
        PageParameters pp = new PageParameters();
        pp.add("recipe", recipe.getId());
        return pp;
    }

    private LoadableDetachableModel<Recipe> createModel() {
        return new LoadableDetachableModel<Recipe>() {
            @Override
            protected Recipe load() {
                return new Recipe();
            }
        };
    }

    private LoadableDetachableModel<List<Recipe>> getRecipes() {
        return new LoadableDetachableModel<List<Recipe>>() {
            @Override
            protected List<Recipe> load() {
                return recipeService.getRecipes();
            }
        };
    }
}

