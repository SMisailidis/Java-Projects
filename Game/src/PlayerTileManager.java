import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.*;

public class PlayerTileManager {
    
    BoardPanelGUI gp;
    PlayerTile[] tile;
    int mapTileNum[][];


    public PlayerTileManager(BoardPanelGUI gp) {

        this.gp = gp;

        tile = new PlayerTile[4];
        getHeroes();

    }

    public void getHeroes() {

        int i = 0;
        for (Heroes r : Game.selectedHeroes) {

            try {

                tile[i] = new PlayerTile();
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("HeroesPixel/" + r.name + ".png"));

                i++;

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2) {

        int temp = 0;
        for (int i = 0; i < Game.selectedHeroes.size(); i++) {
            
            g2.drawImage(tile[i].image, gp.playersX[i] - temp, gp.playersY[i], gp.HeroesSize, gp.HeroesSize, null);
            tile[i].rect.x = gp.playersX[i] - temp;
            tile[i].rect.y = gp.playersY[i];
            temp += 16;
        }
    }
}
