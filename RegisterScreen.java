package covidTest;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class RegisterScreen implements ActionListener {

    JPanel screen = new JPanel();
    JPanel header = new JPanel();

    JTextField firstNameInput;
    JTextField lastNameInput;
    JTextField phoneNumberInput;
    JTextField emailInput;
    JRadioButton yesButton;
    JRadioButton noButton;
    JLabel phoneNumberERROR;
    JLabel emailERROR;
    JLabel radioERROR;
    
    Color MAROON = new Color( 128, 0, 0 );

    Font titleFont = new Font("Serif", Font.PLAIN, 30);
    Font labelFont = new Font( "Serif", Font.PLAIN, 20);

    public Main m = new Main();
    
    public RegisterScreen() throws IOException {

        screen.setBackground( MAROON );
        screen.setLayout(null);
        addComponents();

    }

    private void addComponents() throws IOException {

        /* Helper for making components */
        ComponentMaker cm = new ComponentMaker();

        /* Adds the header */
        header = cm.makeHeader();
        screen.add(header);

        /* Adds the title */
        JLabel title = cm.makeLabel( "REGISTER", titleFont );
        title.setBounds( 900, 50, 200, 200 );
        screen.add(title);

        /* Adds the first name text */
        JLabel firstNameText = cm.makeLabel("FIRST NAME: ", labelFont);
        firstNameText.setBounds( 650, 300, 150, 50 );
        screen.add(firstNameText);

        /* Adds the first name input */
        firstNameInput = new JTextField();
        firstNameInput.setBounds( 850, 300, 200, 50 );
        firstNameInput.setFont(labelFont);
        screen.add(firstNameInput);

        /* Adds the last name text */
        JLabel lastNameText = cm.makeLabel("LAST NAME: ", labelFont);
        lastNameText.setBounds( 650, 400, 150, 50 );
        screen.add(lastNameText);

        /* Adds the last name input */
        lastNameInput = new JTextField();
        lastNameInput.setBounds( 850, 400, 200, 50 );
        lastNameInput.setFont(labelFont);
        screen.add(lastNameInput);

        /* Adds the phone number text */
        JLabel phoneNumberText = cm.makeLabel("PHONE NUMBER: ", labelFont);
        phoneNumberText.setBounds( 650, 500, 170, 50 );
        screen.add(phoneNumberText);

        /* Adds the phone number input */
        phoneNumberInput = new JTextField();
        phoneNumberInput.setBounds( 850, 500, 200, 50 );
        phoneNumberInput.setFont(labelFont);
        screen.add(phoneNumberInput);

        /* Adds the email text */
        JLabel emailText = cm.makeLabel("UWL EMAIL: ", labelFont);
        emailText.setBounds( 650, 600, 170, 50 );
        screen.add(emailText);

        /* Adds the email input */
        emailInput = new JTextField();
        emailInput.setBounds( 850, 600, 200, 50 );
        emailInput.setFont(labelFont);
        screen.add(emailInput);

        /* Adds the covid text */
        JLabel covidText = cm.makeLabel("DO YOU HAVE ANY COVID-19 SYMPTOMS: ", labelFont);
        covidText.setBounds( 780, 700, 400, 50 );
        screen.add(covidText);

        /* Adds the covid radio buttons */
        yesButton = new JRadioButton("YES");
        yesButton.setBounds( 780, 750, 200, 50 );
        yesButton.setBackground(MAROON);
        yesButton.setForeground( Color.WHITE );
        yesButton.setFont(labelFont);

        noButton = new JRadioButton("NO");
        noButton.setBounds( 1000, 750, 200, 50 );
        noButton.setBackground(MAROON);
        noButton.setForeground( Color.WHITE );
        noButton.setFont(labelFont);

        ButtonGroup bg = new ButtonGroup();
        bg.add(yesButton);
        bg.add(noButton);

        screen.add(yesButton);
        screen.add(noButton);

        /* Adds the submit button */
        JButton submitButton = cm.makeButton("SUBMIT");
        submitButton.setBounds( 850, 850, 200, 100 );
        submitButton.addActionListener(this);
        screen.add(submitButton);
        
        //error labels
        
        phoneNumberERROR = cm.makeLabel("ERROR: not a proper phone number OR number already used", labelFont);
        phoneNumberERROR.setBounds( 1100, 500, 1800, 50 );
        screen.add(phoneNumberERROR);
        phoneNumberERROR.setVisible(false);
        
        emailERROR = cm.makeLabel("ERROR: not a proper email OR email already used", labelFont);
        emailERROR.setBounds(1100, 600, 1800, 50);
        screen.add(emailERROR);
        emailERROR.setVisible(false);
        
        radioERROR = cm.makeLabel("Well, do you have COVID symptoms or not??", labelFont);
        radioERROR.setBounds(1210, 750, 1800, 50);
        screen.add(radioERROR);
        radioERROR.setVisible(false);
        

    }

    public void actionPerformed(ActionEvent e) {
    	
        /* Gets the button that was pressed */
        String buttonPressed = e.getActionCommand();

        if(buttonPressed.equals("SUBMIT")) {

            String firstName = firstNameInput.getText();
            String lastName = lastNameInput.getText();
            String phoneNumber = phoneNumberInput.getText();
            String email = emailInput.getText();
            String covidSymptoms;

            
            
            
            if(!(phoneNumber.length() == 10 && isNumeric(phoneNumber) && !m.containsNumber(phoneNumber))){
            	//highlights phoneNumber field for review
            	phoneNumberInput.setBorder(new LineBorder(Color.YELLOW,4,true));
            	phoneNumberERROR.setVisible(true);
            	return;
            }else {
            	phoneNumberInput.setBorder(new LineBorder(Color.white,1,false));
            	phoneNumberERROR.setVisible(false);
            }
            
            if(!(email.contains("@uwlax.edu")&& !m.containsEmail(email))) {
            	emailInput.setBorder(new LineBorder(Color.YELLOW,4,true));
            	emailERROR.setVisible(true);
            	return;
            }else {
            	emailInput.setBorder(new LineBorder(Color.white,1,false));
            	emailERROR.setVisible(false);
            }


            if(yesButton.isSelected()) {
                covidSymptoms = "YES";
            } else if(noButton.isSelected()) {
                covidSymptoms = "NO";
            } else {
            	radioERROR.setVisible(true);
                yesButton.setBackground(Color.magenta);
                noButton.setBackground(Color.magenta);
                return;
            }
            
            m.addReg(firstName,lastName, email, phoneNumber,covidSymptoms );
            
            
            
            //validateInput();
            
            //addData();  // dont add the data yet, wait until appointment is submitted
           // System.out.println(firstName +" " +lastName +" " +phoneNumber +" " +email +" " +covidSymptoms);

            Startup startup = new Startup();
            startup.changeScreen("Appointment");
        }
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long a = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
