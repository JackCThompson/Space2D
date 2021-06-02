

import java.awt.image.BufferedImage;

public class TextureSheet {

	private BufferedImage sheet;
	
	public TextureSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
