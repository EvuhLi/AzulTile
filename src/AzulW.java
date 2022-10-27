import javax.swing.JFrame;
import java.util.*;

public class AzulW extends JFrame {
//private static final int WIDTH =1366;
//private static final int HEIGHT = 768;
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1000;

	public AzulW(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new AzulFactory());
		setVisible(true);
	}
}