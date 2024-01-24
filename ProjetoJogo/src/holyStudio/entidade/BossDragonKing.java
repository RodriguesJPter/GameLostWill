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

public class BossDragonKing extends Entidade {

	public double life = 500, maxLife = 500;
	public double speed = 0.5;
	public int movimentacao = 1;
	public int atacando = 0;
	public int frames = 0, maxFrames = 7, index = 0, maxIndex = 5;
	public int framesA = 0, maxFramesA = 4, indexA = 0, maxIndexA = 4;

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
	
	double limiteProximidadeW = 20.0;
	
	public int valorWill = 150;
	
	private boolean interromperAnimacaoAtaque = false;
	
	public int acaoUm = 0;
	public int acaoDois = 1;
	public int acaoTres = 0;
	
	public double getLife (double life) {
		return life;
	}

	public BossDragonKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		ataqueUmLeft = new BufferedImage[7];
		ataqueDoisLeft = new BufferedImage[5];
		ataqueTresLeft = new BufferedImage[5];
		andarLeft = new BufferedImage[6];
		defesaLeft = new BufferedImage[5];
		ataqueUmRight = new BufferedImage[7];
		ataqueDoisRight = new BufferedImage[5];
		ataqueTresRight = new BufferedImage[5];
		andarRight = new BufferedImage[6];
		defesaRight = new BufferedImage[5];
		
		for(int i = 0; i < 7; i++) {
			ataqueUmLeft[i] = Game.sprite.getSprite(1851 + (i*91) , 53, 91, 81);
		}

		for(int i = 0; i < 5; i++) {
			ataqueDoisLeft[i] = Game.sprite.getSprite(1850 + (i*84) , 143, 85, 80);
		}
		
		for(int i = 0; i < 5; i++) {
			ataqueTresLeft[i] = Game.sprite.getSprite(1838 + (i*72) , 419, 73, 77);
		}
		
		for(int i = 0; i < 6; i++) {
			andarLeft[i] = Game.sprite.getSprite(1851 + (i*61) , 231, 62, 82);
		}

		for(int i = 0; i < 5; i++) {
			defesaLeft[i] = Game.sprite.getSprite(1851, 322, 62, 82);
		}
		
		for(int i = 0; i < 6; i++) {
			ataqueUmRight[i] = Game.sprite.getSprite(2857 - (i*91) , 53, 91, 81);
		}

		for(int i = 0; i < 5; i++) {
			ataqueDoisRight[i] = Game.sprite.getSprite(2862 - (i*84) , 143, 85, 80);
		}
		for(int i = 0; i < 5; i++) {
			ataqueTresRight[i] = Game.sprite.getSprite(2864 - (i*72) , 416, 73, 77);
		}
		
		for(int i = 0; i < 6; i++) {
			andarRight[i] = Game.sprite.getSprite(2889 - (i*61) , 231, 62, 82);
		}

