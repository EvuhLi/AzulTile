import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

public class EndScreenPanel{

    private BufferedImage bkg, gray;

    public EndScreenPanel(){
        try{

            bkg = ImageIO.read(new File("src/images/azulejos.png"));
            gray = ImageIO.read(new File("src/images/startgamebg.png"));
            


        }  
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }

    public void drawMenu(Graphics g) {

        g.drawImage(bkg, 0, 0, 1920, 1080, null);
        g.drawImage(gray, 100, 100, 1820, 1720, null );
		
		
	}	
    
}
