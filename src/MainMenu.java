import javax.swing.JFrame;


public class MainMenu extends JFrame{

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1000;
	
	public MainMenu(String title) {
		
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MainMenuPanel());
		setVisible(true);
	}
	
}
