import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class OneFactoryPanel {

    private BufferedImage factory, blue, red, yellow, TChoose, teal, black, factorymiddle;
    private ArrayList<Tile>TArr;
    private TreeMap<String, Integer>possibleT;

	private Tile t1, t2, t3, t4;
	private boolean isMiddle = false;
	private boolean M;
	private Factory ffs;
    public OneFactoryPanel() {
        try {


			//ffs = new Factory(M);
            TArr = new ArrayList<>();
            possibleT = new TreeMap<>();
			factorymiddle = ImageIO.read(new File("src/images/factorymiddle.png"));

            blue = ImageIO.read(new File("src/images/blue tile.png"));
            red = ImageIO.read(new File("src/images/red tile.png"));
            yellow = ImageIO.read(new File("src/images/yellow tile.png"));
            teal = ImageIO.read(new File("src/images/teal tile.png"));
            black = ImageIO.read(new File("src/images/black tile.png"));
            TChoose = ImageIO.read(new File("src/images/TileChoosing.png"));
            factory = ImageIO.read(new File("src/images/factory.png"));
            if(!isMiddle)
			addTiles();
           
        } catch (Exception e) {
            return;
        }
    }

	public void isMiddle(){
		isMiddle = true;
	}
	private void setisMiddle(boolean M){
	    M=M;
	}
    public void setArray(ArrayList<Tile>arr){
        TArr = arr;
    }
    public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
        int size = ww / 10;
        int tSize = ww / 50;
      
		if(!isMiddle)
		g.drawImage(factory, w, h, size, size, null);
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
public void addTiles(){
    t1 = new Tile("red");
	t2 = new Tile("red");
    t3 = new Tile("yellow");
    t4 = new Tile("yellow");
	TArr.add(t1);
	TArr.add(t2);
	TArr.add(t3);
	TArr.add(t4);

}
public int getSize(){
    return TArr.size();
}
    public void paintChoosing(Graphics g){
        g.drawImage(TChoose, 600, -55, 700, 400, null);
        HashMap<BufferedImage, Integer>ava = new HashMap<>();
        for(int i = 0; i<TArr.size(); i++){
            BufferedImage temp = TArr.get(i).getImage();
            if(!ava.containsKey(temp)){
                ava.put(temp, 1);
            }
            else{
                ava.put(temp, ava.get(temp)+1);
            } 
        }
        Set<BufferedImage> s = ava.keySet();
        Iterator<BufferedImage> iter = s.iterator();
        while(iter.hasNext()){
            BufferedImage b = iter.next();
			int x = ava.get(b);
			g.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			if(b.equals(yellow)){
				g.drawString(x+"", 1029, 68);
			}
			else if(b.equals(red)){
				g.drawString(x+"", 1029, 142);
			}
        }
    }
}