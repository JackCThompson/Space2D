package entity;
import java.awt.Graphics;

import utility.Handler;

public abstract class Entity {

	protected Handler handler;
	
	protected double[] location;
	
	public Entity(Handler handler) {
		this.handler = handler;
	}
	
	public void setLocation(double[] location) {
		this.location = location;
	}

	public double[] getLocation() {
		return location;
	}
	
}
