import java.util.ArrayList;
import java.util.Collections;

public class Game {
     static ArrayList<Player> players;
     static ArrayList<Tile> bag, colors;
     static ArrayList<Tile> discard;
     static ArrayList<Factory> factories;
     static Factory middle;
     static int pickedRow;
     static int phase; //1 is build, 2 is score, 3 is end game. we can use this instead of booleans beacause its easier
     public Game(){
        players = new ArrayList<>();
        bag = new ArrayList<>();
        discard = new ArrayList<>();
        factories = new ArrayList<>();
        pickedRow = -1;

        players.add(new Player("red"));
        players.add(new Player("yellow"));
        players.add(new Player("green"));
        players.add(new Player("blue"));

        for(int c = 0; c < 10; c++){
            factories.add(new Factory(false));
        }
        middle = new Factory(true);
        phase = 1;

        colors = new ArrayList<>();
        colors.add(new Tile("black"));
        colors.add(new Tile("blue"));
        colors.add(new Tile("red"));
        colors.add(new Tile("yellow"));
        colors.add(new Tile("teal"));

        createBag();

    }

    public void createBag(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 20; j++){
                bag.add(colors.get(i));
            }
        }

        Collections.shuffle(bag);
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

        if(bag.size() + discard.size() < 100){

            bag.addAll(discard);

        }else{
            int i = 0;
            while(bag.size() < 100){
                bag.add(discard.get(i));
            }
        }

        Collections.shuffle(bag);
        discard.clear();
    }
    public void transferDiscard(){
        players.get(0).getBoard().addToDiscard(players.get(0).getRow().getDiscard());
        players.get(0). getRow().getDiscard().clear();
        if(players.get(0).getBoard().getDiscard().size() > 7){
            for(int c = players.get(0).getBoard().getDiscard().size() -1; c > 6; c--){
                discard.add(players.get(0).getBoard().getDiscard().remove(c));
            }
            System.out.println(discard.size());
        }
    }

    public ArrayList<Factory> getFactories(){
        return factories;
    }
    public void addToDiscard(Tile tile){
        discard.add(tile);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
    
    public Player getPlayer(String color){ //delete this after your create the player arryalist
        for(Player player: players){
            if(player.getColor().equals(color)){
                return player;
            }
        }
        return players.get(0);
    }

    public void resetFactories(){
        
    }

    public ArrayList<Tile> getFour(){
        ArrayList<Tile> four = new ArrayList<>();

        for(int i = 0; i < 4; i++) {

            four.add(bag.remove(i));

        }

        return four;
    }
}

