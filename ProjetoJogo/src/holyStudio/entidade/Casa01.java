package holyStudio.entidade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Casa01 extends Entidade {


	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
    private BufferedImage[] casaUm;
    private BufferedImage[] cabanaUm;
    private BufferedImage[] corredorVoidUm;
  

	public Casa01(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		casaUm = new BufferedImage[1]; 
		cabanaUm = new BufferedImage[1]; 
		corredorVoidUm = new BufferedImage[1];
	
		for (int i = 0; i < 1; i++) {
			corredorVoidUm[i] = Game.sprite.getSprite(1023, 2767, 463, 124);
        }
		
        for (int i = 0; i < 1; i++) {
        	casaUm[i] = Game.sprite.getSprite(448, 2624, 192, 192);
        }
        for (int i = 0; i < 1; i++) {
        	cabanaUm[i] = Game.sprite.getSprite(1110, 2379, 182, 129);
        }
        

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
	
	  @Override
	    public void render(Graphics g) {
		  
		  
		  if (Game.mundo.levelAtual == 0 && Game.mapaAtual == Game.mapaContador.mapa05) {
			  g.drawImage(cabanaUm[0], this.getX() - Camera.x - 56, this.getY() - Camera.y - 112 , null);
		  } else if (Game.mundo.levelAtual ==1 && Game.mapaAtual == Game.mapaContador.mapa06) {
			  g.drawImage(casaUm[0], this.getX() - Camera.x - 56, this.getY() - Camera.y - 176 , null);
		  } 
		  if (Game.mundo.levelAtual == 0 && Game.mapaAtual == Game.mapaContador.mapa07 ) {
			  g.drawImage(corredorVoidUm[0], this.getX() - Camera.x - 49, this.getY() - Camera.y - 109, null);
		  }     
	            
	       
//	            g.setColor(Color.LIGHT_GRAY);
//	            g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//	            g.setColor(Color.BLACK);
//	            g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
	            
	    }

}

