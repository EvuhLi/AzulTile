import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AzulPanel extends JPanel implements MouseListener {
	private BufferedImage border, factory, azulBoard;
	boolean start = true, build = false, score = false;
	Factory f1 = new Factory();
	Factory f2 = new Factory();
	Factory f3 = new Factory();
	Factory f4 = new Factory();
	Factory f5 = new Factory();
	Factory f6 = new Factory();
	Factory f7 = new Factory();
	Factory f8 = new Factory();
	Factory f9 = new Factory();
	MainMenuPanel menu = new MainMenuPanel();

	public AzulPanel() {

		try {
			border = ImageIO.read(new File("src/images/border.png"));

		} catch (Exception E) {
			System.out.println("Exception Error");
			return;
		}
		addMouseListener(this);
	}
// method to paint the factory
//put the 4 tiles there

//another class to paint the 9 factories
	public void paint(Graphics g) {
		if(start){
			menu.drawMenu(g, getWidth(), getHeight());
			System.out.println(getWidth() + " " + getHeight());
			menu.download();
		}
		else{
		g.drawImage(azulBoard, 0, 0, getWidth(), getHeight(), null);
		int halfw = getWidth() / 2;
		int halfh = getHeight() / 2;
//top left
		f1.paintFactory(halfw / 4, halfh * 3 / 4, getWidth(), getHeight(), g);
// //lower middle left
		f2.paintFactory(halfw * 3 / 9, getHeight() * 14 / 17, getWidth(), getHeight(), g);

// //left
		f3.paintFactory(getWidth() / 15, getHeight() * 4 / 6, getWidth(), getHeight(), g);
// //right m
		f4.paintFactory(getWidth() * 2 / 6, getHeight() * 4 / 6, getWidth(), getHeight(), g);}
		g.drawImage(border, 0, 0, getWidth(), getHeight(), null);
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

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("loc is (" + x + "," + y + ")");
		if (e.getButton() == e.BUTTON1) {

		}
		repaint();
	}
}
