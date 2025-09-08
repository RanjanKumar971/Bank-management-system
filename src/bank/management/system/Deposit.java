package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amount;
    String cardnumber;

    Deposit(String cardnumber) {
        this.cardnumber = cardnumber;
        setLayout(null);
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 700, 35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        // Buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String num = amount.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String shortDate = sdf.format(new Date());

            if (num.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");

            } else {
                Conn conn = new Conn();
                String query = "insert into bank values('" + cardnumber + "', '" + shortDate + "', 'Deposit', '" + num
                        + "')";

                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + num + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardnumber).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardnumber).setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
