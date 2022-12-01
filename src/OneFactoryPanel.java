import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;


public class OneFactoryPanel{
    private BufferedImage factory, TChoose, factorymiddle, highlight, border;
    ArrayList<Tile>TArr;
    Game game;
	boolean isMiddle = false;
    boolean clicked;
    public OneFactoryPanel() {
        try {           
            border = ImageIO.read(new File("src/images/selectborder.png"));
            TArr = new ArrayList<>();
			factorymiddle = ImageIO.read(new File("src/images/factorymiddle.png"));
            highlight = ImageIO.read(new File("src/images/yellowfactory.png"));
            TChoose = ImageIO.read(new File("src/images/TileChoosing.png"));
            factory = ImageIO.read(new File("src/images/factory.png"));
            
        } catch (Exception e) {
            return;
        }
    }

    public void reset(){
        if(!isMiddle)
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
        int s = 28;    
        int c = 25;

        if(isMiddle){
                for(int i = 0; i<TArr.size(); i++){
                    
                Tile t = TArr.get(i);
                
                String col = t.getColor();
                if(col.equals("first")){
                    g.drawImage(t.getImage(), 300, 504, s, s, null);
                }
                if(col.equals("yellow")){
                    if(yyellow>=504){
                        yyellow = 350;
                        xyellow+=c/2;
                    }
                    g.drawImage(t.getImage(), xyellow, yyellow, s, s, null);
                    
                     yyellow += c;
                }
                if(col.equals("blue")){
                    if(yblue>=504){
                        yblue = 350;
                        xblue+=c/2;
                    }
                    g.drawImage(t.getImage(), xblue, yblue, s, s, null);
                    yblue += c;
                    }
                if(col.equals("red")){
                    if(yred>=504){
                        yred = 350;
                        xred+=c/2;
                    }
                    g.drawImage(t.getImage(), xred, yred, s, s, null);
                    yred += c;
                    }
                if(col.equals("black")){
                    if(yblack>=504){
                        yblack = 350;
                        xblack+=c/2;
                    }
                    g.drawImage(t.getImage(), xblack, yblack, s, s, null);
                    yblack += c;
                    }
                 if(col.equals("teal")){
                    if(yteal>=504){
                        yteal = 350;
                        xteal+=c/2;
                    }
                    g.drawImage(t.getImage(), xteal, yteal, s, s, null);
                    yteal += c;
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
 
    public void addArray(ArrayList<Tile>arr){
        TArr.addAll(arr);
    }

    public void addTile(Tile t){
        TArr.add(t);
    }
    public ArrayList<Tile> removeTile(String str){
        for(int i = 0; i<TArr.size(); i++){
            System.out.print(TArr.get(i).getColor()+" ");
        }
        System.out.println();
        for(int i = 0; i<TArr.size(); i++){

            Tile f = TArr.get(i);
            if(f.getColor().equals(str)){
                TArr.remove(i);
                i--;
            }
        }

        for(int i = 0; i<TArr.size(); i++){
            System.out.print(TArr.get(i).getColor()+" ");
        }
        return TArr;
    }
    public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
        int size = ww / 10;
        int tSize = ww / 50;
        if(isMiddle && clicked){
            g.drawImage(highlight, ww*90/100, hh*14/10+10, 235, 235, null);
        }
        if(clicked && !isMiddle) g.drawImage(highlight, w +2, h + 6, size - 3, size- 3, null);
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
    }

    public boolean hasOne(){
        for(int i = 0; i<TArr.size(); i++){
            if(TArr.get(i).getColor().equals("first")){
                return true;
            }
        }
        return false;
    }
    public int getSize(){
        return TArr.size();
    }
    public void paintChoosing(Graphics g, String color){

        g.drawImage(TChoose, 600, -55, 700, 400, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        if(color.equals("yellow")) g.drawImage(border, 777, 49, 27, 27, null);
        if(color.equals("blue")) g.drawImage(border, 777, 79, 27, 27, null);
        if(color.equals("red")) g.drawImage(border, 777, 115, 27, 27, null);
        if(color.equals("black")) g.drawImage(border, 777, 150, 27, 27, null);
        if(color.equals("teal")) g.drawImage(border, 778, 183,  27, 27, null);
        
        
        int y = getAmount("yellow");
        g.drawString("" + y, 1029, 68);
       
        int r = getAmount("red");
        g.drawString("" + r, 1029, 141);
        //🦧

        int b = getAmount("blue");
        g.drawString("" + b, 1029, 104);

        int bl = getAmount("black");
        g.drawString("" + bl, 1029, 173);

        int t = getAmount("teal");
        g.drawString("" + t, 1029, 208);


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