import java.awt.Color;
import java.awt.Graphics;

public class Vessel extends Entity {

	private Controller controller;
	
	private Color color;
	private int size;
	
	private double power;
	
	public Vessel(Handler handler, Color color, double[] location) {
		super(handler);
		this.color = color;
		super.location = location;
		
		this.controller = controller;
		
		acceleration = new double[] {0, 0};
		velocity = new double[] {0, 0};
		
		size = 10;
		power = 0.05;
	}
	
	public void tick() {
		acceleration = controller.getAcceleration();
		
		velocity[0] += acceleration[0];
		velocity[1] += acceleration[1];
		
		location[0] += velocity[0];
		location[1] += velocity[1];
		
		if (Math.abs(velocity[0]) < 0.2) {
			velocity[0] = 0;
		}
		
		if (Math.abs(velocity[1]) < 0.2) {
			velocity[1] = 0;
		}
	}
	
	public void render(Graphics g, Camera camera) {
		g.setColor(color);
		g.fillRect((int) (((location[0] - size / 2)) * camera.getZoom() - camera.getOffset()[0]), (int) (((location[1] - size / 2) * camera.getZoom() - camera.getOffset()[1])), (int) (size *camera.getZoom()), (int)(size*camera.getZoom()));
	
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
}
