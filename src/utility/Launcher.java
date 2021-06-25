package utility;
import java.awt.Toolkit;

public class Launcher {
	
	static int width;
	static int height;
	
	// Starts the game
	public static void main(String[] args) {
		width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.9);
		height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.9);
		
		Game game = new Game(width, height);
		game.start();
	}
}