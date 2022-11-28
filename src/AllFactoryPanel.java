import java.awt.*;
import java.util.*;
public class AllFactoryPanel{
	public boolean chosenTile = false;
	//🦧
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
	static String colorTile;
	private int x, y;

	public AllFactoryPanel() {
		OneFactoryPanel arr [] = new OneFactoryPanel[]{f1, f2, f3, f4, f5, f6, f7, f8, f9, middle};//only used to add factories to the arraylist
		factories = new ArrayList<>(Arrays.asList(arr));	
	}

	public ArrayList<OneFactoryPanel> getArray(){
		return factories;
	}
	public void choosing(Graphics g){
		whichPanel();
		if(temp!= null)temp.paintChoosing(g, colorTile);
	}
	public void whichPanel(){ 
		if(x>=265 && x<=362 && y>=200 && y<=297){
			System.out.println("f1!");
			if(f1.getSize() > 0){
				changeClicked(f1);
				temp = f1;
			}
		}
		else if(x>=128 && x<=233 && y>=243 && y<=336){
			if(f2.getSize() > 0){
				changeClicked(f2);
				temp = f2;
			}
			System.out.println("f2!");
		}
		else if(x>=94 && x<=194 && y>=357 && y<=453){
			System.out.println("f3!");
			if(f3.getSize() > 0){
				changeClicked(f3);
				temp = f3;
			}
		}
		else if(x>=95 && x<=196 && y>=468 && y<=567){
			System.out.println("f4!");
			if(f4.getSize() > 0){
				changeClicked(f4);
				temp = f4;
			}
		}
		else if(x>=201 && x<=299 && y>=545 && y<=637){
			System.out.println("f5!");
			if(f5.getSize() > 0){
				changeClicked(f5);
				temp = f5;
			}
		}
		else if(x>=328 && x<=427 && y>=544 && y<=644){
			System.out.println("f6!");
			if(f6.getSize() > 0){
				changeClicked(f6);
				temp = f6;
			}
		}
		else if(x>=432 && x<=530 && y>=469 && y<=565){
			System.out.println("f7!");
			if(f7.getSize() > 0){
				changeClicked(f7);
				temp = f7;
			}
		}
		else if(x>=435 && x<=533 && y>=355 && y<=450){
			System.out.println("f8!");
			if(f8.getSize() > 0){
				changeClicked(f8);
				temp = f8;
			}
		}
		else if(x >= 374 && y >= 244 && x <= 470 && y <= 338){
			System.out.println("f9!");
			if(f9.getSize() > 0){
				changeClicked(f9);
				temp = f9;
			}
		}
		else if(x>=205 && x<=423 && y>=312 && y<=536 ){
			System.out.println("middle");
			if(middle.hasOne()){
				//set player to #1
				//paint #1 on the board
				//remove the #1 
			}
			if(middle.getSize() > 0){
				changeClicked(middle);
				temp = middle;
			}
		}
		//else return f9; (it always returned this when u clicked near the choosing screen)
	}

	public void changeClicked(OneFactoryPanel fact){
		colorTile = "";
		for(int c = 0; c < factories.size(); c++){
			if(factories.get(c).equals(fact))factories.get(c).clicked = true;
			else factories.get(c).clicked = false;
		}
	}
	public void setCood(int x1, int y1){
		System.out.println("here");
		x = x1;
		y = y1;
	}
	public OneFactoryPanel getTemp(){
		return temp;
	}

	public void moveLeftoverTiles(){
		if(!temp.equals(middle)){
			middle.addArray(temp.getDiscarded(colorTile)); 
			System.out.println("added to middle");
		}
		else temp.removeTile(colorTile);
	}
	public ArrayList<Tile> getChosen(){
		chosenTile = false;
		ArrayList<Tile> arr = new ArrayList<>();
		//remove the occurences of the tile from the arraylist in one factory panel
		//move the leftover tiles to the middle	 
		if(x>=829 && y>=40 && x<=1063 && y<=61 && temp.getAmount("yellow")>0){
			colorTile = "yellow";

			// //yellow
			Tile x = new Tile("yellow");
			 int occ = temp.getAmount("yellow");
			 if(occ > 0) while(occ-->0){
			   arr.add(x);
			}
			chosenTile = true;
			//  //Collections.addAll()
			
		}
		if(x>=829 && x<=1063 && y>=72 && y<=96 && temp.getAmount("blue")>0){
			colorTile = "blue";

			//blue
			Tile x = new Tile("blue");
			int occ = temp.getAmount("blue");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			}
			chosenTile = true;
		
		}
		if(x>=829 && x<=1063 && y>=111 && y<=138&& temp.getAmount("red")>0){
			colorTile = "red";
			//red
			Tile x = new Tile("red");
			int occ = temp.getAmount("red");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			}
			chosenTile = true;
			
		}
		if(x>=829 && x<=1063 && y>=150 && y<=174&& temp.getAmount("black")>0){
			colorTile = "black";
			//black
			Tile x = new Tile("black");
			int occ = temp.getAmount("black");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
		   }
		   chosenTile = true;

		}
		if(x>=829 && x<=1063 && y>=183 && y<=209&& temp.getAmount("teal")>0){
			colorTile = "teal";
			//teal
			Tile x = new Tile("teal");
			int occ = temp.getAmount("teal");
			if(occ > 0) while(occ-->0){
			   arr.add(x);
			}
			chosenTile = true;
		
		}
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
		middle.addTile(new Tile("first"));
		middle.drawMiddle(g);
		
	}
}
