package LAB02.przyklady;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Os extends JFrame {
    private JPanel JPanel1;
    private JRadioButton linuxRadioButton;
    private JRadioButton macintoshRadioButton;
    private JRadioButton windowsRadioButton;
    private JButton okButton;
    private JLabel osIcon;
    private JPanel JPanelMiddle;
    private JPanel JPanelTop;
    private JPanel JPanelBottom;

    public static void main(String[] args) {
        Os os = new Os();
    }
    public Os(){
        super("Operating systems");
        this.setContentPane(JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 500, width = 600;
        this.setMinimumSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        linuxRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linuxRadioButton.isSelected()) {
                    osIcon.setIcon(new ImageIcon("src/LAB02/przyklady/linux.jpg"));
                }else{
                    osIcon.setIcon(null);
                }
            }
        });
        windowsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowsRadioButton.isSelected()) {
                    osIcon.setIcon(new ImageIcon("src/LAB02/przyklady/windows.png"));
                }else{
                    osIcon.setIcon(null);
                }
            }
        });
        macintoshRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(macintoshRadioButton.isSelected()) {
                    osIcon.setIcon(new ImageIcon("src/LAB02/przyklady/mac.png"));
                }else{
                    osIcon.setIcon(null);
                }
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linuxRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "You selected: Linux");
                }else if(windowsRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "You selected: Windows");
                }else if(macintoshRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "You selected: Macintosh");
                }else{
                    JOptionPane.showMessageDialog(null, "No OS selected");
                }
            }
        });
    }
}
