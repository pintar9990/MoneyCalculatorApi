package software.ulpgc.moneycalculator.mock;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public class MockCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get() {
        return currencies.get(1);
    }
}
