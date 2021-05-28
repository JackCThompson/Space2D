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
		
		Body sun = new Body(handler, Color.YELLOW, 70, 0, 0, 0, null);
		Body earth = new Body(handler, Color.BLUE, 20, 0.005, 180, 0, sun);
		Body moon = new Body(handler, Color.GRAY, 6, 0.05, 50, 0, earth);
		
		entities.add(sun);
		entities.add(earth);
		entities.add(moon);
		
		camera.setFocus(moon);
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