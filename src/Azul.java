import javax.swing.JFrame;
import java.util.*;

public class Azul extends JFrame {
//private static final int WIDTH =1366;
//private static final int HEIGHT = 768;
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;

	public Azul(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new AzulPanel());
		setVisible(true);
	}
}