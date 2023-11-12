package LAB02.przyklady;

import javax.swing.*;
import java.awt.*;

public class Courses extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanelTop;
    private JPanel JPanelMiddle;
    private JPanel JPanelBottom;
    private JCheckBox javaCheckBox;
    private JCheckBox cHashCheckBox;
    private JCheckBox cPlusCheckBox;
    private JCheckBox pythonCheckBox;
    private JButton okButton;
    private JLabel JLabelTitle;

    public Courses() {
        super("Courses");
        this.setContentPane(JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 500, width = 700;
        this.setMinimumSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        okButton.addActionListener(e -> {
            String message = "You have selected: ";
            int counter = 0;
            if(!javaCheckBox.isSelected() && !cHashCheckBox.isSelected() && !cPlusCheckBox.isSelected() && !pythonCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "None selected");
                return;
            }
            if (javaCheckBox.isSelected()) {
                message += "Java ";
                counter += 3500;
            }
            if (cHashCheckBox.isSelected()) {
                message += "C# ";
                counter += 3000;
            }
            if (cPlusCheckBox.isSelected()) {
                message += "C++ ";
                counter += 4000;
            }
            if (pythonCheckBox.isSelected()) {
                message += "Python ";
                counter += 500;
            }
            String price = String.valueOf(counter);
            JOptionPane.showMessageDialog(null, message+"\nPrice: "+price);
        });
    }

    public static void main(String[] args) {
        Courses courses = new Courses();
    }
}
