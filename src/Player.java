import java.util.ArrayList;

public class Player{
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;
    private String color;
    private Tile first;
    private Boolean hasFirst;


    public Player(String color){
        this.color = color;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();
        row = new Row();
        tilePicked.add(new Tile("blue"));

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
    
    public void addTile(Tile x){

        tilePicked.add(x);
    }
    
    public boolean hasFirst(){
        
        if(tilePicked.contains(bag.get("one")){
            return true;
        }
        return false;
    }

    
    public void setFirst(Boolean b){
        hasFirst = b;
        if(b == true){
            first = new Tile("one");
        }else{
            first = null;
        }
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
        return true;
    }

    public void rowToBoard(){
        for(int c = 0; c < 5; c++){
            if(row.rowIsFull(c)){
                row.getRow(c)[0].onBoard = true;
                
            }
        }
    }
}
