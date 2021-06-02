import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Field extends GameState{

	private ArrayList<SpaceEntity> entities;
	
	private SpaceCamera camera;
	
	public Field(Handler handler, ArrayList<SpaceEntity> entities) {
		super(handler);

		camera = new SpaceCamera(handler);
		
		this.entities = entities;
		
		Vessel ship = new Vessel(handler, Color.GRAY, new double[] {45, 45});
		ship.setController(new SpacePlayerController(ship, handler));
		
		entities.add(ship);
		
		camera.setFocus(ship);
	}
	
	public void tick() {
		for (SpaceEntity e:entities) {
			e.tick();
		}
		camera.tick();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
		for (SpaceEntity e:entities) {
			e.render(g, camera);
		}
	}
}
