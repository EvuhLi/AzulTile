public class Board{
    Tile[][] b = new Tile[5][5];
    String[][] colors = new String[5][5];
    int score = 0;

    public Board(){
        colors[0][0] = "";
        colors[0][1] = "";
        colors[0][2] = "";
        colors[0][3] = "";
        colors[0][4] = "";
        colors[1][0] = "";
        colors[1][1] = "";
        colors[1][2] = "";
        colors[1][3] = "";
        colors[1][4] = "";
        colors[2][0] = "";
        colors[2][1] = "";
        colors[2][2] = "";
        colors[2][3] = "";
        colors[2][4] = "";
        colors[3][0] = "";
        colors[3][1] = "";
        colors[3][2] = "";
        colors[3][3] = "";
        colors[3][4] = "";
        colors[4][0] = "";
        colors[4][1] = "";
        colors[4][2] = "";
        colors[4][3] = "";
        colors[4][4] = "";
    }

    public boolean colorInBoard(String color, int row){
        for(int c = 0; c < 5; c++){
            if (colors[row][c].equals(color)) return true;
        }
        return false;
    }

    public void addTiles(){

    }
}