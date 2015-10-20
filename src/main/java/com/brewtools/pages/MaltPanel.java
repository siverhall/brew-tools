package com.brewtools.pages;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.MaltType;
import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.MaltService;
import com.brewtools.services.MaltTypeService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.*;
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

    private Malt getMalt() {
        return getModelObject();
    }

    private class MaltAdditionForm extends Form<Malt> {

        private final TextField<Double> amount;
        private final DropDownChoice<MaltType> type;

        public MaltAdditionForm(String id, IModel<Malt> model) {
            super(id, model);
            amount = new TextField<>("amount", new PropertyModel<>(getModel(), "amount"), Double.class);
            type = createDropDown();

            add(amount);
            add(type);
            add(deleteLink("delete"));
        }

        @Override
        protected void onSubmit() {
            if (inputIsValid()) {
                maltService.save(getModelObject());
            }
        }

        private AjaxLink<Malt> deleteLink(final String id) {
            return new AjaxLink<Malt>(id, getModel()) {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    maltService.delete(getModelObject());
                }

                @Override
                protected void onConfigure() {
                    super.onConfigure();
                    setVisibilityAllowed(getMalt() != null);
                }
            };
        }

        private DropDownChoice<MaltType> createDropDown() {
            return new DropDownChoice<>("maltType", new PropertyModel<>(getModel(), "type"),
                    getTypes(), new ChoiceRenderer<MaltType>() {
                @Override
                public Object getDisplayValue(MaltType maltType) {
                    return maltType.getName();
                }
            });
        }

        private boolean inputIsValid() {
            return !amount.getInput().isEmpty() && type.getModelObject() != null;
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
