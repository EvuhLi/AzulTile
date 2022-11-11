import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class PlayerPanel {
    Game game;
    BufferedImage board, redtile, yellowtile, bluetile, tealtile, blacktile;
    static BufferedImage redborder;
    static BufferedImage yellowborder;
    static BufferedImage greenborder;
    static BufferedImage blueborder;
    BufferedImage border, screenbg, logo, score, glowingrow;



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
            redborder = ImageIO.read(new File("src/images/redborder.png"));
            yellowborder = ImageIO.read(new File("src/images/yellowborder.png"));
            blueborder = ImageIO.read(new File("src/images/blueborder.png"));
            greenborder = ImageIO.read(new File("src/images/greenborder.png"));
            glowingrow = ImageIO.read(new File("src/images/glowing row.png"));


		} catch (Exception E) {
			System.out.println(E.getMessage());
			return;
		}
    }
    public void drawAll(Graphics g, int width, int height){
        g.drawImage(screenbg, 0, 0, width, height, null);
        drawLeft(g, game.getPlayers().get(3), width, height);
        drawMiddle(g, game.getPlayers().get(2), width, height); // logic needs change
        drawRight(g, game.getPlayers().get(1)); // logic needs change
        drawTurn(g, width, height, game.getPlayers().get(0));
        g.drawImage(border, 0, 0, width, height, null);
        g.drawImage(logo, width/2+150, 30, 300, 210, null);
    }
    public void drawLeft(Graphics g, Player player, int width, int height){
        g.drawImage(color(player.getColor()), 45, 35, 190, 130, null);
        g.drawImage(board, 50, 40, 180, 120, null);
        //DIMENSTIONS: 80 by 80
        //g.drawImage(border, 56, 44, 80, 80, null);
        int start = 56 + 80 - 15;
        int row = 0;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                x+=16;
            }
            row++;
            start-=16;
        }
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));;
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 70, 188);

    }

    
    public void drawMiddle(Graphics g, Player player, int width, int height){// Player player){
        g.drawImage(color(player.getColor()), 245, 35, 190, 130, null);
        g.drawImage(board, 250, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 275, 188);
        int start = 255 + 80 - 15;
        int row = 0;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d] != null){
                    g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                }
                x+=16;
            }
            row++;
            start-=16;
        }        
    }
    public void drawRight(Graphics g, Player player){
        g.drawImage(color(player.getColor()), 445, 35, 190, 130, null);
        g.drawImage(board, 450, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), 480, 188);
         int row = 0;
         int start = 455 + 80 - 15;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                x+=16;
            }
            row++;
            start-= 16;
        }        
    }
    public void drawValidRows(Graphics g, Player p, int width, int height){
        if(game.phase == 1 && p.getPicked().size() > 0){
            System.out.println(p.getPicked().size());
            for(int c = 0; c < 5; c++){
                if(p.validRow(c)){
                    g.drawImage(glowingrow, width/2 + 250 - c*45, height/2 - 87 + 45*c, (c+1)*44, 40, null);
                }
            }
        }
    }
    public void drawTurn(Graphics g, int width, int height, Player player){
        g.drawImage(color(player.getColor()), width/2+40, height/2-110, 530, 360, null);
        g.drawImage(board, width/2 + 50, height/2 - 100, 510, 340, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 75));
        g.setColor(Color.black);
        g.drawString("SCORE: " + player.getScore(), width/2 + 100, height/2 + 305);
        drawValidRows(g, player, width, height);
        //DIMENSIONS: tiles are 40 by 40 and increment by 45 each time

        //row dimensions: 220 by 200
        //g.drawImage(border, width/2 + 70, height/2 - 87, 220, 220, null); //dimensions of row
        int row = 0;
        int start = width/2+70 + 220 - 40;
        for(int c = height/2 - 87; c < height/2-87 + 40 * 5; c+= 45){
            int x = start;
            for(int d = 0; d < 1+ (c-(height/2-87))/45; d++){
                //Tile tile = game.getPlayers().get(game.turn).getRow().getRow(row)[d];
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 40, 40, null);
                x+=45;
            }
            row++;
            start-=45;
        }
    }
    public static BufferedImage color (String color){
		if(color.equals("red")) return redborder;
        if(color.equals("blue")) return blueborder;
        if(color.equals("green")) return greenborder;
        if(color.equals("yellow")) return yellowborder;
        return redborder;
	}

}
