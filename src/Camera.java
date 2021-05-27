
public class Camera {

	private Handler handler;
	
	private float zoom;
	private float[] center;
	
	private Entity focus;
	
	public Camera(Handler handler) {
		this.handler = handler;
		
		zoom = 1;
		center = new float[] {0, 0};
	}
	
	public void tick() {
		if (focus != null) {
			center = focus.getLocation();
		}
		
		zoom += 0.02;
	}
	
	public void setFocus(Entity e) {
		focus = e;
	}
	
	public float[] getOffset() {
		return new float[] {center[0] - handler.getWidth() / 2, center[1] - handler.getHeight() / 2};
	}
}
