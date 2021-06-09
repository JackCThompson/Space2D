

public abstract class SpaceEntityController {

	protected Vessel controlled;
	
	public SpaceEntityController(Vessel controlled) {
		this.controlled = controlled;
	}
	
	public abstract double[] getAcceleration();

}
