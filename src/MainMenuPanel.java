import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class MainMenuPanel implements Runnable{
	
	private BufferedImage bkg, startGameLetter, startgamebg, logo, howtoplay;
	boolean download = false;
	String home = System.getProperty("user.home");
	File out = new File(home+"/Downloads/AzulTilesInstructions.pdf"); 
	public MainMenuPanel(){
		
		try {
	
			bkg = ImageIO.read(new File("src/images/azulejos.png"));
			startGameLetter = ImageIO.read(new File("src/images/StartGame.png"));
			startgamebg = ImageIO.read(new File("src/images/startgamebg.png"));
			logo = ImageIO.read(new File("src/images/logo.png"));
			howtoplay = ImageIO.read(new File("src/images/howtoplay.png"));	
		}
		catch(Exception e){
		
			System.out.println(e.getMessage());
			return;
		
		}
		
	}
	
	public void drawMenu(Graphics g, int width, int height) {
		
		g.drawImage(bkg, 0, 0, width, height, null);
		
		
		g.drawImage(startgamebg, 70, 0, 500, height, null);
		g.drawImage(startGameLetter, 90, height/2 + 100, 470, 60, null);
		g.drawImage(logo, 90, 80, 460, 280, null);
		g.drawImage(howtoplay, 100, height/2 + 200, 450, 75, null);
		if(download){
			g.setColor(Color.white);
			g.setFont(new Font("Algerian", Font.PLAIN, 25));
			g.drawString("Instructions downloaded", 135, height/2+ 315);
		}
		
	}	
	

	@Override
	public void run() {
		try{
			URL url = new URL("https://tesera.ru/images/items/1108676/EN-Azul-Rules.pdf");
			HttpURLConnection http =(HttpURLConnection)url.openConnection();
			double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] buffer = new byte[1024];
			double downloaded = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;
			while((read = in.read(buffer, 0, 1024))>= 0){
				bout.write(buffer, 0, read);
			}
			bout.close();
			in.close();

		}		
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
