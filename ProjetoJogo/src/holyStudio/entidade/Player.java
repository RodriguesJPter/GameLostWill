package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import holyStudio.Mundo.Camera;
import holyStudio.Mundo.Mundo;
import holyStudio.main.Game;

public class Player extends Entidade  implements Serializable {
	

	 
	public PlayerController controller;
	
	public PlayerInfo info;

	public Mundo mundo;
	
	public NpcMoon npc;
	
	private Timer time;
	
	public String texto = ""; 

	public static int PlayerLevel = 1;

	public boolean right, left, down, up;

	public boolean rightP, leftP;

	public boolean rightA, leftA;

	public double speed = 4;

	public static int direita = 1;

	public static int esquerda = 0;

	public int paradoD = 1;

	public int paradoL = 0;

	public int atacandoR = 1;

	public int atacandoL = 0;

	public int pulandoR = 1;

	public int pulandoL = 0;

	public static int direcaoAtual = direita;

	public int PuloDirecao = direita;

	public int movimentacao = 0;

	public int ataque = 0;

	public int frames = 0, maxFrames = 7, index = 0, maxIndex = 6;

	public int framesP = 0, maxFramesP = 5, indexP = 0, maxIndexP = 4;

	public int framesAA = 0, maxFramesAA = 5, indexAA = 0, maxIndexAA = 4;
	
	public int framesAS = 0, maxFramesAS = 5, indexAS = 0, maxIndexAS = 4;
	
	public int framesAD = 0, maxFramesAD = 5, indexAD = 0, maxIndexAD = 4;
	
	public int framesPl = 0, maxFramesPl = 6, indexPl = 0, maxIndexPl = 5;
	
	public int framesC= 0, maxFramesC = 5, indexC = 0, maxIndexC = 4;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
	
	public int comboAtaque = 0;
	
	private boolean mostrarTexto = false;
	private long tempoTextoVisivel = 0;
	
	public boolean defendendo = false;
	public boolean defeza = false;
	
	public boolean jump = false;
	public boolean caindo = false;
	public boolean isJump = false;
	public int jumpHeigth = 48;
	public int jumpFrames = 0;
	public int maxJumpFrames = 60;
	
	public InimigoRato pl;
	
	public InimigoSoldado pl2;
	
	public InimigoSoldadoRival pl5;
	
	public InimigoWendigo pl3;
	
	public InimigoIronDoll pl4;
	
	public Yellow him;
	
	public BossDogKnight bossUm;

	public PortaMadeira porta;
	
	public BlocoTroca01 bt01;
	
	public BlocoTroca02 bt02;
	
	public BlocoTroca03 bt03;
	
	public BlocoTroca04 bt04;

	public static int danoAdaga = 10;
	
	public static int danoSword = 40;
	
	public static int danoLamina = 60;
	
	public static int danoMoonSword = 70;
	
	public static int armaescolida = danoAdaga;

	public static int dano;
	
	public int posx, posy;
	
	private boolean interromperAnimacaoAtaque = false;
	
	public int Void = 1;
	
	public int framesJ = 0, maxFramesJ = 4, indexJ = 0, maxIndexJ = 3;

	public int framesPJ = 0, maxFramesPJ = 5, indexPJ = 0, maxIndexPJ = 6;
	
	private int animationTick = 2;
	private double animationSpeed = 6;
	
	private int animationTickP = 2;
	private double animationSpeedP = 1.5;
	
	private double gravidade = 0.5;  
    private double velocidadeVertical = 0;
    
	
	public static double life = 100, maxLife = 100;
	
	public static double estamina = 100, maxestamina = 100;
	
	public static boolean descansando = false;
	public static boolean descansadoUmPouco = true;
	
	public static boolean podeAtacar = false;
	
	public static double descansadoNivel;
	
	public static boolean atacando = false;
	
	public static boolean usandoEscada = false;
	
	public static boolean checkpointUm = false;
	public static boolean checkpointDois = false;
	
	public static boolean selecionado = false;
	
	public boolean usandocura = false;
	
	public boolean interagindo = false;
	
	public boolean interagindoComPorta = false;
	
	public boolean opemInventory = false;
	
	public boolean abrindoInventarioy = false;
	
	public boolean morto = false;
	
	public static int forca = 0; 
	
	public int numeroLixo = 0;

	
	public BufferedImage[] playerRight;
	public BufferedImage[] playerLeft;
	public BufferedImage[] playerRightP;
	public BufferedImage[] playerLeftP;
	
