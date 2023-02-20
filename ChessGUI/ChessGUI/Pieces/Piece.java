package Pieces;

import java.awt.*;

public class Piece {
    private int x, y;
    private String type;
    private Color color;

    private boolean isFirst = true;

    public Piece (int x, int y, String type, Color color){

        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean checkColor(){
        return this.color.equals(Color.WHITE);
    }

    public void isFirstMove(boolean flag){
        isFirst = false;
    }

    public boolean isFirst() {
        return isFirst;
    }

        public String Move() {
        return "1," + y;
    }
    public void confirmMove(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void possibleMoves() {

    }
}
