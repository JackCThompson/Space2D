import java.awt.Color;
import java.awt.Graphics;

public class Surface extends GameState{

	private SurfaceCamera camera;
	
	private Tile[] t;
	private Tile[][] map;
	private Human player;
	
	private final double TILE_SIZE = 3;
	
	public Surface(Color c, Handler handler) {
		super(handler);
		camera = new SurfaceCamera(handler);
		
		t = new Tile[] {new Tile(Assets.sand1), new Tile(Assets.sand2), new Tile(Assets.sand3), new Tile(Assets.sand4)};

		map = new Tile[][] {
			{t[0], t[0], t[0], t[0]}, 
			{t[2], t[2], t[2], t[2]}};
		player = new Human(handler);
		camera = new SurfaceCamera(handler);
		camera.setFocus(player);
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render(Graphics g) {
		
		int size = (int) (handler.getHeight() / camera.getHeight());

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].render(g, camera, i * size, j * size, size);
			}
		}
		
		player.render(g, camera);
	}
	
}


