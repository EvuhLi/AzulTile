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
            tile = ImageIO.read(new File("src/blue tile.png"));
            factory = ImageIO.read(new File("src/factory.png"));
		} catch (Exception e) {
			return;
		}

	}

	public void paintFactory(int w, int h, int ww, int hh, Graphics g) {
		int size = ww / 13;
		int tSize = ww / 43;
		g.drawImage(factory, w, h, size, size, null);
		g.drawImage(tile, w + 60, h + 60, tSize, tSize, null);
		g.drawImage(tile, w + 60, h + 105, tSize, tSize, null);
		g.drawImage(tile, w + 100, h + 60, tSize, tSize, null);
		g.drawImage(tile, w + 100, h + 105, tSize, tSize, null);

	}

}