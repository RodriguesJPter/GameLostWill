package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import holyStudio.Mundo.Camera;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.Player;
import holyStudio.entidade.Solido;
import holyStudio.main.Game;

public class NpcMercador extends Entidade {
	
	public int estadoAtual = 1;
	
	 public static boolean jogadorProximo = false;
	
	private boolean dialogoAutomatico = true;
	
	private double jogadorProxi = 1;
	
	public boolean opcaoUm = false;
	public boolean opcaoDois = false;
	public boolean opcaoTres = false;
	
	
	

	private String textopreco = "";

	public BufferedImage[] npcRightP;
	public BufferedImage[] npcLeftP;
	
	public String textoOutro;
	
	public boolean acao;
	
	public Player player;
	
	private Timer timer;
	private boolean alternarTexto = false;
	private String[] frases = {
		"Veja o que eu tenho."
	};

	private int indiceAtual = 0;

	private ArrayList<Entidade> itensDisponiveis;
	
	public static JFrame jframe;
	
	private String textoProximo = "Pressione Q para comprar";
	
	private String textodialogo1 = "";
	
	public int direita = 1, esquerda = 0;
	
	public int movimentacao = 0;
	
	public int direcaoAtual = direita;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 20;
	
	public boolean selecionarRight, selecionarLeft;
	
	public boolean lojaAberta = false ;
	
	public int itemUm = 0 ;
	public int itemDois = 0 ;
	public int itemTres = 0 ;
	
	
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
 
	public NpcMercador(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		 
		npcRightP = new BufferedImage[5];
		npcLeftP = new BufferedImage[5];
		
		for(int i = 0; i < 5; i++) {
			npcRightP[i] = Game.sprite.getSprite(64, 400, 49, 51);
		}

		for(int i = 0; i < 5; i++) {
			npcLeftP[i] = Game.sprite.getSprite(114, 400, 49, 51);
		}

	}
	

	public void imagem(Graphics g) {
		g.drawImage(Entidade.aparenciaMercador ,  240, 70, jframe);
	}
	
	@Override
	public void tick() {
		if(!colisao((int)x,(int)(y+2))) {
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
        
        
        if (jogadorProximo) {
        	if (opcaoTres == true) {
        		Game.dialogo.comprando = true;
        		//System.out.println("deveria estar comprando");
        	}
        }
        
	}
	
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
	
	public void dialogoDois(Graphics g) {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = " hum...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "uhum...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "eu sou um vendedor...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = "eu sou um vendedor?...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "oh uma pessoa real!!";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	Game.dialogo.textoUm = "Ola, eu sou um mercador";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "quer ver o que eu tenho ?!";
	        	Game.inventario.inventarioAberto = false;
	        	Game.dialogo.escolendo = true;
	        	if (Game.dialogo.comprando == false) {
	        		dialogoDoisOpcaoUm(g);
	        	}
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
      g.drawString("quem e voce?!", x + 15, y + 20);
	    
      g.drawImage(Entidade.escolhaDeFala , x, y + 34, jframe);;
	    g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.PLAIN, 12));
      g.drawString("Loja", x + 15, y + 53);
      
