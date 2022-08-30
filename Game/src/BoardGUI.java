import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame{

	protected ImageIcon logo;
	
	
	public BoardGUI() {

		JFrame board = new JFrame();
		logo = new ImageIcon("src\\M.png"); // Frame's logo
			
		JPanel panel = new BoardPanelGUI();
		
		board.add(panel);
		board.pack();

		board.setIconImage(logo.getImage()); // Logo definition
		board.setTitle("Board");
		board.setResizable(false);
		board.setLocationRelativeTo(null);
		board.setVisible(true);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
