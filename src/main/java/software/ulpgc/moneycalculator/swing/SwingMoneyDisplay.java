package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.MoneyDisplay;
import software.ulpgc.moneycalculator.model.Money;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel label;

    public SwingMoneyDisplay() {
        add(label = createLabel());
    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        return label;
    }

    @Override
    public void show(Money money) {
        label.setText(money.toString());
    }
}