		for(int i = 0; i < 4; i++) {
			defesaRight[i] = Game.sprite.getSprite(2857, 322, 62, 82);
		}

	}
	
	@Override
	public void tick() {
		movimentacao = 0;
		
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidade = 300.0;

        jogadorProximo = distancia < limiteProximidade;
        
        double distanciaA = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidadeA = 40.0;

        jogadorProximoA = distanciaA < limiteProximidadeA;
        
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
				    movimentacao = 2;
				    direcaoAtual = direita;
				    
				    if (indexA >= maxIndexA) {
				        interromperAnimacaoAtaque = true;
				        jogadorProximoA = false;
				        indexA = 0;
				        empurrao();
//				        Game.player.life -= 15;
				    }
		        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
		        	    atacando = 1;
					    movimentacao = 2;
					    direcaoAtual = esquerda;
					    
					    if (indexA >= maxIndexA) {
					        interromperAnimacaoAtaque = true;
					        jogadorProximoA = false;
					        indexA = 0;
					        empurrao();
//					        Game.player.life -= 15;
					    }
		        }
		 } else {
			 atacando = 0;
			 jogadorProximoA = true;
			 
		 }

			if (interromperAnimacaoAtaque) {
			    indexA = 0;
			    interromperAnimacaoAtaque = false;
//			    System.out.println("boss - animacao reiniciada");
			    trocaDeMovimento();
			}
			
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
	}
	
	public void lifeBar(Graphics g) {
		int inventarioXB = 45; 
        int inventarioYB = 205;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
		
		g.setColor(Color.black);
		g.fillRect(inventarioXB, inventarioYB, 202, 7);

		g.setColor(Color.red);
		g.fillRect(inventarioX, inventarioY, 200, 5);

		g.setColor(Color.green);
		g.fillRect(inventarioX, inventarioY, (int) ((life /maxLife) * 300), 5);
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
	
	
	 public void trocaDeMovimento() {
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(10) + 1;

	        if (numeroAleatorio == 1 || numeroAleatorio == 3 ||
	        		numeroAleatorio == 5 || numeroAleatorio == 7 || 
	        		numeroAleatorio == 9) {
	        	acaoUm = 1;
	        	acaoDois = 0;
	        	acaoTres = 0;
	            animationTickA = 3;
	        	animationSpeedA = 3.0;
	        	if (jogadorProximoA) {
	        		empurrando = true;
	        	}
	            System.out.println(numeroAleatorio + "boss - acao Um feita");
	        } else if (numeroAleatorio == 2 || numeroAleatorio == 4) {
	        	acaoUm = 0;
	        	acaoDois = 1;
	        	acaoTres = 0;
	        	animationTickA = 2;
	        	animationSpeedA = 2.0;
	        	empurrando = false;
	        	 System.out.println(numeroAleatorio + "boss - acao Dois feita");
	        } else if (numeroAleatorio == 6 || numeroAleatorio == 8 || 
	        		numeroAleatorio == 10) {
	        	acaoUm = 0;
	        	acaoDois = 0;
	        	acaoTres = 1;
	        	animationTickA = 2;
	        	animationSpeedA = 2.0;
	        	empurrando = false;
	        	System.out.println(numeroAleatorio + "boss - acao Tres feita");
	        } else {
	        	atacando = 0;
	        }
	    }
	 
		public void empurrao() {
			time = new Timer();
		    time.scheduleAtFixedRate( new EmpurraPlayer(), 0, 500);
		}
		
		private class EmpurraPlayer extends TimerTask {
				@Override
				public void run() {
					
				if (empurrando == true) {
					if (acaoUm == 1) {
			        	if (direcaoAtual == esquerda) {
							Game.player.x -= 30;
						}
						if (direcaoAtual == direita) {
							Game.player.x += 30;
						}
			        }
					
					
				}
			}
			
		}

	@Override
	public void render(Graphics g) {
		
		if (direcaoAtual == esquerda && movimentacao == 1 && atacando == 0) {
			g.drawImage(andarLeft[index], this.getX()-Camera.x - 25, this.getY()-Camera.y - 66, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoUm == 1) {
			g.drawImage(ataqueUmLeft[indexA], this.getX()-Camera.x - 55, this.getY()-Camera.y - 65, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoDois == 1) {
			g.drawImage(ataqueDoisLeft[indexA], this.getX()-Camera.x - 55, this.getY()-Camera.y - 63, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1 && acaoTres == 1) {
			g.drawImage(ataqueTresLeft[indexA], this.getX()-Camera.x - 45, this.getY()-Camera.y - 60, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 0 && atacando == 0) {
			g.drawImage(andarLeft[0], this.getX()-Camera.x - 15, this.getY()-Camera.y - 66, null);
		}

		if (direcaoAtual == direita && movimentacao == 1  && atacando == 0) {
			g.drawImage(andarRight[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 66, null);
		}
		
		if (direcaoAtual == direita && atacando == 1 && acaoUm == 1) {
			g.drawImage(ataqueUmRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 65, null);
		}
		
		if (direcaoAtual == direita && atacando == 1  && acaoDois == 1) {
			g.drawImage(ataqueDoisRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 63, null);
		}
		
		if (direcaoAtual == direita && atacando == 1  && acaoTres == 1) {
			g.drawImage(ataqueTresRight[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 60, null);
		}

		if (direcaoAtual == direita && movimentacao == 0 && atacando == 0) {
			g.drawImage(andarRight[0], this.getX()-Camera.x - 15 , this.getY()-Camera.y - 66, null);
		}
		
//		  g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//        g.setColor(Color.BLACK);
//        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
        
		if (jogadorProximo) {
			lifeBar(g);
		}
	}

}