	public BufferedImage[] playerRAtaque;
	public BufferedImage[] playerLAtaque;
	public BufferedImage[] playerRAtaqueAdaga;
	public BufferedImage[] playerLAtaqueAdaga;
	public BufferedImage[] playerRAtaqueLamina;
	public BufferedImage[] playerLAtaqueLamina;
	public BufferedImage[] playerRAtaqueAdagaDois;
	public BufferedImage[] playerLAtaqueAdagaDois;
	public BufferedImage[] playerRAtaqueEspadaDois;
	public BufferedImage[] playerLAtaqueEspadaDois;
	public BufferedImage[] playerRAtaqueLaminaDois;
	public BufferedImage[] playerLAtaqueLaminaDois;
	
	public BufferedImage[] playerRPulo;
	public BufferedImage[] playerLPulo;
	public BufferedImage[] playerRCaindo;
	public BufferedImage[] playerLCaindo;
	public BufferedImage[] playerRDefendendo;
	public BufferedImage[] playerLDefendendo;
	
	public BufferedImage[] programadorRight;
	public BufferedImage[] programadorLeft;
	public BufferedImage[] programadorRightP;
	public BufferedImage[] programadorLeftP;
	

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		controller = new PlayerController();
		info = new PlayerInfo();
		controller.danoPlayer();
		
		pl3 =  new InimigoWendigo(16, 1024, 59, 145, Game.sprite.getSprite(16, 1024, 59, 145));
		pl2 =  new InimigoSoldado(3, 768, 46, 57, Game.sprite.getSprite(3, 768, 46, 57));
		pl4 =  new InimigoIronDoll(3, 768, 46, 57, Game.sprite.getSprite(3, 768, 46, 57));
		pl5 =  new InimigoSoldadoRival(3, 768, 46, 57, Game.sprite.getSprite(3, 768, 46, 57));
		pl =  new InimigoRato(1 , 565, 73, 52, Game.sprite.getSprite(1 , 565, 73, 52));
		bossUm = new BossDogKnight(1850, 143, 85, 80, Game.sprite.getSprite(1850, 143, 85, 80));
		him = new Yellow(1850, 143, 85, 80, Game.sprite.getSprite(1850, 143, 85, 80));
		
		playerRightP = new BufferedImage[5];
		playerLeftP = new BufferedImage[5];
		playerRight = new BufferedImage[7];
		playerLeft = new BufferedImage[7];
		playerRAtaqueAdaga = new BufferedImage[5];
		playerLAtaqueAdaga = new BufferedImage[5];
		playerRAtaqueAdagaDois = new BufferedImage[5];
		playerLAtaqueAdagaDois = new BufferedImage[5];
		playerRAtaqueLamina = new BufferedImage[5];
		playerLAtaqueLamina = new BufferedImage[5];
		playerRAtaqueLaminaDois = new BufferedImage[5];
		playerLAtaqueLaminaDois = new BufferedImage[5];
		playerRAtaque = new BufferedImage[5];
		playerLAtaque = new BufferedImage[5];
		playerRAtaqueEspadaDois = new BufferedImage[5];
		playerLAtaqueEspadaDois = new BufferedImage[5];
		playerRPulo = new BufferedImage[5];
		playerLPulo = new BufferedImage[5];
		playerRCaindo = new BufferedImage[5];
		playerLCaindo = new BufferedImage[5];
		playerRDefendendo = new BufferedImage[5];
		playerLDefendendo = new BufferedImage[5];
		
		programadorRightP = new BufferedImage[5];
		programadorLeftP = new BufferedImage[5];
		programadorRight = new BufferedImage[7];
		programadorLeft = new BufferedImage[7];
		
		
		
		for(int i = 0; i < 5; i++) {
			programadorRightP[i] = Game.sprite.getSprite(1104, 592, 32, 52);
		}

		for(int i = 0; i < 5; i++) {
			programadorLeftP[i] = Game.sprite.getSprite(1136, 592, 32, 52);
		}

		for(int i = 0; i < 4; i++) {
			programadorRight[i] = Game.sprite.getSprite(1104 + (i*32), 721, 32, 54);
		}

		for(int i = 0; i < 4; i++) {
			programadorLeft[i] = Game.sprite.getSprite(1200 - (i*32), 656, 32, 54);
		}
		

		for(int i = 0; i < 5; i++) {
			playerRightP[i] = Game.sprite.getSprite(2 + (i*33), 1, 34, 49);
		}

		for(int i = 0; i < 5; i++) {
			playerLeftP[i] = Game.sprite.getSprite(134 - (i*33), 53, 34, 49);
		}

		for(int i = 0; i < 7; i++) {
			playerRight[i] = Game.sprite.getSprite(2 + (i*50), 105, 49, 49);
		}

		for(int i = 0; i < 7; i++) {
			playerLeft[i] = Game.sprite.getSprite(306 - (i*50), 155, 49, 49);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRAtaqueEspadaDois[i] = Game.sprite.getSprite(556 + (i*82), 1559, 81, 61);
		}

		
		for(int i = 0; i < 5; i++) {
			playerLAtaqueEspadaDois[i] = Game.sprite.getSprite(1036 - (i*82), 1625, 81, 61);
		}


