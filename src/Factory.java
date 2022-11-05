import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Factory {

	private BufferedImage factory, tile;

	public Factory() {
		try {
            tile = ImageIO.read(new File("src/images/blue tile.png"));
            factory = ImageIO.read(new File("src/images/factory.png"));
		} catch (Exception e) {
			return;
		}

	}

	public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
		int size = ww / 10;
		int tSize = ww / 50;
		//private static final int WIDTH = 1920;
		//private static final int HEIGHT = 1080;

		g.drawImage(factory, w, h, size, size, null);
		g.drawImage(tile, w + ww/30, h + 100, tSize, tSize, null);
		g.drawImage(tile, w + ww/30, h + 60, tSize, tSize, null);
		g.drawImage(tile, w + ww/20, h + 60, tSize, tSize, null);
		g.drawImage(tile, w + ww/20, h + 100, tSize, tSize, null);

	}

}