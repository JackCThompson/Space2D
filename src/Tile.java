import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	private boolean useColor;
	private BufferedImage image;
	private Color c;
	
	public Tile(BufferedImage image) {
		this.image = image;
		useColor = false;
		
		System.out.println(image);
	}
	
	public Tile(Color c) {
		this.c = c;
		useColor = true;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, SurfaceCamera camera, int x, int y, int size) {
		
		if (useColor) {
			g.setColor(c);
			g.fillRect(x, y, size, size);
		} else {
			g.drawImage(image, (int) (x - camera.getOffset()[0]), (int) (y - camera.getOffset()[1]), size, size, null);
		}
	}
}
