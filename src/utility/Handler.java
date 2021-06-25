package utility;

public class Handler {

	private Game game;
	private KeyHandler keyHandler;
	
	public Handler(Game game, KeyHandler keyHandler) {
		this.game = game;
		this.keyHandler = keyHandler;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
}
