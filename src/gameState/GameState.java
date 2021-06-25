package gameState;
import java.awt.Graphics;

import utility.Handler;

public abstract class GameState {
	
	protected Handler handler;
	
	public GameState(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
