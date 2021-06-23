

import java.awt.image.BufferedImage;

public class TextureSheet {

	private BufferedImage sheet;
	
	public TextureSheet(BufferedImage sheet) {
		this.sheet = new BufferedImage(sheet.getWidth(), sheet.getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.sheet.getGraphics().drawImage(sheet, 0, 0, sheet.getWidth(), sheet.getHeight(), null);
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
	
	public BufferedImage get() {
		return sheet;
	}
}
