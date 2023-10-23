package LAB01.zadania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GeneratorLiczb extends JFrame {
    private JPanel panel1;
    private JTextField textField_a;
    private JTextField textField_b;
    private JButton generateButton;
    private JButton clearButton;
    private JButton exitButton;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel JLabel_itroduction;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel JLabel_result;
    private JLabel JLabel_a;
    private JLabel JLabel_b;
    private JPanel JPanel5;
    private JPanel JPanel6;

    int valueA, valueB, random;

    public static void main(String[] args) {
        GeneratorLiczb generatorLiczb = new GeneratorLiczb();
        generatorLiczb.setVisible(true);
    }

    public GeneratorLiczb() {
        super("Generator");
        this.setContentPane(JPanel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                valueA = Integer.parseInt(textField_a.getText());
                valueB = Integer.parseInt(textField_b.getText());
                random = rand.nextInt(valueB - valueA + 1) + valueA;
                JLabel_result.setText("Wygenerowana liczba: " + random);
                if (random == valueA || random == valueB) {
                    JOptionPane.showMessageDialog(null, "Brawo udało wygenrować ci się liczbę z kresu");
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_a.setText("");
                textField_b.setText("");
                JLabel_result.setText("Losowa liczba...");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
