import java.awt.Color;
import java.awt.Graphics;

public class Surface extends GameState{

	private SurfaceCamera camera;
	
	private Tile[] t;
	private Tile[][] map;
	private Human player;
	
	private final int TILE_SIZE = 3; // in meters
	
	public Surface(Color c, Handler handler) {
		super(handler);
		
		t = new Tile[] {new Tile(Assets.sand1), new Tile(Assets.sand2), new Tile(Assets.sand3), new Tile(Assets.sand4)};

		map = new Tile[][] {
			{t[0], t[0], t[0], t[0]}, 
			{t[2], t[2], t[2], t[2]}};
		player = new Human(handler);
		camera = new SurfaceCamera(handler, this);
		camera.setFocus(player);
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render(Graphics g) {
		

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].render(g, camera, i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE);
			}
		}
		
		player.render(g, camera);
	}
	
	public int getMapHeight() {
		return map[0].length * TILE_SIZE;
	}
	
}


