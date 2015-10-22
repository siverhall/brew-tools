package com.brewtools.pages;

import com.brewtools.dataobjects.Hop;
import com.brewtools.dataobjects.HopSpec;
import com.brewtools.services.HopSpecService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import javax.inject.Inject;
import java.util.List;

public class HopSpecPanel extends Panel {

    @Inject
    private HopSpecService hopSpecService;

    public HopSpecPanel(String id) {
        super(id);
        add(new FeedbackPanel("feedback"));
        add(new HopSpecForm("form", getHopSpec()));
        add(new ListView<HopSpec>("currentHops", getHopSpecs()) {
            @Override
            protected void populateItem(ListItem<HopSpec> item) {
                item.add(new Label("specName", new PropertyModel<>(item.getModel(), "name")));
            }
        });
    }

    private IModel<List<HopSpec>> getHopSpecs() {
        return new LoadableDetachableModel<List<HopSpec>>() {
            @Override
            protected List<HopSpec> load() {
                return hopSpecService.getHopSpecs();
            }
        };
    }

    private class HopSpecForm extends Form<HopSpec> {

        public HopSpecForm(String id, IModel<HopSpec> model) {
            super(id, model);
            add(new RequiredTextField<>("hopName", new PropertyModel<>(getModel(), "name")));
        }

        @Override
        protected void onSubmit() {
            hopSpecService.save(getModelObject());
        }
    }

    private IModel<HopSpec> getHopSpec() {
        return new LoadableDetachableModel<HopSpec>() {
            @Override
            protected HopSpec load() {
                return new HopSpec();
            }
        };
    }
}
