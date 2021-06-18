public abstract class Camera {

	protected Handler handler;
	
	protected double zoom;
	protected double[] center;
	
	protected Entity focus;
	
	public Camera(Handler handler) {
		this.handler = handler;
		
		zoom = 1;
		center = new double[] {0, 0};
	}
	
	public double getZoom() {
		return zoom;
	}
	
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	public abstract void tick();
	
	public abstract double[] getOffset();
}
