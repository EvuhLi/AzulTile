import java.util.ArrayList;

public class Player {
    private int turnNum;
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;


    public Player(){

        turnNum = null;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();

    }

    public void setTurn(int t){
        turnNum = t;
    }

    public int getTurn(){
        return turnNum;
    }

    public void setScore(int x){
        score = x;
    }

    public int getScore(){
        return score;
    }

    public void addTile(Tile x){

        tilePicked.add(x);
    }
}
