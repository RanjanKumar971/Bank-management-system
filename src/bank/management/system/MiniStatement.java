package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {

    String cardnumber;

    MiniStatement(String cardnumber) {
        this.cardnumber = cardnumber;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from login where cardnumber='" +
                    cardnumber + "'");
            // ResultSet rs = conn.s.executeQuery("select * from login where pin='1111'");
            while (rs.next()) {
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber='" +
                    cardnumber + "'");
            // ResultSet rs = conn.s.executeQuery("select * from bank where pin='1111'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html><pre>" + rs.getString("shortDate") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")
                        + "</pre><br>");

            }
        } catch (Exception e) {
            System.out.println(e);
        }

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
        text.setBounds(20, 400, 300, 20);
        add(text);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("5040936068038935");
    }
}
