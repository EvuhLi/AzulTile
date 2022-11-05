import java.util.ArrayList;

public class Player {
    private int turnNum;
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;


    public Player(){

        turnNum = -1;
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

    public ArrayList<Tile> getPicked(){
        return tilePicked;
    }
    public int getScore(){
        return score;
    }

    public void addTile(Tile x){

        tilePicked.add(x);
    }
    public boolean validRow(int rowNum){
        if(row.rowIsFull(rowNum)) return false; //checks if row is full (cant place more tiles)
        if(!row.getRows().get(rowNum)[0].getColor().equals(tilePicked.get(0).getColor())) return false; //checks if row has same color as picked tiles
        if(b.colorInBoard(tilePicked.get(0).getColor(), rowNum)) return false; //checks if board already contains that color (cant place same tile color)
        return true;
    }
}
