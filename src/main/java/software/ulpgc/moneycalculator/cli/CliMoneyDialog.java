package software.ulpgc.moneycalculator.cli;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.MoneyDialog;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.Money;

import java.util.List;
import java.util.Scanner;

public class CliMoneyDialog implements MoneyDialog {
    private CurrencyDialog currencyDialog;

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        currencyDialog = new CliCurrencyDialog().define(currencies);
        return this;
    }

    @Override
    public Money get() {
        return new Money(amount(), currency());
    }

    private Currency currency() {
        return currencyDialog.get();
    }

    private long amount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca una cantidad");
        return scanner.nextLong();
    }

}
