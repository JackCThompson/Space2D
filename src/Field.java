import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Field {

	private Handler handler;
	private ArrayList<Entity> entities;
	
	private Camera camera;
	
	public Field(Handler handler) {
		this.handler = handler;
		camera = new Camera(handler);
		
		entities = new ArrayList<Entity>();
		
		Body sun = new Body(handler, Color.YELLOW, 70, 0, 0, 0);
		Body planet = new Body(handler, Color.ORANGE, 20, 0.005, 150, 0);
		
		entities.add(sun);
		entities.add(planet);
		
		camera.setFocus(planet);
	}
	
	public void tick() {
		camera.tick();
		for (Entity e:entities) {
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
		for (Entity e:entities) {
			e.render(g, camera);
		}
	}
}
