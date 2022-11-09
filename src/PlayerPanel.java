import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class PlayerPanel {
    Game game;
    BufferedImage board, redtile, yellowtile, bluetile, tealtile, blacktile;
    BufferedImage border, screenbg, logo, score;


    public PlayerPanel(Game g){
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
        drawLeft(g, game.getPlayers().get(game.turn - 1 == 0? 4 : game.turn - 1), width, height);
        drawMiddle(g, game.getPlayers().get(game.turn)); // logic needs change
        drawRight(g, game.getPlayers().get(game.turn)); // logic needs change
        drawTurn(g, width, height, game.getPlayers().get(game.turn));
        g.drawImage(border, 0, 0, width, height, null);
        g.drawImage(logo, width/2+150, 30, 300, 210, null);

        

    }
    public void drawLeft(Graphics g, Player player, int width, int height){
        g.drawImage(board, 50, 40, 180, 120, null);
        //DIMENSTIONS: 80 by 80
        //g.drawImage(border, 56, 44, 80, 80, null);
        int row = 0;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = 56 + 80 - 15;
            g.drawImage(blacktile, 136 - 15, c, 15, 15, null);
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                g.drawImage(blacktile, x, c, 15, 15, null);
                x-=16;
            }
            row++;
        }
        g.drawImage(blacktile, 136 - 15, 44, 15, 15, null);

        g.setFont(new Font("Times New Roman", Font.BOLD, 30));;
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 70, 185);
    }
    public void drawMiddle(Graphics g, Player player){// Player player){
        g.drawImage(board, 250, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 275, 185);
        
    }
    public void drawRight(Graphics g, Player player){
        g.drawImage(board, 450, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 480, 185);
    }
    public void drawTurn(Graphics g, int width, int height, Player player){
        g.drawImage(board, width/2 + 50, height/2 - 100, 510, 340, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 75));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), width/2 + 100, height/2 + 300);
        //DIMENSIONS: tiles are 40 by 40 and increment by 45 each time

        //row dimensions: 220 by 200
        //g.drawImage(border, width/2 + 70, height/2 - 87, 220, 220, null); //dimensions of row
        int row = 0;
        for(int c = height/2 - 87; c < height/2-87 + 40 * 5; c+= 45){
            int x = width/2+70 + 220 - 40;
            for(int d = 0; d < 1+ (c-(height/2-87))/45; d++){
                //Tile tile = game.getPlayers().get(game.turn).getRow().getRow(row)[d];

                g.drawImage(blacktile, x, c, 40, 40, null);
                x-= 45;
            }
            row++;
        }
    }

}
