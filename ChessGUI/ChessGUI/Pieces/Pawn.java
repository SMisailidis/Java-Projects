package Pieces;

import java.awt.*;

public class Pawn extends Piece{
    public Pawn(int x, int y, Color color) {
        super(x, y, "Pawn", color);
    }
    public String Move() {
        if(checkColor()){
            return isFirst() ?  (int)(getX()+1) + "," + getY() + "-" + (int)(getX()+2) + "," + getY() : (int)(getX()+1) + "," + getY();
        }
        return isFirst() ?  (int)(getX()-1) + "," + getY() + "-" + (int)(getX()-2) + "," + getY() : (int)(getX()-1) + "," + getY();
    }
    public void confirmMove(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
