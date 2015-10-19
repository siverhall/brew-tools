package com.brewtools.pages;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.MaltType;
import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.MaltService;
import com.brewtools.services.MaltTypeService;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import javax.inject.Inject;
import java.util.List;

public class MaltPanel extends GenericPanel<Malt> {

    private IModel<Recipe> recipeModel;
    @Inject
    private MaltTypeService maltTypeService;
    @Inject
    private MaltService maltService;

    public MaltPanel(String id, IModel<Malt> model, IModel<Recipe> recipeModel) {
        super(id, model);
        this.recipeModel = recipeModel;
    }

    public MaltPanel(String id, IModel<Malt> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new MaltAdditionForm("addMalt", createModel()));
    }

    private IModel<Malt> createModel() {
        return new LoadableDetachableModel<Malt>() {
            @Override
            protected Malt load() {
                return getModelObject() == null ? new Malt(recipeModel.getObject()) : getModelObject();
            }
        };
    }

    private class MaltAdditionForm extends Form<Malt> {
        public MaltAdditionForm(String id, IModel<Malt> model) {
            super(id, model);
            add(new RequiredTextField<>("amount", new PropertyModel<>(getModel(), "amount"), Double.class));
            add(new DropDownChoice<>("maltType", new PropertyModel<>(getModel(), "type"),
                    getTypes(), new ChoiceRenderer<MaltType>() {
                @Override
                public Object getDisplayValue(MaltType maltType) {
                    return maltType.getName();
                }
            }));
        }

        @Override
        protected void onSubmit() {
            maltService.save(getModelObject());
        }

        private IModel<? extends List<? extends MaltType>> getTypes() {
            return new LoadableDetachableModel<List<? extends MaltType>>() {
                @Override
                protected List<? extends MaltType> load() {
                    return maltTypeService.getTypes();
                }
            };
        }
    }
}
