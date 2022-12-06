import java.util.ArrayList;

public class Player {
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;
    private String color;
    public Boolean first;
    public boolean full;

    public Player(String color){
        first = false;
        this.color = color;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();
        row = new Row();
        //tilePicked.add(new Tile("red"));
    }
    
    public void addToScore(int x){
        score+= x;
    }
    public void isOne(boolean f){
        first = f;
        if(f){
            b.discard.add(new Tile("first"));

        }
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
    public void setScore(int x){
        score=x;
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
        if(b.colorInBoard(tilePicked.get(0).getColor(), rowNum)) return false;
        //System.out.println(row.getRow(rowNum));//[0].getColor());
        if(row.getRow(rowNum)[0] == null) return true;
        return(row.getRow(rowNum)[0].getColor().equals(tilePicked.get(0).getColor()));  //checks if row has same color as picked tile
        
        
    }
    public void rowToBoard (int r){
        if (row.rowIsFull(r)){
            
            b.addTile(r, row.getRow(r)[0]);
            score = b.score;
            //board.row.getRow(c)[0].onBoard = true;
            for (int i = row.getRow(r).length - 1; i >= 1; i--){
                Game.discard.add(row.getRow(r)[i]);
            }
            row.clearRow(r);
        }
    }

    public int countPenalty(){
        System.out.println("coufjsda");
        int p = 0;
        for ( int i = 0; i < b.getDiscard().size(); i++){
            if (i < 2){
                p -= 1;
            } else if ( i < 5){
                p -=2;
            } else {
                p -= 3;
            }
        }
        return p;

    }
}
