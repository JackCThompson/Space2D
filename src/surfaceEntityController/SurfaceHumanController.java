package surfaceEntityController;
import surfaceEntity.SurfaceEntity;
import utility.Handler;

public class SurfaceHumanController extends SurfaceEntityController{

	private final int TYPE;
	
	public static final int PLAYER = 0;
	
	public SurfaceHumanController(SurfaceEntity e, Handler handler, int type) {
		super(e, handler);
		
		this.TYPE = type;
	}		
	
	public double[] move() {
		
		if (TYPE == PLAYER) {
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
		
		return null;
	}
}
