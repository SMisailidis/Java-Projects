import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISignOrLogIn extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private  JFrame DeleteCardFrame;
	
	private String card;
    private JPanel panel1;
    private JPanel DeleteCardPanel;

    private JLabel DeleteCardLabel;
    
    private JButton button1;
    private JButton button2;

    private Color ForegroundLabel;
    private Color ForegroundButton;
    private Color BackgroundButton;

    private SQLiteConnection sqlConn;

    public  GUISignOrLogIn() {

    	sqlConn = new SQLiteConnection();
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
            firstName.charAt(0);

            String lastName = JOptionPane.showInputDialog(message1, "Give me your last name");

            do{
                pin = JOptionPane.showInputDialog(message1, "Give me your PIN");
            }while (pin.length() != 4);

            String cvv = cG.CVV();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String creationDate = dtf.format(now);
            String expirationDate = dtf.format(now.plusYears(3));

            String query = "INSERT INTO CARDS (card_number, card_owner,creation_date, exp_date, PIN, CVV) VALUES "
            									+ "(" + "'" + this.card
							            		+ "'" + "," 
            									+ "'" + firstName.charAt(0)
							            		+ "." + lastName 
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

            JOptionPane.showMessageDialog(message2, "Your card has been successfully registered");

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

    public void createLoginPage(){

        ForegroundLabel = new Color(43, 249, 194);
        ForegroundButton = new Color(43, 249, 194);
        BackgroundButton = new Color(77, 80, 79);

        panel1 = new JPanel();
        panel1.setBackground(new Color(77, 80, 79));

        button1 = new JButton("Sign in");
        button1.setForeground(ForegroundButton);
        button1.setBackground(BackgroundButton);
        button1.setBounds(92,62,100,30);
        button1.addActionListener(this);
        button1.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button2 = new JButton("Log in");
        button2.setForeground(ForegroundButton);
        button2.setBackground(BackgroundButton);
        button2.setBounds(92,102,100,30);
        button2.addActionListener(this);
        button2.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        this.setContentPane(panel1);
        this.setVisible(true);
        this.setSize(300,250);
        this.setTitle("Welcome to our bank!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(button1);
        this.add(button2);
        this.setLayout(null);

        DeleteCardPanel = new JPanel();

        DeleteCardPanel.setBackground(new Color(77, 80, 79));
        DeleteCardPanel.setLayout(null);

        DeleteCardFrame = new JFrame();
        DeleteCardFrame.setSize(500,250);

        DeleteCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DeleteCardLabel = new JLabel("Your account has been locked! You have to create a new one!");
        DeleteCardLabel.setForeground(ForegroundLabel);
        DeleteCardLabel.setBounds(75,50,400,50);

        DeleteCardPanel.add(DeleteCardLabel);
        DeleteCardFrame.add(DeleteCardPanel);

    }

}
