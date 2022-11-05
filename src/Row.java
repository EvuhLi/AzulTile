import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Row{
    Tile[] none = new Tile[1];
    Tile[] one = new Tile[1];
    Tile[] two = new Tile[2];
    Tile[] three = new Tile[3];
    Tile[] four = new Tile[4];
    Tile[] five = new Tile[5];
    List<Tile[]> anotherList = Arrays.asList(none, one, two, three, four, five);
    ArrayList<Tile[]> rows;
    ArrayList<Tile> discard;
    
    public Row(){
        rows = new ArrayList<>()
        rows.addAll(anotherList);
        discard = new ArrayList<>();
    }
    
    
}