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
	private BufferedImage factory, azulBoard, factorymiddle;

	OneFactoryPanel f1 = new OneFactoryPanel();
	OneFactoryPanel f2 = new OneFactoryPanel();
	OneFactoryPanel f3 = new OneFactoryPanel();
	OneFactoryPanel f4 = new OneFactoryPanel();
	OneFactoryPanel f5 = new OneFactoryPanel();
	OneFactoryPanel f6 = new OneFactoryPanel();
	OneFactoryPanel f7 = new OneFactoryPanel();
	OneFactoryPanel f8 = new OneFactoryPanel();
	OneFactoryPanel f9 = new OneFactoryPanel();
	OneFactoryPanel middle = new OneFactoryPanel();

	private int x, y;

	public AllFactoryPanel() {

		try {
            factory = ImageIO.read(new File("src/images/factory.png"));
			factorymiddle = ImageIO.read(new File("src/images/factorymiddle.png"));

		} catch (Exception E) {
			System.out.println("Exception Error");
			return;
		}
	}

public void choosing(Graphics g){

	if(x>=265 && x<=362 && y>=200 && y<=297){
		System.out.println("f1!");
		f1.paintChoosing(g);
	}
	else if(x>=128 && x<=233 && y>=243 && y<=336){
		System.out.println("f2!");
		f2.paintChoosing(g);
	}
	else if(x>=94 && x<=194 && y>=357 && y<=453){
		System.out.println("f3!");
		f3.paintChoosing(g);
	}
	else if(x>=95 && x<=196 && y>=468 && y<=567){
		System.out.println("f4!");
		f4.paintChoosing(g);
	}
	else if(x>=201 && x<=299 && y>=545 && y<=637){
		System.out.println("f5!");
		f5.paintChoosing(g);
	}
}
public void setCood(int x1, int y1){
	System.out.println("here");
	x = x1;
	y = y1;

	if(x>=205 && x<=423 && y>=312 && y<=536 ){
	//its in the middle
	}
}
public void paint(Graphics g, int Width, int Height) {

	int halfw = Width / 2;
	int halfh = Height / 2;
	// //top top
	f1.paintFactory(Width/ 5, halfh * 6 / 11, Width, Height, g);
	//top left
	f2.paintFactory(halfw / 5, halfh * 4 / 6, Width, Height, g);
	// middle left
	f3.paintFactory(Width / 15,Height/2, Width, Height, g);
	// //lower middle left
	f4.paintFactory(Width / 15, Height * 4 / 6, Width, Height, g);
	// //bottom left
	f5.paintFactory(halfw * 3 / 10, Height * 14 / 18, Width, Height, g);
	//bottom right
	f6.paintFactory(Width*2 / 8,Height * 14 / 18, Width, Height, g);
	// //lower right 
	f7.paintFactory(Width * 2 / 6, Height * 4 / 6, Width, Height, g);
	// middle right
	f8.paintFactory(Width * 2 / 6,Height/2, Width, Height, g);
	// //top right
	f9.paintFactory(Width * 2 / 7,halfh * 4 / 6, Width, Height, g);

	middle.isMiddle();
	middle.paintFactory(Width * 2 / 7,halfh * 4 / 6, Width, Height, g);
	g.drawImage(factorymiddle, 205, Height/2 - 20, 220, 220, null);
	}

}
