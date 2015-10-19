package com.brewtools.pages;

import com.brewtools.dataobjects.Recipe;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class NewRecipePage extends BasePage {

    public NewRecipePage(PageParameters parameters) {
        super(parameters);

        add(new RecipeForm("form", getRecipe()));
    }

    private LoadableDetachableModel<Recipe> getRecipe() {
        return new LoadableDetachableModel<Recipe>() {
            @Override
            protected Recipe load() {
                return new Recipe();
            }
        };
    }

    private class RecipeForm extends Form<Recipe> {
        public RecipeForm(String id, IModel<Recipe> model) {
            super(id, model);

            add(new RequiredTextField<>("name", new PropertyModel<>(getModel(), "name")));
            add(new TextArea<>("description", new PropertyModel<>(getModel(), "description")));
            add(new TextField<>("batchSize", new PropertyModel<>(getModel(), "batchSize"), Double.class));
            add(new TextField<>("preboilSize", new PropertyModel<>(getModel(), "preboilSize"), Double.class));
            add(new TextField<>("boilTime", new PropertyModel<>(getModel(), "boilTime"), Integer.class));
        }
    }
}
