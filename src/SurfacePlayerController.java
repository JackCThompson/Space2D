
public class SurfacePlayerController extends SurfaceEntityController{

	public SurfacePlayerController(SurfaceEntity e, Handler handler) {
		super(e, handler);
	}		
	
	public double[] move() {
		double[] move = new double[2];
		
		if (handler.
				getKeyHandler().
				W) {
			move[1] = -e.getSpeed();
		} else if (handler.getKeyHandler().S) {
			move[1] = e.getSpeed();
		}
		
		if (handler.getKeyHandler().A) {
			move[0] = -e.getSpeed();
		} else if (handler.getKeyHandler().D) {
			move[0] = e.getSpeed();
		}
		
		return move;
	}
}
