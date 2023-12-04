package LAB03.zadnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog{
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

    public LoginForm(JFrame parent) {
        super(parent);
        setContentPane(loginPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = 550, height = 500;
        setMinimumSize(new Dimension(width, height));
        setModal(true);
        setLocationRelativeTo(parent);
        setResizable(false);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());

                user = getAuthentificationUser(email, password);
                if (user != null) {
                    dispose();
                    DashboardForm dashboardForm = new DashboardForm(null, user);

                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public User user;
    private User getAuthentificationUser(String email, String password) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid email or password", "Try again", JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


//    public static void main(String[] args) {
//        LoginForm loginForm = new LoginForm(null);
//        User user = loginForm.user;
//        if (user != null) {
//            System.out.println("Successfully logged in " + user.name);
//            System.out.println("Email " + user.email);
//            System.out.println("Phone " + user.phone);
//            System.out.println("Address " + user.address);
//        }else {
//            System.out.println("Failed to login");
//        }
//    }
}
