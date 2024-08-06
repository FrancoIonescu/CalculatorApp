import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class CalculatorApp  {

    private static double firstOperand = 0;
    private static double secondOperand = 0;
    private static char operator = ' ';
    private static boolean isNewNumber = true;
    private static JTextField textField;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(panel);

        textField = new JTextField();
        textField.setBounds(30, 80, 460, 80);
        textField.setEditable(false);
        textField.setFont(new Font("Arial",Font.PLAIN,40));
        panel.add(textField);

        JButton add = new JButton("+");
        add.setBounds(390,500,100,80);
        add.setFont(new Font("Arial",Font.BOLD, 50));
        add.setBackground(Color.decode("#e4e4e4"));
        panel.add(add);

        JButton subtract = new JButton("-");
        subtract.setBounds(390,400,100,80);
        subtract.setFont(new Font("Arial",Font.BOLD, 80));
        panel.add(subtract);
        subtract.setBackground(Color.decode("#e4e4e4"));

        JButton multiply = new JButton("X");
        multiply.setBounds(390,300,100,80);
        multiply.setFont(new Font("Arial",Font.BOLD, 40));
        multiply.setBackground(Color.decode("#e4e4e4"));
        panel.add(multiply);

        JButton division = new JButton("/");
        division.setBounds(390,200,100,80);
        division.setFont(new Font("Arial",Font.BOLD, 50));
        division.setBackground(Color.decode("#e4e4e4"));
        panel.add(division);

        JButton equal = new JButton("=");
        equal.setBounds(390,600,100,80);
        equal.setFont(new Font("Arial",Font.BOLD, 50));
        equal.setBackground(Color.decode("#e4e4e4"));
        panel.add(equal);

        JButton zero = new JButton("0");
        zero.setBounds(30,600,100,80);
        zero.setFont(new Font("Arial",Font.BOLD, 50));
        zero.setBackground(Color.decode("#e4e4e4"));
        panel.add(zero);

        JButton one = new JButton("1");
        one.setBounds(30,500,100,80);
        one.setFont(new Font("Arial",Font.BOLD, 50));
        one.setBackground(Color.decode("#e4e4e4"));
        panel.add(one);

        JButton two = new JButton("2");
        two.setBounds(150,500,100,80);
        two.setFont(new Font("Arial",Font.BOLD, 50));
        two.setBackground(Color.decode("#e4e4e4"));
        panel.add(two);

        JButton three = new JButton("3");
        three.setBounds(270,500,100,80);
        three.setFont(new Font("Arial",Font.BOLD, 50));
        three.setBackground(Color.decode("#e4e4e4"));
        panel.add(three);

        JButton four = new JButton("4");
        four.setBounds(30,400,100,80);
        four.setFont(new Font("Arial",Font.BOLD, 50));
        four.setBackground(Color.decode("#e4e4e4"));
        panel.add(four);

        JButton five = new JButton("5");
        five.setBounds(150,400,100,80);
        five.setFont(new Font("Arial",Font.BOLD, 50));
        five.setBackground(Color.decode("#e4e4e4"));
        panel.add(five);

        JButton six = new JButton("6");
        six.setBounds(270,400,100,80);
        six.setFont(new Font("Arial",Font.BOLD, 50));
        six.setBackground(Color.decode("#e4e4e4"));
        panel.add(six);

        JButton seven = new JButton("7");
        seven.setBounds(30,300,100,80);
        seven.setFont(new Font("Arial",Font.BOLD, 50));
        seven.setBackground(Color.decode("#e4e4e4"));
        panel.add(seven);

        JButton eight = new JButton("8");
        eight.setBounds(150,300,100,80);
        eight.setFont(new Font("Arial",Font.BOLD, 50));
        eight.setBackground(Color.decode("#e4e4e4"));
        panel.add(eight);

        JButton nine = new JButton("9");
        nine.setBounds(270,300,100,80);
        nine.setFont(new Font("Arial",Font.BOLD, 50));
        nine.setBackground(Color.decode("#e4e4e4"));
        panel.add(nine);

        JButton delete  = new JButton("C");
        delete.setBounds(30,200,100,80);
        delete.setFont(new Font("Arial",Font.BOLD, 50));
        delete.setBackground(Color.decode("#e4e4e4"));
        panel.add(delete);

        JButton dot = new JButton(".");
        dot.setBounds(150,600,100,80);
        dot.setFont(new Font("Arial",Font.BOLD, 60));
        dot.setBackground(Color.decode("#e4e4e4"));
        panel.add(dot);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530,750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        zero.addActionListener(e -> appendNumber("0"));
        one.addActionListener(e -> appendNumber("1"));
        two.addActionListener(e -> appendNumber("2"));
        three.addActionListener(e -> appendNumber("3"));
        four.addActionListener(e -> appendNumber("4"));
        five.addActionListener(e -> appendNumber("5"));
        six.addActionListener(e -> appendNumber("6"));
        seven.addActionListener(e -> appendNumber("7"));
        eight.addActionListener(e -> appendNumber("8"));
        nine.addActionListener(e -> appendNumber("9"));

        add.addActionListener(e -> setOperator('+'));
        subtract.addActionListener(e -> setOperator('-'));
        multiply.addActionListener(e -> setOperator('*'));
        division.addActionListener(e -> setOperator('/'));

        equal.addActionListener(e -> calculateResult());
        dot.addActionListener(e -> appendDot());
        delete.addActionListener(e -> clear());

        setupKeyBindings(panel);
    }

    private static void setupKeyBindings(JPanel panel) {
        Map<String, Action> keyActions = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            String digit = String.valueOf(i);
            keyActions.put(digit, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    appendNumber(digit);
                }
            });
        }

        keyActions.put("MINUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperator('-');
            }
        });

        keyActions.put("shift EQUALS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperator('+');
            }
        });

        keyActions.put("shift 8", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperator('*');
            }
        });

        keyActions.put("SLASH", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperator('/');
            }
        });

        keyActions.put("ENTER", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });

        keyActions.put("C", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        keyActions.put("PERIOD", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendDot();
            }
        });

        for (Map.Entry<String, Action> entry : keyActions.entrySet()) {
            String key = entry.getKey();
            Action action = entry.getValue();
            panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key + "_action");
            panel.getActionMap().put(key + "_action", action);
        }
    }

    private static void appendNumber(String number) {
        if (isNewNumber) {
            textField.setText(number);
            isNewNumber = false;
        } else {
            textField.setText(textField.getText() + number);
        }
    }

    private static void appendDot() {
        textField.setText(textField.getText() + ".");
    }

    private static void setOperator(char op) {
        if (!textField.getText().isEmpty()) {
            operator = op;
            firstOperand = Double.parseDouble(textField.getText());
            isNewNumber = true;
            textField.setText(textField.getText() + ' ' + op);
        }
    }

    private static void calculateResult() {
        if (!isNewNumber) {
            secondOperand = Double.parseDouble(textField.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;
                case '-':
                    result = firstOperand - secondOperand;
                    break;
                case '*':
                    result = firstOperand * secondOperand;
                    break;
                case '/':
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            isNewNumber = true;
            operator = ' ';
        }
    }

    private static void clear() {
        textField.setText("");
        firstOperand = 0;
        secondOperand = 0;
        operator = ' ';
        isNewNumber = true;
    }
}