
public class SurfaceCamera extends Camera{

	private double height;
	
	public SurfaceCamera(Handler handler) {
		super(handler);
		height = 4;
	}
	
	public double getHeight() {
		return height;
	}

	public void tick() {
		
	}

	public double[] getOffset() {
		double[] offset = new double[2];

		offset[0] = -handler.getWidth() / 2 + focus.getLocation()[0];
		offset[1] = -handler.getHeight() / 2 + focus.getLocation()[1];
		
		return offset;
	}
	
	public void setFocus(SurfaceEntity e) {
		focus = e;
	}
}
