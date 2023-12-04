package LAB04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie1 extends JDialog {
    private JList leftList;
    private JList rightList;
    private JButton moveFromLeftButton;
    private JButton moveAllFromRightButton;
    private JButton moveFromRightButton;
    private JButton moveAllFromLeftButton;
    private JPanel listSwitcherJPanel;
    private JPanel leftJPanel;
    private JPanel rightJPanel;
    private JPanel middleJPanel;

    public Zadanie1(JFrame parent) {
        super(parent);
        setContentPane(listSwitcherJPanel);
        setTitle("List Switcher");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = 550, height = 500;
        setMinimumSize(new Dimension(width, height));
        setModal(true);
        setLocationRelativeTo(parent);
        DefaultListModel listModel1 = new DefaultListModel();
        DefaultListModel listModel2 = new DefaultListModel();
        for(int i = 0; i < 10; i++) {
            listModel1.addElement("Element " + i);
            listModel2.addElement("Element " + i);
        }
        leftList.setModel(listModel1);
        rightList.setModel(listModel2);

        moveFromLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(leftList.getSelectedIndex() != -1) {
                    String selected = listModel1.getElementAt(leftList.getSelectedIndex()).toString();
                    listModel1.removeElementAt(leftList.getSelectedIndex());
                    listModel2.addElement(selected);
                }
            }
        });
        moveFromRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rightList.getSelectedIndex() != -1) {
                    String selected = listModel2.getElementAt(rightList.getSelectedIndex()).toString();
                    listModel2.removeElementAt(rightList.getSelectedIndex());
                    listModel1.addElement(selected);
                }
            }
        });
        moveAllFromLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < listModel1.size(); i++) {
                    String taken = listModel1.elementAt(i).toString();
                    listModel2.addElement(taken);
                }
                listModel1.clear();
            }
        });
        moveAllFromRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < listModel2.size(); i++) {
                    String taken = listModel2.elementAt(i).toString();
                    listModel1.addElement(taken);
                }
                listModel2.clear();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        Zadanie1 zadanie1 = new Zadanie1(null);
        System.out.println();
    }
}
