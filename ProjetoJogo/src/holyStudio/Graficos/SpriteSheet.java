package holyStudio.Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import holyStudio.Mundo.Camera;

public class SpriteSheet {

	public BufferedImage spritsheet;

	public SpriteSheet(String path) {
		try {
			spritsheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spritsheet.getSubimage(x, y, width, height);
	}

}
