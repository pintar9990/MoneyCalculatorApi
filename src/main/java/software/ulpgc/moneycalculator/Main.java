package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.cli.CliCurrencyDialog;
import software.ulpgc.moneycalculator.cli.CliMoneyDialog;
import software.ulpgc.moneycalculator.control.ExchangeCommand;
import software.ulpgc.moneycalculator.mock.MockCurrencyLoader;
import software.ulpgc.moneycalculator.mock.MockExchangeRateLoader;
import software.ulpgc.moneycalculator.mock.MockMoneyDisplay;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MockCurrencyLoader currencyLoader = new MockCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        MoneyDialog moneyDialog = new CliMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new CliCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        ExchangeCommand exchangeCommand = new ExchangeCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay);
        exchangeCommand.execute();

    }
}
