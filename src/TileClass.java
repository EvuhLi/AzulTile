public class TileClass {
    private int xPos;
    private int yPos;
    private String color;

    public TileClass(String c){

        color = c;

    }

    public TileClass(String c, int x, int y){

        color = c;
        xPos = x;
        yPos = y;
    }

    public String getColor(){
        return color;
    }

    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }

    public void setXPos(int x){
        xPos = x;
    }

    public void setYPos(int y){
        yPos = y;
    }
}
