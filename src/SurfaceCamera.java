
public class SurfaceCamera{

	private double height;
	private Surface surface;
	
	private double zoom;
	
	private Entity focus;
	
	private Handler handler;
	
	public SurfaceCamera(Handler handler, Surface surface) {
		this.handler = handler;
		
		this.surface = surface;
		
		zoom = 100;
	}
	
	public void tick() {
		
	}

	public double[] getOffset() {
		double[] offset = new double[2];

		offset[0] = -handler.getWidth() / 2 + focus.getLocation()[0] * zoom;
		offset[1] = -handler.getHeight() / 2 + focus.getLocation()[1] * zoom;
		
		if (offset[1] < 0) {
			offset[1] = 0;
		} else if (offset[1] + handler.getHeight() > surface.getMapHeight() * zoom) {
			offset[1] = surface.getMapHeight() * zoom - handler.getHeight();
		}
		return offset;
	}
	
	public void setFocus(SurfaceEntity e) {
		focus = e;
	}
	
	public double getZoom() {
		return zoom;
	}
}
