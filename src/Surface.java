import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Surface extends GameState{

	private SurfaceCamera camera;
	
	private Human player;
	private ChunkHandler chunkHandler;
	
	private final int MAP_HEIGHT = 12;
	private final int MAP_LENGTH = 30;
	
	public static final double TILE_SIZE = 1; // in meters
	
	public Surface(Handler handler) {
		super(handler);
		
		player = new Human(handler);
		camera = new SurfaceCamera(handler, this);
		camera.setFocus(player);
		
		this.chunkHandler = new ChunkHandler(MAP_LENGTH, MAP_HEIGHT, Color.GREEN, new Random(5).nextLong(), handler);
	}
	
	public void tick() {
		player.tick();
		
		double[] location = player.getLocation();
		
		if (player.getLocation()[0] > MAP_LENGTH * TILE_SIZE) {
			player.setLocation(new double[] {location[0] - MAP_LENGTH * TILE_SIZE, location[1]});
		}
	}
	
	public void render(Graphics g) {
		chunkHandler.render(g, camera);
		
		player.render(g, camera);
	}
	
	public double getMapHeight() {
		return MAP_HEIGHT * TILE_SIZE;
	}
	
}


