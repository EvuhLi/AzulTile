import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class ImagePanel extends JPanel {
    private BufferedImage screen;
    public ImagePanel(){
        try {
            screen = ImageIO.read(new File("AzulStartScreen.jpg"));
        }
        catch (Exception E){
            System.out.println("Exception Error");
            return;
        }
    }

    public void paint (Graphics g){
        g.setColor(Color.BLUE);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawImage(screen, 0, 0, 400, 400, null);
        }
}
 //heheh