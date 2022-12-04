import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class AzulPanel extends JPanel implements MouseListener, MouseMotionListener{
	boolean start = true;
	boolean end = false;
	int pickphase = -1;
	MainMenuPanel menu;
	Game game;
	EndScreenPanel endScreen;
	PlayerPanel player;
	int width, height;
	int row, scorephase;
	boolean fillRows = false;
	

	public AzulPanel(int w, int h) {
		endScreen = new EndScreenPanel();
		scorephase = 0;
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
			player.drawAll(g, getWidth(), getHeight(), pickphase);
			game.getfactoryP().paint(g, getWidth(), getHeight());
		}
		//if they have chosen a factory, paint the options
		if(Game.phase == 1){
			game.getfactoryP().choosing(g);
		}
		if(Game.phase == 3){
			endScreen.paint(g, game.getPlayers());
		}
		if(end == true){
			endScreen.paint(g, game.getPlayers());
		}
			
		
		//try to make this happen AFTER you choose which row
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
				
		
		if(!start && scorephase == 1 && pickphase == -2 && x >= 1119 && x <= 1190 && y >= 34 && y <= 63 && Game.round < 4){
			pickphase = -3;
			scorephase = 2;
			System.out.println("hi");
			row = 0;
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask(){
				@Override
				public void run(){
					while(row < 5 && !game.getPlayers().get(0).getRow().rowIsFull(row)) row++; System.out.println(row);
					
					if(row == 5){	
						//System.out.println(game.getPlayers().get(0).countPenalty());
						game.getPlayers().get(0).setScore(Math.max(game.getPlayers().get(0).getScore() + game.getPlayers().get(0).countPenalty(), 0));
						for ( int i = 0; i < game.getPlayers().get(0).getBoard().getDiscard().size(); i++){
							if (game.getPlayers().get(0).getBoard().getDiscard().get(i) != null && !game.getPlayers().get(0).getBoard().getDiscard().get(i).getColor().equals("first")){
								game.discard.add(game.getPlayers().get(0).getBoard().getDiscard().get(i));
							}
						}
						game.getPlayers().get(0).getBoard().getDiscard().clear();
						
						System.out.println("penalty " + game.getPlayers().get(0).getScore());
						repaint();
						//row++;
						pickphase = 3;
						Game.round++;
						if(game.round == 3){
							scorephase = 3; pickphase = 3;game.round = -1; 
							if (end){
								game.endOfGame();
								// call end screen panel
							}
						}
						timer.cancel();
					}
					else if(row >= 0 && row <= 4){
						game.getPlayers().get(0).rowToBoard(row); 
						end = game.getPlayers().get(0).getBoard().checkEnd();
						repaint();
						row++;
					}
				}
			}, 1000,  1000);
					
			// if(game.round == 4){// scorephase = 1; 
			// 	System.out.println("hello");
			// 	scorephase = 3;
			// 	pickphase = 3;
			// }
			
		}
		if(pickphase == 3 && x >= 1069 && y >= 35 && x <= 1217 && y <= 64){//&&){
			game.nextPlayer(); 
			if(scorephase == 3){
				scorephase = 0;
				game.resetFactories();
			}
			pickphase = -1;
			if(Game.round > -1){
				pickphase = -2;
				scorephase = 1;
			}
			if(game.facsEmpty() && scorephase == 0) game.firstPlayer();
		}
		if(!start && scorephase == 0 && pickphase != 3 && game.facsEmpty()){ 
			System.out.println("empty");
			//fillRows = false;
			//game.fillRows();
			scorephase = 1;
			row = 0;
			pickphase = -2;
		}
		if(!start && scorephase == 0 && pickphase != 3 && fillRows){ 
			System.out.println("empty");
			fillRows = false;
			game.fillRows();
			scorephase = 1;
			row = 0;
			pickphase = -2;
		}
		
		if(!start && !game.facsEmpty() && pickphase < 2){
			//pickedF = true;
			//if its within factory range at all
			if(x>=94 && x<=531 && y>=199 && y<=649){
				pickphase = -1;
				game.getfactoryP().setCood(x, y);
			    game.getPlayers().get(0).getPicked().clear();
				game.getfactoryP().whichPanel();
				// game.getPlayers().get(0).getPicked().clear();
				if(game.getfactoryP().getTemp()!= null){
					pickphase = 0;
				}
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
				if(x >= 703 && x <= 924 && y >= 253 && y <= 473){
					boolean novalid = true;
					for(int c = 0; c < 5; c++){
						if(game.getPlayers().get(0).validRow(c)) novalid = false;
					}
					if(novalid){
						game.getPlayers().get(0).addToRow(0);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
					
				}
					//repaint();
					//set player to #1
					//paint #1 on the board
					//remove the #1 
				if(x >= 885 && x <= 925  && y >= 255 && y <= 295) {
					if(game.getPlayers().get(0).validRow(0)){
						game.getPlayers().get(0).addToRow(0);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
					
				}
				if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
					if(game.getPlayers().get(0).validRow(1)){
						game.getPlayers().get(0).addToRow(1);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
					
				}
				if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
					if(game.getPlayers().get(0).validRow(2)){
						game.getPlayers().get(0).addToRow(2);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
					
					// game.getPlayers().get(0).addToRow(2);
					// pickphase = 2;
				}
				if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
					if(game.getPlayers().get(0).validRow(3)){
						game.getPlayers().get(0).addToRow(3);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
				}
				if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
					if(game.getPlayers().get(0).validRow(4)){
						game.getPlayers().get(0).addToRow(4);
						pickphase = 2;
						if(game.getfactoryP().temp.equals(game.getfactoryP().middle) && game.getfactoryP().middle.hasOne()){
							System.out.println("I AM IN THE MIDDLE !");
							game.getPlayers().get(0).isOne(true);
							game.getfactoryP().middle.removeTile("first");
						}
					}
					
				}

			if(pickphase == 2){
				game.getfactoryP().moveLeftoverTiles();
				// game.getPlayers().get(0).setTiles(game.getfactoryP().getChosen());
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
		}
		
		//g.drawImage(glowingrow, width/2 + 250 - c*45, height/2 - 87 + 45*c, (c+1)*44, 40, null);
		//need boolean for when player has picked tiles
		
		
		if(start){
			if(x >= 90 && x <= 560 && y >=getHeight()/2 + 100 && y <= getHeight()/2 + 160){
				start = false;
				game = new Game();
				player = new PlayerPanel(game);
				Game.phase = 1;
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
				player.hover = 0;
			}
			if(x >= 835 && x <= 925 && y >= 300 && y <= 340) {
				player.hover = 1;
			}
			if(x >= 795 && x <= 925 && y >= 345 && y <= 385){
				player.hover = 2;
			}
			if(x >= 750 && x <= 925 && y >= 390 && y <= 430){
				player.hover = 3;
			}
			if(x >= 700 && x <= 925 && y >= 435 && y <= 475){
				player.hover = 4;
			} 
		}
		if(pickphase == 1 || start) repaint();
	}
	
}
