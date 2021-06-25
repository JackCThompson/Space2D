package utility;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private boolean[] keys;
	
	public boolean W;
	public boolean A;
	public boolean S;
	public boolean D;
	
	public boolean SPACE;
	public boolean UP;
	public boolean DOWN;
	
	public KeyHandler() {
		keys = new boolean[256];
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {}
	
	public void tick() {
		W = keys[KeyEvent.VK_W];
		A = keys[KeyEvent.VK_A];
		S = keys[KeyEvent.VK_S];
		D = keys[KeyEvent.VK_D];
		
		SPACE = keys[KeyEvent.VK_SPACE];
		UP = keys[KeyEvent.VK_UP];
		DOWN = keys[KeyEvent.VK_DOWN];
	}

}
