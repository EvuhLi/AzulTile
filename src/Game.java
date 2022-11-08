import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Tile> bag, colors;
    private ArrayList<Tile> discard;
    private ArrayList<Factory> factories;
    Factory middle;
    int turn;
    int phase; //1 is build, 2 is score, 3 is end game. we can use this instead of booleans beacause its easier
    public Game(){
        players = new ArrayList<>();
        bag = new ArrayList<>();
        discard = new ArrayList<>();
        factories = new ArrayList<>();
        

        //players.add(new Player(""));
        players.add(new Player("red"));
        players.add(new Player("yellow"));
        players.add(new Player("green"));
        players.add(new Player("blue"));

        for(int c = 0; c < 10; c++){
            factories.add(new Factory(false));
        }
        middle = new Factory(true);
        turn = (int)(Math.random()*4) + 1;
        phase = 1;

        colors = new ArrayList<>();
        colors.add(new Tile("black"));
        colors.add(new Tile("blue"));
        colors.add(new Tile("red"));
        colors.add(new Tile("yellow"));
        colors.add(new Tile("teal"));

    }

    public void createBag(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 20; j++){
                bag.add(colors.get(i));
            }
        }

        Collections.shuffle(bag);
    }

    public void turn(){
        turn = (turn+1)%4;
    }

    public boolean checkEmpty(){
        for(Factory factory: factories){
            if(!factory.isEmpty()) return false;
        }
        if(!middle.isEmpty())return false;
        phase = 2;
        return true;
    }

    public void resetBag(){
        bag.addAll(discard);
        discard = new ArrayList<>();
    }
    public ArrayList<Factory> getFactories(){
        return factories;
    }
    public void addToDiscard(ArrayList<Tile> arr){
        discard.addAll(arr);
    }

    public void resetFactories(){

    }
}
