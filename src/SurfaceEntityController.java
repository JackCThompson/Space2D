
public abstract class SurfaceEntityController {

	protected Handler handler;
	
	protected SurfaceEntity e;
	
	public SurfaceEntityController(SurfaceEntity e, Handler handler) {
		this.e = e;
		
		this.handler = handler;
	}
	
	public abstract double[] move();
}
