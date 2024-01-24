package holyStudio.entidade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import holyStudio.Mundo.Camera;
import holyStudio.Mundo.Mundo;
import holyStudio.main.Game;

public class PortaMadeiraTres extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    private int index = 0;
    private int maxIndex = 2;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 
    
    private int estadoDaRocha = 0;
    
    public String textoPropS;
    
	public static JFrame jframe;
    
	 public static boolean jogadorProximo = false;
	 
	 private String textoProximo = "Pressione Q para entrar";
	 
	 private String textodialogo1 = "";

    private int maskx = 0, masky = 0, maskw = 16, maskh = 16;

    private BufferedImage[] propEstatuaUm;
    
    public String mapacasa;
    
    public PortaMadeiraTres(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
        propEstatuaUm = new BufferedImage[1]; 
        for (int i = 0; i < 1; i++) {
        	propEstatuaUm[i] = Game.sprite.getSprite(704, 144, 32, 48);
        }
    }

    @Override
    public void tick() {
        if (!colisao((int) x, (int) (y - 10))) {
            y += 2;
        }
        
        double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow(Game.player.getY() - this.getY(), 2));
        double limiteProximidade = 70.0;

        jogadorProximo = distancia < limiteProximidade;
        
//      System.out.println("Distância até o jogador: " + distancia);

        frameDelay++;
        
        
			if(jogadorProximo) {
				Game.ui.setTexto(textoProximo);
				if(Game.player.interagindoComPorta == true) {
					System.out.println("inderagiu com a porta numero 3");
					controlePorta();
					Game.player.interagindoComPorta = false;
					
			}
			
		} else {
            Game.ui.setTexto(""); 
        }
        
    }
    public void controlePorta() {
		 
		 if (Game.mapaAtual == Game.mapaContador.mapa07) {
			 	Mundo.esteveVoid = 1;
		 } else {
			 	Game.level++;
				String Level = "casa1.png";
				if(Game.level > Game.levelMaximo) {
					Game.level = 1;
				}	
				 if (Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.mapa03 ||
					 Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa01 ||
					 Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa02 ||
					 Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa03) {
					Level = "casa3.png";
					Game.mapaAtual = Game.mapaContador.casa03;
					Mundo.levelAtual = 1;
					Game.mapaAnterior = Game.mapaContador.mapa06;
					Game.posicaoPlayer = 0;
					Game.player.direcaoAtual = Game.player.direita;
					limpaCenario();
				} 
				
				Mundo.newLevel(Level);
				
				System.out.println(Game.mapaAtual);
				System.out.println(Game.mapaAnterior);
				System.out.println(Game.posicaoPlayer);
		 }
		 
	 }
   
   public void limpaCenario() {
	    Game.bt01.clear();
		Game.bt02.clear();
		Game.bt03.clear();
		Game.bt04.clear();
		Game.casaUm.clear();
		Game.catedral.clear();
		Game.wendigo.clear();
		Game.soldado.clear();
		Game.undead.clear();
		Game.rato.clear();
		Game.dogK.clear();
		Game.BBR.clear();
		Game.fundoCenario.clear();
		Game.propUm.clear();
		Game.corredor.clear();
		Game.ironDoll.clear();
		Game.nun.clear();
		Game.rival.clear();
}

    public void setTexto(String texto){
		this.textoPropS = texto;
	}
    
    public void imagem(Graphics g) {
		g.drawImage(Entidade.aparenciaOutro , 240, 70, jframe);
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
            g.drawImage(propEstatuaUm[0], this.getX() - Camera.x, this.getY() - Camera.y - 44, null);
            
            
        	if (jogadorProximo) {
    			if(Game.player.interagindo) {
    				imagem(g);
    			}
    		}
            
        	if (jogadorProximo && !Game.player.interagindo) {
   			 g.drawImage(Entidade.balaoDeFala, this.getX() - Camera.x + 10, this.getY() - Camera.y - 60, null);
        	}
       
//            g.setColor(Color.LIGHT_GRAY);
//            g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//            g.setColor(Color.BLACK);
//            g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
            
    }
    


}
