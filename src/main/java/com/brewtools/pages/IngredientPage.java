package com.brewtools.pages;

import com.brewtools.dataobjects.MaltType;
import com.brewtools.services.MaltTypeService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.inject.Inject;
import java.util.List;

public class IngredientPage extends BasePage {

    @Inject
    private MaltTypeService maltTypeService;

    public IngredientPage(PageParameters parameters) {
        super(parameters);
        add(new FeedbackPanel("feedback"));
        add(new MaltTypeForm("maltType", newMalt()));
        add(new ListView<MaltType>("currentTypes", getMaltTypes()) {
            @Override
            protected void populateItem(ListItem<MaltType> item) {
                item.add(new Label("typeName", new PropertyModel<>(item.getModel(), "name")));
            }
        });
    }

    private IModel<List<MaltType>> getMaltTypes() {
        return new LoadableDetachableModel<List<MaltType>>() {
            @Override
            protected List<MaltType> load() {
                return maltTypeService.getTypes();
            }
        };
    }

    private IModel<MaltType> newMalt() {
        return new LoadableDetachableModel<MaltType>() {
            @Override
            protected MaltType load() {
                return new MaltType();
            }
        };
    }

    private class MaltTypeForm extends Form<MaltType> {
        public MaltTypeForm(String id, IModel<MaltType> model) {
            super(id, model);
            add(new RequiredTextField<String>("name", new PropertyModel<>(getModel(), "name")));
            add(new RequiredTextField<>("potential", new PropertyModel<>(getModel(), "potential"), Integer.class));
            add(new RequiredTextField<>("lovibond", new PropertyModel<>(getModel(), "lovibond"), Double.class));
        }

        @Override
        protected void onSubmit() {
            maltTypeService.save(getModelObject());
            getModel().detach();
            success("Malt type saved!");
        }
    }
}
