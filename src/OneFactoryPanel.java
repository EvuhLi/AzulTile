import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class OneFactoryPanel{
    private BufferedImage factory, blue, red, yellow, TChoose, teal, black, factorymiddle, highlight;
    private ArrayList<Tile>TArr;
    private TreeMap<String, Integer>possibleT;
    Game game;
	private Tile t1, t2, t3, t4;
	private boolean isMiddle = false;
    boolean clicked;
    public OneFactoryPanel() {
        try {           
            TArr = new ArrayList<>();
            possibleT = new TreeMap<>();
			factorymiddle = ImageIO.read(new File("src/images/factorymiddle.png"));
            highlight = ImageIO.read(new File("src/images/yellowfactory.png"));
            blue = ImageIO.read(new File("src/images/blue tile.png"));
            red = ImageIO.read(new File("src/images/red tile.png"));
            yellow = ImageIO.read(new File("src/images/yellow tile.png"));
            teal = ImageIO.read(new File("src/images/teal tile.png"));
            black = ImageIO.read(new File("src/images/black tile.png"));
            TChoose = ImageIO.read(new File("src/images/TileChoosing.png"));
            factory = ImageIO.read(new File("src/images/factory.png"));
            
        } catch (Exception e) {
            return;
        }
    }

    public void reset(){
        TArr.clear();
    }
    
	public void isMiddle(){
		isMiddle = true;
	}
	public void drawMiddle(Graphics g){
        int xyellow = 235;
        int xred = 300;
        int xblue = 268;
        int xblack = 330;
        int xteal =  360;
        int yyellow = 350;
        int yred = 335;
        int yblue = 335;
        int yblack = 335;
        int yteal = 350;
        int s = 33;    
        if(isMiddle){
                for(int i = 0; i<TArr.size(); i++){
                Tile t = TArr.get(i);
                String col = t.getColor();
                if(col.equals("yellow")){
                    g.drawImage(t.getImage(), xyellow, yyellow, s, s, null);
                     yyellow += 30;
                }
                if(col.equals("blue")){
                    g.drawImage(t.getImage(), xblue, yblue, s, s, null);
                    yblue += 30;
                    }
                if(col.equals("red")){
                    g.drawImage(t.getImage(), xred, yred, s, s, null);
                    yred += 30;
                    }
                if(col.equals("black")){
                    g.drawImage(t.getImage(), xblack, yblack, s, s, null);
                    yblack += 30;
                    }
                 if(col.equals("teal")){
                    g.drawImage(t.getImage(), xteal, yteal, s, s, null);
                    yteal += 30;
                    }
            }
        }
   
    }
    public ArrayList<Tile> getDiscarded(String str){
        ArrayList<Tile> arr = new ArrayList<>();
  
        for(int i = 0; i<TArr.size(); i++){
                if(!TArr.get(i).getColor().equals(str)){
                    arr.add(TArr.get(i));
                }
        }
        return arr;
    }
 
    public void setArray(ArrayList<Tile>arr){
        TArr = arr;
    }
    public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
        int size = ww / 10;
        int tSize = ww / 50;
        if(clicked) g.drawImage(highlight, w +2, h + 6, size - 3, size- 3, null);
		if(!isMiddle) g.drawImage(factory, w, h, size, size, null);
        else{
			g.drawImage(factorymiddle, w, h, ww, hh, null);
		}
		int fW = w + ww/30;
        int fH = h+hh/11;

		if(!isMiddle){
        for(int i = 0; i<TArr.size(); i++){
            if(i==0)
                g.drawImage(TArr.get(i).getImage(), fW, fH, tSize, tSize, null);
                else if(i==1)
                g.drawImage(TArr.get(i).getImage(), w + ww/20, h + hh/18, tSize, tSize, null);
                else if(i==2)
                g.drawImage(TArr.get(i).getImage(), w + ww/30, h + hh/18, tSize, tSize, null);
                else
                g.drawImage(TArr.get(i).getImage(), w + ww/20, h + hh/11, tSize, tSize, null);
        }
    }
	else{
		//draw middle
	}
}
/*public void addTiles(){

    t1 = new Tile("teal");
	t2 = new Tile("black");
    t3 = new Tile("yellow");
    t4 = new Tile("yellow");
	TArr.add(t1);
	TArr.add(t2);
	TArr.add(t3);
	TArr.add(t4);

    //figure out how to get random tiles now/
    /*ArrayList<Tile>  
}*/
public int getSize(){
    return TArr.size();
}
    public void paintChoosing(Graphics g){
        g.drawImage(TChoose, 600, -55, 700, 400, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        g.drawString(""+getAmount("yellow"), 1029, 68);
        g.drawString("" + getAmount("red"), 1029, 141);
        g.drawString("" + getAmount("blue"), 1029, 104);
        g.drawString("" + getAmount("black"), 1029, 173);
        g.drawString("" + getAmount("teal"), 1029, 208);


        /*or(int i = 0; i<TArr.size(); i++){
            Tile temp = TArr.get(i);
			String c = temp.getColor();

            if(c.equals("yellow")){
                int x = getAmount("yellow");
            }
            else if(c.equals("red")){
                int x = getAmount("red");
            }
            else if(c.equals("blue")){
                int x = getAmount("blue");
            }
            else if(c.equals("black")){
                int x = getAmount("black");
            }
            else{
                int x = getAmount("teal");
                g.drawString(x+"", 1029, 208);
            }
        }*/
    }

    public int getAmount(String color){ //jeanna can u use this to count tiles yes bbbg baeeee !!😊😊😊😊😊😊😊
        int count = 0;
        for(Tile tile: TArr){
            if(tile.getColor().equals(color)){
                count++;
            }
        }
        return count;
    }
}