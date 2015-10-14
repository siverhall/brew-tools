package com.brewtools.components;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class DoubleField extends FormComponentPanel<Double> {

    private final RequiredTextField<Double> input;

    public DoubleField(String id, IModel<String> label) {
        super(id, Model.of(0.0));
        input = new RequiredTextField<>("input", getModel(), Double.class);
        add(new ComponentFeedbackPanel("feedback", input));
        add(new Label("label", label));
        add(input);
    }

    @Override
    public void convertInput() {
        setConvertedInput(input.getConvertedInput());
    }
}
