import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame{

	protected ImageIcon logo;
	protected JFrame board = new JFrame();
	
	protected BoardPanelGUI panel;
	
	
	public BoardGUI() {
		
		
		logo = new ImageIcon("src\\M.png"); // Frame's logo
			
		panel = new BoardPanelGUI();
		this.board.add(panel);
		this.board.setSize(1600,800);
		this.board.setIconImage(logo.getImage()); // Logo definition
		this.board.setTitle("Board");
		this.board.setResizable(false);
		this.board.setBackground(Color.BLACK);
		this.board.setLocationRelativeTo(null);
		this.board.setVisible(true);
		this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
