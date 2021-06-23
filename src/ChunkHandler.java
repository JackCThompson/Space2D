import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChunkHandler {

	private Handler handler;
	
	private Chunk[] chunks;
	
	private int circumference;
	private int chunkHeight;
	private long seed;
	
	private BufferedImage[] textures;
	
	public ChunkHandler(int circumference, int chunkHeight, Color color, long seed, Handler handler) {
		this.handler = handler;
		this.circumference = circumference;
		this.chunkHeight = chunkHeight;
		this.seed = seed;
		
		chunks = new Chunk[(int) Math.ceil(circumference / Chunk.CHUNK_LENGTH)];
		
		textures = new BufferedImage[] {Assets.sand1, Assets.sand2, Assets.sand3, Assets.sand4};
		
		for (int i = 0; i < textures.length; i ++) {
			Graphics2D g = textures[i].createGraphics();
			g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 180));
			g.fillRect(0, 0, textures[i].getWidth(), textures[i].getHeight());
		}
	}
	
	public void render(Graphics g, SurfaceCamera camera) {
		double tileSize = camera.getZoom() * Surface.TILE_SIZE;
		
		int height = (int) Math.ceil(handler.getHeight() / tileSize) + 1;
		int width = (int) Math.ceil(handler.getWidth() / tileSize) + 1;

		int left = (int) Math.floor(camera.getOffset()[0] / tileSize);
		int top = (int) Math.floor(camera.getOffset()[1] / tileSize);
		
		for (int i = left; i < left + width; i++) {
			for (int j = top; j < top + height; j++) {
				
				int x = i;
				int y = j;
				
				if (y > chunkHeight - 1) {
					continue;
				}
				
				int offset = 0;
				
				while (x < 0) {
					x += circumference;
					offset ++;
				}
				
				while (x > circumference - 1) {
					x -= circumference;
					offset --;
				}
				
				int chunkIndex = (int) Math.floor(x / Chunk.CHUNK_LENGTH);
				
				if (chunks[chunkIndex] == null) {
					
					Random rand = new Random(seed);
					for (int r = 0; r < chunkIndex; r++) {
						rand.nextLong();
					}
					chunks[chunkIndex] = new Chunk(chunkHeight, rand.nextLong(), textures, chunkIndex);
				}
				
				chunks[chunkIndex].render(g, new int[] {x, y}, camera, offset * circumference);
				
			}
		}
	}
}
