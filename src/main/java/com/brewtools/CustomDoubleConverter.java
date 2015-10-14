package com.brewtools;

import org.apache.wicket.util.convert.converter.DoubleConverter;

import java.util.Locale;

public class CustomDoubleConverter extends DoubleConverter {

    @Override
    public Double convertToObject(String value, Locale locale) {
        if ("sv".equals(locale.getLanguage())) {
            value = value.replace(".", ",");
        }
        return super.convertToObject(value, locale);
    }
}
