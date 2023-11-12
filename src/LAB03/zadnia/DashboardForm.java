package LAB03.zadnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardForm extends JFrame{
    private JPanel dashboardPanel;
    private JButton registerButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton closeButton;
    private JTable clientsTable;
    private JScrollPane scrollPane;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel middlePanel;
    private JLabel iconLabel;
    private JLabel titleLabel;

    public static void main(String[] args) {
        new DashboardForm();
    }
    public DashboardForm() {
        super("Dashboard");
        this.setContentPane(dashboardPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 550;
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        closeButton.addActionListener(new ActionListener() {
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
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
