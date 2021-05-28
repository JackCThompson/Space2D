import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Field {

	private Handler handler;
	private ArrayList<Entity> entities;
	
	private KeyHandler keyHandler;
	
	private Camera camera;
	
	public Field(Handler handler, KeyHandler keyHandler) {
		this.handler = handler;
		this.keyHandler = keyHandler;
		
		camera = new Camera(handler);
		
		entities = new ArrayList<Entity>();
		
		Body sun = new Body(handler, Color.YELLOW, 70, 0.1, 0, 0, null);
		Body earth = new Body(handler, Color.BLUE, 20, 0.005, 180, 0, sun);
		Body moon = new Body(handler, Color.GRAY, 6, 0.05, 50, 0, earth);
		Body rock = new Body(handler, Color.WHITE, 1, 0.1, 19, 0, moon);

		
		Vessel ship = new Vessel(handler, Color.GRAY, new double[] {45, 45});
		ship.setController(new PlayerController(ship, handler, keyHandler));
		
		entities.add(sun);
		entities.add(earth);
		entities.add(moon);
		entities.add(rock);
		entities.add(ship);
		
		camera.setFocus(ship);
	}
	
	public void tick() {
		for (Entity e:entities) {
			e.tick();
		}
		camera.tick();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
		for (Entity e:entities) {
			e.render(g, camera);
		}
	}
}
