package LAB03.zadnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JPanel loginPanel;
    private JTextField emailField;
    private JButton okButton;
    private JButton cancelButton;
    private JPasswordField passwordField;
    private JPanel leftPanel;
    private JLabel titleTopLabel;
    private JLabel titleBottomLabel;
    private JLabel iconLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel rightPanel;

    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        super("Login");
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 550, height = 500;
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
