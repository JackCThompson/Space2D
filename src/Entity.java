import java.awt.Graphics;

public abstract class Entity {

	protected Handler handler;
	
	protected double[] location;
	protected double[] velocity;
	protected double[] acceleration;
	protected double mass;
	
	public Entity(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g, Camera camera);
	
	public double[] getLocation() {
		return location;
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}

	public double[] getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double[] acceleration) {
		this.acceleration = acceleration;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}
	
	
}
