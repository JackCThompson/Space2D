package gameState.space;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import spaceEntity.SpaceEntity;
import utility.Handler;
import utility.Utils;

public class FieldBuilder {

	// Returns a new Map loaded from data in the png and txt files called String:mapName.(png/txt)
	public static Field loadMap(String fieldName, Handler handler) {
		Scanner fieldData = new Scanner(Utils.loadFileAsString("res/fields/" + fieldName + ".txt"));
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<SpaceEntity> bodies = new ArrayList<SpaceEntity>();
		
		while (fieldData.hasNextLine()) {
			Scanner item = new Scanner(fieldData.nextLine());
			String name = item.next();
			int red = item.nextInt();
			int green = item.nextInt();
			int blue = item.nextInt();
			double radius = item.nextDouble();
			double angularVelocity = item.nextDouble();
			double distance = item.nextDouble();
			double angle = item.nextDouble();
			
			Body body;
			if (item.hasNext()) {
				String focus = item.next();
				body = new Body(handler, name, new Color(red, green, blue), radius, angularVelocity, distance, angle, (Body)bodies.get(names.indexOf(focus)));
			} else {
				body = new Body(handler, name, new Color(red, green, blue), radius, angularVelocity, distance, angle, null);
			}
 			
			names.add(name);
			bodies.add(body);
			item.close();
		}
		
		fieldData.close();
		
		return new Field(handler, bodies);
	}
}
