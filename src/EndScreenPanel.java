import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.util.Collections;
import java.util.ArrayList;

public class EndScreenPanel extends JPanel{

    private BufferedImage bkg, gray;
    
    

    public EndScreenPanel(){
        try{

            bkg = ImageIO.read(new File("src/images/azulejos.png"));
            gray = ImageIO.read(new File("src/images/startgamebg.png"));

        }  
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        
        //paint(); //call players ArrayList from the game class
        
        
    }

    //for ArrayList Player either call the game class arraylist in this paint method, or call the paint method in a different class

    public void paint(Graphics g, ArrayList<Player> plyr) {

        //String score = Integer.toString(pLayerScore);
    	
    	
        g.drawImage(bkg, 0, 0, 1280, 720, null);
        g.drawImage(gray, 50, 50, 1170, 520, null);
        
        g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.ITALIC , 50));  
		
		g.drawString("Final Scores", getWidth()/2 - 100, getHeight() - 570);
		
		int n = plyr.size();
		
		for(int i = 0; i < n - 1; i++){
			int max_idx = i;
			for (int j = i+1; j < n; j++) {
				if (plyr.get(j).getScore() > plyr.get(max_idx).getScore()){
                    plyr.set(0, plyr.remove(j));

					max_idx = j;
	            }
			}
			// Player temp = plyr.get(max_idx);
	        // plyr.get(i);
	        // plyr.get(i) = temp;

		}	
		
        g.drawString(plyr.get(0).getColor() + " Player  .......................................................", getWidth()/3 - 330, getHeight() - 500); //first place
        g.drawString(plyr.get(1).getColor() + " Player  .......................................................", getWidth()/3 - 330, getHeight() - 380);  //second place
        g.drawString(plyr.get(2).getColor() + " Player  .......................................................", getWidth()/3 - 330, getHeight() - 260);  //third place
        g.drawString(plyr.get(3).getColor() + " Player  .......................................................", getWidth()/3 - 330, getHeight() - 140);  //last place
        
        g.drawString(Integer.toString(plyr.get(0).getScore()), getWidth()/3 + 700, getHeight() - 500); //first score
        g.drawString(Integer.toString(plyr.get(1).getScore()), getWidth()/3 + 700, getHeight() - 380); //second score
        g.drawString(Integer.toString(plyr.get(2).getScore()), getWidth()/3 + 700, getHeight() - 260); //third score
        g.drawString(Integer.toString(plyr.get(3).getScore()), getWidth()/3 + 700, getHeight() - 140); //fourth score		
		
	}	
    
}
