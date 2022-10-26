import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class MockupPanel extends JPanel implements MouseListener{
	
	private BufferedImage bkg, startbttn, board;
	
	public MockupPanel(){
		
		try {
	
			bkg = ImageIO.read(MockupPanel.class.getResource("src/AzulStartScreen.jpg"));
			startbttn = ImageIO.read(MockupPanel.class.getResource("/Images/start.png"));
			board = ImageIO.read(MockupPanel.class.getResource("/Images/clearAzulBoard.jpg"));
			
		}
		catch(Exception e){
		
			System.out.println(e.getMessage());
			return;
		
		}
		
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(bkg, 0, 0, 900, 900, null);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif Bold", Font.BOLD , 35));
		
		g.drawImage(startbttn, 280, 720,  350, 100, null);
		
	}
	
	
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		System.out.println("loc is ("+x+", "+y+")");
		if(e.getButton() == e.BUTTON1) {
			
			if(x >= 280 && y >= 740 && x <= 630 && y <= 640) {
				
				bkg = board;
				startbttn = null;
				//g
				
				
			}
			
		}
		
	}
	
}
