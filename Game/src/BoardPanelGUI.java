import java.awt.*;
import javax.swing.*;

public class BoardPanelGUI extends JPanel{

	//Screen settings
	final int originalTileSize = 64; // For tiles
	final int originalHeroesSize = 16; //For heroes
	final int scale = 1;
	final int heroScale = 2;

	final int tileSize = originalTileSize * scale;
	final int HeroesSize = originalHeroesSize * heroScale;
	final int maxScreenCol = 10;
	final int maxScreenRow = 10;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	TileManager tileM = new TileManager(this);

	public BoardPanelGUI() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);

		repaint();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		tileM.draw(g2);

		g2.dispose();

	}
}
