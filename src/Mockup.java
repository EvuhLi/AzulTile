import javax.swing.JFrame;


public class Mockup extends JFrame{

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1000;
	
	public Mockup(String title) {
		
		super(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MockupPanel());
		setVisible(true);
		//g
	}
	
}
