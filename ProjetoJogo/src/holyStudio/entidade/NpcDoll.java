package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import holyStudio.Mundo.Camera;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.Player;
import holyStudio.entidade.Solido;
import holyStudio.main.Game;

public class NpcDoll extends Entidade {
	
	boolean jogadorProximo = false;
	
	private boolean dialogoAutomatico = true;
	
	private double jogadorProxi = 1;
	
	public BufferedImage[] npcRightP;
	public BufferedImage[] npcLeftP;
	
	public String textoOutro;
	
	public boolean acao;
	
	public Player player;
	
	private Timer timer;
	private boolean alternarTexto = false;
	private String[] frases = {
		"..."
	};

	private int indiceAtual = 0;

	
	private String textoProximo = "Pressione Q para falar";
	
	private String textodialogo1 = "";
	
	public int direita = 1, esquerda = 0;
	
	public int movimentacao = 0;
	
	public int direcaoAtual = direita;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 20;
	
	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() {
		return (int)this.x;
	}

	public int getY() {
		return (int)this.y;
	}
 
	public NpcDoll(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		 iniciarTrocaTexto();
		
		npcRightP = new BufferedImage[5];
		npcLeftP = new BufferedImage[5];
		
		for(int i = 0; i < 5; i++) {
			npcRightP[i] = Game.sprite.getSprite(80, 336, 17, 54);
		}

		for(int i = 0; i < 5; i++) {
			npcLeftP[i] = Game.sprite.getSprite(112, 336, 17, 54);
		}

	}
	@Override
	public void tick() {
		if(!colisao((int)x,(int)(y+35))) {
			y+=2;
		}
		
		if(Game.player.getX() > this.getX()){
			direcaoAtual = esquerda;
		} else if (Game.player.getX() < this.getX()) {
			direcaoAtual = direita;
		}
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow(Game.player.getY() - this.getY(), 2));
        double limiteProximidade = 50.0;

        jogadorProximo = distancia < limiteProximidade;
        
        //System.out.println("Distância até o jogador: " + distancia);
        
        if (jogadorProximo) {
        	if(Game.player.interagindo) {
        		Game.ui.setTexto(textodialogo1); 
        	} else {
        		Game.ui.setTexto(textoProximo);
        	}
    	} else {
            Game.ui.setTexto(""); 
        }
        
	}
	
	public void iniciarTrocaTexto() {
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TrocaTextoTask(), 0, 2500); 
	}

	// ... (outros membros da classe)

	private boolean dialogoReiniciado = false;

	private class TrocaTextoTask extends TimerTask {
	    @Override
	    public void run() {
	        if (dialogoAutomatico) {
	            if (indiceAtual < frases.length) {
	                textodialogo1 = frases[indiceAtual];
	                alternarTexto = !alternarTexto;
	                indiceAtual++;
	            } else {
	                // Se atingir o final da lista de frases, defina o texto como textoProximo
	                Game.ui.setTexto(textoProximo);
	                dialogoReiniciado = true; // Indica que o diálogo foi reiniciado
	                dialogoAutomatico = false; // Desative o modo automático
	            }
	        }
	    }
	}

	public void iniciarTrocaTexto1() {
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TrocaTextoTask(), 0, 2500);
	}

	public void reiniciarDialogo() {
	    if (dialogoReiniciado) {
	        indiceAtual = 0;
	        dialogoReiniciado = false;
	        dialogoAutomatico = true; // Ative o modo automático novamente
	        iniciarTrocaTexto(); // Inicie o timer novamente
	    }
	}

	// ... (outros membros da classe)





	
	public void setTexto(String texto){
		this.textoOutro = texto;
	}
	
	public void setTextoDialogo1(String textoDialogo1){
		this.textodialogo1 = textoDialogo1;
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
	    if (direcaoAtual == direita && movimentacao == 0) {
	        g.drawImage(npcRightP[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
	    }

	    if (direcaoAtual == esquerda && movimentacao == 0) {
	        g.drawImage(npcLeftP[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
	    }
	    
	    if (jogadorProximo) {
	        g.setColor(Color.WHITE);
	        g.setFont(new Font("Arial", Font.PLAIN, 10));
	        
	        char letra = 'A';
	        
	        int letraX = this.getX() + (this.getWidth() / 2) - 5;
	        int letraY = this.getY() - 10;
	        
	        g.drawString(String.valueOf(letra), letraX, letraY);
	    }
	}


}

