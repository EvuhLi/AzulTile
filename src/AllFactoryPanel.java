import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AllFactoryPanel{
	private BufferedImage factory, azulBoard;

	OneFactoryPanel f1 = new OneFactoryPanel();
	OneFactoryPanel f2 = new OneFactoryPanel();
	OneFactoryPanel f3 = new OneFactoryPanel();
	OneFactoryPanel f4 = new OneFactoryPanel();
	OneFactoryPanel f5 = new OneFactoryPanel();
	OneFactoryPanel f6 = new OneFactoryPanel();
	OneFactoryPanel f7 = new OneFactoryPanel();
	OneFactoryPanel f8 = new OneFactoryPanel();
	OneFactoryPanel f9 = new OneFactoryPanel();

	public AllFactoryPanel() {

		try {
            factory = ImageIO.read(new File("src/images/factory.png"));

		} catch (Exception E) {
			System.out.println("Exception Error");
			return;
		}
	}
// method to paint the factory
//put the 4 tiles there

//another class to paint the 9 factories
	public void paint(Graphics g, int Width, int Height) {
//private static final int WIDTH =1920;
//private static final int HEIGHT = 1000;
	//	g.drawImage(azulBoard, 0, 0, getWidth(), getHeight(), null);
	int halfw = Width / 2;
	int halfh = Height / 2;
//top left
	f1.paintFactory(halfw / 5, halfh * 4 / 6, Width, Height, g);
// //bottom left
	f2.paintFactory(halfw * 3 / 10, Height * 14 / 18, Width, Height, g);

// //lower middle left
	f3.paintFactory(Width / 15, Height * 4 / 6, Width, Height, g);
// //lower right 
	f4.paintFactory(Width * 2 / 6, Height * 4 / 6, Width, Height, g);
// //top top
	f5.paintFactory(Width/ 5, halfh * 6 / 11, Width, Height, g);
	// //top right
f6.paintFactory(Width * 2 / 7,halfh * 4 / 6, Width, Height, g);
// middle right
f7.paintFactory(Width * 2 / 6,Height/2, Width, Height, g);
// middle left
f8.paintFactory(Width / 15,Height/2, Width, Height, g);
//bottom right
f9.paintFactory(Width*2 / 8,Height * 14 / 18, Width, Height, g);

	}

}
