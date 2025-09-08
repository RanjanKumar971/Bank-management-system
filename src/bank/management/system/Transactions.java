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

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, fastcash, pinchange, balEnquiry, exit;
    String cardnumber;

    Transactions(String cardnumber) {
        this.cardnumber = cardnumber;
        //this.pinnumber=pinnumber;
        setLayout(null);
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Labels

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Buttons

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balEnquiry = new JButton("Balance Enquiry");
        balEnquiry.setBounds(355, 485, 150, 30);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        // Frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdraw(cardnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(cardnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(cardnumber).setVisible(true);
        } else if (ae.getSource() == balEnquiry) {
            setVisible(false);
            new BalanceEnquiry(cardnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            
            new MiniStatement(cardnumber).setVisible(true);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
