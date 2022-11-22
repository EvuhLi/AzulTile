import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.plugins.tiff.TIFFDirectory;

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
    }
    public String toString(){
        String str = "";
        for(Tile[] row : rows){
            for(Tile tile: row){
                if(tile!= null) str+= tile.getColor() + " ";
                else str+= "null ";
            }
            str+= "\n";
        }
        return str;
    }
    public void fillRow(String color, int row){
        for(int c = 0; c < rows.get(row).length; c++){
            rows.get(row)[c] = new Tile(color);
        }
    }
    public boolean rowIsFull(int row){
        Tile[] temp = rows.get(row);
        for(Tile tile : temp){
            if(tile == null) return false;
        }
        return true;
    }
    public ArrayList<Tile> getDiscard(){
        return discard;
    }

    public void addToRow(int row, ArrayList<Tile> add){
        if(rowIsFull(row)) discard.addAll(add);
        else{
            int indx = 0;
            int c = 0;
            while(getRow(row)[indx] != null){
                indx++;
            }
            while(!rowIsFull(row) && indx < getRow(row).length && add.size() > 0){
                getRow(row)[indx] = add.remove(c);
                indx++;
            }
            while(add.size() > 0){
                discard.add(add.remove(0));
            }
        }
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