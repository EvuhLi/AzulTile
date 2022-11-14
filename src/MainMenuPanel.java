import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
			
			
public class MainMenuPanel implements Runnable{
			
	BufferedImage bkg, startGameLetter, startgamebg, logo, howtoplay;
	boolean download = false;
	String home = System.getProperty("user.home");
	int hover = -1;
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
		g.setColor(Color.white);
		if(hover == 1)g.drawLine(90, height/2 + 160, 560, height/2 + 160);
		if(hover == 2) g.drawLine(100, height/2 + 280, 550, height/2 + 280);
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
			URL url = new URL("https://www.cadl.org/application/files/6515/8257/3893/EN-Azul-Rules-Next-Move-web.pdf");
			HttpURLConnection http =(HttpURLConnection)url.openConnection();
			double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] buffer = new byte[1024];
			int read = 0;
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
			