import java.awt.Graphics;

public class Human extends SurfaceEntity{

	public Human(Handler handler) {
		super(handler);
		
		controller = new SurfacePlayerController(this, handler);
		location = new double[] {100, 100};
		
		speed = 4;
		
		texture = Assets.commander;
	}
	
	public void tick() {
		double[] move = controller.move();
		
		location[0] += move[0];
		location[1] += move[1];
		
		System.out.println(location[0] + " " + location[1]);
	}
	
	public void render(Graphics g, SurfaceCamera camera) {
		g.drawImage(texture, (int) (location[0] - camera.getOffset()[0]), (int)(location[1] - camera.getOffset()[1]), texture.getWidth() * 2, texture.getHeight() * 2, null);
	}
	
}
