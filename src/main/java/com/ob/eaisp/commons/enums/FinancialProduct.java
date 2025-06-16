package com.ob.eaisp.commons.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum FinancialProduct {
    CURRENT_ACCOUNTS("Current Accounts"),
    CREDIT_CARDS("Credit Cards"),
    PAYMENT_ENABLED_SAVINGS("Payment Enabled Savings"),
    OTHER_SAVINGS("Other Savings"),
    INVESTMENTS("Investments"),
    LOANS("Loans"),
    MORTGAGES("Mortgages"),
    PENSIONS("Pensions"),;

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonCreator
   public static FinancialProduct fromValue(String value) {
        return Arrays.stream(FinancialProduct.values())
                .filter(product -> product.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