		for(int i = 0; i < 5; i++) {
			playerRAtaqueAdaga[i] = Game.sprite.getSprite(18 + (i*58), 1404, 58, 53);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaqueAdaga[i] = Game.sprite.getSprite(246 - (i*58), 1469, 58, 53);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRAtaqueAdagaDois[i] = Game.sprite.getSprite(368 + (i*64), 1408, 64, 48);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaqueAdagaDois[i] = Game.sprite.getSprite(624 - (i*64), 1472, 64, 48);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRAtaqueLamina[i] = Game.sprite.getSprite(1714 + (i*80), 627, 80, 61);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaqueLamina[i] = Game.sprite.getSprite(2032 - (i*80), 691, 80, 61);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRAtaqueLaminaDois[i] = Game.sprite.getSprite(2155 + (i*104), 593, 104, 95);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaqueLaminaDois[i] = Game.sprite.getSprite(2571 - (i*104), 705, 104, 95);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRAtaque[i] = Game.sprite.getSprite(13 + (i*81), 1564, 80, 55);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaque[i] = Game.sprite.getSprite(329 - (i*81), 1631, 80, 55);
		}

		for(int i = 0; i < 5; i++) {
			playerRPulo[i] = Game.sprite.getSprite(189, 214, 41, 54);
		}

		for(int i = 0; i < 5; i++) {
			playerLPulo[i] = Game.sprite.getSprite(230, 213, 41, 54);
		}
		for(int i = 0; i < 5; i++) {
			playerRCaindo[i] = Game.sprite.getSprite(800 + (i*32), 1392, 32, 64);
		}

		for(int i = 0; i < 5; i++) {
			playerLCaindo[i] = Game.sprite.getSprite(960 - (i*32), 1456, 32, 64);
		}
		
		for(int i = 0; i < 5; i++) {
			playerRDefendendo[i] = Game.sprite.getSprite(96, 272, 32, 48);
		}

