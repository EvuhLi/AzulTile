import java.util.ArrayList;

public class Player {
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;
    private String color;
    private Boolean hasFirst;


    public Player(String color){
        this.color = color;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();
        row = new Row();
        hasFirst = false;

    }

    public Board getBoard(){
        return b;
    }
    public Row getRow(){
        return row;
    }
    public String getColor(){
        return color;
    }
    public void addScore(int x){
        score+=x;
    }

    public ArrayList<Tile> getPicked(){
        return tilePicked;
    }
    public int getScore(){
        return score;
    }

    public Boolean hasFirst(){
        if(tilePicked.contains(tile)){ //need to define tile one
            return true;
        }
        return false;
    }

    public void addTile(Tile x){

        tilePicked.add(x);
    }
    public boolean validRow(int rowNum){

        if(row.rowIsFull(rowNum)){  //checks if row is full (cant place more tiles)
            return false;
        }  
        if(!row.getRows().get(rowNum)[0].getColor().equals(tilePicked.get(0).getColor())){  //checks if row has same color as picked tile
            return false;
        }
        if(b.colorInBoard(tilePicked.get(0).getColor(), rowNum)){  //checks if board already contains that color (cant place same tile color)
            return false;
        }

        return true;
    }
}
