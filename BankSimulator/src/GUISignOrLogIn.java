import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISignOrLogIn extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
    private  JFrame DeleteCardFrame;
    private JFrame frame1;
	
    private String card;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel DeleteCardPanel;

    private JLabel label1;
    private JLabel label2;
    private JLabel DeleteCardLabel;

    private JTextField textField1;
    private JTextField textField2;

    private JPasswordField passwordField1;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    private JCheckBox checkBox1;

    private Color ForegroundLabel;
    private Color ForegroundButton;
    private Color BackgroundButton;

    private SQLiteConnection sqlConn;

    private ArrayList<String> receivedData;

    public  GUISignOrLogIn() {

    	sqlConn = new SQLiteConnection();
        

        ForegroundLabel = new Color(43, 249, 194);
        ForegroundButton = new Color(43, 249, 194);
        BackgroundButton = new Color(77, 80, 79);

        panel1 = new JPanel();
        panel1.setBackground(new Color(77, 80, 79));

        button1 = new JButton("Sign in");
        button1.setForeground(ForegroundButton);
        button1.setBackground(BackgroundButton);
        button1.setBounds(0,80,100,30);
        button1.addActionListener(this);
        button1.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button2 = new JButton("Log in");
        button2.setForeground(ForegroundButton);
        button2.setBackground(BackgroundButton);
        button2.setBounds(183,80,100,30);
        button2.addActionListener(this);
        button2.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button3 = new JButton("See your card?");
        button3.setForeground(ForegroundButton);
        button3.setBackground(BackgroundButton);
        button3.setBounds(0,130,100,30);
        button3.addActionListener(this);
        button3.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button4 = new JButton("Contant Bank");
        button4.setForeground(ForegroundButton);
        button4.setBackground(BackgroundButton);
        button4.setBounds(183,130,100,30);
        button4.addActionListener(this);
        button4.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        DeleteCardPanel = new JPanel();
        label1 = new JLabel("Hello, welcome to our Bank!");
        label2 = new JLabel("-------------------(How can i assist you?)-------------------");

        this.setContentPane(panel1);
        this.setVisible(true);
        this.setSize(300,200);
        this.setTitle("Welcome to our bank!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(label1);
        this.add(label2);
        this.setLayout(null);

        DeleteCardPanel.setBackground(new Color(77, 80, 79));
        DeleteCardPanel.setLayout(null);

        label1.setBounds(63,0,180,30);
        label1.setForeground(ForegroundButton);
        label1.setBackground(BackgroundButton);

        label2.setBounds(0,35,300,30);
        label2.setForeground(ForegroundButton);
        label2.setBackground(BackgroundButton);

        DeleteCardFrame = new JFrame();
        DeleteCardFrame.setSize(500,250);
        DeleteCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField1 = new JTextField("Insert your Lastname...");
        textField1.setBackground(BackgroundButton);
        textField1.setForeground(ForegroundButton);
        textField1.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        textField2 = new JTextField("PIN");
        textField2.setBackground(BackgroundButton);
        textField2.setForeground(ForegroundButton);
        textField2.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button5 = new JButton("Sumbit request");
        button5.setForeground(ForegroundButton);
        button5.setBackground(BackgroundButton);
        button5.addActionListener(this);
        button5.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        checkBox1 = new JCheckBox("Check your card!");
        checkBox1.setBackground(BackgroundButton);
        checkBox1.setForeground(ForegroundButton);
        checkBox1.addActionListener(this);
        checkBox1.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        passwordField1 = new JPasswordField();
        passwordField1.setBackground(BackgroundButton);
        passwordField1.setForeground(ForegroundButton);
        passwordField1.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        panel2 = new JPanel();
        panel2.setBackground(new Color(77, 80, 79));

        frame1 = new JFrame();
        frame1.setSize(350,220);
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        frame1.add(panel2);

        panel2.setSize(350,220);
        panel2.add(textField1);
        panel2.add(passwordField1);
        panel2.add(textField2);
        panel2.add(button5);
        panel2.add(checkBox1);
        panel2.setLayout(null);
        
        textField1.setBounds(25,25,200,19);
        textField2.setBounds(240,25,70,19);

        checkBox1.setBounds(108,140, 119, 35);
        passwordField1.setBounds(69,115,200,20);

        button5.setBounds(108, 65, 119,30);

        DeleteCardLabel = new JLabel("Your account has been locked! You have to create a new one!");
        DeleteCardLabel.setForeground(ForegroundLabel);
        DeleteCardLabel.setBounds(75,50,400,50);

        DeleteCardPanel.add(DeleteCardLabel);
        DeleteCardFrame.add(DeleteCardPanel);
    }

    public String insert(){

        int count = 3;
    
        String pin;
        String query = "";

        do {
            this.card = JOptionPane.showInputDialog(null, "Insert card number");

            query = "SELECT CARDS.card_number FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
            
        } while(!sqlConn.makeDMLQuery(query));

        do {
            if(count != 0) {
                pin = JOptionPane.showInputDialog(null, "Give me your PIN");

                query = "SELECT CARDS.PIN FROM CARDS WHERE CARDS.PIN =" + "'" + pin + "'" + "AND CARDS.card_number =" + "'" + this.card + "'";

                if (!sqlConn.makeDMLQuery(query)) {

                    count--;
                    JOptionPane message2 = new JOptionPane();
                    JOptionPane.showMessageDialog(message2, "Wrong pin! You have " + count + " tries left.");
                }
            }
            else {
            	
                this.DeleteCardFrame.setVisible(true);
                
                query = "DELETE FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
                
                sqlConn.makeDMLQuery(query);
                
                query = "";
                
                break;
            }          
            
        } while (!sqlConn.makeDMLQuery(query));

        
        
        if(sqlConn.makeDMLQuery(query)){
            return this.card;
        }
        return "0";
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(button1)){

            this.setVisible(false);

            String message1 = null;
            JOptionPane message2 = new JOptionPane();
            String pin;

            CardGenerator cG = new CardGenerator();
            
            this.card = cG.generate("4054", 16);

            String firstName = JOptionPane.showInputDialog(message1, "Give me your first name");
            String lastName = JOptionPane.showInputDialog(message1, "Give me your last name");

            do{
                pin = JOptionPane.showInputDialog(message1, "Give me your PIN");
            }while (pin.length() != 4);

            String cvv = cG.CVV();

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

            sqlConn.makeDMLQuery(query);

            
            JOptionPane.showMessageDialog(null, "Your card has been successfully registered");

            this.setVisible(true);

        }
        else if(e.getSource().equals(button2)){

            this.setVisible(false);

            String card = insert();

            if(!card.equals("0")){
            	
            	@SuppressWarnings("unused")
            	Card cardData = new Card(this.card);
    	
                @SuppressWarnings("unused")
				GUI gui = new GUI(this.card);
            }
        }
        else if(e.getSource().equals(button3)){

            System.out.println("mphka");
            frame1.setVisible(true);
            
        }
        else if(e.getSource().equals(button4)){
            //Contant bank
        }
        else if(e.getSource().equals(button5)){

            receivedData = new ArrayList<String>();
            String query = "SELECT CARDS.card_number FROM CARDS WHERE CARDS.last_name =" + "'" + this.textField1.getText() + "'" + "AND CARDS.PIN =" + "'" + this.textField2.getText() + "'";

            if(!sqlConn.makeDMLQuery(query)){
                JOptionPane.showMessageDialog(null, "Something went wrong! Invalid lastname or PIN");
            }
            else{
                receivedData.addAll(sqlConn.getQueryResults());
                this.passwordField1.setText(receivedData.get(0));
            }


        }
        else if(e.getSource().equals(checkBox1)){
            if(checkBox1.isSelected()){
                this.passwordField1.setEchoChar((char)0);
            }
            else {
                this.passwordField1.setEchoChar('*');
            }
        }
    }

}
