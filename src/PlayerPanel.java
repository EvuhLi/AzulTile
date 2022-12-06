import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class PlayerPanel {
    Game game;
    BufferedImage board, redtile, yellowtile, bluetile, tealtile, blacktile, firstTile;
    static BufferedImage redborder;
    static BufferedImage yellowborder;
    static BufferedImage greenborder;
    static BufferedImage blueborder;
    BufferedImage border, screenbg, logo, score, glowingrow, blackborder, nextplayer, blackbg, arrow;
    int hover;


    public PlayerPanel(Game g){
        game = g;
        hover = -1;
        try {
            firstTile = ImageIO.read(getClass().getResourceAsStream("/images/firstplayer.png"));
            blackbg = ImageIO.read(getClass().getResourceAsStream("/images/startgamebg.png"));
            nextplayer = ImageIO.read(getClass().getResourceAsStream("/images/nextplayer.png"));
            board = ImageIO.read(getClass().getResourceAsStream("/images/Azul Board.jpg"));
            redtile = ImageIO.read(getClass().getResourceAsStream("/images/red tile.png"));
            yellowtile = ImageIO.read(getClass().getResourceAsStream("/images/yellow tile.png"));
            bluetile = ImageIO.read(getClass().getResourceAsStream("/images/blue tile.png"));
            tealtile = ImageIO.read(getClass().getResourceAsStream("/images/teal tile.png"));
            blacktile = ImageIO.read(getClass().getResourceAsStream("/images/black tile.png"));
            border = ImageIO.read(getClass().getResourceAsStream("/images/border.png"));
			screenbg = ImageIO.read(getClass().getResourceAsStream("/images/bluebg.png"));
            logo = ImageIO.read(getClass().getResourceAsStream("/images/logo.png"));
            score = ImageIO.read(getClass().getResourceAsStream("/images/score.png"));
            redborder = ImageIO.read(getClass().getResourceAsStream("/images/redborder.png"));
            yellowborder = ImageIO.read(getClass().getResourceAsStream("/images/yellowborder.png"));
            blueborder = ImageIO.read(getClass().getResourceAsStream("/images/blueborder.png"));
            greenborder = ImageIO.read(getClass().getResourceAsStream("/images/greenborder.png"));
            glowingrow = ImageIO.read(getClass().getResourceAsStream("/images/glowing row.png"));
            blackborder = ImageIO.read(getClass().getResourceAsStream("/images/blackborder.png"));
            arrow = ImageIO.read(getClass().getResourceAsStream("/images/arrow.png"));

		} catch (Exception E) {
			System.out.println(E.getMessage());
			return;
		}
    }
    public void drawAll(Graphics g, int width, int height, int pick){
        g.drawImage(screenbg, 0, 0, width, height, null);
        if(pick == -2){
            g.setColor(new Color(219, 132, 77));
            g.fillRect(1167 - 50, 35, 75, 30);
            g.setFont(new Font("Times New Roman", Font.BOLD, 28));
            g.setColor(Color.gray);
            g.drawString("Score", 1173 - 50, 60);
            g.setColor(Color.white);
            g.drawString("Score", 1170 - 50, 60);
        }
        if(pick == -1){
            g.setFont(new Font("Times New Roman", Font.BOLD, 28));
            g.setColor(Color.gray);
            g.drawString("Pick a Factory", width/2 - 150, height/2 - 120);
            g.setColor(Color.white);
            g.drawString("Pick a Factory", width/2 - 153, height/2 - 120);
        }
        if(pick == 0){
            g.setFont(new Font("Times New Roman", Font.BOLD, 28));
            g.setColor(Color.gray);
            g.drawString("Pick a", 663, 100);
            g.drawString("Tile", 677, 124);
            g.setColor(Color.white);
            g.drawString("Pick a", 660, 100);
            g.drawString("Tile", 674, 124);
            g.drawImage(arrow, width/2 , 150, 75, 60, null);
        }
        if(pick == 1){
            g.setFont(new Font("Times New Roman", Font.BOLD, 28));
            g.setColor(Color.gray);
            g.drawString("Pick a Row", width/2 - 50, height/2 - 120);
            g.setColor(Color.white);
            g.drawString("Pick a Row", width/2 - 53, height/2 - 120);
        }
        if(pick == 3){
            g.setColor(new Color(219, 132, 77));
            g.fillRect(1067, 35, 150, 30);
            g.setFont(new Font("Times New Roman", Font.BOLD, 28));
            g.setColor(Color.gray);
            g.drawString("Next Player", 1073, 60);
            g.setColor(Color.white);
            g.drawString("Next Player", 1070, 60);
            g.drawImage(arrow, width - 190, 100, 75, 60, null);
            //g.drawImage(nextplayer, 1020, 30, 215,  40, null)
        }
        drawLeft(g, game.getPlayers().get(3), width, height);
        drawMiddle(g, game.getPlayers().get(2), width, height); // logic needs change
        drawRight(g, game.getPlayers().get(1), width, height); // logic needs change
        drawTurn(g, width, height, game.getPlayers().get(0), pick == 1);
        g.drawImage(border, 0, 0, width, height, null);
        g.drawImage(logo, width/2+150, 30, 300, 210, null);
        if(hover > -1){
            drawHover(g, width, height);
            hover = -1;
        }
        //🦧
    }
    
    public void drawLeft(Graphics g, Player player, int width, int height){
        g.drawImage(color(player.getColor()), 45, 35, 190, 130, null);
        g.drawImage(board, 50, 40, 180, 120, null);
        if(player.first){
            g.drawImage(firstTile, 60, 130, 15, 15, null);
        }
        //DIMENSTIONS: 80 by 80
        //g.drawImage(border, 56, 44, 80, 80, null);
        int start = 56 + 80 - 15;
        int row = 0;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                x-=16;
            }
            row++;
            //start-=16;
        }
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));;
        g.setColor(Color.black);
        g.drawImage(score, 55, 165, 125, 35, null);
        g.drawString(player.getScore() + "", 185, 191);
        //g.drawString("SCORE: " + player.getScore(), 74, 188);
        for(int c = 0; c < player.getBoard().getDiscard().size(); c++){
            g.drawImage(player.getBoard().getDiscard().get(c).getImage(), 56 + c * 35/2, 135, 15, 15, null);
        }
        int ypos= 44;
        for ( int r = 0; r < 5; r++){
            int xpos= 143;
            for ( int c = 0; c < 5; c++){
                if (player.getBoard().b[r][c] != null) {
                g.drawImage(player.getBoard().b[r][c].getImage(),xpos, ypos, 15, 15, null);
                }
                xpos +=16; 
            }
            ypos+= 16; 
        } 

    }

    
    public void drawMiddle(Graphics g, Player player, int width, int height){// Player player){
        g.drawImage(color(player.getColor()), 245, 35, 190, 130, null);
        g.drawImage(board, 250, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawImage(score, 255, 165, 125, 35, null);
        g.drawString(player.getScore() + "", 385, 191);
        //g.drawString("SCORE: " + player.getScore(), 275, 188);
        int start = 255 + 80 - 15;
        int row = 0;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d] != null){
                    g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                }
                x-=16;
            }
            row++;
            //start-=16;
        }

        for(int c = 0; c < player.getBoard().getDiscard().size(); c++){
            g.drawImage(player.getBoard().getDiscard().get(c).getImage(), 256 + c * 35/2, 135, 15, 15, null);
        }
        int ypos= 44;
        for ( int r = 0; r < 5; r++){
            int xpos= 343;
            for ( int c = 0; c < 5; c++){
                if (player.getBoard().b[r][c] != null) {
                g.drawImage(player.getBoard().b[r][c].getImage(),xpos, ypos, 15, 15, null);
                }
                xpos +=16; 
            }
            ypos+= 16; 
        } 

    }
    public void drawRight(Graphics g, Player player, int width, int height){
        g.drawImage(color(player.getColor()), 445, 35, 190, 130, null);
        g.drawImage(board, 450, 40, 180, 120, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawImage(score, 456, 165, 125, 35, null);
        g.drawString(player.getScore() + "", 586, 191);
        //g.drawString("SCORE: " + player.getScore(), 480, 188);
         int row = 0;
         int start = 455 + 80 - 15;
        for(int c = 44; c < 44 + 16 *5; c+=16){
            int x = start;
            for(int d = 0; d < 1 + (c - (44))/16; d++){
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 15, 15, null);
                x-=16;
            }
            row++;
            //start-= 16;
        } // board 

        
        for(int c = 0; c < player.getBoard().getDiscard().size(); c++){
            g.drawImage(player.getBoard().getDiscard().get(c).getImage(), 456 + c * 35/2, 135, 15, 15, null);
        }
        int ypos= 44;
        for ( int r = 0; r < 5; r++){
            int xpos= 543;
            for ( int c = 0; c < 5; c++){
                if (player.getBoard().b[r][c] != null) {
                g.drawImage(player.getBoard().b[r][c].getImage(),xpos, ypos, 15, 15, null);
                }
                xpos +=16; 
            }
            ypos+= 16; 
        } 
    }
    public void drawValidRows(Graphics g, Player p, int width, int height){
        if(Game.phase == 1 && p.getPicked().size() > 0){
            for(int c = 0; c < 5; c++){
                if(p.validRow(c)){
                    g.drawImage(glowingrow, width/2 + 250 - c*45, height/2 - 87 + 45*c, (c+1)*44, 40, null);
                }
            }
        }
    }
    public void moveTile(Graphics g, int row, int x, int height){
        g.drawImage(Game.players.get(0).getRow().getRow(row)[0].getImage(), x, height/2 - 87 + 45 * row, null);
    }
    public void drawTurn(Graphics g, int width, int height, Player player, boolean pickedF){
        game.transferDiscard();
        g.drawImage(color(player.getColor()), width/2+40, height/2-110, 530, 360, null);
        g.drawImage(board, width/2 + 50, height/2 - 100, 510, 340, null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 70));
        g.setColor(Color.black);
        g.drawImage(score, width/2 + 100, height/2 + 250, 275, 76, null);
        g.drawString(player.getScore() + "", width/2 + 380, height/2 + 307);
        //g.drawString("SCORE: " + player.getScore(), width/2 + 115, height/2 + 305);
        if(pickedF) drawValidRows(g, player, width, height);
        //DIMENSIONS: tiles are 40 by 40 and increment by 45 each time

        //row dimensions: 220 by 200
        //g.drawImage(border, width/2 + 70, height/2 - 87, 220, 220, null); //dimensions of row
        int row = 0;
        int start = width/2+70 + 220 - 40;
        for(int c = height/2 - 87; c < height/2-87 + 40 * 5; c+= 45){
            int x = start;
            for(int d = 0; d < player.getRow().getRow(row).length; d++){
                //Tile tile = game.getPlayers().get(game.turn).getRow().getRow(row)[d];
                if(player.getRow().getRow(row)[d]!= null) g.drawImage(player.getRow().getRow(row)[d].getImage(), x, c, 40, 40, null);
                x-=45;
            }
            row++;
            //start-=45;
        }
        for(int c = 0; c < player.getBoard().getDiscard().size() && c < 7; c++){
            g.drawImage(player.getBoard().getDiscard().get(c).getImage(), width/2 + 70 + c * 98/2, height/2 + 170, 40, 40, null);
        }
        // board coding
        int ypos= height/2 - 87;
        for ( int r = 0; r < 5; r++){
            int xpos= width/3 * 2 + 105;
            for ( int c = 0; c < 5; c++){
                if (player.getBoard().b[r][c] != null) {
                g.drawImage(player.getBoard().b[r][c].getImage(),xpos, ypos, 40, 40, null);
                }
                xpos +=45; 
            }
            ypos+= 45;
        }

    }
    public static BufferedImage color (String color){
		if(color.equals("red")) return redborder;
        if(color.equals("blue"))  return blueborder;
        if(color.equals("green")) return greenborder;
        else return yellowborder;
        //return redborder;
	}
    public void drawHover(Graphics g, int width, int height){
        if(game.getPlayers().get(0).getPicked().size() > 0 && game.getPlayers().get(0).validRow(hover)) g.drawImage(blackborder, width/2 + 250 - hover*45, height/2 - 87 + 45*hover, (hover+1)*44, 40, null);


    }

}
