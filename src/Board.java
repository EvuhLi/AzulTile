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

    }

    public boolean colorInBoard(String color, int row){
        for(int c = 0; c < 5; c++){
            if (b[row][c] != null && b[row][c].getColor().equals(color)) return true;
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
       /*  ArrayList<Tile[]> rows = r.getRows();
        for ( int i = 0; i<rows.size(); i++){
            if (r.rowIsFull(i)){
                Tile[] atm = rows.get(i);
                atm[atm.length - 1].onBoard = true; 

            */  }
      //  }
     /*    int w = 0;
        for (Tile[] row: r.getRows()){ // for each cant edit? 
            if (r.rowIsFull(w)){
                row[row.length-1].onBoard = true;
                int c = 0;
                for (int i = 0; i<colors[w].length; i++){
                    if (row[0].getColor().equals(colors[w][i])){
                        c = i;
                    }
                }
                b[w][c] = row[row.length - 1];
                Arrays.fill(row, null); // move to discard (except 1st) + fill w/ null 
                countScore(w, c);
            }
            w++;
         } */
        // gah
            // if full 
                // change last tile in arrayList to onboard true
                // iterate through that row on the colors matrix to see which spot that color is in
                // set that spot to the last tile in the arrayList
                // empty the rest of the row
                // count score(r and c that we found by iterating through the colors matrix)

 //  }

    public int countScore (int r, int c){
        score++;
        for ( int i = 1; r-i>-1 && b[r-i][c]!= null && b[r-i][c].onBoard; i++){
            score++;
        }
        for ( int i = 1; c-i>-1 && b[r][c-i]!= null && b[r][c-i].onBoard; i++){
            score++;
        }
        for ( int i = 1; r+i<5 && b[r+i][c]!= null && b[r+i][c].onBoard; i++){
            score++;
        }
        for ( int i = 1; c+i<5 && b[r][c+i]!= null && b[r][c+i].onBoard; i++){
            score++;
        }
        return score;
    }
    
    public boolean countEndScore(){ // need to implement
    //    int bonus = 0;
    //    return score + bonus;
  //  }
    
    // public boolean checkEnd(){ // need to implement
    //    for (Tile[] arr: b){
    //        for (Tile i: arr){
    //          //  if (!i.onBoard){
     //               break;
     //           }
          //  }
    //    }
    return true;
  }
}

