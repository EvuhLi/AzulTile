import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class AzulPanel extends JPanel implements MouseListener, MouseMotionListener{
	boolean start = true, build = false, score = false, factory = false, pickedF = false;
	MainMenuPanel menu;
	AllFactoryPanel factoryP;
	Game game;
	PlayerPanel board;
	int width, height;
	int row;

	public AzulPanel(int w, int h) {
		menu = new MainMenuPanel();
		factoryP = new AllFactoryPanel();
		addMouseListener(this);
		addMouseMotionListener(this);
		width = w;
		height = h;
		row = 0;
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
		//if they have chosen a factory, paint the options
		if(factory && pickedF){
			factoryP.choosing(g);
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
		//g.drawImage(glowingrow, width/2 + 250 - c*45, height/2 - 87 + 45*c, (c+1)*44, 40, null);
		//need boolean for when player has picked tiles
			if(x >= 885 && x <= 925  && y >= 255 && y <= 295) {
				game.getPlayers().get(0).addToRow(0);
			}
			if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
				game.getPlayers().get(0).addToRow(1);
			}
			if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
				game.getPlayers().get(0).addToRow(2);
			}
			if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
				game.getPlayers().get(0).addToRow(3);
			}
			if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
				game.getPlayers().get(0).addToRow(4);
			}
				
		 
		
		//after the start screen
		if(factory){
			pickedF = true;
			//if its within factory range at all
			if(x>=94 && x<=531 && y>=199 && y<=649){
				factoryP.setCood(x, y);
			}
			//if its within the choosing image, then move on to next stage
			if(x>=600 && x<=1300 && y>=-50 && y<=350){
				pickedF = false;
				factory = false;
				factoryP.setCood(x, y);
			}
		}
		if(start){
			if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
				start = false;
				game = new Game();
				board = new PlayerPanel(game);
				factory = true;
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
		if(start){
			menu.hover = -1;
			if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
				menu.hover = 1;
			}
			if(x >= 100 && x <= 550 && y >= getHeight()/2 + 200 && y <= getHeight()/2 + 275){
				menu.hover = 2;
			}
			if(x >= 885 && x <= 925  && y >= 255 && y <= 295) {
				game.getPlayers().get(0).addToRow(0);
			}
			if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
				game.getPlayers().get(0).addToRow(1);
			}
			if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
				game.getPlayers().get(0).addToRow(2);
			}
			if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
				game.getPlayers().get(0).addToRow(3);
			}
			if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
				game.getPlayers().get(0).addToRow(4);
			} 

		}

		repaint();
	}
}
