import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField display;
    private StringBuilder currentInput;
    private double result;
    private String lastOperator;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        currentInput = new StringBuilder();
        result = 0;
        lastOperator = "=";

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if ("0123456789.".contains(command)) {
                currentInput.append(command);
                display.setText(currentInput.toString());
            } else {
                if (currentInput.length() > 0) {
                    double input = Double.parseDouble(currentInput.toString());
                    calculate(input);
                    currentInput.setLength(0);
                }
                lastOperator = command;
            }
        }
    }

    private void calculate(double input) {
        switch (lastOperator) {
            case "=":
                result = input;
                break;
            case "+":
                result += input;
                break;
            case "-":
                result -= input;
                break;
            case "*":
                result *= input;
                break;
            case "/":
                if (input != 0) {
                    result /= input;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
