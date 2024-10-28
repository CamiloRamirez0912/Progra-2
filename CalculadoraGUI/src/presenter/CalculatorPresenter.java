package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;
    private double firstNumber = 0;
    private String operation = "";

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addNumberButtonListener(new NumberButtonListener());
        this.view.addOperationButtonListener(new OperationButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getDisplayText();
            JButton source = (JButton) e.getSource();
            view.setDisplayText(currentText + source.getText());
        }
    }

    class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            try {
                if (source == view.getClearButton()) {
                    view.setDisplayText("");
                    firstNumber = 0;
                    operation = "";
                } else if (source == view.getEqualsButton()) {
                    double secondNumber = Double.parseDouble(view.getDisplayText());
                    performOperation(secondNumber);
                    view.setDisplayText(String.valueOf(model.getResult()));
                    operation = "";
                } else {
                    firstNumber = Double.parseDouble(view.getDisplayText());
                    operation = source.getText();
                    view.setDisplayText("");
                }
            } catch (NumberFormatException ex) {
                view.setDisplayText("Error");
            }
        }

        private void performOperation(double secondNumber) {
            switch (operation) {
                case "+":
                    model.add(firstNumber, secondNumber);
                    break;
                case "-":
                    model.subtract(firstNumber, secondNumber);
                    break;
                case "*":
                    model.multiply(firstNumber, secondNumber);
                    break;
                case "/":
                    model.divide(firstNumber, secondNumber);
                    break;
            }
        }
    }
}
