import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile {

    private String color;

    public Tile(String c){

        color = c;
        setPic(color);
        

    }

    private void setPic(String color){

        if(color == "black"){
            pic = ImageIO.read(new File("src/images/black tile.png"));

        }else if(color == "blue"){
            pic = ImageIO.read(new File("src/images/blue tile.png"));

        }else if(color == "red"){
            pic = ImageIO.read(new File("src/images/red tile.png"));

        }else if(color == "yellow"){
            pic = ImageIO.read(new File("src/images/yellow tile.png"));

        }else if(color == "teal"){
            pic = ImageIO.read(new File("src/images/teal tile.png"));

        }
    }

    public BufferedImage getImage(){
        return pic;
    }

    public String getColor(){
        return color;
    }
    
}
