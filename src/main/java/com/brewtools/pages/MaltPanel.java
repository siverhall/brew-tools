package com.brewtools.pages;

import com.brewtools.dataobjects.Malt;
import com.brewtools.dataobjects.MaltType;
import com.brewtools.dataobjects.Recipe;
import com.brewtools.services.MaltService;
import com.brewtools.services.MaltTypeService;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import javax.inject.Inject;
import java.util.List;

public class MaltPanel extends GenericPanel<Malt> {

    private IModel<? extends List<Malt>> malts;
    private IModel<Recipe> recipeModel;
    @Inject
    private MaltTypeService maltTypeService;
    @Inject
    private MaltService maltService;

    public MaltPanel(String id, IModel<Malt> model, IModel<? extends List<Malt>> malts) {
        super(id, model);
        this.malts = malts;
    }

    public MaltPanel(String id, IModel<Recipe> recipeModel) {
        super(id);
        this.recipeModel = recipeModel;
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

        public MaltAdditionForm(String id, IModel<Malt> model) {
            super(id, model);
            add(new TextField<>("amount", new PropertyModel<>(getModel(), "amount"), Double.class));
            add(createDropDown());

            add(deleteLink("delete"));
        }

        @Override
        protected void onSubmit() {
                maltService.save(getModelObject());
        }

        private Link<Malt> deleteLink(final String id) {
            return new Link<Malt>(id, getModel()) {
                @Override
                public void onClick() {
                    maltService.delete(getModelObject());
                    malts.detach();
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
