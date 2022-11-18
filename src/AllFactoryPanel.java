import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;
public class AllFactoryPanel{
	private BufferedImage factory, azulBoard, factorymiddle;
	public boolean chosenTile = false;
	private ArrayList<Tile> discard = new ArrayList<>();

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
	ArrayList<OneFactoryPanel> factories;
	static OneFactoryPanel temp;

	private int x, y;

	public AllFactoryPanel() {
		OneFactoryPanel arr [] = new OneFactoryPanel[]{f1, f2, f3, f4, f5, f6, f7, f8, f9, middle};//only used to add factories to the arraylist
		factories = new ArrayList<>(Arrays.asList(arr));
		
		try {
            factory = ImageIO.read(new File("src/images/factory.png"));
			factorymiddle = ImageIO.read(new File("src/images/factorymiddle.png"));

		} catch (Exception E) {
			System.out.println("Exception Error");
			return;
		}
	}

	public ArrayList<OneFactoryPanel> getArray(){
		return factories;
	}
	public void choosing(Graphics g){
		whichPanel();
		temp.paintChoosing(g);
	}
	public void whichPanel(){ //i cahnged this because otherwise whenever u clicked anywhere if would return f9 and that would change the chosing screen
		if(x>=265 && x<=362 && y>=200 && y<=297){
			System.out.println("f1!");
			changeClicked(f1);
			temp = f1;
		}
		else if(x>=128 && x<=233 && y>=243 && y<=336){
			changeClicked(f2);
			System.out.println("f2!");
			temp = f2;
		}
		else if(x>=94 && x<=194 && y>=357 && y<=453){
			System.out.println("f3!");
			changeClicked(f3);
			temp = f3;
		}
		else if(x>=95 && x<=196 && y>=468 && y<=567){
			System.out.println("f4!");
			changeClicked(f4);
			temp = f4;
		}
		else if(x>=201 && x<=299 && y>=545 && y<=637){
			System.out.println("f5!");
			changeClicked(f5);
			temp = f5;
		}
		else if(x>=328 && x<=427 && y>=544 && y<=644){
			System.out.println("f6!");
			changeClicked(f6);
			temp = f6;
		}
		else if(x>=432 && x<=530 && y>=469 && y<=565){
			System.out.println("f7!");
			changeClicked(f7);
			temp = f7;
		}
		else if(x>=435 && x<=533 && y>=355 && y<=450){
			System.out.println("f8!");
			changeClicked(f8);
			temp = f8;
		}
		else if(x >= 374 && y >= 244 && x <= 470 && y <= 338){
			System.out.println("f9!");
			changeClicked(f9);
			temp = f9;
		}
		else if(x>=205 && x<=423 && y>=312 && y<=536 ){
			System.out.println("middle");
			changeClicked(middle);
			temp = middle;
		}
		//else return f9; (it always returned this when u clicked near the choosing screen)
	}

	public void changeClicked(OneFactoryPanel fact){
		for(int c = 0; c < factories.size(); c++){
			if(factories.get(c).equals(fact))factories.get(c).clicked = true;
			else factories.get(c).clicked = false;
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
	public OneFactoryPanel getTemp(){
		return temp;
	}
	public ArrayList<Tile> getChosen(){
	
		ArrayList<Tile> arr = new ArrayList<>();
		//remove the occurences of the tile from the arraylist in one factory panel
		//move the leftover tiles to the middle	 
		if(x>=829 && y>=40 && x<=1063 && y<=61 && temp.getAmount("yellow")>0){
			//yellow
			Tile x = new Tile("yellow");
			 int occ = temp.getAmount("yellow");
			 if(occ > 0) while(occ-->0){
			   arr.add(x);
			   chosenTile = true;
			}
			 //Collections.addAll()
			 if(!temp.equals(middle)) discard.addAll(temp.getDiscarded("yellow"));
			 else temp.removeTile("yellow");
		}
		if(x>=829 && x<=1063 && y>=72 && y<=96 && temp.getAmount("blue")>0){
			//blue
			Tile x = new Tile("blue");
			int occ = temp.getAmount("blue");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			   chosenTile = true;
			}
			 if(!temp.equals(middle))  discard.addAll(temp.getDiscarded("blue"));
			 else temp.removeTile("blue");
		}
		if(x>=829 && x<=1063 && y>=111 && y<=138&& temp.getAmount("red")>0){
			//red
			Tile x = new Tile("red");
			int occ = temp.getAmount("red");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			   chosenTile = true;
			}
			 if(!temp.equals(middle))  discard.addAll(temp.getDiscarded("red"));
			 else temp.removeTile("red");
		}
		if(x>=829 && x<=1063 && y>=150 && y<=174&& temp.getAmount("black")>0){
			//black
			Tile x = new Tile("black");
			int occ = temp.getAmount("black");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			   chosenTile = true;
		   }
		   if(!temp.equals(middle))  discard.addAll(temp.getDiscarded("black"));
		   else temp.removeTile("black");
		}
		if(x>=829 && x<=1063 && y>=183 && y<=209&& temp.getAmount("teal")>0){
			//teal
			Tile x = new Tile("teal");
			int occ = temp.getAmount("teal");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			   chosenTile = true;
			   }
			if(!temp.equals(middle))  discard.addAll(temp.getDiscarded("teal"));
			else temp.removeTile("teal");
		 }
		//bunch of coordinates to see which tiles you picked, then add those to this arraylist, wchih goes to the player
	   
	   
		
		 for(int i = 0; i < discard.size(); i++){
	    System.out.print(discard.get(i).getColor()+" ");
		 }
		 if(middle.TArr.size()==0) middle.setArray(discard);
	    else{
			for(int i = 0; i < arr.size(); i++){
				System.out.print(arr.get(i).getColor()+"j ");
			}
		}
		 //middle.drawMiddle();
		   
		return arr;
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
		middle.paintFactory(205, Height/2 - 20, 220, 220, g);
		//g.drawImage(factorymiddle, 205, Height/2 - 20, 220, 220, null);
		
	}
}
