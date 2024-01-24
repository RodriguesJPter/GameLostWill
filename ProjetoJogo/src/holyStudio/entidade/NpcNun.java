package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import holyStudio.Mundo.Camera;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.Player;
import holyStudio.entidade.Solido;
import holyStudio.main.Game;

public class NpcNun extends Entidade {
	
	public static boolean jogadorProximo = false;
	
	private boolean dialogoAutomatico = true;
	
	private double jogadorProxi = 1;
	
	public BufferedImage[] npcRightP;
	public BufferedImage[] npcLeftP;
	
	public boolean acao;
	
	public static JFrame jframe;
	
	private boolean opcaoUm = false;
	private boolean opcaoDois = false;
	private boolean opcaoTres = false;
	
	public String moon;
	
	public Player player;
	
	private Timer timer;
	private boolean alternarTexto = false;

	private int indiceAtual = 0;

	
	private String textoProximo = "Pressione Q para falar";
	
	private String textodialogo1 = "...";
	
	public int direita = 1, esquerda = 0;
	
	public int movimentacao = 0;
	
	public int direcaoAtual = direita;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
	
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
 
	public NpcNun(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		 indiceAtual = 0;
		
		npcRightP = new BufferedImage[5];
		npcLeftP = new BufferedImage[5];
		
		for(int i = 0; i < 5; i++) {
			npcRightP[i] = Game.sprite.getSprite(192, 416, 32, 64);
		}

		for(int i = 0; i < 5; i++) {
			npcLeftP[i] = Game.sprite.getSprite(224, 416, 32, 64);
		}

	}
	public void imagem(Graphics g) {
		g.drawImage(Entidade.aparenciaNun , 270, 70, jframe);
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
	
	public void dialogoDois(Graphics g) {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = "Oh, é você. ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "Não achei que você";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "viria até aqui. ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = "Bem, já que você está aqui,";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "eu posso responder algumas";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	Game.dialogo.textoUm = "perguntas, mas seja rápido.";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "Você tem que terminar essa Demo.";
	        	Game.inventario.inventarioAberto = false;
	        	Game.dialogo.escolendo = true;
	        	dialogoDoisOpcaoUm(g);
	        	break;
		 
		 }
		
	}
	
