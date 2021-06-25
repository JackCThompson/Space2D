package surfaceEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import camera.SurfaceCamera;
import entity.Entity;
import surfaceEntityController.SurfaceEntityController;
import utility.Handler;

public abstract class SurfaceEntity extends Entity{

	protected double speed;
	
	protected BufferedImage texture;
	
	protected SurfaceEntityController controller;
	
	public SurfaceEntity(Handler handler) {
		super(handler);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g, SurfaceCamera camera);
	
	public abstract void move();
	
	public double getSpeed() {
		return speed;
	}
}
