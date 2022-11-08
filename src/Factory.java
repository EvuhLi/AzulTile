import java.util.ArrayList;

public class Factory {
    boolean middle;
    ArrayList<Tile> tiles;

    public Factory(boolean m){
        middle = m;
        tiles = new ArrayList<>();
    }

    public ArrayList<Tile> getArray(){
        return tiles;
    }
    public int getTiles(String color){
        int count = 0;
        for(int c = 0; c < tiles.size(); c++){
            if(tiles.get(c).getColor().equals(color)) count++;
        }
        return count;
    }

    public ArrayList<Tile> pickTiles(String color){
        ArrayList<Tile> picked = new ArrayList<>();
        for(int c = tiles.size()-1; c > -1; c--){
            if(!tiles.get(c).equals(color)){
                //middle.add(tiles.remove(c));
            }
            else picked.add(tiles.remove(c));
        }
        return picked;
    }

    public boolean isEmpty(){
        return (tiles.size() == 0);
    }

    public boolean numberOne(){ //used for middle
        for(Tile tile: tiles){
            if(tile.getColor().equals("one")){
                return true;
            }
        }
        return false;
    }
}
