package surfaceEntity;

import java.awt.Graphics;

import camera.SurfaceCamera;
import surfaceEntityController.SurfaceHumanController;
import utility.Assets;
import utility.Handler;

public class Human extends SurfaceEntity{

	private final double SIZE = 1.8;
	
	public Human(Handler handler) {
		super(handler);
		
		controller = new SurfaceHumanController(this, handler, SurfaceHumanController.PLAYER);
		location = new double[] {2, 1};
		
		speed = 0.0283;
		
		texture = Assets.commander;
	}
	
	public void tick() {
		move();
	}
	
	public void render(Graphics g, SurfaceCamera camera) {
		g.drawImage(texture, (int) (location[0] * camera.getZoom() - camera.getOffset()[0]), (int)(location[1] * camera.getZoom() - camera.getOffset()[1]), (int) (SIZE * camera.getZoom()), (int) (SIZE * camera.getZoom()), null);
	}
	
	public void move() {
		
		double[] move = controller.move();
		
		location[0] += move[0];
		location[1] += move[1];	
	}
	
}
