package LAB01.zadania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZadaniaWyswietl extends JFrame {
    private JPanel JPanel_1;
    private JButton konwerterButton;
    private JButton kalkulatorButton;
    private JButton generatorButton;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JLabel descriptionLabel;

    public static void main(String[] args) {
        ZadaniaWyswietl zadaniaWyswietl = new ZadaniaWyswietl();
        zadaniaWyswietl.setVisible(true);
    }

    public ZadaniaWyswietl() {
        super("tt125169");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(JPanel_1);
        this.setVisible(true);
//        this.pack();
        int height = 250, width = 450;
        this.setSize(width, height);
//        this.setLocation(600,200);
        this.setLocationRelativeTo(null);
        konwerterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Konwerter konwerter = new Konwerter();
            }
        });
        kalkulatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kalkulator kalkulator = new Kalkulator();
            }
        });
        generatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneratorLiczb generatorLiczb = new GeneratorLiczb();
            }
        });
    }
}
