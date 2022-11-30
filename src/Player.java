import java.util.ArrayList;

public class Player {
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;
    private String color;
    public Boolean first;

    public Player(String color){
        first = false;
        this.color = color;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();
        row = new Row();
        //tilePicked.add(new Tile("red"));
    }
    public void addFirstTile(){
        
    }
    public void isOne(boolean f){
        first = f;
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
    
    public void setTiles(ArrayList<Tile> arr){
        tilePicked.clear();
        tilePicked.addAll(arr);
    }
    public void addToRow(int r){
        row.addToRow(r, tilePicked);
        //🦧
    }
    public boolean validRow(int rowNum){
        if(row.rowIsFull(rowNum)){  //checks if row is full (cant place more tiles)
            return false;
        }  
        if(row.getRow(rowNum).length == 0) return true;
        //System.out.println(row.getRow(rowNum));//[0].getColor());
        if(row.getRow(rowNum)[0] == null) return true;
        if(!row.getRow(rowNum)[0].getColor().equals(tilePicked.get(0).getColor())){  //checks if row has same color as picked tile
            return false;
        }
        if(b.colorInBoard(tilePicked.get(0).getColor(), rowNum)){  //checks if board already contains that color (cant place same tile color)
            return false;
        }
        return true;//hihhgj
    }
    public boolean rowToBoard (int r){
        boolean end = false;
        if (row.rowIsFull(r)){
            
            b.addTile(r, row.getRow(r)[0]);
            score = b.score;
            //board.row.getRow(c)[0].onBoard = true;
            for (int i = row.getRow(r).length - 1; i >= 1; i--){
                Game.discard.add(row.getRow(r)[i]);
            }
            row.clearRow(r);
            end = b.checkEnd(r);
        }
        return end;
    }
}
