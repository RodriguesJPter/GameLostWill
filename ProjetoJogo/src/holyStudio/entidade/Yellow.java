package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Yellow extends Entidade {

	public double life = 50000000, maxLife = 500;
	public double speed = 6.1;
	public int movimentacao = 1;
	public int atacando = 0;
	public int frames = 0, maxFrames = 4, index = 0, maxIndex = 3;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public int direita = 1, esquerda = 0;
	public int direcaoAtual = esquerda;

	boolean jogadorProximo = false;
	
	public boolean jogadorProximoA = false;
	
	boolean jogadorProximoW = false;
	
	public boolean empurrando = false;
	
	public static BlocoBossRoom bbr;
	
	private Timer time;
	
	public BufferedImage[] ataqueUmLeft;
	public BufferedImage[] ataqueDoisLeft;
	public BufferedImage[] ataqueTresLeft;
	public BufferedImage[] andarLeft;
	public BufferedImage[] defesaLeft;
	public BufferedImage[] ataqueUmRight;
	public BufferedImage[] ataqueDoisRight;
	public BufferedImage[] ataqueTresRight;
	public BufferedImage[] andarRight;
	public BufferedImage[] defesaRight;
	
	private int animationTick = 2;
	private double animationSpeed = 0.5;
	
	private int animationTickA = 2;
	private double animationSpeedA = 2.0;
	
	public double getLife (double life) {
		return life;
	}

	public Yellow(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		andarLeft = new BufferedImage[4];
		andarRight = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			andarRight[i] = Game.sprite.getSprite(1088 + (i*96) , 864, 96, 70);
		}

		for(int i = 0; i < 4; i++) {
			andarLeft[i] = Game.sprite.getSprite(1392 - (i*96) , 944, 96, 70);
		}

		

	}
	
	@Override
	public void tick() {
		movimentacao = 0;
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidade = 3000.0;

        jogadorProximo = distancia < limiteProximidade;
        
//        System.out.println("Distância até o jogador: " + distanciaA);
//        System.out.println("boss atacando: " + atacando);
//        System.out.println("boss posicao x: " + x);
        
		if(!colisao((int)x,(int)(y + 2))) {
			y+=2;
		}
		 double diferencaX = Game.player.getX() - this.getX();
			if (jogadorProximo) {
		    	if (atacando == 0) {
		    		if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
			            x = x + speed;
			            movimentacao = 1;
			            direcaoAtual = direita;
			        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
			            x = x - speed;
			            movimentacao = 1;
			            direcaoAtual = esquerda;
			        }
		    	}
		    }

			animationTick++;
		    if (animationTick >= animationSpeed) {
		        animationTick = 0;
		        frames++;
		        if (frames > maxFrames) {
		            frames = 0;
		            index++;
		            if (index > maxIndex) {
		                index = 0;
		            }
		        }
		    }
		    
		  
	}
	
	
	public boolean colisao(int nextx, int nexty) {
		Rectangle inimigo = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (holyStudio.entidade.Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky,maskw,maskh);
				if(inimigo.intersects(solido)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	@Override
	public void render(Graphics g) {
		
		if (direcaoAtual == esquerda && movimentacao == 1 && atacando == 0) {
			g.drawImage(andarLeft[index], this.getX()-Camera.x - 50, this.getY()-Camera.y - 53, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 0 && atacando == 0) {
			g.drawImage(andarLeft[0], this.getX()-Camera.x - 50, this.getY()-Camera.y - 53, null);
		}

		if (direcaoAtual == direita && movimentacao == 1  && atacando == 0) {
			g.drawImage(andarRight[index], this.getX()-Camera.x - 40, this.getY()-Camera.y - 53, null);
		}
		
		if (direcaoAtual == direita && movimentacao == 0 && atacando == 0) {
			g.drawImage(andarRight[0], this.getX()-Camera.x - 40 , this.getY()-Camera.y - 53, null);
		}
		
//		  g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//        g.setColor(Color.BLACK);
//        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
        
		
	}

}
