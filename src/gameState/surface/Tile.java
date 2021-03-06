package gameState.surface;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import camera.SurfaceCamera;

public class Tile {

	private BufferedImage image;
	private double[] location;
	
	public Tile(BufferedImage image, double location[]) {
		this.image = image;
		this.location = location;
	}

	public void render(Graphics g, SurfaceCamera camera) {
		
		g.drawImage(image, 
				(int) (location[0] * Surface.TILE_SIZE * camera.getZoom() - camera.getOffset()[0]), 
				(int) (location[1] * Surface.TILE_SIZE * camera.getZoom() - camera.getOffset()[1]), 
				(int) Math.ceil(Surface.TILE_SIZE * camera.getZoom()), 
				(int) Math.ceil(Surface.TILE_SIZE * camera.getZoom()), 
				null);
	}
	
	public void render(Graphics g, SurfaceCamera camera, int offset) {
		
		g.drawImage(image, 
				(int) ((location[0] - offset) * Surface.TILE_SIZE * camera.getZoom() - camera.getOffset()[0]), 
				(int) (location[1] * Surface.TILE_SIZE * camera.getZoom() - camera.getOffset()[1]), 
				(int) Math.ceil(Surface.TILE_SIZE * camera.getZoom()), 
				(int) Math.ceil(Surface.TILE_SIZE * camera.getZoom()), 
				null);
	}
}
