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
	private BufferedImage border, factory, screenbg;
	boolean start = true, build = false, score = false;
	MainMenuPanel menu = new MainMenuPanel();
	AzulFactory factoryP = new AzulFactory();

	public AzulPanel() {

		try {
			border = ImageIO.read(new File("src/images/border.png"));
			screenbg = ImageIO.read(new File("src/images/bluebg.png"));


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
		super.paintComponent(g);
		if(start){
			menu.drawMenu(g, getWidth(), getHeight());
		}
		else{
			g.drawImage(screenbg, 0, 0, getWidth(), getHeight(), null);
			factoryP.paint(g, getWidth(), getHeight());
			g.drawImage(border, 0, 0, getWidth(), getHeight(), null);
		}
	
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
		if(start){
			if(x >= 90 && x <= 470 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 168){
				start = false;
			}

			if(x >= 100 && x <= 450 && y >= getHeight()/2 + 200 && y <= getHeight()/2 + 275){
				menu.download = true;
				new Thread(menu).start();

			}
		}
		repaint();
	}
}
