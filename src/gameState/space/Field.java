package gameState.space;
import java.awt.Graphics;
import java.util.ArrayList;

import camera.SpaceCamera;
import gameState.GameState;
import spaceEntity.SpaceEntity;
import spaceEntity.Vessel;
import spaceEntityController.SpaceVesselController;
import utility.Assets;
import utility.Handler;

public class Field extends GameState{

	private ArrayList<SpaceEntity> entities;
	
	private SpaceCamera camera;
	
	public Field(Handler handler, ArrayList<SpaceEntity> entities) {
		super(handler);

		camera = new SpaceCamera(handler);
		
		this.entities = entities;
		
		Vessel ship = new Vessel(handler, new double[] {45, 45});
		ship.setController(new SpaceVesselController(ship, handler, SpaceVesselController.PLAYER));
		
		entities.add(ship);
		
		camera.setFocus(ship);
	}
	
	public void tick() {
		for (SpaceEntity e:entities) {
			e.tick();
		}
		camera.tick();
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		for (SpaceEntity e:entities) {
			e.render(g, camera);
		}
	}
}
