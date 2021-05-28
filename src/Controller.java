
public abstract class Controller {

	protected Vessel controlled;
	
	public Controller(Vessel controlled) {
		this.controlled = controlled;
	}
	
	public abstract double[] getAcceleration();

}
