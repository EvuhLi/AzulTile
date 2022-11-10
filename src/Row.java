import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Row{
    Tile[] one = new Tile[1];
    Tile[] two = new Tile[2];
    Tile[] three = new Tile[3];
    Tile[] four = new Tile[4];
    Tile[] five = new Tile[5];
    List<Tile[]> anotherList = Arrays.asList(one, two, three, four, five);
    public ArrayList<Tile[]> rows;
    private ArrayList<Tile> discard;
    
    public Row(){
        rows = new ArrayList<>();
        rows.addAll(anotherList);
        discard = new ArrayList<>();
        //temp:

        for(int c = 0; c < 5; c++){
            for(int d = 0; d <= c; d++){
                rows.get(c)[d] =new Tile("red");
            }
        }
        rows.get(4)[4] = null;
        rows.get(3)[2] = new Tile("blue");
    }
    
    public boolean rowIsFull(int row){
        Tile[] temp = rows.get(row);
        for(Tile tile : temp){
            if(tile == null) return false;
        }
        return true;
    }

    public void addToRow(int row, ArrayList<Tile> add){
        if(rowIsFull(row)) discard.addAll(add);

    }

    public ArrayList<Tile[]> getRows(){
        return rows;
    }
    public void clearRow(int row){
        rows.set(row, new Tile[row+1]);
    }
    public Tile[] getRow(int row){
        return rows.get(row);
    }
        
}