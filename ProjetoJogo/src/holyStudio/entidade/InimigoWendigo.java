package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.entidade.Solido;
import holyStudio.main.Game;

public class InimigoWendigo extends Entidade {

	public double life = 150, maxLife = 150;
	public double speed = 0.5;
	public int movimentacao = 1;
	public int atacando = 0;
	public int frames = 0, maxFrames = 7, index = 0, maxIndex = 6;
	public int framesA = 0, maxFramesA = 4, indexA = 0, maxIndexA = 3;
	public int framesP = 0, maxFramesP = 4, indexP = 0, maxIndexP = 3;
	private int animationTickA = 0;
	private double animationSpeedA = 0.2;
	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public int direita = 1, esquerda = 0;
	public int direcaoAtual = esquerda;

	boolean jogadorProximo = false;
	
	boolean jogadorProximoR = false;
	
	boolean jogadorProximoRe = false;
	
	public boolean jogadorProximoA = false;
	
	boolean jogadorProximoW = false;
	
	boolean isRemovido; 
	
	public BufferedImage[] inimigoSLeft;
	public BufferedImage[] inimigoSRight;
	public BufferedImage[] inimigoWLeft;
	public BufferedImage[] inimigoWRight;
	public BufferedImage[] inimigoWLeftP;
	public BufferedImage[] inimigoWRightP;
	
	private int animationTick = 0;
	private double animationSpeed = 1;
	
	private int animationTickP = 0;
	private double animationSpeedP = 3;
	
	double limiteProximidadeW = 20.0;
	
	public int valorWill = 75;
	
	public double getLife (double life) {
		return life;
	}

	public InimigoWendigo(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		
		inimigoSLeft = new BufferedImage[7];
		inimigoSRight = new BufferedImage[7];
		inimigoWLeft = new BufferedImage[4];
		inimigoWRight = new BufferedImage[4];
		inimigoWLeftP = new BufferedImage[4];
		inimigoWRightP = new BufferedImage[4];
		
		for(int i = 0; i < 7; i++) {
			inimigoSRight[i] = Game.sprite.getSprite(10 + (i*59) , 1024, 59, 145);
		}

		for(int i = 0; i < 7; i++) {
			inimigoSLeft[i] = Game.sprite.getSprite(361 - (i*59) , 1184, 59, 145);
		}
		
		for(int i = 0; i < 4; i++) {
			inimigoWLeft[i] = Game.sprite.getSprite(15 + (i*108) , 1730, 108, 142);
		}

		for(int i = 0; i < 4; i++) {
			inimigoWRight[i] = Game.sprite.getSprite(882 - (i*108) , 1728, 108, 145);
		}
		for(int i = 0; i < 4; i++) {
			inimigoWLeftP[i] = Game.sprite.getSprite(464 + (i*64) , 1184, 64, 144);
		}

		for(int i = 0; i < 4; i++) {
			inimigoWRightP[i] = Game.sprite.getSprite(656 - (i*64) , 1024, 64, 144);
		}

	}
	
	@Override
	public void tick() {
		movimentacao = 0;
		
		double distanciaRe = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
	    double limiteProximidadeRe = 280.0;

	    jogadorProximoRe = distanciaRe < limiteProximidadeRe;
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidade = 100.0;

        jogadorProximo = distancia < limiteProximidade;
        
        double distanciaR = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidadeR = 230.0;

        jogadorProximoR = distanciaR < limiteProximidadeR;
        
        double distanciaA = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidadeA = 22.0;

        jogadorProximoA = distanciaA < limiteProximidadeA;
        
        double distanciaW = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        if (direcaoAtual == esquerda) {
        	 limiteProximidadeW = 20.0;
        } else {
        	 limiteProximidadeW = 20.0;
        }
        

        jogadorProximoW = distanciaW < limiteProximidadeW;
        
        //System.out.println("Distância até o jogador: " + distanciaA);
        
		if(!colisao((int)x,(int)(y + 2))) {
			y+=2;
		}
		 double diferencaX = Game.player.getX() - this.getX();
		 
		 
		 
		 if (jogadorProximoW) {
			 if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
		            direcaoAtual = direita;
		            atacando = 1;
		            movimentacao = 2;
		        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
		            direcaoAtual = esquerda;
		            atacando = 1;
		            movimentacao = 2;
		        }
		 } else {
			 atacando = 0;
		 }

		    if (jogadorProximo) {
		    	if(atacando == 0) {
		    		if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
			            x += speed;
			            movimentacao = 1;
			            direcaoAtual = direita;
			        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
			            x -= speed;
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
		    
		    animationTickA++;
		    if (animationTickA >= animationSpeedA) {
		        animationTickA = 0;
		        framesA++;
		        if (framesA > maxFramesA) {
		            framesA = 0;
		            indexA++;
		            if (indexA > maxIndexA) {
		                indexA = 0;
		            }
		        }
		    }
		    
		    if (jogadorProximoRe) {
			    if (movimentacao == 0) {
		    	  animationTickP++;
				    if (animationTickP >= animationSpeedP) {
				        animationTickP = 0;
				        framesP++;
				        if (framesP > maxFramesP) {
				            framesP = 0;
				            indexP++;
				            if (indexP > maxIndexP) {
				                indexP = 0;
				            }
				        }
				    }
		    }
		    }

		  
	}
	
	public void lifeBar(Graphics g) {
		int inventarioXB = this.getX()-Camera.x - 15; 
        int inventarioYB = this.getY()-Camera.y - 135;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
        
		g.setColor(Color.black);
		g.fillRect(inventarioXB, inventarioYB, 52, 4);

		g.setColor(Color.red);
		g.fillRect(inventarioX, inventarioY, 50, 2);

		g.setColor(Color.green);
		g.fillRect(inventarioX, inventarioY, (int) ((life /maxLife) * 50), 2);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawString("Wendigo", inventarioXB, inventarioYB);
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

	public void animations(Graphics g) {
		if (direcaoAtual == esquerda && movimentacao == 1) {
			g.drawImage(inimigoSRight[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 126, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1) {
			g.drawImage(inimigoWRight[indexA], this.getX()-Camera.x - 55, this.getY()-Camera.y - 126, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 0) {
			g.drawImage(inimigoWRightP[indexP], this.getX()-Camera.x - 15, this.getY()-Camera.y - 126, null);
		}

		if (direcaoAtual == direita && movimentacao == 1) {
			g.drawImage(inimigoSLeft[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 126, null);
		}
		
		if (direcaoAtual == direita && atacando == 1) {
			g.drawImage(inimigoWLeft[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 126, null);
		}

		if (direcaoAtual == direita && movimentacao == 0) {
			g.drawImage(inimigoWLeftP[indexP], this.getX()-Camera.x - 15 , this.getY()-Camera.y - 126, null);
		}
	}
	
	
	@Override
	public void render(Graphics g) {
		
		

		if (jogadorProximo) {
			lifeBar(g);
		}
		
		if (jogadorProximoRe) {
			animations(g);
		}
		
		
//		g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//        g.setColor(Color.BLACK);
//        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
	}

}
