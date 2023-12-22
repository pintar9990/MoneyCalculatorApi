package software.ulpgc.moneycalculator.mock;

import software.ulpgc.moneycalculator.MoneyDisplay;
import software.ulpgc.moneycalculator.model.Money;

public class MockMoneyDisplay implements MoneyDisplay {
    @Override
    public void show(Money money) {
        System.out.println(money);
    }
}
