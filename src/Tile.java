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
	
	public void render(Graphics g, int x, int y, int size) {
		
		if (useColor) {
			g.setColor(c);
			g.fillRect(x, y, size, size);
		} else {
			g.drawImage(image, x, y, size, size, null);
		}
	}
}
