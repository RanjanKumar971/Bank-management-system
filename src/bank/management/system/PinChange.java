package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

    String cardnumber;
    JButton change, back;
    JPasswordField pin, repin;

    PinChange(String cardnumber) {
        this.cardnumber = cardnumber;
        //this.pinnumber=pinnumber;
        setLayout(null);

        // background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 100, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repinText = new JLabel("Re-Enter New PIN");
        repinText.setForeground(Color.white);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(165, 360, 130, 25);
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        // Buttons

        change = new JButton("CHANGE");
        change.setBounds(355, 405, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardnumber).setVisible(true);
        } else {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the new pin");
                    return;
                } else if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new pin");
                    return;
                } else if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn conn = new Conn();
                
                String q2 = "update login set pinnumber='" + rpin + "' where cardnumber='" + cardnumber + "'";
                String q3 = "update signupthree set pinnumber='" + rpin + "' where cardnumber='" + cardnumber + "'";

                
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(cardnumber);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
