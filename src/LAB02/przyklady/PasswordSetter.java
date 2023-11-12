package LAB02.przyklady;

import javax.swing.*;
import java.awt.*;

public class PasswordSetter extends JFrame{
    private JPanel JPanel1;
    private JButton okButton;
    private JPasswordField passwordField;
    private JPasswordField passwordField1;
    private JLabel topLabel;
    private JLabel bottomLabel;

    public PasswordSetter() {
        super("Password setter");
        this.setContentPane(JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 200, width = 300;
        this.setMinimumSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        okButton.addActionListener(e -> {
            String password = String.valueOf(passwordField.getPassword());
            String password1 = String.valueOf(passwordField1.getPassword());
            if (password.equals(password1)) {
                JOptionPane.showMessageDialog(null, "Password set");
            }else{
                JOptionPane.showMessageDialog(null, "Passwords do not match");
            }
        });
    }

    public static void main(String[] args) {
        PasswordSetter passwordSetter = new PasswordSetter();
    }
}
