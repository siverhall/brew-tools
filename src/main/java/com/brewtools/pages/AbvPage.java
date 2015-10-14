package com.brewtools.pages;

import com.brewtools.components.DoubleField;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.math.BigDecimal;

public class AbvPage extends BasePage {

    private String estimatedAbv;

    public AbvPage(PageParameters parameters) {
        super(parameters);

        add(new Label("abv", new PropertyModel<>(this, "estimatedAbv")));

        add(new AbvForm("form"));
    }

    private class AbvForm extends Form<Void> {

        private final DoubleField og;
        private final DoubleField fg;

        public AbvForm(String id) {
            super(id);
            og = new DoubleField("og", 1.055, new ResourceModel("ogLabel"));
            fg = new DoubleField("fg", 1.010, new ResourceModel("fgLabel"));
            add(og);
            add(fg);
        }

        @Override
        protected void onSubmit() {
            double abv = (76.08 * (og.getConvertedInput() - fg.getConvertedInput())
                    / (1.775 - og.getConvertedInput())) * (fg.getConvertedInput() / 0.794);
            estimatedAbv = "Your ABV %: "+ round(abv);
        }
    }

    public static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
