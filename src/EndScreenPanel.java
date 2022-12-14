import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;

import java.util.List;
import java.util.*;
public class EndScreenPanel extends JPanel{

    private BufferedImage bkg, gray;
    
    

    public EndScreenPanel(){
        try{

            bkg = ImageIO.read(getClass().getResourceAsStream("/images/azulejos.png"));
            gray = ImageIO.read(getClass().getResourceAsStream("/images/startgamebg.png"));

        }  
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        
        //paint(); //call players ArrayList from the game class
        
        
    }

    //for ArrayList Player either call the game class arraylist in this paint method, or call the paint method in a different class

    public void paint(Graphics g, ArrayList<Player> plyr, int width, int height) {

        //String score = Integer.toString(pLayerScore);
    	
    	
         g.drawImage(bkg, 0, 0, 1280, 720, null);
         g.drawImage(gray, 50, 50, 1170, 520, null);
        System.out.println("1");
        g.setColor(Color.white);
        System.out.println("2");

		g.setFont(new Font("Times New Roman", Font.PLAIN , 80));  
		System.out.println("After setting");
		//g.drawString("Final Scores", width/2, 0);
        g.drawString("Final Scores", 450, 125);

		System.out.println("drawfinal");
		int n = plyr.size();


        ArrayList<Integer> scores = new ArrayList<>();
        for(int c = 0; c < 4; c++){
            scores.add(plyr.get(c).getScore());
        }
        Collections.sort(scores);
        // Convert entrySet to Array using toArray method
        Player[] sort = new Player[4];
        for(int c = 0; c < 4; c++){
            for(int d = 0; d < 4; d++){
                if(plyr.get(c).getScore()== scores.get(d)){
                    if(sort[d] == null){
                        sort[d] = plyr.get(c);
                        break;
                    }
                }
            }
        }
        // g.drawString(" Player  .......................................................", width/3 - 330, height - 500); //first place


       
        //    for (Map.Entry<String, String> entry : gfg.entrySet())
        //         System.out.println(
        //         "[" + entry.getKey()
        //         + ", " + entry.getValue() + "]");

        g.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        g.drawString(sort[3].getColor().substring(0, 1).toUpperCase() + sort[3].getColor().substring(1) + " Player  .......................................................", width/3 - 330, height - 500); //first place
        g.drawString(sort[2].getColor().substring(0, 1).toUpperCase() + sort[2].getColor().substring(1) + " Player  .......................................................", width/3 - 330, height - 380);  //second place
        g.drawString(sort[1].getColor().substring(0, 1).toUpperCase() + sort[1].getColor().substring(1) + " Player  .......................................................", width/3 - 330, height - 260);  //third place
        g.drawString(sort[0].getColor().substring(0, 1).toUpperCase() + sort[0].getColor().substring(1) + " Player  .......................................................", width/3 - 330, height - 140);  //last place

        g.drawString(sort[3].getScore() + "", width/3 + 700, height - 500); //first score
        g.drawString(sort[2].getScore() + "", width/3 + 700, height - 380); //second score
        g.drawString(sort[1].getScore() + "", width/3 + 700, height - 260); //third score
        g.drawString(sort[0].getScore() + "", width/3 + 700, height - 140); //fourth score		
		
	}	
    
}
