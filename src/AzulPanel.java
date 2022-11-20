import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class AzulPanel extends JPanel implements MouseListener, MouseMotionListener{
	boolean start = true;
	int pickphase = -1;
	int gamephase = 0;
	MainMenuPanel menu;
	Game game;
	PlayerPanel board;
	int width, height;
	int row;

	public AzulPanel(int w, int h) {
		menu = new MainMenuPanel();
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
			board.drawAll(g, getWidth(), getHeight(), pickphase);
			game.getfactoryP().paint(g, getWidth(), getHeight());
		}
		//if they have chosen a factory, paint the options
		if(game.phase == 1){
			game.getfactoryP().choosing(g);
		}
		
		
		//try to make this happen AFTER you choose which row
		//if(gamephase == 1)
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
		if(pickphase == 3 && x >= 1020 && y >= 29 && x <= 1234 && y <= 68){//&&){
			game.nextPlayer(); 
			gamephase = 0;
			pickphase = 0;
		}
		if(!start && !game.facsEmpty() && pickphase < 2){
			//pickedF = true;
			//if its within factory range at all
			if(x>=94 && x<=531 && y>=199 && y<=649){
				game.getfactoryP().setCood(x, y);
				game.getfactoryP().whichPanel();
				game.getPlayers().get(0).getPicked().clear();
				pickphase = 0;
			}
			//if its within the choosing image, then move on to next stage
			if(x>=821 && x<=1066 && y>37 && y<=215 && pickphase > -1){
				game.getfactoryP().colorTile = "";
				pickphase = 0;
				game.getfactoryP().setCood(x, y);
				game.getPlayers().get(0).setTiles(game.getfactoryP().getChosen());
				System.out.println("size " + game.getPlayers().get(0).getPicked().size());
				if(game.getfactoryP().chosenTile){
					pickphase = 1;//tiles have been chosen
					game.getfactoryP().chosenTile = false;
				}
			}	
			if(pickphase == 1){
				if(x >= 885 && x <= 925  && y >= 255 && y <= 295) {
					if(game.getPlayers().get(0).validRow(0)){
						game.getPlayers().get(0).addToRow(0);
						pickphase = 2;
					}
				}
				if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
					if(game.getPlayers().get(0).validRow(1)){
						game.getPlayers().get(0).addToRow(1);
						pickphase = 2;
					}
				}
				if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
					if(game.getPlayers().get(0).validRow(2)){
						game.getPlayers().get(0).addToRow(2);
						pickphase = 2;
					}
					// game.getPlayers().get(0).addToRow(2);
					// pickphase = 2;
				}
				if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
					if(game.getPlayers().get(0).validRow(3)){
						game.getPlayers().get(0).addToRow(3);
						pickphase = 2;
					}
				}
				if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
					if(game.getPlayers().get(0).validRow(4)){
						game.getPlayers().get(0).addToRow(4);
						pickphase = 2;
					}
				}
			}
			if(pickphase == 2){
				game.getfactoryP().moveLeftoverTiles();
				//game.getPlayers().get(0).setTiles(game.getfactoryP().getChosen());
				OneFactoryPanel cur =game.getfactoryP().getTemp();
				if(!cur.isMiddle) cur.reset();
				pickphase = 3;
				//factory = false;
				//pickedF = false;
				game.getfactoryP().changeClicked(null);
				game.getfactoryP().temp = null;
				game.getfactoryP().chosenTile = false;
				//game.nextPlayer();
			}	
		}
		
		//g.drawImage(glowingrow, width/2 + 250 - c*45, height/2 - 87 + 45*c, (c+1)*44, 40, null);
		//need boolean for when player has picked tiles
		
		
		if(start){
			if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
				start = false;
				game = new Game();
				board = new PlayerPanel(game);
				game.phase = 1;
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
		}
		else if(pickphase == 1){
			if(x >= 885 && x <= 925  && y >= 255 && y <= 295) {
				board.hover = 0;
			}
			if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
				board.hover = 1;
			}
			if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
				board.hover = 2;
			}
			if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
				board.hover = 3;
			}
			if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
				board.hover = 4;
			} 
		}
		if(pickphase == 1 || start) repaint();
	}
}
