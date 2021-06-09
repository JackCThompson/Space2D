
import java.awt.Graphics;

public abstract class SpaceEntity extends Entity{

	protected double[] velocity;
	protected double[] acceleration;
	
	public SpaceEntity(Handler handler) {
		super(handler);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g, SpaceCamera camera);

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

	
	
	
}
