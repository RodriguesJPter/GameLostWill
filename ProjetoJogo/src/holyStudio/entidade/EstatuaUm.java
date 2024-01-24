package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class EstatuaUm extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    private int index = 0;
    private int maxIndex = 2;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 
    
    private int estadoDaRocha = 0;
    
    public String textoPropS;
    
	 public boolean jogadorProximo = false;
	 
	 private String textoProximo = "Pressione Q para interagir";
	 
	 private String textodialogo1 = "";

    private int maskx = 0, masky = 0, maskw = 16, maskh = 16;

    private BufferedImage[] propEstatuaUm;
    
    private BufferedImage[] propEstatuaDois;

    public EstatuaUm(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
        propEstatuaUm = new BufferedImage[1];
        propEstatuaDois = new BufferedImage[1];
        
        
        for (int i = 0; i < 1; i++) {
        	propEstatuaUm[i] = Game.sprite.getSprite(768, 473, 68, 104);
        }
        
        for (int i = 0; i < 1; i++) {
        	propEstatuaDois[i] = Game.sprite.getSprite(865, 464, 64, 112);
        }
        
    }

    @Override
    public void tick() {
        if (!colisao((int) x, (int) (y + 2))) {
            y += 2;
        }
        
        double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow(Game.player.getY() - this.getY(), 2));
        double limiteProximidade = 70.0;

        jogadorProximo = distancia < limiteProximidade;

        frameDelay++;
        
        if (jogadorProximo) {
        	if(Game.player.interagindo) {
        		Game.player.life = 100;
        		Game.ui.setTexto(textodialogo1); 
        		
        	} else {
        		Game.ui.setTexto(textoProximo);
        	}
    	} else {
            Game.ui.setTexto(""); 
        }

    }

    public void setTexto(String texto){
		this.textoPropS = texto;
	}
    
    public boolean colisao(int nextx, int nexty) {
        Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
        for (Entidade entidade : Game.entidade) {
            if (entidade instanceof Solido) {
                Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
                if (player.intersects(solido)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    

    @Override
    public void render(Graphics g) {
    	
    	if (Game.mapaAtual == Game.mapaContador.mapa00) {
    		  g.drawImage(propEstatuaUm[0], this.getX() - Camera.x, this.getY() - Camera.y - 85, null);
    	} else if (Game.mapaAtual == Game.mapaContador.mapa03) {
    		  g.drawImage(propEstatuaDois[0], this.getX() - Camera.x, this.getY() - Camera.y - 92, null);
    	}
          
            
//            if(Game.player.interagindo) {
//    			if(jogadorProximo) {
//    				Game.ui.levelUp(g);
//    			}
//    		 } else {
//    			 
//    		 }
       
    }

}
