import java.util.ArrayList;
import java.util.Collections;

public class Game {
     static ArrayList<Player> players;
     static ArrayList<Tile> bag, colors;
     static ArrayList<Tile> discard;
     static AllFactoryPanel factoryP;
     static int pickedRow;
     static int phase; //1 is build, 2 is score, 3 is end game. we can use this instead of booleans beacause its easier
     public Game(){
        players = new ArrayList<>();
        bag = new ArrayList<>();
        discard = new ArrayList<>();
        pickedRow = -1;
        factoryP = new AllFactoryPanel();
        players.add(new Player("red"));
        players.add(new Player("yellow"));
        players.add(new Player("green"));
        players.add(new Player("blue"));

       
        phase = 1;

        colors = new ArrayList<>();
        colors.add(new Tile("black"));
        colors.add(new Tile("blue"));
        colors.add(new Tile("red"));
        colors.add(new Tile("yellow"));
        colors.add(new Tile("teal"));

        createBag();
        resetFactories();

    }
    public AllFactoryPanel getfactoryP(){
        return factoryP;
    }
    public void createBag(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 20; j++){
                bag.add(colors.get(i));
            }
        }

        Collections.shuffle(bag);
    }
    public void nextPlayer(){
        players.add(players.remove(0));
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

    
    public void addToDiscard(Tile tile){
        discard.add(tile);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void resetFactories(){
        for(int c = 0; c < 9; c++){//iterates through each ractory
            ArrayList<Tile> tempTile = new ArrayList<>();
            for(int d = 0; d < 4; d++){//adds four tiles from bag
                if(bag.size() < 1) resetBag();
                tempTile.add(bag.remove(0));
            }
            factoryP.getArray().get(c).setArray(tempTile);
        }
    }

    public ArrayList<Tile> getFour(){
        ArrayList<Tile> four = new ArrayList<>();

        for(int i = 0; i < 4; i++) {

            four.add(bag.remove(i));

        }

        return four;
    }
}

