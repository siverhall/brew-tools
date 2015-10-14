package com.brewtools.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class MashingPage extends BasePage {

    private String mashCalculation;
    private String spargeCalculation;

    public MashingPage(PageParameters parameters) {
        super(parameters);

        add(new MashForm("form"));
        add(new Label("mashWater", new PropertyModel<>(this, "mashCalculation")));
        add(new Label("spargeWater", new PropertyModel<>(this, "spargeCalculation")));
    }

    private class MashForm extends Form<Void> {

        private final RequiredTextField<Double> grain;
        private final RequiredTextField<Double> preboil;

        public MashForm(String id) {
            super(id);
            add(new FeedbackPanel("feedback"));
            grain = new RequiredTextField<>("grainWeight", Model.of(0.0), Double.class);
            preboil = new RequiredTextField<>("preboilVol", Model.of(0.0), Double.class);
            add(grain);
            add(preboil);
        }

        @Override
        protected void onSubmit() {
            double mash = grain.getConvertedInput() * 2.7 + 3.5;
            double sparge = (preboil.getConvertedInput() - mash) + (grain.getConvertedInput() * 0.8);
            mashCalculation = "Mash water: " + mash + " L";
            spargeCalculation = "Sparge water: " + sparge + " L";
        }
    }
}
