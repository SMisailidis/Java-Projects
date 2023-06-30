import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	private JButton button = new JButton("PrintResults");
	private DiagnosticCenter test;
	
	public GUI(DiagnosticCenter test) {
		
		this.test = test;
		
		panel.add(button);
		this.setContentPane(panel);		
		
		button.addActionListener(this);
		
		this.setVisible(true);
		this.setSize(200, 200);
		this.setTitle("Test Statistics");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void actionPerformed(ActionEvent e) {
		

		if(e.getSource() == button) {
			
			int count = 0, countneg = 0;
			
			double pos = 0, posneg = 0;;
			
			
			ArrayList<DiagnosticTest> arr = test.getTests();
			
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i).isResult()) {
					count++;
				}
			}
			
			countneg = arr.size() - count;
			
			pos = ((double)count/arr.size()) * 100;
			posneg = 100 - pos;
			System.out.println("Positive Tests: " + count + " (" + pos + "%)," + " Negative Tests: " + countneg + " (" + posneg + "%)");
		}
		
	}
	
	
}