	public void dialogoDoisOpcaoUm(Graphics g) {
		int x = 40;
		int y = 80;
		int largura = 200;
		int altura = 30;

	    
		g.drawImage(Entidade.escolhaDeFala , x, y, jframe);
	    g.setColor(Color.BLACK);
       g.setFont(new Font("Arial", Font.PLAIN, 12));
       g.drawString("quem é voce?!", x + 15, y + 20);
	    
       g.drawImage(Entidade.escolhaDeFala , x, y + 34, jframe);;
	    g.setColor(Color.BLACK);
       g.setFont(new Font("Arial", Font.PLAIN, 12));
       g.drawString("o que é tudo isso?", x + 15, y + 53);
       
       g.drawImage(Entidade.escolhaDeFala , x, y + 68, jframe);
	    g.setColor(Color.BLACK);
       g.setFont(new Font("Arial", Font.PLAIN, 12));
       g.drawString("terminar conversa", x + 15, y + 88);
	    
		
		 switch (Game.dialogo.opcaoDialogo) {
	        case 0:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 8, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("quem é voce?!", x + 15, y + 20);
	            
	            if (Game.player.selecionado) {
	            	opcaoUm = true;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	            
	        	break;
	        case 1:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 42, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("o que é tudo isso?", x + 15, y + 53);
	            
	            if (Game.player.selecionado) {
	            	opcaoDois = true;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	            
	        	break;
	        case 2:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 76, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("terminar conversa", x + 15, y + 88);
	            
	            if (Game.player.selecionado) {
	            	Game.player.interagindo = false;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	        	break;
	      
		 }
		
	}
	
	public void dialogoTres(Graphics g) {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = "Ah, quem sou eu?!";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "Bem, como pode ver, eu sou uma freira.";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "Eu deveria falar que faço parte da ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = "Igreja do Amor *risadas*";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "Que troço mal escrito. Você não poderia";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	Game.dialogo.textoUm = "escrever nada melhor?!";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "";
	        	Game.inventario.inventarioAberto = false;
	        	Game.dialogo.escolendo = true;
	        	opcaoUm = false;
	        	Game.dialogo.linhaDialogo = 6;
	        	break;
		 
		 }
	}
		 public void dialogoQuatro(Graphics g) {
				
			 switch (Game.dialogo.linhaDialogo) {
		        case 0:
		        	Game.dialogo.textoUm = "Isso não cabe a mim te dizer.";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 1:
		        	Game.dialogo.textoUm = "Meu objetivo é ser um NPC";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 2:
		        	Game.dialogo.textoUm = "e tentar te ajudar.";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 3:
		        	Game.dialogo.textoUm = "Não faz essa cara, J@$%. ";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 4:
		        	Game.dialogo.textoUm = "Aqui, toma isso.";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 5:
		        	Game.dialogo.textoUm = "Uma lembrança.";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 6:
		        	Game.inventario.candle += 1;
		        	Game.dialogo.notificacao = "+1 vela";
		        	
		        	Game.dialogo.espada = false;
		        	Game.dialogo.chave = false;
		        	Game.dialogo.frasco = false;
		        	Game.dialogo.candle = true;
		        	
		        	Game.dialogo.textoUm = "";
		        	Game.inventario.inventarioAberto = false;
		        	Game.dialogo.escolendo = true;
		        	opcaoDois = false;
		        	Game.dialogo.linhaDialogo = 0;
		        	Game.mundo.escolhaFeitaNun = true;
		        	break;
			 
			 }
		 }
			 
			 public void dialogoCinco(Graphics g) {
					
				 switch (Game.dialogo.linhaDialogo) {
			        case 0:
			        	Game.dialogo.textoUm = " olha so esse garanhao me secando";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 1:
			        	Game.dialogo.textoUm = "que olhar profundo";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 2:
			        	Game.dialogo.textoUm = "para que assim eu fico sem graca";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 3:
			        	Game.dialogo.textoUm = " voce deve tar coisas mais importante";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 4:
			        	Game.dialogo.textoUm = "o que ficar admirando minha beleza";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 5:
			        	Game.dialogo.textoUm = "...";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 6:
			        	Game.dialogo.textoUm = "";
			        	Game.inventario.inventarioAberto = false;
			        	Game.dialogo.escolendo = true;
			        	Game.player.interagindo = false;
			        	Game.mundo.escolhaFeitaNun  = true;
			        	break;
				 
				 }
		
	}
			 public void dialogoSeis(Graphics g) {
					
				 switch (Game.dialogo.linhaDialogo) {
			        case 0:
			        	Game.dialogo.textoUm = "Você não precisa perder tempo aqui.";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 1:
			        	Game.dialogo.textoUm = "Pode ir.";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 2:
			        	Game.dialogo.textoUm = "Procure a sua paz.";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 3:
			        	Game.dialogo.textoUm = "";
			        	Game.inventario.inventarioAberto = false;
			        	Game.dialogo.escolendo = true;
			        	Game.player.interagindo = false;
			        	break;
			        case 4:
			        	break;
			        case 5:
			        	break;
			        case 6:
			        	break;
				 
				 }
		
	}
			 
			 
	
	@Override
	public void render(Graphics g) {
		if (jogadorProximo) {
			if(Game.player.interagindo) {
				imagem(g);
			}
		}
		
		if (jogadorProximo && !Game.player.interagindo) {
			 g.drawImage(Entidade.balaoDeFala, this.getX() - Camera.x + 10, this.getY() - Camera.y - 60, null);
		}
		
	    if (direcaoAtual == direita && movimentacao == 0) {
	        g.drawImage(npcRightP[0], this.getX() - Camera.x, this.getY() - Camera.y - 48, null);
	    }

	    if (direcaoAtual == esquerda && movimentacao == 0) {
	        g.drawImage(npcLeftP[0], this.getX() - Camera.x, this.getY() - Camera.y - 48, null);
	    }
		
		
		if (jogadorProximo) {
        	if(Game.player.interagindo) {
        		 if (Game.mapaAtual == Game.mapaContador.mapa08) {
        			if (Game.mundo.escolhaFeitaNun == false) {
        				dialogoDois(g);
        				
        				if (opcaoUm == true) {
            				dialogoTres(g);
            			} else if (opcaoDois == true) {
            				dialogoQuatro(g);
            			} else if (opcaoTres == true) {
            				dialogoCinco(g);
            			}
        			} else if (Game.mundo.escolhaFeitaNun  == true) {
        				dialogoSeis(g);
        			}
        		}
        	} else {
        		Game.dialogo.linhaDialogo = 0;
        		Game.dialogo.textoUm.isEmpty();
        	}
    	} else {
        }
		
	
	    
	}


}