      g.drawImage(Entidade.escolhaDeFala , x, y + 68, jframe);
	    g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.PLAIN, 12));
      g.drawString("terminar conversa", x + 15, y + 88);
	    
		
		 switch (Game.dialogo.opcaoDialogo) {
	        case 0:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 8, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("quem e voce?!", x + 15, y + 20);
	            
	            if (Game.player.selecionado) {
	            	opcaoDois = true;
	            	Game.dialogo.linhaDialogo = 0;
	            	Game.player.selecionado = false;
	            }
	            
	        	break;
	        case 1:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 42, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("Loja", x + 15, y + 53);
	            
	            if (Game.player.selecionado) {
	            	opcaoTres = true;
	            	Game.dialogo.comprando = true;
	            	Game.player.selecionado = false;
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
	            	Game.player.selecionado = false;
	            }
	        	break;
	        
	      
		 }
		
	}
	
		 public void dialogoQuatro(Graphics g) {
				
			 switch (Game.dialogo.linhaDialogo) {
		        case 0:
		        	Game.dialogo.textoUm = " ah voce quer saber como continuar";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 1:
		        	Game.dialogo.textoUm = "voce precisa pegar a chave";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 2:
		        	Game.dialogo.textoUm = "onde esta a chave??";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 3:
		        	Game.dialogo.textoUm = "ele esta com o cachorro";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 4:
		        	Game.dialogo.textoUm = "e so voce ir pra esquerda";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 5:
		        	Game.dialogo.textoUm = "ESQUERDA... ESQUERDA... ESQUERDA";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 6:
		        	Game.dialogo.textoUm = "";
		        	Game.inventario.inventarioAberto = false;
		        	Game.dialogo.escolendo = true;
		        	opcaoDois = false;
		        	Game.dialogo.linhaDialogo = 6;
		        	break;
			 
			 }
		 }
		 
		 public void renderLojinha(Graphics g) {
		        int lojinhaX = 80;
		        int lojinhaY = 35;
		        int larguraLojinha = 59;
		        int alturaLojinha = 50;
		        int campoX = 133;
		        int campoY = 70;
		        int campoHeight = 20;
		        int campoItemx = 16;
		        int campoItemY = 16;
		        
		        Game.dialogo.escolendo = false;
		        
		        g.drawImage(Entidade.imagemDaLoja , lojinhaX, lojinhaY, jframe);

		        g.setColor(Color.WHITE);
		        g.setFont(new Font("Arial", Font.PLAIN, 8));
		        g.drawString(textopreco, lojinhaX + 56, lojinhaY + 65);
		        
		        g.drawImage(Entidade.frasco, campoX, campoY, jframe);
		        
		        if (Game.inventario.laminaDupla == 0) {
		        	g.drawImage(Entidade.iconL, campoX + 19, campoY, jframe);
		        }
		        
		        g.setColor(Color.GRAY);
		        g.fillRect(lojinhaX + 62, lojinhaY + 117, campoItemx + 20, campoItemY - 5);
		        g.setColor(Color.WHITE);
		        g.setFont(new Font("Arial", Font.PLAIN, 8));
		        g.drawString("Fechar", lojinhaX + 68, lojinhaY + 125);

		        
		        if(Game.inventario.cranio == 0) {
		        	g.drawImage(Entidade.cranio, campoX + 38, campoY, jframe);
		        }
		        
		        switch (Game.dialogo.estadoAtualloja) {
		         case 0:
		        	 Game.dialogo.textoUm = "Frasco de sangue";
		        	 g.setColor(Color.RED);
			         g.fillRect(lojinhaX + 53, lojinhaY + 34, campoItemx, campoItemY);
			         g.drawImage(Entidade.frasco, campoX, campoY, jframe);	  
			         textopreco = "025";
			         if (Game.player.selecionado == true) {
			        	        if (Game.inventario.numeroDeWill >= 25 ) { 
			        	            Game.inventario.numeroDeWill -= 25; 
			        	            Game.inventario.numeroFrasco += 1;
			        	            Game.player.selecionado = false;
			        	            Game.dialogo.compra = false;
			        	        } else {
			        	            textopreco = "insuficiente";
			        	        }
			        	}

		        	 break;
		         case 1:
		        	 Game.dialogo.textoUm = "Lamina Dupla";
		        	 g.setColor(Color.RED);
			         g.fillRect(lojinhaX + 72, lojinhaY + 34, campoItemx, campoItemY);
			        
			         if(Game.inventario.laminaDupla == 0) {
			        	 g.drawImage(Entidade.iconL, campoX + 19, campoY, jframe);
				         textopreco = "050";
				         if (Game.player.selecionado == true) {
			        	        if (Game.inventario.numeroDeWill >= 50 ) { 
			        	            Game.inventario.numeroDeWill -= 50; 
			        	            Game.inventario.laminaDupla = 1;
			        	            Game.player.selecionado = true;
			        	            Game.dialogo.compra = false;
			        	        } else {
			        	            textopreco = "insuficiente";
			        	        }
			         }
			        
		        	 }
		             break;
		         case 2:
		        	 Game.dialogo.textoUm = "Cranio de Gato";
		        	 g.setColor(Color.RED);
			         g.fillRect(lojinhaX + 91, lojinhaY + 34, campoItemx, campoItemY);
			            if (Game.inventario.cranio == 0) {
			                g.drawImage(Entidade.cranio, campoX + 38, campoY, jframe);
			                textopreco = "100";
			                if (Game.player.selecionado == true) {
			        	        if (Game.inventario.numeroDeWill >= 100 ) { 
			        	            Game.inventario.numeroDeWill -= 100; 
			        	            Game.inventario.cranio = 1; 
			        	            Game.player.selecionado = false;
			        	            Game.dialogo.compra = false;
			        	        } else {
			        	            textopreco = "insuficiente";
			        	        }
			        	}
			            } else {
			            	textopreco = "esgotado";
			            }
		             break;
		         case 3:
		        	 Game.dialogo.textoUm = "voltar a conversar";
		        	    g.setColor(Color.RED);
		    	        g.fillRect(lojinhaX + 62, lojinhaY + 117, campoItemx + 20, campoItemY - 5);
		    	        g.setColor(Color.WHITE);
		    	        g.setFont(new Font("Arial", Font.PLAIN, 8));
		    	        g.drawString("Fechar", lojinhaX + 68, lojinhaY + 125);
		    	        textopreco = "";
		    	        
		    	        if (Game.player.selecionado == true) {
		    	        	opcaoTres = false;
		    	        	Game.player.selecionado = false;
		    	        	Game.player.interagindo = false;
		    	        	Game.dialogo.comprando = false;
		    	        	
		    	        }
		    	        
		    	        
		        	 break;
		         }
		    }
	
	@Override
	public void render(Graphics g) {
		
		if (jogadorProximo && !Game.player.interagindo) {
			 g.drawImage(Entidade.balaoDeFala, this.getX() - Camera.x + 10, this.getY() - Camera.y - 60, null);
		}
		
	    if (direcaoAtual == direita && movimentacao == 0) {
	        g.drawImage(npcRightP[0], this.getX() - Camera.x, this.getY() - Camera.y - 34, null);
	    }

	    if (direcaoAtual == esquerda && movimentacao == 0) {
	        g.drawImage(npcLeftP[0], this.getX() - Camera.x, this.getY() - Camera.y - 34, null);
	    }
	    if(Game.player.interagindo) {
			if(jogadorProximo) {
				imagem(g);
			}
		 } else {
			 
		 }
	    
	    if (jogadorProximo) {
        	if(Game.player.interagindo) {
        		 if (Game.mapaAtual == Game.mapaContador.mapa06) {
        			if (Game.dialogo.comprando == false) {
        				dialogoDois(g);
        			} 
        			if (opcaoUm == true) {
        				
        			} else if (opcaoDois == true) {
        				dialogoQuatro(g);
        			} else if (opcaoTres == true) {
        				renderLojinha(g);
        			}
        		}
        	} else {
        		Game.dialogo.linhaDialogo = 0;
        		Game.dialogo.textoUm.isEmpty();
        	}
    	} else {
        }
	    
//	    g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//        g.setColor(Color.BLACK);
//        g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
	}


}

