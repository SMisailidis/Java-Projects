import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISignOrLogIn extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

    private String card;
    private Boolean LogInPINAppear = false;
    private int count = 3;
	
    private JFrame DeleteCardFrame;
    private JFrame ForgotCardNumberFrame;
    private JFrame SignInFrame;
    private JFrame LogInFrame;

    private ImageIcon icon; // Image icon

    private JPanel MainPagePanel;
    private JPanel ForgotCardNumberPanel;
    private JPanel SignInPanel;
    private JPanel LogInPanel;
    private JPanel DeleteCardPanel;

    private JLabel MainPageWelcomeLabel;
    private JLabel MainPageAssistLabel;
    private JLabel SignInPINLabel;
    private JLabel LogInLabel;
    private JLabel DeleteCardLabel;
    private JLabel ForgotCardNumberPINLabel;

    private JTextField ForgotCardNumberLastNameTextField;
    private JTextField SignInFirstNameTextField;
    private JTextField SignInLastNameTextField;
    private JTextField LogInCardNumberTextField;

    private JPasswordField ForgotCardNumberPasswordField;
    private JPasswordField SignInPINPasswordField;
    private JPasswordField LogInPINPasswordField;
    private JPasswordField ForgotCardNumberPINTextField;

    private JButton MainPageSignInButton;
    private JButton MainPageLoginInButton;
    private JButton MainPageForgotCardNumberButton;
    private JButton MainPageInformationsButton;
    private JButton ForgotCardNumberSubmitRequest;
    private JButton SignInSubmitRequestButton;
    private JButton SignInReturnToMainPageButton;
    private JButton LogInReturnToMainPageButton;
    private JButton ForgotCardNumberReturnToMainPageButton;
    private JButton LogInSubmitRequestButton;

    private JCheckBox ForgotCardNumberCheckBox;
    private JCheckBox SignInCheckBox;
    private JCheckBox LogInCheckBox;

    private Color ForegroundLabel;
    private Color ForegroundButton;
    private Color BackgroundButton;

    private ArrayList<String[]> receivedData;

    public  GUISignOrLogIn() {
        
        //--Colors--\\
        ForegroundLabel = new Color(43, 249, 194);
        ForegroundButton = new Color(43, 249, 194);
        BackgroundButton = new Color(77, 80, 79);
        //----------\\

        //--Icons--\\
        icon = new ImageIcon("Home.png");
        //---------\\

        //--Frames--\\
        ForgotCardNumberFrame = new JFrame();
        ForgotCardNumberFrame.setTitle("Retrieval frame");
        ForgotCardNumberFrame.setSize(350,220);
        ForgotCardNumberFrame.setLayout(null);
        ForgotCardNumberFrame.setLocationRelativeTo(null);
        ForgotCardNumberFrame.setResizable(false);
        ForgotCardNumberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SignInFrame = new JFrame();
        SignInFrame.setTitle("Sign into our Bank!");
        SignInFrame.setSize(350,250);
        SignInFrame.setLayout(null);
        SignInFrame.setLocationRelativeTo(null);
        SignInFrame.setResizable(false);
        SignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DeleteCardFrame = new JFrame();
        DeleteCardFrame.setTitle("Failed to log in!");
        DeleteCardFrame.setSize(500,250);
        DeleteCardFrame.setLayout(null);
        DeleteCardFrame.setLocationRelativeTo(null);
        DeleteCardFrame.setResizable(false);
        DeleteCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LogInFrame = new JFrame();
        LogInFrame.setTitle("Log into our bank");
        LogInFrame.setSize(350,250);
        LogInFrame.setLayout(null);
        LogInFrame.setLocationRelativeTo(null);
        LogInFrame.setResizable(false);
        LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------\\

        //--Panels--\\
        MainPagePanel = new JPanel();
        MainPagePanel.setBackground(new Color(77, 80, 79));
        this.setContentPane(MainPagePanel);
        this.setSize(300,200);
        this.setTitle("Welcome to our bank!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        ForgotCardNumberPanel = new JPanel();
        ForgotCardNumberPanel.setBackground(new Color(77, 80, 79));
        ForgotCardNumberPanel.setSize(350,220);
        ForgotCardNumberPanel.setLayout(null);

        SignInPanel = new JPanel();
        SignInPanel.setBackground(new Color(77, 80, 79));
        SignInPanel.setSize(350,250);
        SignInPanel.setLayout(null);

        DeleteCardPanel = new JPanel();
        DeleteCardPanel.setBackground(new Color(77, 80, 79));
        DeleteCardPanel.setSize(500,250);
        DeleteCardPanel.setLayout(null);

        LogInPanel = new JPanel();
        LogInPanel.setBackground(new Color(77, 80, 79));
        LogInPanel.setSize(500,250);
        LogInPanel.setLayout(null);
        //----------\\

        //--Labels--\\
        MainPageWelcomeLabel = new JLabel("Hello, welcome to our Bank!");
        MainPageWelcomeLabel.setForeground(ForegroundButton);
        MainPageWelcomeLabel.setBackground(BackgroundButton);
        MainPageWelcomeLabel.setBounds(63,0,180,30);
        
        MainPageAssistLabel = new JLabel("-------------------(How may i assist you?)-------------------");
        MainPageAssistLabel.setForeground(ForegroundButton);
        MainPageAssistLabel.setBackground(BackgroundButton);
        MainPageAssistLabel.setBounds(0,35,300,30);

        SignInPINLabel = new JLabel("Give me your PIN ↓");
        SignInPINLabel.setForeground(ForegroundButton);
        SignInPINLabel.setBackground(BackgroundButton);
        SignInPINLabel.setBounds(114,95,222,20);

        DeleteCardLabel = new JLabel("Your account has been locked! You have to create a new one!");
        DeleteCardLabel.setForeground(ForegroundLabel);
        DeleteCardLabel.setBounds(75,50,400,50);

        LogInLabel = new JLabel("Give me your PIN ↓");
        LogInLabel.setForeground(ForegroundButton);
        LogInLabel.setBackground(BackgroundButton);
        LogInLabel.setBounds(114,75,222,20);

        ForgotCardNumberPINLabel = new JLabel("PIN ↓");
        ForgotCardNumberPINLabel.setForeground(ForegroundButton);
        ForgotCardNumberPINLabel.setBackground(BackgroundButton);
        ForgotCardNumberPINLabel.setBounds(262,05,40,20);
        //----------\\

        //--Buttons--\\
        MainPageSignInButton = new JButton("Sign up");
        MainPageSignInButton.setForeground(ForegroundButton);
        MainPageSignInButton.setBackground(BackgroundButton);
        MainPageSignInButton.addActionListener(this);
        MainPageSignInButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageSignInButton.setBounds(0,80,100,30);

        MainPageLoginInButton = new JButton("Log in");
        MainPageLoginInButton.setForeground(ForegroundButton);
        MainPageLoginInButton.setBackground(BackgroundButton);
        MainPageLoginInButton.addActionListener(this);
        MainPageLoginInButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageLoginInButton.setBounds(183,80,100,30);

        MainPageForgotCardNumberButton = new JButton("See your card?");
        MainPageForgotCardNumberButton.setForeground(ForegroundButton);
        MainPageForgotCardNumberButton.setBackground(BackgroundButton);
        MainPageForgotCardNumberButton.addActionListener(this);
        MainPageForgotCardNumberButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageForgotCardNumberButton.setBounds(0,130,100,30);

        MainPageInformationsButton = new JButton("Informations");
        MainPageInformationsButton.setForeground(ForegroundButton);
        MainPageInformationsButton.setBackground(BackgroundButton);
        MainPageInformationsButton.addActionListener(this);
        MainPageInformationsButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageInformationsButton.setBounds(183,130,100,30);

        ForgotCardNumberSubmitRequest = new JButton("Submit request");
        ForgotCardNumberSubmitRequest.setForeground(ForegroundButton);
        ForgotCardNumberSubmitRequest.setBackground(BackgroundButton);
        ForgotCardNumberSubmitRequest.addActionListener(this);
        ForgotCardNumberSubmitRequest.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberSubmitRequest.setBounds(108, 65, 119,30);

        SignInSubmitRequestButton = new JButton("Submit");
        SignInSubmitRequestButton.setForeground(ForegroundButton);
        SignInSubmitRequestButton.setBackground(BackgroundButton);
        SignInSubmitRequestButton.addActionListener(this);
        SignInSubmitRequestButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInSubmitRequestButton.setBounds(128, 170, 80,30);

        SignInReturnToMainPageButton = new JButton(icon);
        SignInReturnToMainPageButton.setForeground(ForegroundButton);
        SignInReturnToMainPageButton.setBackground(BackgroundButton);
        SignInReturnToMainPageButton.addActionListener(this);
        SignInReturnToMainPageButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInReturnToMainPageButton.setBounds(5, 5, 37,37);

        LogInReturnToMainPageButton = new JButton(icon);
        LogInReturnToMainPageButton.setForeground(ForegroundButton);
        LogInReturnToMainPageButton.setBackground(BackgroundButton);
        LogInReturnToMainPageButton.addActionListener(this);
        LogInReturnToMainPageButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        LogInReturnToMainPageButton.setBounds(5, 5, 37,37);
        
        ForgotCardNumberReturnToMainPageButton = new JButton(icon);
        ForgotCardNumberReturnToMainPageButton.setForeground(ForegroundButton);
        ForgotCardNumberReturnToMainPageButton.setBackground(BackgroundButton);
        ForgotCardNumberReturnToMainPageButton.addActionListener(this);
        ForgotCardNumberReturnToMainPageButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberReturnToMainPageButton.setBounds(5, 5, 37,37);

        LogInSubmitRequestButton = new JButton("Submit");
        LogInSubmitRequestButton.setForeground(ForegroundButton);
        LogInSubmitRequestButton.setBackground(BackgroundButton);
        LogInSubmitRequestButton.addActionListener(this);
        LogInSubmitRequestButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        LogInSubmitRequestButton.setBounds(128, 150, 80,30);
        //-----------\\

        //--Checkboxes--\\
        ForgotCardNumberCheckBox = new JCheckBox("Check your card!");
        ForgotCardNumberCheckBox.setBackground(BackgroundButton);
        ForgotCardNumberCheckBox.setForeground(ForegroundButton);
        ForgotCardNumberCheckBox.addActionListener(this);
        ForgotCardNumberCheckBox.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberCheckBox.setBounds(108,140, 119, 35); 

        SignInCheckBox = new JCheckBox();
        SignInCheckBox.setBackground(BackgroundButton);
        SignInCheckBox.setForeground(ForegroundButton);
        SignInCheckBox.addActionListener(this);
        SignInCheckBox.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInCheckBox.setBounds(230,117, 119, 35); 

        LogInCheckBox = new JCheckBox();
        LogInCheckBox.setBackground(BackgroundButton);
        LogInCheckBox.setForeground(ForegroundButton);
        LogInCheckBox.addActionListener(this);
        LogInCheckBox.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        LogInCheckBox.setBounds(230,98, 119, 35); 
        //--------------\\
        
        //--TextFields--\\
        ForgotCardNumberLastNameTextField = new JTextField("Insert your Lastname...");
        ForgotCardNumberLastNameTextField.setBackground(BackgroundButton);
        ForgotCardNumberLastNameTextField.setForeground(ForegroundButton);
        ForgotCardNumberLastNameTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberLastNameTextField.setBounds(50,25,185,19);

        SignInFirstNameTextField = new JTextField("Give me your first name");
        SignInFirstNameTextField.setBackground(BackgroundButton);
        SignInFirstNameTextField.setForeground(ForegroundButton);
        SignInFirstNameTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInFirstNameTextField.setBounds(55,20,222,20);

        SignInLastNameTextField = new JTextField("Give me your last name");
        SignInLastNameTextField.setBackground(BackgroundButton);
        SignInLastNameTextField.setForeground(ForegroundButton);
        SignInLastNameTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInLastNameTextField.setBounds(55,60,222,20);

        LogInCardNumberTextField = new JTextField("Give me your card number");
        LogInCardNumberTextField.setBackground(BackgroundButton);
        LogInCardNumberTextField.setForeground(ForegroundButton);
        LogInCardNumberTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        LogInCardNumberTextField.setBounds(55,40,222,20);
        //--------------\\

        //--PasswordFields--\\
        ForgotCardNumberPasswordField = new JPasswordField();
        ForgotCardNumberPasswordField.setBackground(BackgroundButton);
        ForgotCardNumberPasswordField.setForeground(ForegroundButton);
        ForgotCardNumberPasswordField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberPasswordField.setBounds(69,115,200,20);

        SignInPINPasswordField = new JPasswordField();
        SignInPINPasswordField.setBackground(BackgroundButton);
        SignInPINPasswordField.setForeground(ForegroundButton);
        SignInPINPasswordField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        SignInPINPasswordField.setBounds(111,125,111,20);

        LogInPINPasswordField = new JPasswordField();
        LogInPINPasswordField.setBackground(BackgroundButton);
        LogInPINPasswordField.setForeground(ForegroundButton);
        LogInPINPasswordField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        LogInPINPasswordField.setBounds(111,105,111,20);

        ForgotCardNumberPINTextField = new JPasswordField();
        ForgotCardNumberPINTextField.setBackground(BackgroundButton);
        ForgotCardNumberPINTextField.setForeground(ForegroundButton);
        ForgotCardNumberPINTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ForgotCardNumberPINTextField.setBounds(240,25,70,19);
        //------------------\\
           
        //--frames/Panels content--\\
        this.add(MainPageSignInButton);
        this.add(MainPageLoginInButton);
        this.add(MainPageForgotCardNumberButton);
        this.add(MainPageInformationsButton);
        this.add(MainPageWelcomeLabel);
        this.add(MainPageAssistLabel);

        ForgotCardNumberPanel.add(ForgotCardNumberLastNameTextField);
        ForgotCardNumberPanel.add(ForgotCardNumberPINTextField);
        ForgotCardNumberPanel.add(ForgotCardNumberPasswordField);
        ForgotCardNumberPanel.add(ForgotCardNumberSubmitRequest);
        ForgotCardNumberPanel.add(ForgotCardNumberCheckBox);
        ForgotCardNumberPanel.add(ForgotCardNumberPINLabel);
        ForgotCardNumberPanel.add(ForgotCardNumberReturnToMainPageButton);

        SignInPanel.add(SignInFirstNameTextField);
        SignInPanel.add(SignInLastNameTextField);
        SignInPanel.add(SignInPINPasswordField);
        SignInPanel.add(SignInPINLabel);
        SignInPanel.add(SignInSubmitRequestButton);
        SignInPanel.add(SignInReturnToMainPageButton);
        SignInPanel.add(SignInCheckBox);

        DeleteCardPanel.add(DeleteCardLabel);

        LogInPanel.add(LogInCardNumberTextField);
        LogInPanel.add(LogInLabel);
        LogInPanel.add(LogInPINPasswordField);
        LogInPanel.add(LogInSubmitRequestButton);
        LogInPanel.add(LogInReturnToMainPageButton);
        LogInPanel.add(LogInCheckBox);

        ForgotCardNumberFrame.add(ForgotCardNumberPanel);
        SignInFrame.add(SignInPanel);  
        DeleteCardFrame.add(DeleteCardPanel);
        LogInFrame.add(LogInPanel);
        //-------------------------\\

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(MainPageSignInButton)){

            this.setVisible(false);

            this.SignInFrame.setVisible(true);
        }
        else if(e.getSource().equals(MainPageLoginInButton)){

            this.setVisible(false);

            this.LogInFrame.setVisible(true);
            this.LogInLabel.setVisible(false);
            this.LogInPINPasswordField.setVisible(false);
            this.LogInCheckBox.setVisible(false);
        }
        else if(e.getSource().equals(MainPageForgotCardNumberButton)){

            this.setVisible(false);
            ForgotCardNumberFrame.setVisible(true);
            
        }
        else if(e.getSource().equals(MainPageInformationsButton)){
            //Contant bank

        }
        else if(e.getSource().equals(ForgotCardNumberSubmitRequest)){

            receivedData = new ArrayList<String[]>();

            char[] receivedPassword = this.ForgotCardNumberPINTextField.getPassword();

            String query = "SELECT CARDS.card_number FROM CARDS WHERE CARDS.last_name =" + "'" + this.ForgotCardNumberLastNameTextField.getText() + "'" + "AND CARDS.PIN =" + "'" + String.valueOf(receivedPassword) + "'";

            if(!Main.sql.makeDMLQuery(query)){
                JOptionPane.showMessageDialog(null, "Something went wrong! Invalid lastname or PIN");
            }
            else{
                receivedData = Main.spliterator(Main.sql.getQueryResults());
                this.ForgotCardNumberPasswordField.setText(receivedData.get(0)[0]);
            }
        }
        else if(e.getSource().equals(SignInSubmitRequestButton)){

            CardGenerator cG = new CardGenerator();
            
            String firstName = this.SignInFirstNameTextField.getText();
            String lastName = this.SignInLastNameTextField.getText();
            char[] receivedPassword = this.SignInPINPasswordField.getPassword();
            

            if(this.SignInPINPasswordField.getPassword().length == 0 || firstName.contains(" ") || lastName.contains(" ")){

                JOptionPane.showMessageDialog(null, "Invalid Data! Fill up the fields correctly");
            }
            else{

                String pin = String.valueOf(receivedPassword);
                String cvv = cG.CVV();
                this.card = cG.generate("4054", 16);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String creationDate = dtf.format(now);
                String expirationDate = dtf.format(now.plusYears(3));

                String query = "INSERT INTO CARDS (card_number, card_owner, first_name, last_name, creation_date, exp_date, PIN, CVV) VALUES "
                                                    + "(" + "'" + this.card
                                                    + "'" + "," 
                                                    + "'" + firstName.charAt(0)
                                                    + "." + lastName 
                                                    + "'" + "," 
                                                    + "'" + firstName
                                                    + "'" + ","
                                                    + "'" + lastName
                                                    + "'" + ","
                                                    + "'" + creationDate 
                                                    + "'" + "," 
                                                    + "'" + expirationDate 
                                                    + "'" + "," 
                                                    + "'" + pin
                                                    + "'" + "," 
                                                    + "'" + cvv 
                                                    + "'" + ")";

                Main.sql.makeDMLQuery(query);

                JOptionPane.showMessageDialog(null, "Your card has been successfully registered");

                this.setVisible(true);
                this.SignInFrame.setVisible(false);
            }
        }
        else if(e.getSource().equals(SignInReturnToMainPageButton) || e.getSource().equals(LogInReturnToMainPageButton) || e.getSource().equals(ForgotCardNumberReturnToMainPageButton)){

            this.setVisible(true);

            this.ForgotCardNumberFrame.setVisible(false);
            this.SignInFrame.setVisible(false);
            this.LogInFrame.setVisible(false);
        }
        else if(e.getSource().equals(ForgotCardNumberCheckBox) || e.getSource().equals(SignInCheckBox) || e.getSource().equals(LogInCheckBox)){
            if(this.ForgotCardNumberCheckBox.isSelected() || this.SignInCheckBox.isSelected() || this.LogInCheckBox.isSelected()){
                this.ForgotCardNumberPasswordField.setEchoChar((char)0);
                this.LogInPINPasswordField.setEchoChar((char)0);
                this.SignInPINPasswordField.setEchoChar((char)0);
            }
            else {
                this.ForgotCardNumberPasswordField.setEchoChar('*');
                this.LogInPINPasswordField.setEchoChar('*');
                this.SignInPINPasswordField.setEchoChar('*');
            }
        }
        else if(e.getSource().equals(LogInSubmitRequestButton)){

            String pin;
            String query = "";
            
            if(!this.LogInPINAppear){

                this.card = this.LogInCardNumberTextField.getText();

                query = "SELECT CARDS.card_number FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
                if(!Main.sql.makeDMLQuery(query)){
                    JOptionPane.showMessageDialog(null, "Your Card Number is incorrect! Try again.");
                }
                else{
                    this.LogInCardNumberTextField.setEditable(false);
                    this.LogInLabel.setVisible(true);
                    this.LogInPINPasswordField.setVisible(true);
                    this.LogInCheckBox.setVisible(true);;
                    this.LogInPINAppear = true;
                }
            }
            else{
                
                if(this.count != 0) {

                    char[] receivedPassword = this.LogInPINPasswordField.getPassword();

                    pin = String.valueOf(receivedPassword);
    
                    query = "SELECT CARDS.PIN FROM CARDS WHERE CARDS.PIN =" + "'" + pin + "'" + "AND CARDS.card_number =" + "'" + this.card + "'";
    
                    if (!Main.sql.makeDMLQuery(query)) {
    
                        count--;
                        JOptionPane.showMessageDialog(null, "Wrong pin! You have " + count + " tries left.");
                    }
                    else{

                        @SuppressWarnings("unused")
                        GUI gui = new GUI(this.card);

                        this.LogInFrame.setVisible(false);
                    }
                }

                if(this.count == 0) {
                    
                    this.DeleteCardFrame.setVisible(true);
                    
                    query = "DELETE FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
                    
                    Main.sql.makeDMLQuery(query);
                    
                    query = "";
                }          
            }
        }
    }
}
