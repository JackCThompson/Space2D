import java.awt.Color;
import java.awt.Graphics;

public class Body extends Entity{

	Color color;
	int radius;
	
	double angularVelocity;
	double distance;
	double angle;
	
	public Body(Handler handler, Color color, int radius, double angularVelocity, double distance, double angle) {
		super(handler);
		
		this.color = color;
		this.radius = radius;
		
		this.angularVelocity= angularVelocity;
		this.distance = distance;
		this.angle = angle;
		
		distance = 0;
		angle = 0;
		
		location = new float[] {(float) (distance * Math.cos(angle)), (float) (distance * Math.sin(angle))};
	}
	
	public void tick() {
		angle += angularVelocity;
		location = new float[] {(float) (distance * Math.cos(angle)), (float) (distance * Math.sin(angle))};
	}
	
	public void render(Graphics g, Camera camera) {
		g.setColor(color);
		g.fillOval((int) (((location[0]- radius)) * camera.getZoom() - camera.getOffset()[0]), (int) (((location[1] - radius) * camera.getZoom() - camera.getOffset()[1])), (int)(2*radius*camera.getZoom()), (int)(2*radius*camera.getZoom()));
	}
}
