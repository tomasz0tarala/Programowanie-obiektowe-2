package LAB02.przyklady;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanelLeft;
    private JPanel JPanelRight;
    private JLabel topFieldName;
    private JLabel bottomFieldName;
    private JTextField textField1;
    private JPasswordField passwordField;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel loginLabel;
    private JLabel onTheTop;
    private JLabel wynikLogowania;
    private JPanel JPanelTop;
    private JPanel JPanelBottom;
    private JPanel JPanelMiddle;
    private JTextField loginField;
    private String user = "admin", password = "admin";

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();

    }

    public LoginForm() {
        super("Login to Application");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 500, width = 600;
//        this.setSize(width,height);
        this.setMinimumSize(new Dimension(width, height));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userLogin = loginField.getText();
                String userPassword = new String(passwordField.getPassword());
                if (userLogin.equals(user) && userPassword.equals(password)) {
                    wynikLogowania.setText("Login successful");
                }else{
                    wynikLogowania.setText("Login failed");
                    passwordField.setText("");
                    loginField.setText("");
                }

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
