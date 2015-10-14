package com.brewtools.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
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
            grain = initField("grainWeight");
            preboil = initField("preboilVol");
            add(grain);
            add(preboil);
        }

        private RequiredTextField<Double> initField(String id) {
            RequiredTextField<Double> input = new RequiredTextField<>(id, Model.of(0.0), Double.class);
            add(new ComponentFeedbackPanel(id+"Feedback", input));
            return input;
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
