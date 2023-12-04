package LAB03.zadnia;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DashboardForm extends JDialog {
    private User user;
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
    private JPanel middleBottomPanel;
    private JLabel iconLabel;
    private JLabel titleLabel;
    private JTextField firstLastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField adressField;
    private JPanel middleTopJPanel;

    public DashboardForm(JFrame parent, User user) {
        super(parent);
        this.user = user;
        setTitle("Dashboard");
        setModal(true);
        setContentPane(dashboardPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = 800, height = 600;
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(parent);
        clientsTable.setFillsViewportHeight(true);
        titleLabel.setText("Welcome " + user.name);
        createTable();
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm(null);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstLastNameField.getText().equals("") ||
                        emailField.getText().equals("") ||
                        phoneField.getText().equals("") ||
                        adressField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                } else {
                    String data[] = {firstLastNameField.getText(), emailField.getText(), phoneField.getText(), adressField.getText()};
                    DefaultTableModel tblModel = (DefaultTableModel) clientsTable.getModel();
                    tblModel.addRow(data);
                    JOptionPane.showMessageDialog(null, "Added successfully");
                    firstLastNameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                    adressField.setText("");
                }
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tblModel = (DefaultTableModel) clientsTable.getModel();
                if (firstLastNameField.getText().equals("") ||
                        emailField.getText().equals("") ||
                        phoneField.getText().equals("") ||
                        adressField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                } else {

                    if (clientsTable.getSelectedRowCount() == 1) {
                        String firstLastName = firstLastNameField.getText();
                        String email = emailField.getText();
                        String phone = phoneField.getText();
                        String adress = adressField.getText();
                        tblModel.setValueAt(firstLastName, clientsTable.getSelectedRow(), 0);
                        tblModel.setValueAt(email, clientsTable.getSelectedRow(), 1);
                        tblModel.setValueAt(phone, clientsTable.getSelectedRow(), 2);
                        tblModel.setValueAt(adress, clientsTable.getSelectedRow(), 3);
                        JOptionPane.showMessageDialog(null, "Updated successfully");
                        firstLastNameField.setText("");
                        emailField.setText("");
                        phoneField.setText("");
                        adressField.setText("");

                    } else {
                        if (clientsTable.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Table is empty");
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select single row for delete");
                        }


                }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tblModel = (DefaultTableModel) clientsTable.getModel();
                if (clientsTable.getSelectedRowCount() == 1) {
                    tblModel.removeRow(clientsTable.getSelectedRow());
                } else {
                    if (clientsTable.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Table is empty");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select single row for delete");
                    }
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstLastNameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                adressField.setText("");
            }
        });
        setVisible(true);

        /*//II Wersja
        //====================================================================================
        boolean hasRegistredUsers = connectToDatanbase();
        if(hasRegistredUsers) {
            LoginForm loginForm = new LoginForm(this);
            User user = loginForm.user;

            if (user!=null){
                lbAdmin.setText("User: " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }else dispose();
        }
        else {
            //show registration form
            RegistrationForm registrationForm = new RegistrationForm(this);
            User user = registrationForm.user;

            if(user != null){
                lbAdmin.setText("User: " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }else dispose();

        }

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm = new RegistrationForm(DashboardForm.this);
                User user = registrationForm.user;

                if (user !=null){
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "New user: "+ user.name,
                            "Successful Registration",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        //====================================================================================*/
    }

    private void createTable() {
        Object[][] data = {

        };

        clientsTable.setModel(new DefaultTableModel(
                data,
                new String[]{"First and last name",
                        "e-mail",
                        "Phone",
                        "Adress"
                }

        ));

        TableColumnModel columnModel = (TableColumnModel) clientsTable.getColumnModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
    }

    private boolean connectToDatanbase() {
        boolean hasRegistredUsers = false;

        //spr podłaczenia do bazy
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            //fist connet to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS MyStore");
            statement.close();
            ;
            conn.close();

            //connect to the database and create the table "users if not created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(200) NOT NULL," +
                    "email VARCHAR(200) NOT NULL UNIQUE," +
                    "phone varchar(200)," +
                    "address VARCHAR(200)," +
                    "password VARCHAR(200) NOT NULL)";
            statement.executeUpdate(sql);

            //check if we have user in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasRegistredUsers;
    }
}

