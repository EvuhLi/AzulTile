import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Tile {

    private String color;
    private BufferedImage pic;
    public boolean onBoard;

    public Tile(String c){

        color = c;
        setPic(color);
    }

    private void setPic(String color){
        //🦧
        try{
            if(color == "black"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/black tile.png"));
    
            }else if(color == "blue"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/blue tile.png"));
    
            }else if(color == "red"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/red tile.png"));
    
            }else if(color == "yellow"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/yellow tile.png"));
    
            }else if(color == "teal"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/teal tile.png"));
    
            }
            else if(color == "first"){
                pic = ImageIO.read(getClass().getResourceAsStream("/images/firstplayer.png"));
            }

        }
        catch(Exception e){

            System.out.println(e.getMessage());
			return;
        }

       
    }

    public BufferedImage getImage(){
        return pic;
    }

    public String getColor(){
        return color;
    }
    
}
