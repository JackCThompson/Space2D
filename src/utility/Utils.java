package utility;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;

public class Utils {

	// Returns the file of path String:path as a String
	public static String loadFileAsString(String path) {
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
	
	public static BufferedImage rotateImageByDegrees(BufferedImage img, double rads) {
	    double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
	    int w = img.getWidth();
	    int h = img.getHeight();
	    int newWidth = (int) Math.floor(w * cos + h * sin);
	    int newHeight = (int) Math.floor(h * cos + w * sin);

	    BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = rotated.createGraphics();
	    AffineTransform at = new AffineTransform();
	    at.translate((newWidth - w) / 2, (newHeight - h) / 2);

	    int x = w / 2;
	    int y = h / 2;

	    at.rotate(rads, x, y);
	    g2d.setTransform(at);
	    g2d.drawImage(img, 0, 0, null);
	    g2d.dispose();

	    return rotated;
	}
}
