package holyStudio.entidade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class BlocoTroca02 extends Entidade {

	public boolean jogadorProximo = false;
	
	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public BlocoTroca02(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);

		
		
	}
	@Override
	public void tick() {
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow(Game.player.getY() - this.getY(), 2));
        double limiteProximidade = 15.0;

        jogadorProximo = distancia < limiteProximidade;
        
//        System.out.println("Distância até o jogador: " + distancia);
        
        
		if(!colisao((int)x,(int)(y - 14))) {
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
	           
	            g.setColor(Color.YELLOW);
	            g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);

	            g.setColor(Color.BLACK);
	            g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
	            
	            
	    }
	    

}

