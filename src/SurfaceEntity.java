import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class SurfaceEntity {

	protected Handler handler;
	
	protected double[] location;
	
	protected BufferedImage texture;
	
	public SurfaceEntity(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public double[] getLocation() {
		return location;
	}
}
