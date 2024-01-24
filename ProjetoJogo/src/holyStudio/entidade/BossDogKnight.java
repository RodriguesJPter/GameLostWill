package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class BossDogKnight extends Entidade implements Serializable {

	public double life = 500, maxLife = 500;
	public double speed = 1.0;
	public int movimentacao = 1;
	public int atacando = 0;
	public int frames = 0, maxFrames = 5, index = 0, maxIndex = 4;
	public int framesA = 0, maxFramesA = 6, indexA = 0, maxIndexA = 5;
	public int framesE = 0, maxFramesE = 6, indexE = 0, maxIndexE = 5;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public int direita = 1, esquerda = 0;
	public int direcaoAtual = esquerda;

	boolean jogadorProximo = false;
	
	public boolean jogadorProximoA = false;
	
	public boolean jogadorProximoD = false;
	
	public boolean efeitoOn = false;
	
	public boolean paradao = false;
	
	public boolean acaoDeAtaque = false;
	
	boolean jogadorProximoW = false;
	
	public boolean empurrando = false;
	
	boolean isRemovido; 
	
	public static BlocoBossRoom bbr;
	
	private Timer time;
	
	public BufferedImage[] ataqueUmLeft;
	public BufferedImage[] ataqueDoisLeft;
	public BufferedImage[] ataqueTresLeft;
	public BufferedImage[] andarLeft;
	public BufferedImage[] ataqueUmRight;
	public BufferedImage[] ataqueDoisRight;
	public BufferedImage[] ataqueTresRight;
	public BufferedImage[] andarRight;
	public BufferedImage[] paradoLeft;
	public BufferedImage[] paradoRight;
	private BufferedImage[] efeito;
	
	private int animationTick = 2;
	private double animationSpeed = 0.5;
	
	private int animationTickA = 2;
	private double animationSpeedA = 2.0;
	
	double limiteProximidadeW = 20.0;
	
	public int valorWill = 150;
	
	private boolean interromperAnimacaoAtaque = false;
	
	public int acaoUm = 0;
	public int acaoDois = 0;
	public int acaoTres = 0;
	private boolean tempoPraRespirar = false;
	
	public double getLife (double life) {
		return life;
	}

	public BossDogKnight(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		ataqueUmLeft = new BufferedImage[6];
		ataqueDoisLeft = new BufferedImage[6];
		ataqueTresLeft = new BufferedImage[6];
		andarLeft = new BufferedImage[5];
		ataqueUmRight = new BufferedImage[6];
		ataqueDoisRight = new BufferedImage[6];
		ataqueTresRight = new BufferedImage[6];
		andarRight = new BufferedImage[5];
		paradoLeft = new BufferedImage[5];
		paradoRight = new BufferedImage[5];
		efeito = new BufferedImage[6]; 
		
		for(int i = 0; i < 6; i++) {
			ataqueUmLeft[i] = Game.sprite.getSprite(1647 + (i*113) , 92, 113, 73);
		}

		for(int i = 0; i < 6; i++) {
			ataqueDoisLeft[i] = Game.sprite.getSprite(1688 + (i*97) , 240, 96, 81);
		}
		
		for(int i = 0; i < 6; i++) {
			ataqueTresLeft[i] = Game.sprite.getSprite(1731 + (i*87) , 165, 87, 75);
		}
		
		for(int i = 0; i < 5; i++) {
			andarLeft[i] = Game.sprite.getSprite(1787 + (i*56) , 16, 56, 76);
		}

		for(int i = 0; i < 6; i++) {
			ataqueUmRight[i] = Game.sprite.getSprite(2856 - (i*113) , 170, 113, 73);
		}

		for(int i = 0; i < 6; i++) {
			ataqueDoisRight[i] = Game.sprite.getSprite(2832 - (i*97) , 318, 96, 81);
		}
		
		for(int i = 0; i < 6; i++) {
			ataqueTresRight[i] = Game.sprite.getSprite(2798 - (i*87) , 243, 87, 75);
		}
		
		for(int i = 0; i < 5; i++) {
			andarRight[i] = Game.sprite.getSprite(2773 - (i*56) , 94, 56, 76);
		}
		for(int i = 0; i < 5; i++) {
			paradoLeft[i] = Game.sprite.getSprite(1776 + (i*64) , 336, 64, 80);
		}
		for(int i = 0; i < 5; i++) {
			paradoRight[i] = Game.sprite.getSprite(2784 - (i*64) , 416, 64, 80);
		}
	
        for (int i = 0; i < 6; i++) {
            efeito[i] = Game.sprite.getSprite(1120 + (i * 32), 160, 32, 80);
        }
	}
	
	@Override
	public void tick() {
		movimentacao = 0;
		
		if (jogadorProximoD == false) {
			tempoPraRespirar= false;
		}
		
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidade = 300.0;

        jogadorProximo = distancia < limiteProximidade;
        
        double distanciaA = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidadeA = 40.0;

        jogadorProximoA = distanciaA < limiteProximidadeA;
        
        double distanciaD = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidadeD = 30.0;

        jogadorProximoD = distanciaD < limiteProximidadeD;
        
        double distanciaW = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        if (direcaoAtual == esquerda) {
        	 limiteProximidadeW = 29.0;
        } else {
        	 limiteProximidadeW = 29.0;
        }
        

        jogadorProximoW = distanciaW < limiteProximidadeW;
        
//        System.out.println("Distância até o jogador: " + distanciaA);
//        System.out.println("boss atacando: " + atacando);
//        System.out.println("boss posicao x: " + x);
        
		if(!colisao((int)x,(int)(y + 2))) {
			y+=2;
		}
		 double diferencaX = Game.player.getX() - this.getX();
		 
		if (Game.mundo.eventoBossMorto == 1) {
			Game.BBR.remove(bbr);
		}
		 
		 if (jogadorProximoW) { 
			 
			 if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
				    atacando = 1;
				    movimentacao = 0;
				    direcaoAtual = direita;
				    
				    if (indexA >= maxIndexA) {
				        interromperAnimacaoAtaque = true;
				        jogadorProximoA = false;
				        indexA = 0;
				        empurrando = true;
				        concequenciaAtaque();
				        if (acaoUm == 1) {
				        	 Game.player.life -= 15;
				        } else if (acaoDois == 1) {
				        	 Game.player.life -= 30;
				        } else if (acaoTres == 1) {
				        	 Game.player.life -= 20;
				        }
				    }
		        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
		        	    atacando = 1;
					    movimentacao = 0;
					    direcaoAtual = esquerda;
					    
					    if (indexA >= maxIndexA) {
					        interromperAnimacaoAtaque = true;
					        jogadorProximoA = false;
					        indexA = 0;
					        empurrando = true;
					        concequenciaAtaque();
					        if (acaoUm == 1) {
					        	 Game.player.life -= 15;
					        } else if (acaoDois == 1) {
					        	 Game.player.life -= 30;
					        } else if (acaoTres == 1) {
					        	 Game.player.life -= 20;
					        }
					    }
		        }
		 } else {
			 atacando = 0;
			 empurrando = false;
			 
		 }

			if (interromperAnimacaoAtaque) {
			    indexA = 0;
			    interromperAnimacaoAtaque = false;
//			    System.out.println("boss - animacao reiniciada");
			    	trocaDeMovimento();
			}
			
			if (jogadorProximo) {
				if (tempoPraRespirar == true) {
					 if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
				            x = x + speed;
				            movimentacao = 1;
				            direcaoAtual = direita;
				        } else if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
				            x = x - speed;
				            movimentacao = 1;
				            direcaoAtual = esquerda;
				        }
				 } else if (tempoPraRespirar == false) {
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
		    
		    animationTickA++;
		    if (animationTickA >= animationSpeedA) {
		        animationTickA = 0;
		        framesE++;
		        if (framesE > maxFramesE) {
		            framesE = 0;
		            indexE++;
		            if (indexE > maxIndexE) {
		                indexE = 0;
		            }
		        }
		    }
	}
	
	public void lifeBar(Graphics g) {
		int inventarioXB = 45; 
        int inventarioYB = 205;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
		
		g.setColor(Color.YELLOW);
		g.fillRect(inventarioXB, inventarioYB, 302, 7);

		g.setColor(Color.red);
		g.fillRect(inventarioX, inventarioY, 300, 5);

		g.setColor(Color.green);
		g.fillRect(inventarioX, inventarioY, (int) ((life/maxLife) * 300), 5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Mathew, The Last Dog Knight", inventarioXB, inventarioYB);
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
	
	public void concequenciaAtaque() {
		
		if (acaoUm == 1) {
			if (direcaoAtual == esquerda && empurrando == true) {
	    		Game.player.x -= 15; 
	       	} else if (direcaoAtual == direita && empurrando == true) {
	       		Game.player.x += 15; 
	       	}
		}
	}

	
	
	 public void trocaDeMovimento() {
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(9) + 1;

	        if (numeroAleatorio == 1 || numeroAleatorio == 6 ) {
	        	movimentacao = 0;
	        	acaoUm = 1;
	        	acaoDois = 0;
	        	acaoTres = 0;
	            animationTickA = 3;
	        	animationSpeedA = 1.0;
	        	paradao = false;
	        	tempoPraRespirar = false;
	            System.out.println(numeroAleatorio + "boss - acao Um feita");
	        } else if (numeroAleatorio == 3) {
	        	movimentacao = 0;
	        	acaoUm = 0;
	        	acaoDois = 1;
	        	acaoTres = 0;
	        	animationTickA = 2;
	        	animationSpeedA = 1.0;
	        	paradao = false;
	        	tempoPraRespirar = false;
	        	System.out.println(numeroAleatorio + "boss - acao Dois feita");
	        } else if (numeroAleatorio == 5 ) {
	        	movimentacao = 0;
	        	acaoUm = 0;
	        	acaoDois = 0;
	        	acaoTres = 1;
	        	animationTickA = 2;
	        	animationSpeedA = 1.0;
	        	paradao = false;
	        	tempoPraRespirar = false;
	        	System.out.println(numeroAleatorio + "boss - acao Tres feita");
	        } else if (numeroAleatorio == 4 || numeroAleatorio == 2 ||
	        		numeroAleatorio == 8 || numeroAleatorio == 10 ||
	        		numeroAleatorio == 7 || numeroAleatorio == 9) {
	        	acaoUm = 0;
	        	acaoDois = 0;
	        	acaoTres = 0;
	        	paradao = true;
	        	tempoPraRespirar = false;
	        } 
	        
	        System.out.println("diagnostico do numero Aleatorio " + numeroAleatorio );
	    }
	 
	@Override
	
	public void render(Graphics g) {
	
		    g.setColor(Color.LIGHT_GRAY);
	        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);

	        g.setColor(Color.BLACK);
	        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
		
		if (direcaoAtual == esquerda && movimentacao == 1 && atacando == 0) {
			g.drawImage(andarLeft[index], this.getX()-Camera.x - 25, this.getY()-Camera.y - 60, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoUm == 1) {
			g.drawImage(ataqueUmLeft[indexA], this.getX()-Camera.x - 80, this.getY()-Camera.y - 57, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoDois == 1) {
			g.drawImage(ataqueDoisLeft[indexA], this.getX()-Camera.x - 55, this.getY()-Camera.y - 65, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoTres == 1) {
			g.drawImage(ataqueTresLeft[indexA], this.getX()-Camera.x - 58, this.getY()-Camera.y - 58, null);
		}

		if (direcaoAtual == direita && movimentacao == 1  && atacando == 0) {
			g.drawImage(andarRight[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 60, null);
		}
		
		if (direcaoAtual == direita && atacando == 1 && acaoUm == 1) {
			g.drawImage(ataqueUmRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 57, null);
		}
		
		if (direcaoAtual == direita && atacando == 1  && acaoDois == 1) {
			g.drawImage(ataqueDoisRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 65, null);
		}
		
		if (direcaoAtual == direita && atacando == 1  && acaoTres == 1) {
			g.drawImage(ataqueTresRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 58, null);
		}

		if (direcaoAtual == direita && movimentacao == 0 && paradao == true && acaoUm == 0 ||
			direcaoAtual == direita && movimentacao == 0 && paradao == true && acaoDois == 0 || 
			direcaoAtual == direita && movimentacao == 0 && paradao == true && acaoTres == 0) {
			g.drawImage(paradoRight[index], this.getX()-Camera.x - 15 , this.getY()-Camera.y - 63, null);
		}
		
		if (direcaoAtual == esquerda && movimentacao == 0 && paradao == true && acaoUm == 0 ||
			direcaoAtual == esquerda && movimentacao == 0 && paradao == true && acaoDois == 0 || 
			direcaoAtual == esquerda && movimentacao == 0 && paradao == true && acaoTres == 0) {
			g.drawImage(paradoLeft[index], this.getX()-Camera.x - 25 , this.getY()-Camera.y - 63, null);
		}
		
		if (acaoDois == 1) {
    		g.drawImage(efeito[indexE], Game.player.getX() - Camera.x - 5, Game.player.getY() - Camera.y - 60, null);
    	}
		
        
		if (jogadorProximo) {
			lifeBar(g);
		}
	}

}
