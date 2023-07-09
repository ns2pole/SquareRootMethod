package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Decimal {
    public int integerPart;
    ArrayList<Integer> decimalPart;

    @Override
    public String toString() {
        return integerPart + "." + decimalPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decimal decimal = (Decimal) o;
        return integerPart == decimal.integerPart && Objects.equals(decimalPart, decimal.decimalPart);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(integerPart);
        result = 31 * result + decimalPart.hashCode();
        return result;
    }
}