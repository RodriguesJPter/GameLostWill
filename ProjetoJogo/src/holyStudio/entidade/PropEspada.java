package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class PropEspada extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    private int index = 0;
    private int maxIndex = 2;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 
    
    private int estadoDaRocha = 0;
    
    public String textoPropS;
    
	 public static boolean jogadorProximo = false;
	 
	 private String textoProximo = "Pressione Q para interagir";
	 
	 private String textodialogo1 = "";

    private int maskx = 0, masky = 0, maskw = 16, maskh = 16;

    private BufferedImage[] propEspada;
    private BufferedImage[] propEspadaVazia;

    public PropEspada(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
        propEspada = new BufferedImage[1]; 
        propEspadaVazia = new BufferedImage[1]; 
        for (int i = 0; i < 1; i++) {
            propEspada[i] = Game.sprite.getSprite(432, 310, 64, 42);
        }
        for (int i = 0; i < 1; i++) {
            propEspadaVazia[i] = Game.sprite.getSprite(432, 262, 64, 42);
        }
    }

    @Override
    public void tick() {
        if (!colisao((int) x, (int) (y + 25))) {
            y += 2;
        }
        
        double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow(Game.player.getY() - this.getY(), 2));
        double limiteProximidade = 50.0;

        jogadorProximo = distancia < limiteProximidade;

        frameDelay++;
        
        if (jogadorProximo) {
        	if(Game.player.interagindo) {
        		Game.ui.setTexto(textodialogo1); 
        		estadoDaRocha += 1;
        		espadacoletada();
        		Game.player.interagindo = false;
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
    
    public void espadacoletada() {
    	if (estadoDaRocha == 1) {
    		Game.inventario.sword += 1;
    		Game.dialogo.notificacao = "+1 Espada";
    		
    		Game.dialogo.frasco = false;
    		Game.dialogo.espada = true;
    		Game.dialogo.chave = false;
    	}
    }

    @Override
    public void render(Graphics g) {
    	
    	if (jogadorProximo && !Game.player.interagindo && estadoDaRocha == 0) {
			 g.drawImage(Entidade.balaoDeFala, this.getX() - Camera.x + 10, this.getY() - Camera.y - 40, null);
		}
        if (estadoDaRocha == 0) {
            g.drawImage(propEspada[0], this.getX() - Camera.x - 15, this.getY() - Camera.y - 25, null);
        } else {
            g.drawImage(propEspadaVazia[0], this.getX() - Camera.x - 15, this.getY() - Camera.y - 25, null);
        }
    }

}
