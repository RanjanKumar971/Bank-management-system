package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String cardnumber;
    JButton back;

    BalanceEnquiry(String cardnumber) {
        this.cardnumber = cardnumber;
        setLayout(null);

        // background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // button

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // bal cal
        Conn conn = new Conn();
        int bal = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '" + cardnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit"))
                    bal += Integer.parseInt(rs.getString("amount"));
                else
                    bal -= Integer.parseInt(rs.getString("amount"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current account balance is Rs. " + bal);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        // frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(cardnumber).setVisible(true);
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
