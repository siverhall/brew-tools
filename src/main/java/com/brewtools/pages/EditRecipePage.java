package com.brewtools.pages;

import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.RecipeService;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import javax.inject.Inject;

public class EditRecipePage extends BasePage {

    @Inject
    private RecipeService recipeService;

    public EditRecipePage(PageParameters parameters) {
        super(parameters);
        StringValue param = parameters.get("recipe");
        if (param.isNull()) {
            throw new RestartResponseException(RecipeStartPage.class);
        }
        add(new FeedbackPanel("feedback"));
        add(new RecipeForm("form", getRecipe(param)));
    }

    private LoadableDetachableModel<Recipe> getRecipe(StringValue param) {
        return new LoadableDetachableModel<Recipe>() {
            @Override
            protected Recipe load() {
                return recipeService.load(param.toLongObject());
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

        @Override
        protected void onSubmit() {
            recipeService.save(getModelObject());
            success(getString("saved"));
        }
    }
}
