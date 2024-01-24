package holyStudio.entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.main.Game;

public class caxote extends Entidade {


	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public caxote(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);


	}
	@Override
	public void tick() {
		if(!colisao((int)x,(int)(y+2))) {
			y+=2;
		}
	}

	public boolean colisao(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty+masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					return true;
				}
			}

		}
		return false;
	}

}

