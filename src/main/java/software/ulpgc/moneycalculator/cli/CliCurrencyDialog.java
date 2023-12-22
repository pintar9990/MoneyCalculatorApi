package software.ulpgc.moneycalculator.cli;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;
import java.util.Scanner;

public class CliCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introduzca una divisa");
            String code = scanner.next();
            if (existCurrency(code)) return findCurrency(code);
            System.out.println(code + "Código de la divisa no encontrado");
        }
    }

    private boolean existCurrency(String code) {
        return findCurrency(code) != null;
    }

    private Currency findCurrency(String code) {
        return currencies.stream()
                .filter(c -> c.code().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
