import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Chunk {

	public static final int CHUNK_LENGTH = 2;
	
	private Tile[][] chunk;
	
	private int Xmin;
	
	public Chunk(int height, long seed, BufferedImage[] textures, int chunkNumber) {
		
		this.Xmin = chunkNumber * CHUNK_LENGTH;
		
		chunk = new Tile[CHUNK_LENGTH][height];

		Random randomizer = new Random(seed);
		
		for (int i = 0; i < CHUNK_LENGTH; i++) {
			for (int j = 0; j < height; j++) {
				int rand = (int) ((textures.length - 1) * randomizer.nextDouble());
				
				chunk[i][j] = new Tile(textures[rand], new double[] {Xmin + i, j});
			}
		}
	}
	
	public void render(Graphics g, int[] location, SurfaceCamera camera) {
		chunk[location[0] - Xmin][location[1]].render(g, camera);
	}
	
	public void render(Graphics g, int[] location, SurfaceCamera camera, int offset) {
		chunk[location[0] - Xmin][location[1]].render(g, camera, offset);
	}
}
