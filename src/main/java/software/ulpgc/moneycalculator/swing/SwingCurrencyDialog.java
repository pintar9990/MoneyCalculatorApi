package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.model.Currency;

import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private List<Currency> currencies;
    private JComboBox<Currency> currency;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        add(currency = currencySelector(currencies));
        return this;
    }

    private JComboBox<Currency> currencySelector(List<Currency> currencies) {
        JComboBox<Currency> result = new JComboBox<>();
        for (Currency currency : currencies) result.addItem(currency);
        return result;
    }

    @Override
    public Currency get() {
        return currency.getItemAt(currency.getSelectedIndex());
    }
}
