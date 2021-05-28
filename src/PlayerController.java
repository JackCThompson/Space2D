
public class PlayerController extends Controller{

	private Handler handler;
	
	private double power = 0.2;
	
	public PlayerController(Vessel controlled, Handler handler, KeyHandler keyHandler) {
		super(controlled);
		
		this.handler = handler;
	}
	
	public double[] getAcceleration() {
		
		double[] acceleration = new double[] {0, 0};
	
		if (handler.getKeyHandler().SPACE) {
			double[] velocity = controlled.getVelocity();
			double speed = Math.sqrt(Math.pow(velocity[0], 2) + Math.pow(velocity[1], 2));
			
			if (speed != 0) {
				double[] direction = new double[] {velocity[0] / speed, velocity[1] / speed};
				
				acceleration[0] = direction[0] * power * -1;
				acceleration[1] = direction[1] * power * -1;
			}
			
		}
		
		if (handler.getKeyHandler().A) {
			acceleration[0] = -power;
		} else if (handler.getKeyHandler().D) {
			acceleration[0] = power;
		}
		
		if (handler.getKeyHandler().W) {
			acceleration[1] = -power;
		} else if (handler.getKeyHandler().S) {
			acceleration[1] = power;
		}
		
		return acceleration;	
	}
}
