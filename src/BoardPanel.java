import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class BoardPanel {
    private Game game;
    private Player red, green, yellow, blue;
    BufferedImage board, redtile, yellowtile, bluetile, tealtile, blacktile;
    BufferedImage border, screenbg, logo, score;


    public BoardPanel(Game g){
        game = g;
        try {
            board = ImageIO.read(new File("src/images/Azul Board.jpg"));
            redtile = ImageIO.read(new File("src/images/red tile.png"));
            yellowtile = ImageIO.read(new File("src/images/yellow tile.png"));
            bluetile = ImageIO.read(new File("src/images/blue tile.png"));
            tealtile = ImageIO.read(new File("src/images/teal tile.png"));
            blacktile = ImageIO.read(new File("src/images/black tile.png"));
            border = ImageIO.read(new File("src/images/border.png"));
			screenbg = ImageIO.read(new File("src/images/bluebg.png"));
            logo = ImageIO.read(new File("src/images/logo.png"));
            score = ImageIO.read(new File("src/images/score.png"));



		} catch (Exception E) {
			System.out.println(E.getMessage());
			return;
		}
    }
    public void drawAll(Graphics g, int width, int height){
        g.drawImage(screenbg, 0, 0, width, height, null);
        drawLeft(g);//red);
        drawMiddle(g);
        drawRight(g);
        drawTurn(g, width, height);
        g.drawImage(border, 0, 0, width, height, null);
        g.drawImage(logo, width/2+150, 30, 300, 210, null);

        g.drawImage(score, width/2 + 50, height/2 + 235, 300, 100, null);

    }
    public void drawLeft(Graphics g){ //Player player){
        g.drawImage(board, 50, 40, 180, 120, null);
    }
    public void drawMiddle(Graphics g){// Player player){
        g.drawImage(board, 250, 40, 180, 120, null);
    }
    public void drawRight(Graphics g){
        g.drawImage(board, 450, 40, 180, 120, null);
    }
    public void drawTurn(Graphics g, int width, int height){
        g.drawImage(board, width/2 + 50, height/2 - 100, 510, 340, null);
    }

}
