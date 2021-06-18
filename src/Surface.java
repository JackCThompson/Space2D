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
			{t[2], t[2], t[2], t[1]},
			{t[0], t[0], t[0], t[2]}, 
			{t[2], t[2], t[2], t[3]}};
		player = new Human(handler);
		camera = new SurfaceCamera(handler, this);
		camera.setFocus(player);
	}
	
	public void tick() {
		player.tick();
		
		double[] location = player.getLocation();
		
		if (player.getLocation()[0] > map.length * TILE_SIZE) {
			player.setLocation(new double[] {location[0] - map.length * TILE_SIZE, location[1]});
		}
	}
	
	public void render(Graphics g) {

		double tileSize = camera.getZoom() * TILE_SIZE;
		
		int height = (int) Math.ceil(handler.getHeight() / tileSize) + 1;
		int width = (int) Math.ceil(handler.getWidth() / tileSize) + 1;

		int left = (int) Math.floor(camera.getOffset()[0] / tileSize);
		int top = (int) Math.floor(camera.getOffset()[1] / tileSize);
		
		for (int i = left; i < left + width; i++) {
			for (int j = top; j < top + height; j++) {
				
				int x = i;
				int y = j;
				
				if (y > map[0].length - 1) {
					continue;
				}
				
				while (x < map.length - 1) {
					x += map.length;
				}
				
				while (x > map.length - 1) {
					x -= map.length;
				}
				
				map[x][y].render(g, camera, i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE);
			}
		}
		
		player.render(g, camera);
	}
	
	public int getMapHeight() {
		return map[0].length * TILE_SIZE;
	}
	
}


