package LAB01.zadania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konwerter extends JFrame {
    private JLabel JLabel_title;
    private JTextField textField_input;
    private JLabel JLabel_instruction;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel5;
    private JButton button_convert;
    private JPanel JPanel4;
    private JLabel JLabel_convert_result;
    private JButton clearButton;
    private JButton exitButton;
    private JPanel JPanel6;
    double celciius, farenheit;

    public static void main(String[] args) {
        Konwerter konwerter = new Konwerter();
        konwerter.setVisible(true);
    }

    public Konwerter() {
        super("Konwerter");
        this.setContentPane(JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        button_convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celciius = Double.parseDouble(textField_input.getText());
                farenheit = ((9/5)*celciius)+32;
                JLabel_convert_result.setText("Podana temperatura w °F: "+farenheit);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel_convert_result.setText("Temperatura po konwersji...");
                textField_input.setText("");
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
