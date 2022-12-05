import java.util.ArrayList;

public class Board{
    Tile[][] b = new Tile[5][5];
    String[][] colors = new String[5][5];
    int score = 0;
    ArrayList<Tile> discard;

    public Board(){
        discard = new ArrayList<>();
        colors[0][0] = "blue";
        colors[0][1] = "yellow";
        colors[0][2] = "red";
        colors[0][3] = "black";
        colors[0][4] = "teal";
        colors[1][0] = "teal";
        colors[1][1] = "blue";
        colors[1][2] = "yellow";
        colors[1][3] = "red";
        colors[1][4] = "black";
        colors[2][0] = "black";
        colors[2][1] = "teal";
        colors[2][2] = "blue";
        colors[2][3] = "yellow";
        colors[2][4] = "red";
        colors[3][0] = "red";
        colors[3][1] = "black";
        colors[3][2] = "teal";
        colors[3][3] = "blue";
        colors[3][4] = "yellow";
        colors[4][0] = "yellow";
        colors[4][1] = "red";
        colors[4][2] = "black";
        colors[4][3] = "teal";
        colors[4][4] = "blue";
        //🦧
    }

    public boolean colorInBoard(String color, int row){
        for(int c = 0; c < 5; c++){
            if (b[row][c] != null && b[row][c].getColor().equals(color)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tile> getDiscard(){
        return discard;
    }
    public void addToDiscard(ArrayList<Tile> arr){
        discard.addAll(arr);
    }

    public void addTile(int row, Tile tile){ 
        for(int c = 0; c < 5; c++){
            if(colors[row][c].equals(tile.getColor())){
                b[row][c] = tile;
                countScore(row, c);
            }
        }
    }

    public void countScore (int r, int c){
        score++;
        for ( int i = 1; r-i>-1 && b[r-i][c]!= null; i++){
            score++;
        }
        for ( int i = 1; c-i>-1 && b[r][c-i]!= null; i++){
            score++;
        }
        for ( int i = 1; r+i<5 && b[r+i][c]!= null; i++){
            score++;
        }
        for ( int i = 1; c+i<5 && b[r][c+i]!= null; i++){
            score++;
        }
        
    }

    public void countEndScore(){
        int bonus= 0;
        // check row
        int f = 0;
        for ( int r = 0; r < 5; r ++){
            for ( int c = 0; c < 5; c++){
                if (b[r][c]!=null) f++;
            }
            if (f==5) bonus += 2; 
            f=0;
        }
        // check column
        int x = 0;
        for ( int c = 0; c < 5; c++){
            for ( int r = 0; r < 5; r++){
                if (b[r][c]!=null) x++;
            }
            if (x==5) bonus+=7;
            x=0;
        }
        // check all colors
        int t = 0;
        ArrayList<String> cols = new ArrayList<>();
        cols.add("red");
        cols.add("blue");
        cols.add("teal");
        cols.add("yellow");
        cols.add("black");
        for (int i = 0; i < 5; i ++){
            for ( int r = 0; r<5; r++){
                if (colorInBoard(cols.get(i), r)){
                    t++;
                }
            }
            if (t==5) bonus+=10;
            t=0;
        }

        score += bonus;
    } 
    
    
    public boolean checkEnd(int row){ 
        int f = 0;
        for ( int r = 0; r < 5; r ++){
            if (b[row][r]!=null)
             f++;
            
        }
        return f == 5;
     } 
}

