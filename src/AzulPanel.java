import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class AzulPanel extends JPanel implements MouseListener, MouseMotionListener{
	boolean start = true, build = false, score = false;
	MainMenuPanel menu;
	AllFactoryPanel factoryP;
	Game game;
	PlayerPanel board;

	public AzulPanel() {
		menu = new MainMenuPanel();
		factoryP = new AllFactoryPanel();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		if(start){
			menu.drawMenu(g, getWidth(), getHeight());
		}
		else{
			board.drawAll(g, getWidth(), getHeight());
			factoryP.paint(g, getWidth(), getHeight());
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
			if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
				start = false;
				game = new Game();
				board = new PlayerPanel(game);
			}
			if(x >= 100 && x <= 550 && y >= getHeight()/2 + 200 && y <= getHeight()/2 + 275){
				menu.download = true;
				new Thread(menu).start();

			}
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { //used for hover
		int x = e.getX();
		int y = e.getY();
		menu.hover = -1;
		if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
			menu.hover = 1;
		}
		if(x >= 100 && x <= 550 && y >= getHeight()/2 + 200 && y <= getHeight()/2 + 275){
			menu.hover = 2;
		}
		repaint();
	}
}
