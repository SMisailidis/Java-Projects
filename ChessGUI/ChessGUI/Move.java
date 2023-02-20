import Pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class Move {
    private int x, y;

    public Move(int x, int y){
        this.x = x;
        this.y = y;

    }
    public ArrayList<String> getPossibleMoves(Piece piece) {

        String moves = piece.Move();

        ArrayList<String> m = new ArrayList<>(Arrays.asList(moves.split("-")));

        return m;
    }

    public ArrayList<String[]> checkValidity(Square[][] squares, Piece piece){

        ArrayList<String> moves = getPossibleMoves(piece);
        ArrayList<String> validMoves = new ArrayList<>();

        for(int i=0;i<8;i++){
            System.out.println(squares[x][i].getIcon());
            if(squares[x][i].getIcon() == null){
                for(String r : moves){
                    System.out.println(r);
                    if(r.equals(x + "," + i)){
                        System.out.println("mphka");
                    }
                }
            }
        }

        return null;
    }
}
