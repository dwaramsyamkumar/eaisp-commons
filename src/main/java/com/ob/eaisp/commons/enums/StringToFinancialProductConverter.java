package com.ob.eaisp.commons.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFinancialProductConverter implements Converter<String, FinancialProduct> {
    @Override
    public FinancialProduct convert(String value) {
        return FinancialProduct.fromValue(value);
    }
}
