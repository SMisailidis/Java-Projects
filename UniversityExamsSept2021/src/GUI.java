import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener{

	private ArrayList<Taxi> taxis = new ArrayList<>();
	
	private JPanel panel1;
	
	private JTextField field1;
	
	private JButton button1;
	private JButton button2;
	
	public GUI(ArrayList<Taxi> taxi) {
		
		this.taxis = taxi;
		
		panel1 = new JPanel();
		
		field1 = new JTextField("Ποια πόλη αναζητάς;  ");
		
		button1 = new JButton("Εμφάνιση Αυτονομίας");
		button2 = new JButton("Αποθήκευση σε Αρχείο");
		
		this.setContentPane(panel1);
		this.setVisible(true);
		this.setSize(300,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(field1);
		this.add(button1);
		this.add(button2);
			
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource().equals(button1)) {
			
			double sum = 0.0;
			int count = 0;
			
			String text = field1.getText();
			
			for(int i=0;i<this.taxis.size();i++) {
				if(this.taxis.get(i).getTown().equals(text)) {
					count++;
					sum = sum + this.taxis.get(i).calcAutonomy();
				}
			}
			
			System.out.println("Όνομα πόλης: " + text);
			System.out.println("Διαθέσιμα ταξί: " + count);
			System.out.println("Συνολική αυτονομία " + sum);
			
			
			}
		else if(e.getSource().equals(button2)) {
			
			try 
			{
				File ics21166 = new File("");
				FileWriter writer = new FileWriter("ics21166.txt");
				
				double sum = 0.0;
				String text = "Ρέθυμνο";
				printInfo(writer, text);
				
				text = "Ηράκλειο";
				printInfo(writer, text);
				
				writer.close();
			}
			catch(IOException x)
			{
				x.printStackTrace();
			}
		}
		
	}
	
	public void printInfo(Writer writer, String text) {
		
		double sum = 0.0;
		
		try
		{
			writer.write("Όνομα πόλης: " + text + System.lineSeparator());
			writer.write("------------------" + System.lineSeparator());
			
			for(int i=0;i<taxis.size();i++) {
				if(text.equals(taxis.get(i).getTown())){
					writer.write("Όνομα οδηγού: " + this.taxis.get(i).getName() + System.lineSeparator());
					writer.write("Αριθμό κυκλοφορίας: " + this.taxis.get(i).getNumber() + System.lineSeparator());
					writer.write("Αυτονομία: " + this.taxis.get(i).calcAutonomy() + System.lineSeparator());
					writer.write("------------------" + System.lineSeparator());		
					
					sum = sum + this.taxis.get(i).calcAutonomy();	
				}
			}
			writer.write("Συνολική αυτονομία: " + sum + System.lineSeparator());
			writer.write("------------------" + System.lineSeparator());
		}
		catch(IOException x)
		{
			x.printStackTrace();
		}	
	}		
}



