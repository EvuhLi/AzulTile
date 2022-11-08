import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Tile> bag;
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
        players.add(new Player(""));
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
