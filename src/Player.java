import java.util.ArrayList;

public class Player {
    private ArrayList<Tile> tilePicked;
    private int score;
    private Board b;
    private Row row;
    private String color;
    private Boolean hasFirst;
    private ArrayList<Tile> tempDiscard;

    public Player(String color){
        tempDiscard = new ArrayList<>();
        this.color = color;
        tilePicked = new ArrayList<Tile>();
        score = 0;
        b = new Board();
        row = new Row();
        tilePicked.add(new Tile("red"));
    }
    public void transferDiscard(){
        b.addToDiscard(row.getDiscard());
        row.getDiscard().clear();
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
    
    public void addTiles(ArrayList<Tile> arr){
            tilePicked.addAll(arr);
    }
    public void addToRow(int r){
        if(validRow(r)){
            row.addToRow(r, tilePicked);
           addRandom();
        }    
    }
    public void addRandom(){
        String color = "";
        int rand = (int)(Math.random()*5) + 1;
        if(rand == 1) color = "red";
        if(rand == 2) color = "black";
        if(rand == 3) color = "teal";
        if(rand == 4) color = "yellow";
        if(rand == 5) color = "blue";
        for(int c = 0; c < 5; c++){
            tilePicked.add(new Tile(color));
        }
    }
    /*public boolean hasFirst(){
        //if(tilePicked.contains(tile one)){
            return true;
        }
        return false;
    }*/

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

    public void rowToBoard (){
        for ( int c = 0; c < 5; c++){
            if (row.rowIsFull(c)){
                row.getRow(c)[0].onBoard = true;
                int temp = 0;
                for ( int i = 0; i < 5; i ++){
                    if (b.colors[c][i].equals(row.getRow(c)[0].getColor())){
                        temp = i;
                    }
                }
                b.b[c][temp] = row.getRow(c)[0];
                for (int i = 5; i >= 1; i--){
                    Game.discard.add(row.getRow(c)[i]);
                    row.clearRow(c);
                }
            }
        }
    }
}
