package spaceEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import camera.SpaceCamera;
import spaceEntityController.SpaceEntityController;
import utility.Assets;
import utility.Handler;
import utility.Utils;

public class Vessel extends SpaceEntity {

	private SpaceEntityController controller;
	
	private BufferedImage baseTexture;
	
	private int size;
	
	private double directionRads;
	
	public Vessel(Handler handler, double[] location) {
		super(handler);
		super.location = location;
		
		acceleration = new double[] {0, 0};
		velocity = new double[] {0, 0};
		
		size = 10;
		
		baseTexture = Assets.ship;
		directionRads = 0;
	}
	
	public void tick() {
		acceleration = controller.getAcceleration();
		
		if (acceleration[0] != 0 || acceleration[1] != 0) {
			double r = Math.sqrt(Math.pow(acceleration[0], 2) + Math.pow(acceleration[1], 2));
			directionRads = Math.acos(-acceleration[1] / r);
			
			if (acceleration[0] < 0) {
				directionRads = -directionRads;
			}
		}
		
		velocity[0] += acceleration[0];
		velocity[1] += acceleration[1];
		
		location[0] += velocity[0];
		location[1] += velocity[1];
		
		if (Math.abs(velocity[0]) < 0.02) {
			velocity[0] = 0;
		}
		
		if (Math.abs(velocity[1]) < 0.02) {
			velocity[1] = 0;
		}
	}
	
	public void render(Graphics g, SpaceCamera camera) {
		BufferedImage texture = Utils.rotateImageByDegrees(baseTexture, directionRads);

		double scaler = (float) texture.getWidth() / baseTexture.getWidth();
		
		g.drawImage(texture, (int) ((location[0] - size * scaler / 2) * camera.getZoom() - camera.getOffset()[0]), (int) ((location[1] - size * scaler / 2) * camera.getZoom() - camera.getOffset()[1]), (int) (size * scaler * camera.getZoom()), (int) (size * scaler * camera.getZoom()), null);
	}
	
	public void setController(SpaceEntityController controller) {
		this.controller = controller;
	}
}
