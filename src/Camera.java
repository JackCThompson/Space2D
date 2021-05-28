
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
		
		//zoom = 30;
	}
	
	public void setFocus(Entity e) {
		focus = e;
	}
	
	public float[] getOffset() {
		return new float[] {center[0] * zoom - handler.getWidth() / 2, center[1] * zoom - handler.getHeight() / 2};
	}
	
	public float getZoom() {
		return zoom;
	}
}
