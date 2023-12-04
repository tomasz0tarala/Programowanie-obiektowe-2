package LAB04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadnie2 extends JDialog{
    private JComboBox koloryComboBox;
    private JEditorPane editorPane;
    private JButton bButton;
    private JButton iButton;
    private JButton zButton;
    private JButton pButton;
    private JPanel editorJPanel;
    private JPanel leftJPanel;
    private JPanel topRightJPanel;
    private JPanel bottomLeftJPanel;
    private JLabel title1Label;

    public Zadnie2() {
        setContentPane(editorJPanel);
        setTitle("Zadanie 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = 550, height = 500;
        setSize(new Dimension(width, height));
        setModal(true);
        setLocationRelativeTo(null);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Czerwony");
        comboBoxModel.addElement("Niebieski");
        comboBoxModel.addElement("Zielony");
        comboBoxModel.addElement("Żółty");
        comboBoxModel.addElement("Czarny");
        comboBoxModel.addElement("Szary");
        comboBoxModel.addElement("Fioletowy");
        koloryComboBox.setModel(comboBoxModel);
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorPane.setFont(new Font(editorPane.getFont().getName(), Font.BOLD, editorPane.getFont().getSize()));
            }
        });
        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorPane.setFont(new Font(editorPane.getFont().getName(), Font.ITALIC, editorPane.getFont().getSize()));
            }
        });
        pButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorPane.setFont(new Font(editorPane.getFont().getName(), Font.PLAIN, editorPane.getFont().getSize()+1));
            }
        });
        zButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorPane.setFont(new Font(editorPane.getFont().getName(), Font.PLAIN, editorPane.getFont().getSize()-1));
            }
        });
        koloryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (koloryComboBox.getSelectedItem().toString().equals("Czerwony"))
                    editorPane.setForeground(Color.RED);
                else if (koloryComboBox.getSelectedItem().toString().equals("Niebieski"))
                    editorPane.setForeground(Color.BLUE);
                else if (koloryComboBox.getSelectedItem().toString().equals("Zielony"))
                    editorPane.setForeground(Color.GREEN);
                else if (koloryComboBox.getSelectedItem().toString().equals("Żółty"))
                    editorPane.setForeground(Color.YELLOW);
                else if (koloryComboBox.getSelectedItem().toString().equals("Czarny"))
                    editorPane.setForeground(Color.BLACK);
                else if (koloryComboBox.getSelectedItem().toString().equals("Szary"))
                    editorPane.setForeground(Color.GRAY);
                else if (koloryComboBox.getSelectedItem().toString().equals("Fioletowy"))
                    editorPane.setForeground(Color.MAGENTA);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Zadnie2();
    }
}
