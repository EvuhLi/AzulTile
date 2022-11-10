import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class OneFactoryPanel {

	private ArrayList<Tile> tiles;
	private BufferedImage factory, tile, red, yellow, TChoose;

	public OneFactoryPanel() {
		try {
			tiles = new ArrayList<>();
            tile = ImageIO.read(new File("src/images/blue tile.png"));
			red = ImageIO.read(new File("src/images/red tile.png"));
			yellow = ImageIO.read(new File("src/images/yellow tile.png"));
			TChoose = ImageIO.read(new File("src/images/TileChoosing.png"));
            factory = ImageIO.read(new File("src/images/factory.png"));
		} catch (Exception e) {
			return;
		}

	}
	public void getArray(ArrayList<Tile>a){
		tiles = a;
	}

	public void paintChoosing(Graphics g){
		g.drawImage(TChoose, 600, -50, 700, 400, null);

	}

	public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
		int size = ww / 10;
		int tSize = ww / 50;
		//private static final int WIDTH = 1920;
		//private static final int HEIGHT = 1080;
		g.drawImage(factory, w, h, size, size, null);
		g.drawImage(tile, w + ww/30, h + hh/11, tSize, tSize, null);
		g.drawImage(red, w + ww/30, h + hh/18, tSize, tSize, null);
		g.drawImage(tile, w + ww/20, h + hh/18, tSize, tSize, null);
		g.drawImage(yellow, w + ww/20, h + hh/11, tSize, tSize, null);
	}

}