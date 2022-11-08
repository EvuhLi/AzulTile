import java.util.ArrayList;

public class Game {
    private static ArrayList<Player> players;
    private static ArrayList<Tile> bag;
    private static ArrayList<Tile> discard;
    private static ArrayList<Factory> factories;
    static Factory middle;
    static int turn;
    static int phase; //1 is build, 2 is score, 3 is end game. we can use this instead of booleans beacause its easier
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

    public ArrayList<Player> getPlayers(){
        return players;
    }
    
    public Player getPlayer(String color){
        for(Player player: players){
            if(player.getColor().equals(color)){
                return player;
            }
        }
        return players.get(0);
    }
    public void resetFactories(){
        
    }
}

