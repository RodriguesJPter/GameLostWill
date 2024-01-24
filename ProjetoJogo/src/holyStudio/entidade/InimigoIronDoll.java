package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class InimigoIronDoll extends Entidade {

	public double life = 100, maxLife = 100;
	public double speed = 0.8;
	public int movimentacao = 1;
	public int atacando = 0;
	public int frames = 0, maxFrames = 5, index = 0, maxIndex = 4;
	public int framesP = 0, maxFramesP = 5, indexP = 0, maxIndexP = 4;
	public int framesA = 0, maxFramesA = 6, indexA = 0, maxIndexA = 5;
	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;

	public int direita = 1, esquerda = 0;
	public int direcaoAtual = esquerda;

	public boolean jogadorProximo = false;
	
	public boolean jogadorProximoV = false;
	
	boolean jogadorProximoR = false;
	
	boolean jogadorProximoRe = false;
	
	boolean jogadorProximoA = false;
	
	boolean jogadorProximoW = false;
	
	double limiteProximidadeW = 20.0;
	
	private Timer mudarDirecaoTimer;
	
	double pontoX ;
	
	boolean isRemovido; 
	
	private int animationTickP = 0;
	private double animationSpeedP = 3;
	
	public int valorWill = 15;
	
	public BufferedImage[] inimigoSLeft;
	public BufferedImage[] inimigoSRight;

	public BufferedImage[] inimigoSLeftP;
	public BufferedImage[] inimigoSRightP;
	
	public BufferedImage[] inimigoSLeftA;
	public BufferedImage[] inimigoSRightA;
	
	
	public double getLife (double life) {
		return life;
	}

	public InimigoIronDoll(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		mudarDirecaoTimer = new Timer();
	    mudarDirecaoTimer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            mudarDirecao();
	        }
	    }, 0, 5000); 
		
		inimigoSLeft = new BufferedImage[5];
		inimigoSRight = new BufferedImage[5];
		inimigoSLeftP = new BufferedImage[5];
		inimigoSRightP = new BufferedImage[5];
		inimigoSLeftA = new BufferedImage[6];
		inimigoSRightA = new BufferedImage[6];
		
		for(int i = 0; i < 5; i++) {
			inimigoSLeftP[i] = Game.sprite.getSprite(2400 - (i*48) , 2352, 48, 64);
		}

		for(int i = 0; i < 5; i++) {
			inimigoSRightP[i] = Game.sprite.getSprite(2208 + (i*48) , 2272, 48, 64);
		}
		
		for(int i = 0; i < 5; i++) {
			inimigoSLeft[i] = Game.sprite.getSprite(2112 - (i*48) , 2352, 48, 64);
		}

		for(int i = 0; i < 5; i++) {
			inimigoSRight[i] = Game.sprite.getSprite(1920 + (i*48) , 2272, 48, 64);
		}
		
		for(int i = 0; i < 6; i++) {
			inimigoSLeftA[i] = Game.sprite.getSprite(2160 - (i*48) , 2512, 48, 64);
		}

		for(int i = 0; i < 6; i++) {
			inimigoSRightA[i] = Game.sprite.getSprite(1920 + (i*48) , 2432, 48, 64);
		}

	}
	
	@Override
	public void tick() {
	    movimentacao = 0;

	    double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
	    double limiteProximidade = 120.0;

	    jogadorProximo = distancia < limiteProximidade;
	    
	    double distanciaA = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
	    double limiteProximidadeA = 20.0;

	    jogadorProximoA = distanciaA < limiteProximidadeA;
	    
	    double distanciaV = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
	    double limiteProximidadeV = 160.0;

	    jogadorProximoV = distanciaV < limiteProximidadeV;

	    double distanciaRe = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
	    double limiteProximidadeRe = 280.0;

	    jogadorProximoRe = distanciaRe < limiteProximidadeRe;
	    
	    double distanciaW = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        if (direcaoAtual == esquerda) {
        	 limiteProximidadeW = 20.0;
        } else {
        	 limiteProximidadeW = 20.0;
        }
        

        jogadorProximoW = distanciaW < limiteProximidadeW;

	    if (!colisao((int) x, (int) (y + 2))) {
	        movimentacao = 0;
	        y += 2;
	    }
	    

	    if (fimDaTrajetoria((int) x, (int) (y + 2))) {
	        mudarDirecao();
	    }
	    
	    
		 double diferencaX = Game.player.getX() - this.getX();
		 if (jogadorProximoW) {
			 if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
		            direcaoAtual = direita;
		            atacando = 1;
		        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
		            direcaoAtual = esquerda;
		            atacando = 1;
		        }
		 } else {
			 atacando = 0;
		 }
	    
	    if (jogadorProximo) {
	        if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
	            x += speed;
	            movimentacao = 1;
	            direcaoAtual = direita;
	        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
	            x -= speed;
	            movimentacao = 1;
	            direcaoAtual = esquerda;
	        }
	    } else if (!fimDaTrajetoria((int) (x + speed), this.getY()) && !fimDaTrajetoria((int) (x - speed), this.getY())) {
	        if (direcaoAtual == direita) {
	            x += speed;
	            movimentacao = 1;
	        } else if (direcaoAtual == esquerda) {
	            x -= speed;
	            movimentacao = 1;
	        }
	    }

	    if (movimentacao == 1) {
	        frames++;
	        if (frames == maxFrames) {
	            index++;
	            frames = 0;
	            if (index > maxIndex)
	                index = 0;
	        }
	    } else {
	        speed = 0.8;
	    }
	    
	    if (atacando == 1) {
	        framesA++;
	        if (framesA == maxFramesA) {
	            indexA++;
	            framesA = 0;
	            if (indexA > maxIndexA)
	                indexA = 0;
	        }
	    } else {
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

	private void mudarDirecao() {
	    direcaoAtual = (direcaoAtual == direita) ? esquerda : direita;

	    if (direcaoAtual == direita) {
	        x += 5;
	    } else if (direcaoAtual == esquerda) {
	        x -= 5;
	    }
	}


	
	public void lifeBar(Graphics g) {
		int inventarioXB = this.getX()-Camera.x - 15; 
        int inventarioYB = this.getY()-Camera.y - 45;
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
        g.drawString("Iron Doll", inventarioXB, inventarioYB);
	}

	public boolean colisao(int nextx, int nexty) {
		Rectangle inimigo = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky,maskw,maskh);
				if(inimigo.intersects(solido)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean fimDaTrajetoria(int nextx, int nexty) {
	    Rectangle inimigo = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for (Entidade entidade : Game.entidade) {
	        if (entidade instanceof BlocoParaInimigo) {
	            Rectangle solido = new Rectangle(entidade.getX(), entidade.getY(), entidade.getWidth(), entidade.getHeight());
	            if (inimigo.intersects(solido)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	
	public void animations(Graphics g) {
		if (direcaoAtual == direita && movimentacao == 1 && atacando == 0) {
			g.drawImage(inimigoSRight[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 48, null);
		}

		if (direcaoAtual == direita && movimentacao == 0 && atacando == 0) {
			g.drawImage(inimigoSRightP[indexP], this.getX()-Camera.x - 15, this.getY()-Camera.y - 48, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 1 && atacando == 0) {
			g.drawImage(inimigoSLeft[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 48, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 0 && atacando == 0) {
			g.drawImage(inimigoSLeftP[indexP], this.getX()-Camera.x - 15 , this.getY()-Camera.y - 48, null);
		}
		
		if (direcaoAtual == esquerda && atacando == 1) {
			g.drawImage(inimigoSLeftA[indexA], this.getX()-Camera.x - 15, this.getY()-Camera.y - 48, null);
		}
		
		if (direcaoAtual == direita && atacando == 1) {
			g.drawImage(inimigoSRightA[indexA], this.getX()-Camera.x - 15 , this.getY()-Camera.y - 48, null);
		}
		
	}

	@Override
	public void render(Graphics g) {

		if (jogadorProximoV) {
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
