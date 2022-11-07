public class Board{
    Tile[][] b = new Tile[5][5];
    int points = 0;

    public Board(){}

    public boolean colorInBoard(String color, int row){
        for(int c = 0; c < 5; c++){
            if (b[row][c].getColor().equals(color)) return true;
        }
        return false;
    }
}