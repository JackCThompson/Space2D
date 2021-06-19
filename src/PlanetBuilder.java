import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PlanetBuilder {

	public static Surface buildPlanet(Color color, Handler handler) {
		BufferedImage[] images = new BufferedImage[] {Assets.sand1, Assets.sand2, Assets.sand3, Assets.sand4};
		Tile[] tiles = new Tile[images.length];
		
		for (int i = 0; i < images.length; i ++) {
			Graphics2D g = images[i].createGraphics();
			g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 180));
			g.fillRect(0, 0, images[i].getWidth(), images[i].getHeight());
			
			tiles[i] = new Tile(images[i]);
		}
		
		Tile[][] map = new Tile[][] {
			{tiles[0], tiles[0], tiles[0], tiles[0]}, 
			{tiles[2], tiles[2], tiles[2], tiles[1]},
			{tiles[0], tiles[0], tiles[0], tiles[2]}, 
			{tiles[2], tiles[2], tiles[2], tiles[3]}};
			
			return new Surface(map, handler);
	}
}
