package LAB01.zadania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame {
    private JPanel JPanel1;
    private JTextField textField_a;
    private JTextField textField_b;
    private JButton sumaButton;
    private JButton ilorazButton;
    private JButton różnicaButton;
    private JButton iloczynButton;
    private JButton wyczyścPolaButton;
    private JButton wyjścieButton;
    private JLabel Label_podaj_a;
    private JLabel Label_podaj_b;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JPanel JPanel5;
    private JLabel JLabelwyniki;
    double valueA, valueB, score;

    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        kalkulator.setVisible(true);
    }

    public Kalkulator() {
        super("Kalkulator");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height = 400;
        this.setSize(width, height);
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textField_a.getText());
                valueB = Double.parseDouble(textField_b.getText());
                score = valueA+valueB;
                JLabelwyniki.setText("Wynik "+valueA+" + "+valueB+" = "+score);

            }
        });
        różnicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textField_a.getText());
                valueB = Double.parseDouble(textField_b.getText());
                score = valueA-valueB;
                JLabelwyniki.setText("Wynik "+valueA+" - "+valueB+" = "+score);
            }
        });
        iloczynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textField_a.getText());
                valueB = Double.parseDouble(textField_b.getText());
                score = valueA*valueB;
                JLabelwyniki.setText("Wynik "+valueA+" * "+valueB+" = "+score);
            }
        });
        ilorazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textField_a.getText());
                valueB = Double.parseDouble(textField_b.getText());
                if (valueB != 0) {
                    score = valueA / valueB;
                    JLabelwyniki.setText("Wynik " + valueA + " / " + valueB + " = " + score);
                }
                else JLabelwyniki.setText("Nie można dzielić przez zero");
            }
        });
        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        wyczyścPolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelwyniki.setText("Wynik działania ...");
//                JLabelwyniki.setFont(Arial);
                textField_a.setText("");
                textField_b.setText("");
            }
        });
    }
}