		for(int i = 0; i < 5; i++) {
			playerLDefendendo[i] = Game.sprite.getSprite(128, 272, 32, 48);
		}



	}
	
	 public void aplicarGravidade() {
	        if (!colisao((int) x, (int) (y + velocidadeVertical + 1))) {
	            velocidadeVertical += gravidade;
	            caindo = true;
	            if (velocidadeVertical > 10) {  
	                velocidadeVertical = 6;
	            }
	        } else {
	            velocidadeVertical = 0;
	        }
	        y += velocidadeVertical;
	    }

	@Override
	public void tick() {
		camera();
		
		if (estamina <= maxestamina && estamina >= 0) {
			podeAtacar = true;
		}
		if (estamina >= descansadoNivel ||estamina == maxestamina && estamina >= 0) {
			descansadoUmPouco = true;
		}
		
		if (defeza == true) {
			defendendo = true;
		} else {
			defendendo = false;
		}
		
		movimentacao = 0;
		ataque = 0;
		
		dano = forca + armaescolida;
		
		if (Game.inventario.cranio == 1) {
			forca = Game.inventario.bonuscranio ;
		}

		if(!colisao((int) x, (int)(y+2)) && !isJump) {
			velocidadeVertical = 6;
			aplicarGravidade();
			caindo = true;
			y+=1;
			if (colisao((int) x, (int)(y- 2))){
				System.out.println(" bateu a cabeca ");
				y += 32; 
			}
		}
		
		
		if (colisaoEspinhos((int) x, (int)(y+2)) && !isJump) {
			life = 0;
		}
		
		if (up && !usandoEscada((int) x, (int)(y+2))) {
			usandoEscada = true;
			y += speed;
			
		}

		 if (right && !colisao((int)(x+speed), this.getY())) {
		        x += speed;
		        movimentacao = 1;
		        direcaoAtual = direita;
		        speed = 4;
		    }

		  if (left && !colisao((int)(x-speed), this.getY())) {
		        x -= speed;
		        movimentacao = 1;
		        direcaoAtual = esquerda;
		        speed = 4;
		    }

		if(Game.b01.jogadorProximo) {
			
		}
		
		if (usandoEscada((int)(x-speed), this.getY())) {
			usandoEscada = true;
		} else if (!usandoEscada((int)(x-speed), this.getY())) {
			usandoEscada = false;
		}
		
	 	if(bt01((int)(x-speed), this.getY())){
			controller.controleMapaBt01();
		}
	 	if(bt02((int)(x-speed), this.getY())){
			controller.controleMapaBt02();
		}
	 	if(bt03((int)(x-speed), this.getY())){
			controller.controleMapaBt03();
			System.out.println(Game.mundo.esteveVoid);
		}
	 	if(bt04((int)(x-speed), this.getY())){
	 		if ( Game.mundo.eventoBossMorto == 1) {
	 			controller.controleMapaBt04();
	 		}
		}
	 	
	 	if (usandoEscada == true) {
	 		up = true;
	 		down = true;
	 	}
	 	
			
	 	if (pl2.jogadorProximoA) {
	 	    if (Game.player.rightA) {
	 	        pl2.x += 30;
	 	        pl2.life -= dano;
	 	        if (pl2.life <= 0) {
	 	            if (!pl2.isRemovido) {
	 	                Game.soldado.remove(pl2);
	 	                pl2.life = 0;
	 	                Game.inventario.numeroDeWill += 25;  
	 	               Game.inventario.recompensa();
	 	                pl2.isRemovido = true; 
	 	            }
	 	        }
	 	    } else if (Game.player.leftA) {
	 	        pl2.x -= 30;
	 	        pl2.life -= dano;
	 	        if (pl2.life <= 0) {
	 	            if (!pl2.isRemovido) {
	 	                Game.soldado.remove(pl2);
	 	                pl2.life = 0;
	 	                Game.inventario.numeroDeWill += 25;  
	 	                Game.inventario.recompensa();
	 	                pl2.isRemovido = true; 
	 	            }
	 	        }
	 	    }
	 	}
	 	
	 	if (pl5.jogadorProximoA) {
	 	    if (Game.player.rightA) {
	 	        pl5.x += 30;
	 	        pl5.life -= dano;
	 	        if (pl5.life <= 0) {
	 	            if (!pl5.isRemovido) {
	 	                Game.rival.remove(pl5);
	 	                pl5.life = 0;
	 	                Game.inventario.numeroDeWill += 25;  
	 	               Game.inventario.recompensa();
	 	                pl5.isRemovido = true; 
	 	            }
	 	        }
	 	    } else if (Game.player.leftA) {
	 	        pl5.x -= 30;
	 	        pl5.life -= dano;
	 	        if (pl5.life <= 0) {
	 	            if (!pl5.isRemovido) {
	 	                Game.rival.remove(pl5);
	 	                pl5.life = 0;
	 	                Game.inventario.numeroDeWill += 25;  
	 	                Game.inventario.recompensa();
	 	                pl5.isRemovido = true; 
	 	            }
	 	        }
	 	    }
	 	}

			
			if(pl4.jogadorProximoA) {
	        	if(Game.player.rightA) {
	        		pl4.x += 30;
	        		pl4.life -= dano - 5;
	        		if (pl4.life <= 0) {
	        			if (!pl4.isRemovido) {
	        				Game.ironDoll.remove(pl4);
		        			pl4.life = 0;
		        			Game.inventario.numeroDeWill += 40;  
			 	            pl4.isRemovido = true; 
	        			}
	        		}
	        	} else if (Game.player.leftA) {
	        		pl4.x -= 30;
	        		pl4.life -= dano - 5;
	        		if (pl4.life <= 0) {
	        			if (!pl4.isRemovido) {
	        				Game.ironDoll.remove(pl4);
		        			pl4.life = 0;
		        			Game.inventario.numeroDeWill += 40;  
			 	            pl4.isRemovido = true; 
	        			}
	        		}
	        	}
	        }
			
			if(pl3.jogadorProximoA) {
	        	if(Game.player.rightA) {
	        		pl3.x += 30;
	        		pl3.life -= dano;
	        		if (pl3.life <= 0) {
	        			if (!pl3.isRemovido) {
	        				Game.wendigo.remove(pl3);
		        			pl3.life = 0;
		        			Game.inventario.numeroDeWill += 500;  
			 	            pl3.isRemovido = true;
	        			}
	        		}
	        	} else if (Game.player.leftA) {
	        		pl3.x -= 30;
	        		pl3.life -= dano;
	        		if (pl3.life <= 0) {
	        			if (!pl3.isRemovido) {
	        				Game.wendigo.remove(pl3);
		        			pl3.life = 0;
		        			Game.inventario.numeroDeWill += 100;  
			 	            pl3.isRemovido = true;
	        			}
	        		}
	        	} 
	        }
			
			if(pl.jogadorProximoA) {
	        	if(Game.player.rightA) {
	        		pl.x += 30;
	        		pl.life -= dano;
	        		if (pl.life <= 0) {
	        			Game.rato.remove(pl);
	        			Game.inventario.numeroDeWill += 025;
	        		}
	        	} else if (Game.player.leftA) {
	        		pl.x -= 30;
	        		pl.life -= dano;
	        		if (pl2.life <= 0) {
	        			Game.rato.remove(pl);
	        			Game.inventario.numeroDeWill += 025;
	        		}
	        	}
	        }
			
			
			if (rightA && !colisao(this.getX(), this.getY())) {
			    ataque = 1;
			    movimentacao = 2;
			    speed = 0;
			    direcaoAtual = atacandoR;
			    
			    if (indexAA >= maxIndexAA) {
			        interromperAnimacaoAtaque = true;
			        rightA = false;
			        indexAA = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }
			        
			    }
			    if (indexAS >= maxIndexAS) {
			        interromperAnimacaoAtaque = true;
			        rightA = false;
			        indexAS = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }			    }
			    if (indexAD >= maxIndexAD) {
			        interromperAnimacaoAtaque = true;
			        rightA = false;
			        indexAD = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }			    }
			}

			if (leftA && !colisao(this.getX(), this.getY())) {
			    ataque = 1;
			    movimentacao = 2;
			    speed = 0;
			    direcaoAtual = atacandoL;
			    
			    if (indexAA >= maxIndexAA) {
			        interromperAnimacaoAtaque = true;
			        leftA = false;
			        indexAA = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }			    }
			    if (indexAS >= maxIndexAS) {
			        interromperAnimacaoAtaque = true;
			        leftA = false;
			        indexAS = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }			    }
			    if (indexAD >= maxIndexAD) {
			        interromperAnimacaoAtaque = true;
			        leftA = false;
			        indexAD = 0;
			        if (bossUm.jogadorProximoD) {
			        	controller.bossAtacado(bossUm);
			        }			    }
			}

			if (interromperAnimacaoAtaque) {
			    indexAA = 0;
			    indexAS = 0;
			    interromperAnimacaoAtaque = false;
			    System.out.println("animacao reiniciada");
			}
			
	 	
		if(rightP && !colisao((int)(x+speed), this.getY())) {
			movimentacao = 0;
			direcaoAtual = paradoD;
		}

		if(leftP && !colisao((int)(x-speed), this.getY())) {
			movimentacao = 0;
			direcaoAtual = paradoL;
		}

		if(jump && direcaoAtual == direita) {
			movimentacao = 3;
			direcaoAtual = pulandoR;
			PuloDirecao = direita;
			if(colisao(this.getX(), this.getY() + 2)) {
				isJump = true;
			}
		} else if(jump) {
			movimentacao = 3;
			direcaoAtual = pulandoL;
			PuloDirecao = esquerda;
			if(colisao(this.getX(), this.getY() + 2)) {
				isJump = true;
			}
		}

		
		
		if (isJump) {
	        if (!colisao(getX(), getY() - 2)) {
	            jumpFrames += 1;

	            if (!colisao(getX(), getY() - 2)) {
	                if (jumpFrames <= maxJumpFrames / 2) {
	                    y -= 5;
	                    caindo = false;
	                    rightA = false;
	                    leftA = false;
	                } else {
	                	caindo = true;
	                	aplicarGravidade();
	                }
	            }

	            if (jumpFrames >= maxJumpFrames) {
	                isJump = false;
	                jump = false;
	                jumpFrames = 0;
	            }
	        } else {
	            isJump = false;
	            jump = false;
	            jumpFrames = 0;
	        }
	    }
		
		if (movimentacao == 1 || ataque == 1 ) {
			frames ++;
			framesJ++;
			  if(frames == maxFrames) {
				  index++;
				  frames = 0;
				  if (index > maxIndex) {
					  index = 0;
				  }
			  }
			  
			  animationTick++;
			    if (animationTick >= animationSpeed) {
			        animationTick = 0;
			        framesJ++;
			        if (framesJ > maxFramesJ) {
			            framesJ = 0;
			            indexJ++;
			            if (indexJ > maxIndexJ) {
			                indexJ = 0;
			            }
			        }
			    }
			  
			  if (framesPJ == maxFramesPJ) {
				  indexPJ++;
				  framesPJ = 0;
				  if (indexPJ > maxIndexPJ) {
					  indexPJ = 0;
				  }
			  }
		}
		
		if (opemInventory) {
			abrindoInventarioy = true;
			
		}
		
		if(check((int)(x-speed), this.getY())) {

			if (Game.mapaAtual == Game.mapaContador.mapa03) {
				checkpointUm = true;
				checkpointDois = false;
				System.out.println("check point level 03");
			} else if (Game.mapaAtual == Game.mapaContador.mapa00) {
				checkpointDois = true;
				checkpointUm = false;
				System.out.println("check point level 00");
			}
			
		}
		
		if (mostrarTexto) {
		    long tempoAtual = System.currentTimeMillis();
		    if (tempoAtual - tempoTextoVisivel >= 3000) { 
		        mostrarTexto = false;
		        texto = ""; 
		    }
		}
		
		
		if (usandocura && Game.inventario.numeroFrasco > 0) {
			life += 20;
			Game.inventario.numeroFrasco -= 1;
			usandocura = false;
			
			if(life > maxLife) {
				life = 100;
				usandocura = false;
			}
		} else {
			
		}
		
		
		if(controller.damageWendigo((int)(x-speed), this.getY())) {
			life -= 0.90;
		}

		if(controller.damageRato((int)(x-speed), this.getY())) {
			life -= 0.45;
		}
		
		if(controller.damageSoldado((int)(x-speed), this.getY())) {
			life -= 0.25;
		}
		
		if(controller.damageIronDoll((int)(x-speed), this.getY())) {
			life -= 0.25;
		}
		
		if(controller.damageRival((int)(x-speed), this.getY())) {
			life -= 0.30;
		}
		
		if(controller.him((int)(x-speed), this.getY())) {
			Game.endGame();
		}
		
		if(controller.damageBossDog((int)(x-speed), this.getY())) {
			System.out.println("colidindo com o boss");
			if (bossUm.direcaoAtual == bossUm.esquerda) {
				x -= 2;
			} else if (bossUm.direcaoAtual == bossUm.direita) {
				x += 2;
			}
		}

		if (rightA || leftA) {
			
		 if (ataque == 1) {
		        framesAA++;
		        if (framesAA == maxFramesAA) {
		            indexAA++;
		            framesAA = 0;
		            if (indexAA > maxIndexAA) {
		                indexAA = 0;
		            }
		        }
		        framesAS++;
		        if (framesAS == maxFramesAS) {
		            indexAS++;
		            framesAS = 0;
		            if (indexAS > maxIndexAS) {
		                indexAS = 0;
		            }
		        }
		        framesAD++;
		        if (framesAD == maxFramesAD) {
		            indexAD++;
		            framesAD = 0;
		            if (indexAD > maxIndexAD) {
		                indexAD = 0;
		            }
		        }
		    }

		}
		
		framesC++;
        if (framesC == maxFramesC) {
            indexC++;
            framesC = 0;
            if (indexC > maxIndexC) {
                indexC = 0;
            }
        }
		
		
		
		if (movimentacao == 0 || caindo == true) {
			animationTickP++;
		    if (animationTickP >= animationSpeedP) {
		        animationTickP = 0;
		    	framesP ++;
				  if(framesP == maxFramesP) {
					  indexP++;
					  framesP = 0;
					  if (indexP > maxIndexP) {
						  indexP = 0;
					  }
				  } else {
					  
				  }
		    	}
		    }		 
		
	}
	
    
	
	public void estaminaRecarga() {
		time = new Timer();
	    time.scheduleAtFixedRate( new EstaminaRecuoperando(), 0, 500);
	}
	
	private class EstaminaRecuoperando extends TimerTask {
			@Override
			public void run() {
				
				recarregando();
				
				if(estamina <= 0) {
					descansando = true;
					descansadoUmPouco = false;
				} else if (estamina >= maxestamina) {
					estamina = maxestamina;
					descansando = false;
					descansadoUmPouco = true;
				}
			
			}
			
			public void recarregando() {
				if(descansando == true || estamina <= maxestamina) {
					estamina += 3;
				}
			}
		
		
	}
	
	public boolean check(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (int i = 0; i< Game.estatua01.size(); i++) {
			Entidade entidade = Game.estatua01.get(i);
			if(entidade instanceof EstatuaUm) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					return true;
				}
			}

		}
		return false;
	}
	

	public boolean colisao(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					caindo = false;
					return true;
				}
			}

		}
		return false;
	}
	
	public boolean usandoEscada(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Escada) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					caindo = false;
					return true;
				}
			}

		}
		return false;
	}
	
	
	public boolean colisaoEspinhos(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Espinhos) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					caindo = false;
					return true;
				}
			}

		}
		return false;
	}
	public boolean colisaoDois(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (BlocoBossRoom entidade : Game.BBR) {
			if(entidade instanceof BlocoBossRoom) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					caindo = false;
					return true;
				}
			}

		}
		return false;
	}



	public boolean porta(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (holyStudio.entidade.PortaMadeira entidade : Game.porta) {
			if(entidade instanceof PortaMadeira) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
				if(player.intersects(inimigo)) {
					porta = entidade;
					return true;

				}
			}

		}
		return false;
	}

	public boolean bt01(int nextx, int nexty) {
	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for (holyStudio.entidade.BlocoTroca01 entidade : Game.bt01) {
	        if (entidade instanceof BlocoTroca01) {
	            Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
	            inimigo.add(new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh));

	            if (player.intersects(inimigo)) {
	                bt01 = entidade;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public boolean bt02(int nextx, int nexty) {
	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for (holyStudio.entidade.BlocoTroca02 entidade : Game.bt02) {
	        if (entidade instanceof BlocoTroca02) {
	            Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
	            inimigo.add(new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh));

	            if (player.intersects(inimigo)) {
	                bt02 = entidade;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public boolean bt03(int nextx, int nexty) {
	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for (holyStudio.entidade.BlocoTroca03 entidade : Game.bt03) {
	        if (entidade instanceof BlocoTroca03) {
	            Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
	            inimigo.add(new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh));

	            if (player.intersects(inimigo)) {
	                bt03 = entidade;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public boolean bt04(int nextx, int nexty) {
	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
	    for (holyStudio.entidade.BlocoTroca04 entidade : Game.bt04) {
	        if (entidade instanceof BlocoTroca04) {
	            Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
	            inimigo.add(new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh));

	            if (player.intersects(inimigo)) {
	            	if (Game.mundo.eventoBossMorto == 1)
	                bt04 = entidade;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	 public void empurrao() {
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(9) + 1;
	        
	        if (numeroAleatorio == 1 ) {
	        	if (direcaoAtual == esquerda) {
	        		bossUm.x -= 16;
	        	} else if (direcaoAtual == direita) {
	        		bossUm.x += 16;
	        	}
	        	
	        } else if (numeroAleatorio == 7 ) {
	        	if (direcaoAtual == esquerda) {
	        		bossUm.x -= 32;
	        	} else if (direcaoAtual == direita) {
	        		bossUm.x += 32;
	        	}
	        } else if (numeroAleatorio == 2 ||numeroAleatorio == 3 ||
	        		numeroAleatorio == 4 ||numeroAleatorio == 5 ||
	        		numeroAleatorio == 6 ||numeroAleatorio == 8 ||
	        		numeroAleatorio == 9) {
	        	if (direcaoAtual == esquerda) {
	        		bossUm.x -= 0;
	        	} else if (direcaoAtual == direita) {
	        		bossUm.x += 0;
	        	}
	        }
	        
	        
	 }
	
public void camera () {
	
	if (Game.mapaAtual == Game.mapaContador.mapa07) {
		if (direcaoAtual == direita) {
			Camera.x = Camera.Clamp(this.getX() - 38 - (Game.WIDTH/3), 0, Mundo.WIDTH*16 - Game.WIDTH);
			Camera.y = Camera.Clamp(this.getY() - 73 - (Game.HEIGHT/3), 0, Mundo.HEIGHT*16 - Game.HEIGHT);
		} else if (direcaoAtual == esquerda) {
			Camera.x = Camera.Clamp(this.getX() - 43 - (Game.WIDTH/3), 0, Mundo.WIDTH*16 - Game.WIDTH);
			Camera.y = Camera.Clamp(this.getY() - 73 - (Game.HEIGHT/3), 0, Mundo.HEIGHT*16 - Game.HEIGHT);
		}
	} else {
		if (direcaoAtual == direita) {
			Camera.x = Camera.Clamp(this.getX() - 13 - (Game.WIDTH/3), 0, Mundo.WIDTH*16 - Game.WIDTH);
			Camera.y = Camera.Clamp(this.getY() - 53 - (Game.HEIGHT/3), 0, Mundo.HEIGHT*16 - Game.HEIGHT);
		} else if (direcaoAtual == esquerda) {
			Camera.x = Camera.Clamp(this.getX() - 43 - (Game.WIDTH/3), 0, Mundo.WIDTH*16 - Game.WIDTH);
			Camera.y = Camera.Clamp(this.getY() - 53 - (Game.HEIGHT/3), 0, Mundo.HEIGHT*16 - Game.HEIGHT);
		}
	}
	
	
}


 public void animacaoAtaque(Graphics g) {
	 System.out.println("arama escolida" + armaescolida);
	    
		switch (comboAtaque){
			case 0:
				if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoAdaga && !caindo == true) {
					g.drawImage(playerRAtaqueAdagaDois[indexAA], this.getX()-Camera.x - 16,((int)(y + 1))-Camera.y - 31, null);
				}
				
				if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoAdaga && !caindo == true) {
					g.drawImage(playerLAtaqueAdagaDois[indexAA], ((int)(x - 39))-Camera.x + 5,((int)(y + 1))-Camera.y - 31, null);
				}
				
			break;
			case 1:
				
				if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoAdaga && !caindo == true) {
					g.drawImage(playerRAtaqueAdaga[indexAA], this.getX()-Camera.x - 16,((int)(y + 1))-Camera.y - 35, null);
				}
				
				if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoAdaga && !caindo == true) {
					g.drawImage(playerLAtaqueAdaga[indexAA], ((int)(x - 39))-Camera.x + 5,((int)(y + 1))-Camera.y - 35, null);
				}
				
			break;
		}
		switch (comboAtaque){
			case 0:
				if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoSword && !caindo == true) {
					g.drawImage(playerLAtaqueEspadaDois[indexAS], ((int)(x - 39))-Camera.x - 9,((int)(y + 1))-Camera.y - 37, null);
				}
				if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoSword  && !caindo == true) {
					g.drawImage(playerRAtaqueEspadaDois[indexAS], this.getX()-Camera.x - 16,((int)(y + 1))-Camera.y - 37, null);
				}
				break;
			case 1:
				if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoSword && !caindo == true) {
					g.drawImage(playerLAtaque[indexAS], ((int)(x - 39))-Camera.x - 9,((int)(y + 1))-Camera.y - 37, null);
				}
				if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoSword  && !caindo == true) {
					g.drawImage(playerRAtaque[indexAS], this.getX()-Camera.x - 16,((int)(y + 1))-Camera.y - 37, null);
				}
				break;
	}
		switch (comboAtaque){
		case 0:
			if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoLamina && !caindo == true) {
				g.drawImage(playerLAtaqueLaminaDois[indexAD], ((int)(x - 39))-Camera.x - 9,((int)(y + 1))-Camera.y - 79, null);
			}
			if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoLamina  && !caindo == true) {
				g.drawImage(playerRAtaqueLaminaDois[indexAD], this.getX()-Camera.x - 41,((int)(y + 1))-Camera.y - 79, null);
			}
			break;
		case 1:
			if (direcaoAtual == atacandoL && ataque == 1 && armaescolida == danoLamina && !caindo == true) {
				g.drawImage(playerLAtaqueLamina[indexAD], ((int)(x - 39))-Camera.x - 9,((int)(y + 1))-Camera.y - 45, null);
			}
			if (direcaoAtual == atacandoR && ataque == 1 && armaescolida == danoLamina  && !caindo == true) {
				g.drawImage(playerRAtaqueLamina[indexAD], this.getX()-Camera.x - 32,((int)(y + 1))-Camera.y - 45, null);
			}
			break;
}
		
	 
 }
 
 public void animcaoProgramador(Graphics g) {
	 
	 	jump = false;
	 	isJump = false;
	 	rightA = false;
	 	leftA = false;
	 	speed = 6;
	 
	 	if (direcaoAtual == direita && movimentacao == 1 && !caindo == true) {
			g.drawImage(programadorRight[indexJ], this.getX()-Camera.x - 9, this.getY()-Camera.y - 36, null);
		}
		if (direcaoAtual == esquerda && movimentacao == 1 && !caindo == true) {
			g.drawImage(programadorLeft[indexJ], this.getX()-Camera.x - 15, this.getY()-Camera.y - 36, null);
		}
		if (direcaoAtual == paradoL && movimentacao == 0 && !caindo == true) {
			g.drawImage(programadorLeftP[indexPJ], this.getX()-Camera.x - 9, this.getY()-Camera.y - 35, null);
		}
		if (direcaoAtual == paradoD && movimentacao == 0 && !caindo == true) {
			g.drawImage(programadorRightP[indexPJ], this.getX()-Camera.x - 9, this.getY()-Camera.y - 35, null);
		}
	 
 }
	
	
	
	@Override
	public void render(Graphics g) {
		
		
		
		if (rightA == true && defendendo == false || leftA == true && defendendo == false) {
			animacaoAtaque(g);
		}
		if (Game.mapaAtual == Game.mapaContador.mapa07) {
			animcaoProgramador(g);
		} else {
			
		if (defendendo == true && direcaoAtual == direita) {
			g.drawImage(playerRDefendendo[0], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		} 
		if (defendendo == true && direcaoAtual == esquerda){
			g.drawImage(playerLDefendendo[0], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		}
		
		if (direcaoAtual == direita && movimentacao == 1 && !caindo == true) {
			g.drawImage(playerRight[index], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == paradoD && movimentacao == 0 && !caindo == true) {
			g.drawImage(playerRightP[indexP], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == pulandoR && movimentacao == 3 && PuloDirecao == direita && !caindo == true) {
			g.drawImage(playerRPulo[indexPl], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == direita && caindo == true) {
			g.drawImage(playerRCaindo[indexC], this.getX()-Camera.x , this.getY()-Camera.y - 31, null);
		}
		
		if (direcaoAtual == esquerda && movimentacao == 1 && !caindo == true) {
			g.drawImage(playerLeft[index], this.getX()-Camera.x - 15, this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == paradoL && movimentacao == 0 && !caindo == true) {
			g.drawImage(playerLeftP[indexP], this.getX()-Camera.x - 9, this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == pulandoL && movimentacao == 3 && PuloDirecao == esquerda && !caindo == true) {
			g.drawImage(playerLPulo[indexPl], this.getX()-Camera.x - 9 , this.getY()-Camera.y - 31, null);
		}
		if (direcaoAtual == esquerda && caindo == true) {
			g.drawImage(playerLCaindo[indexC], this.getX()-Camera.x  , this.getY()-Camera.y - 31, null);
		}
		
		}
		
//		    g.setColor(Color.ORANGE);
//	        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//	        g.setColor(Color.BLACK);
//	        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
	}

	public double getLife() {
		return life;
	}

	public double setLife(double life) {
	   return this.life =  life;
	}
	
	public boolean isInteragindo() {
		interagindo = true;
	    return interagindo;
	}

}