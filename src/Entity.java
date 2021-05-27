import java.awt.Graphics;

public abstract class Entity {

	protected Handler handler;
	
	protected float[] location;
	protected float[] velocity;
	protected float mass;
	
	public Entity(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g, Camera camera);
	
	public float[] getLocation() {
		return location;
	}
}
