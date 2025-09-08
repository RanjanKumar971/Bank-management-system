package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {

    JButton r1, r2, r3, r4, r5, r6, back;
    String cardnumber;

    FastCash(String cardnumber) {
        this.cardnumber = cardnumber;
        setLayout(null);
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Labels

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Buttons

        r1 = new JButton("Rs. 100");
        r1.setBounds(170, 415, 150, 30);
        r1.addActionListener(this);
        image.add(r1);

        r2 = new JButton("Rs. 500");
        r2.setBounds(355, 415, 150, 30);
        r2.addActionListener(this);
        image.add(r2);

        r4 = new JButton("Rs. 1000");
        r4.setBounds(170, 450, 150, 30);
        r4.addActionListener(this);
        image.add(r4);

        r3 = new JButton("Rs. 2000");
        r3.setBounds(355, 450, 150, 30);
        r3.addActionListener(this);
        image.add(r3);

        r5 = new JButton("Rs. 5000");
        r5.setBounds(170, 485, 150, 30);
        r5.addActionListener(this);
        image.add(r5);

        r6 = new JButton("Rs. 10000");
        r6.setBounds(355, 485, 150, 30);
        r6.addActionListener(this);
        image.add(r6);

        back = new JButton("back");
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
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4);
            Conn conn = new Conn();

            try {

                ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '" + cardnumber + "'");
                int bal = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit"))
                        bal += Integer.parseInt(rs.getString("amount"));
                    else
                        bal -= Integer.parseInt(rs.getString("amount"));
                }

                if (ae.getSource() != back && bal < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String shortDate = sdf.format(new Date());

                String query = "insert into bank values('" + cardnumber + "', '" + shortDate + "', 'withdraw', '"
                        + amount
                        + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawed Successfully");
                setVisible(false);
                new Transactions(cardnumber).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
