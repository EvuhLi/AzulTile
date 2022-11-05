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
	public void paint(Graphics g, int width, int height) {

		g.drawImage(azulBoard, 0, 0, width, height, null);
		int halfw = width / 2;
		int halfh = height/ 2;
//top left
		f1.paintFactory(halfw / 4, halfh * 3 / 4, width, height, g);
// //lower middle left
		f2.paintFactory(halfw * 3 / 9, height * 14 / 17, width, height, g);

// //left
		f3.paintFactory(width / 15, height* 4 / 6, width, height, g);
// //right m
		f4.paintFactory(width * 2 / 6, height * 4 / 6, width, height, g);
// //top left
// f5.paintFactory(getWidth()/6,getHeight()/6, getWidth(), getHeight(), g);
// //top right
// f6.paintFactory(getWidth()/2+(getWidth()/6),getHeight()/6, getWidth(), getHeight(), g);
// //lower left
// f7.paintFactory(getWidth()*1/9,getHeight()*5/8, getWidth(), getHeight(), g);
// //right low mid
// f8.paintFactory(getWidth()*4/7,getHeight()*14/18, getWidth(), getHeight(), g);
//
// f9.paintFactory(getWidth()*3/4,getHeight()*5/8, getWidth(), getHeight(), g);

	}

}
