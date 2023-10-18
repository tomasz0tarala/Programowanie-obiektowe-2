package LAB01.zadania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Example extends JFrame {
    private JPanel JPanel1;
    private JButton okButton;
    private JButton Wyjscie;
    private JPanel JPanel;
    private JLabel JLabelText1;
    private JLabel JLabelData1;
    private JButton klikButton;

    public static void main(String[] args) {
        Example example = new Example();
        example.setVisible(true);
    }

    public Example() {
        super("Tomasz Tarała");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height = 300;
        this.setSize(width, height);
//        this.pack();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = JOptionPane.showInputDialog("Podaj imię");
//                JOptionPane.showMessageDialog(null, "Witaj " + text);
                JOptionPane.showMessageDialog(null, "Witaj " + text,"UWAGA",JOptionPane.YES_NO_OPTION);
//                JOptionPane.showMessageDialog(null, "Witaj " + text,"UWAGA",JOptionPane.WARNING_MESSAGE);


            }
        });
        Wyjscie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        klikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelText1.setText("Tekst po zmianie");
                JLabelData1.setText(new Date().toString());
            }
        });
    }

}
