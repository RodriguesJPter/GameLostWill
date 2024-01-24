package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class PropCenarioUm extends Entidade {


	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
	
	 private BufferedImage[] pilhaCorpos;
	 private BufferedImage[] pilhaCorposDois;
	 private BufferedImage[] pilhaCorposTres;
	 
	 private BufferedImage[] propDuasEspadas;
	 
	
	 

	public PropCenarioUm(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		pilhaCorpos = new BufferedImage[1]; 
		pilhaCorposDois = new BufferedImage[1]; 
		pilhaCorposTres = new BufferedImage[1]; 
		propDuasEspadas = new BufferedImage[1];
	
		

		for (int i = 0; i < 1; i++) {
			pilhaCorpos[i] = Game.sprite.getSprite(1043, 2561, 140, 117);
        }
		for (int i = 0; i < 1; i++) {
			pilhaCorposDois[i] = Game.sprite.getSprite(864, 2640, 128, 128);
        }
		for (int i = 0; i < 1; i++) {
			pilhaCorposTres[i] = Game.sprite.getSprite(832, 2848, 128, 144);
        }
		
		for (int i = 0; i < 1; i++) {
			propDuasEspadas[i] = Game.sprite.getSprite(1421, 2441, 49, 53);
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
		  
		  if (Game.mapaAtual == Game.mapaContador.mapa00) {
			  g.drawImage(pilhaCorpos[0], this.getX() - Camera.x - 49, this.getY() - Camera.y - 52, null);
			  g.drawImage(pilhaCorposDois[0], this.getX() - Camera.x + 365, this.getY() - Camera.y + 41, null);
			  g.drawImage(pilhaCorposTres[0], this.getX() - Camera.x + 150, this.getY() - Camera.y + 20, null);
		  }
		  
		  if (Game.mapaAtual == Game.mapaContador.mapa01 || Game.mapaAtual == Game.mapaContador.mapa02
				  || Game.mapaAtual == Game.mapaContador.mapa03 || Game.mapaAtual == Game.mapaContador.mapa04
				  || Game.mapaAtual == Game.mapaContador.mapa05) {
			  g.drawImage(propDuasEspadas[0], this.getX() - Camera.x - 49, this.getY() - Camera.y - 36, null);
		  }
		  
		  
		  
		  
		  
	    }

}

