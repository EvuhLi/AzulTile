import java.awt.*;
import javax.swing.*;

public class FirstImage extends JFrame {
    private static final int HEIGHT = 480;
    private static final int WIDTH = 1200;

    public FirstImage (String frameName){
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        add(new ImagePanel());
        setVisible(true);
    }
}
