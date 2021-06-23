

import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {

	public static final int CELL_LENGTH = 64;

	public static TextureSheet planet1_sand;
	public static TextureSheet commander_sheet;
	public static TextureSheet ship_sheet;
	public static TextureSheet background_sheet;

	public static BufferedImage sand1;
	public static BufferedImage sand2;
	public static BufferedImage sand3;
	public static BufferedImage sand4;

	public static BufferedImage commander;

	public static BufferedImage ship;
	
	public static BufferedImage background;

	public static void init() {
		
		planet1_sand = new TextureSheet(ImageLoader.loadImage(new File ("res/textures/planet 1/sand.png")));
		
		sand1 = crop(0, 0, 1, 1, planet1_sand);
		sand2 = crop(1, 0, 1, 1, planet1_sand);
		sand3 = crop(0, 1, 1, 1, planet1_sand);
		sand4 = crop(1, 1, 1, 1, planet1_sand);
		
		commander_sheet = new TextureSheet(ImageLoader.loadImage(new File("res/textures/commander/commander.png")));
		
//		commander = crop(0, 0, 1, 1, commander_sheet);
		commander = commander_sheet.get();
		
		ship_sheet = new TextureSheet(ImageLoader.loadImage(new File("res/textures/ship/ship.png")));
		
		ship = ship_sheet.get();
		
		background_sheet = new TextureSheet(ImageLoader.loadImage(new File("res/textures/background.jpg")));
		
		background = background_sheet.get();
		
	}
	
	private static BufferedImage crop(int x, int y, int width, int height, TextureSheet sheet) {
		return sheet.crop(x * CELL_LENGTH, y * CELL_LENGTH, width * CELL_LENGTH, height * CELL_LENGTH);
	}
	
}
