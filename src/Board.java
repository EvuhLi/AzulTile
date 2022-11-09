public class Board{
    Tile[][] b = new Tile[5][5];
    String[][] colors = new String[5][5];
    int score = 0;

    public Board(){
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
            if (colors[row][c].equals(color)) return true;
        }
        return false;
    }

    public void addTiles(){ // need to implement

        // iterate through each row / all the arraylists
// if left row is full
// iterate through columns
// if [r][c] in this class is same color as [r][c] in rows class
			// change the boolean onBoard of the board class to true
			// call Arrays.fill(rows, null) to empty the row if it’s full
			// countScore(r, c)

    }

    public int countScore (int r, int c){
       // for ( int i = 1; r-i>-1 && b[r-i][c]!= null && b[r-i][c].onBoard; i++){
            score++;
     //   }
     //   for ( int i = 1; c-i>-1 && b[r][c-i]!= null && b[r][c-i].onBoard; i++){
            score++;
       }
        for ( int i = 1; r+i<5 && b[r+i][c]!= null && b[r+i][c].onBoard; i++){
            score++;
        }
    //    for ( int i = 1; c+i<5 && b[r][c+i]!= null && b[r][c+i].onBoard; i++){
            score++;
    //    }
        return score;
 //   }

   // public int countEndScore(){ // need to implement
 //      int bonus = 0;
        
        return score + bonus;
  //  }
    
 //   public boolean checkEnd(){ // need to implement
        for (Tile[] arr: b){
            for (Tile i: arr){
              //  if (!i.onBoard){
                    break;
                }
            }
    //    }
        return true;
    }
}*/

