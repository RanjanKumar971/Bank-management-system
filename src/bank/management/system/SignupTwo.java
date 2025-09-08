package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {
    JButton next;
    JComboBox religion, category, income, education, occupation;
    JTextField aadharTextField, panTextField;
    JRadioButton yes1, no1, yes2, no2;
    long random;
    String formno;

    SignupTwo(String formno) {
        this.formno=formno;
        // Frame
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);

        // Labels and textfields

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel religionLabel = new JLabel("Religion : ");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String valReligion[] = { "Hindu", "Muslim", "Christian", "Others" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        // Category
        JLabel categoryLabel = new JLabel("Category : ");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = { "General", "OBCs", "SC/ST" };
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        // Income
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String valIncome[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000" };
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        // Educational
        JLabel eduLabel = new JLabel("Educational ");
        eduLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        eduLabel.setBounds(100, 290, 200, 30);
        add(eduLabel);

        JLabel q = new JLabel("Qualification: ");
        q.setFont(new Font("Raleway", Font.BOLD, 20));
        q.setBounds(100, 315, 200, 30);
        add(q);

        String valEdu[] = { "Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others" };
        education = new JComboBox<>(valEdu);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        // Occupation
        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String valOccupation[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        // PAN
        JLabel pan = new JLabel("PAN No. : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar No. : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        // Senior citizen
        JLabel seniorCitizen = new JLabel("Senior citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        yes1 = new JRadioButton("Yes");
        yes1.setBounds(300, 540, 60, 30);
        yes1.setBackground(Color.WHITE);
        add(yes1);

        no1 = new JRadioButton("No");
        no1.setBounds(450, 540, 100, 30);
        no1.setBackground(Color.WHITE);
        add(no1);

        ButtonGroup seniGroup = new ButtonGroup();
        seniGroup.add(yes1);
        seniGroup.add(no1);

        // Existing Account
        JLabel existingAcc = new JLabel("Existing Account  : ");
        existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAcc.setBounds(100, 590, 200, 30);
        add(existingAcc);

        yes2 = new JRadioButton("Yes");
        yes2.setBounds(300, 590, 60, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);

        no2 = new JRadioButton("No");
        no2.setBounds(450, 590, 100, 30);
        no2.setBackground(Color.WHITE);
        add(no2);

        ButtonGroup existiButtonGroup = new ButtonGroup();
        existiButtonGroup.add(yes2);
        existiButtonGroup.add(no2);

        // Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();

        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();

        String soccupation = (String) occupation.getSelectedItem();

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String seniorCitizen = null;
        if (yes1.isSelected()) {
            seniorCitizen = "Yes";
        } else if (no1.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (yes2.isSelected()) {
            existingAccount = "Yes";
        } else if (no2.isSelected()) {
            existingAccount = "No";
        }

        try {
            if (pan.equals("") || aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "aadhar and pan is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" +formno+"', '" + sreligion + "', '" + scategory + "', '" + sincome
                        + "', '" + seducation+ "', '" + soccupation + "', '" + pan + "', '" + aadhar + "', '" + seniorCitizen + "', '"
                        + existingAccount+ "')";
                c.s.executeUpdate(query);

                //signup3 obj
                setVisible(false);
                new SignupThree(formno).setVisible(true);;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
