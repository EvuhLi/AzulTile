import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AzulFactory{
	private BufferedImage factory, azulBoard;

	Factory f1 = new Factory();
	Factory f2 = new Factory();
	Factory f3 = new Factory();
	Factory f4 = new Factory();
	Factory f5 = new Factory();
	Factory f6 = new Factory();
	Factory f7 = new Factory();
	Factory f8 = new Factory();
	Factory f9 = new Factory();

	public AzulFactory() {

		try {
            azulBoard = ImageIO.read(new File("src/images/azul tiles background.jpg"));
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
	f2.paintFactory(halfw * 3 / 10, Height * 14 / 17, Width, Height, g);

// //lower middle left
	f3.paintFactory(Width / 15, Height * 4 / 6, Width, Height, g);
// //lower right 
	f4.paintFactory(Width * 2 / 6, Height * 4 / 6, Width, Height, g);
// //top top
	f5.paintFactory(Width/ 5, halfh * 3 / 6, Width, Height, g);
	// //top right
f6.paintFactory(Width * 2 / 7,halfh * 4 / 6, Width, Height, g);
// middle right
f7.paintFactory(Width * 2 / 6,Height/2, Width, Height, g);
// middle left
f8.paintFactory(Width / 15,Height/2, Width, Height, g);
//bottom right
f9.paintFactory(Width*2 / 8,Height * 14 / 17, Width, Height, g);

	}

}
