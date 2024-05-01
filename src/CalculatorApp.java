import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp  {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel(null);
        frame.getContentPane().add(panel);
        JTextField textField = new JTextField();

        // Setăm dimensiunile preferate ale câmpului de text
        textField.setBounds(10, 10, 200, 50);
        textField.setText("Hello World!");
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        panel.add(textField);
        JButton adunare = new JButton("+");
        adunare.setBounds(30,500,100,80);
        adunare.setFont(new Font("Arial",Font.BOLD, 50));
        panel.add(adunare);
        JButton scadere = new JButton("-");
        scadere.setBounds(30,200,100,80);
        scadere.setFont(new Font("Arial",Font.BOLD, 80));
        panel.add(scadere);
        JButton inmultire = new JButton("*");
        inmultire.setBounds(30,300,100,80);
        inmultire.setFont(new Font("Arial",Font.BOLD, 80));
        panel.add(inmultire);
        JButton impartire = new JButton("/");
        impartire.setBounds(30,400,100,80);
        impartire.setFont(new Font("Arial",Font.BOLD, 50));
        panel.add(impartire);

        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
