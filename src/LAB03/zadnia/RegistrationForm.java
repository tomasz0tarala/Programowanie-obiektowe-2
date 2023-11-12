package LAB03.zadnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class RegistrationForm extends JFrame{
    private JPanel registerPanel;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;
    private JButton registerButton;
    private JButton cancelButton;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;
    private JLabel iconLabel;

    public static void main(String[] args) {
        new RegistrationForm();
    }
    public RegistrationForm() {
        super("Register");
        this.setContentPane(registerPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 550, height = 500;
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
