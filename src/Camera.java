
public class Camera {

	private Handler handler;
	
	private double zoom;
	private double[] center;
	
	private Entity focus;
	
	public Camera(Handler handler) {
		this.handler = handler;
		
		zoom = 1;
		center = new double[] {0, 0};
	}
	
	public void tick() {
		if (focus != null) {
			center = focus.getLocation();
		}
		
		if(handler.getKeyHandler().UP) {
			zoom *= 1.02;
		}
		
		if (handler.getKeyHandler().DOWN){
			zoom *= 0.98;
		}
	}
	
	public void setFocus(Entity e) {
		focus = e;
	}
	
	public double[] getOffset() {
		return new double[] {center[0] * zoom - handler.getWidth() / 2, center[1] * zoom - handler.getHeight() / 2};
	}
	
	public double getZoom() {
		return zoom;
	}
}
