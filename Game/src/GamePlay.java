public class GamePlay {
    
    int round;

    BoardPanelGUI gp;
    TileManager tileM;
    PlayerTileManager pTileM;

    public GamePlay(BoardPanelGUI gp) {

        this.gp = gp;
        
        boolean flag = true;

        tileM = new TileManager(gp);
        pTileM = new PlayerTileManager(gp);

        // System.out.println(pTileM.tile[0].rect.intersects(tileM.rects.get(0)));
        // System.out.println(pTileM.tile[0].rect.intersects(tileM.rects.get(0)));
    }
}
