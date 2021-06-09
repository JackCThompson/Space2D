import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class SurfaceEntity extends Entity{

	protected double speed;
	
	protected BufferedImage texture;
	
	protected SurfaceEntityController controller;
	
	public SurfaceEntity(Handler handler) {
		super(handler);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g, SurfaceCamera camera);
	
	public double getSpeed() {
		return speed;
	}
}
