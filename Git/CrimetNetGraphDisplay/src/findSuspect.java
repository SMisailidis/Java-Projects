import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class findSuspect extends JFrame implements ActionListener{
	
	private JPanel panel1; //Main panel (Find Suspect)
	
	private JTextField text1; //Εισαγωγή του ονοματεπώνυμου ενός πιθανού υπόπτου
	
	private JButton button1; //Κουμπί Find
	
	private JButton button2; //Κουμπί Visualize Network
	
	private JOptionPane message1; //Παράθυρο με μήνυμα για λάθος καταχώριση υπόπτου
	
	private Registry registry;
	
	private Suspect sus = null;
	
	public findSuspect(Registry registry) {
		
		panel1 = new JPanel();
		
		text1 = new JTextField("Please enter suspect's name");
		
		button1 = new JButton("Find");
		button2 = new JButton("Visualize Network");
		
		message1 = new JOptionPane();
		
		panel1.add(text1);
		panel1.add(button1);
		panel1.add(button2);
	
		this.registry = registry;
		this.setContentPane(panel1);
		this.setVisible(true);
		this.setSize(300,150);
		this.setTitle("Find Suspect");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button1) {
			
			String name = text1.getText();
			
			for(int i = 0; i < registry.suspects.size(); i++) {
				if(name.equals(registry.suspects.get(i).getName())){
					this.setVisible(false);
					this.sus = registry.suspects.get(i);
					suspectPage page = new suspectPage(sus, this.registry);
					
					 break;
				}	 
			}
			
			if(this.sus == (null)) {
				JOptionPane.showMessageDialog(message1, "Suspect " + text1.getText() + " Not Found");
			}	
		}
		else if (e.getSource() == button2) {
			
			this.setVisible(false);
		}
	}	
}
