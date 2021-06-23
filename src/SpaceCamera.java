
public class SpaceCamera extends Camera {
	
	public SpaceCamera(Handler handler) {
		super(handler);
	}

	public void tick() {		
		if(handler.getKeyHandler().UP) {
			zoom *= 1.02;
		}
		
		if (handler.getKeyHandler().DOWN){
			zoom *= 0.98;
		}
	}
	
	public double[] getOffset() {
		
		if (focus != null) {
			center = focus.getLocation();
		}
		
		return new double[] {center[0] * zoom - handler.getWidth() / 2, center[1] * zoom - handler.getHeight() / 2};
	}
	
	public void setFocus(SpaceEntity e) {
		focus = e;
	}

}
