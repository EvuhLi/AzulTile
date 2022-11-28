import javax.swing.JFrame;

public class Azul extends JFrame {

	public Azul(String title) {
		super(title);
		//🦧
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		//pack();
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new AzulPanel(getWidth(), getHeight()));
		setVisible(true);
	}
}