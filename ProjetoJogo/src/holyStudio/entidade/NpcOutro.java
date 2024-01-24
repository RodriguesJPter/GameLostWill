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

public class NpcOutro extends Entidade {
	
	public static boolean jogadorProximo = false;
	
	private boolean dialogoAutomatico = true;
	
	private double jogadorProxi = 1;
	
	public static BufferedImage quadro = Game.sprite.getSprite(752, 144, 32, 48);
	
	public BufferedImage[] npcRightP;
	public BufferedImage[] npcLeftP;
	
	public String textoOutro;
	
	public boolean acao;
	
	public static JFrame jframe;
	
	public String outro;
	
	public Player player;
	
	private Timer timer;
	
	private boolean opcaoUm = false;
	private boolean opcaoDois = false;
	private boolean opcaoTres = false;
	
	
	
	private boolean opcaoUm02 = false;
	private boolean opcaoDois02 = false;
	private boolean opcaoTres02 = false;
	
	private boolean opcaoTres02Dois = false;
	

	
	private boolean alternarTexto = false;

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
 
	public NpcOutro(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		npcRightP = new BufferedImage[5];
		npcLeftP = new BufferedImage[5];
		
		for(int i = 0; i < 5; i++) {
			npcRightP[i] = Game.sprite.getSprite(0, 400, 28, 57);
		}

		for(int i = 0; i < 5; i++) {
			npcLeftP[i] = Game.sprite.getSprite(30, 400, 28, 57);
		}

	}
	
	public void imagem(Graphics g) {
		if (opcaoTres02 == true && !Game.mundo.escolhaFeitaDoisOutro == true) {
			g.drawImage(Entidade.aparenciaOutroDois , 240, 60, jframe);
		} else {
			g.drawImage(Entidade.aparenciaOutro , 240, 70, jframe);
		}
		
		if (Game.mundo.escolhaFeitaDoisOutro == false && Game.mapaAtual == Game.mapaContador.casa03) {
			g.drawImage(Entidade.pintura , 140, 30, jframe);
		} else if (Game.mundo.escolhaFeitaDoisOutro == true) {
			g.drawImage(Entidade.pinturacencura , 140, 30, jframe);
		}
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
        
//        System.out.println("Distância até o jogador: " + distancia);
        
     
        
	}
	
	public void dialogoUm () {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = " OH, voce levantou... ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "Escute bem! voce e o 'Broken One'. eu so te reanimei...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "por que querendo ou nao voce ainda e util pra mim";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = "lembre-se disso...  voce vai matar o 'AMOR' ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	Game.dialogo.textoUm = "Ta esperando o que? anda, passe primeiro na vila ao sul";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "";
	        	Game.inventario.inventarioAberto = false;
	        	Game.player.interagindo = false;
	        	break;
		 
		 }
		
	}
	public void dialogoDois(Graphics g) {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = " tao bela, a cidade dourada";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "aquele castelo ja foi a minha casa";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "ja foi o meu lar... o nosso lar";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = "mas isso nao importa mais";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "agora eu vou destrui-la ate nao sobrar mais nada";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	Game.dialogo.textoUm = "ela nao merece aquele castelo";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "eu farei todos sofrerem como eu !!!";
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
        g.drawString("De quem voce ta falando ?", x + 15, y + 20);
	    
        g.drawImage(Entidade.escolhaDeFala , x, y + 34, jframe);;
	    g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("voce sente falta daquela epoca ?", x + 15, y + 53);
        
        g.drawImage(Entidade.escolhaDeFala , x, y + 68, jframe);
	    g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("nao dizer nada", x + 15, y + 88);
	    
		
		 switch (Game.dialogo.opcaoDialogo) {
	        case 0:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 8, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("De quem voce ta falando ?", x + 15, y + 20);
	            
	            if (Game.player.selecionado) {
	            	opcaoUm = true;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	            
	        	break;
	        case 1:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 42, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("voce sente falta daquela epoca ?", x + 15, y + 53);
	            
	            if (Game.player.selecionado) {
	            	opcaoDois = true;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	            
	        	break;
	        case 2:
	        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 76, jframe);
	    	    g.setColor(Color.WHITE);
	            g.setFont(new Font("Arial", Font.PLAIN, 12));
	            g.drawString("nao dizer nada", x + 15, y + 88);
	            
	            if (Game.player.selecionado) {
	            	opcaoTres = true;
	            	Game.dialogo.linhaDialogo = 0;
	            }
	        	break;
	      
		 }
		
	}
	
	public void dialogoTres(Graphics g) {
		
		 switch (Game.dialogo.linhaDialogo) {
	        case 0:
	        	Game.dialogo.textoUm = " VOCE FALA ?????";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 1:
	        	Game.dialogo.textoUm = "nao esperava por isso... mas fazer o que ne...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 2:
	        	Game.dialogo.textoUm = "bem nao importa de quem eu estou falando ";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 3:
	        	Game.dialogo.textoUm = " o seu objetivo continua o mesmo";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 4:
	        	Game.dialogo.textoUm = "mate o Amor...";
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 5:
	        	
	        	if (Game.inventario.sword == 0) {
	        		Game.dialogo.textoUm = "ah e pegue aquela espada ali, ela era minha";
	        	} else if (Game.inventario.sword == 1) {
	        		Game.dialogo.textoUm = "ah parece que voce ja pegou a minha espada.";
	        	}
	        	Game.inventario.inventarioAberto = false;
	        	break;
	        case 6:
	        	Game.dialogo.textoUm = "";
	        	Game.inventario.inventarioAberto = false;
	        	Game.dialogo.escolendo = true;
	        	Game.player.interagindo = false;
	        	Game.mundo.escolhaFeitaOutro = true;
	        	break;
		 
		 }
	}
		 public void dialogoQuatro(Graphics g) {
				
			 switch (Game.dialogo.linhaDialogo) {
		        case 0:
		        	Game.dialogo.textoUm = " VOCE FALA ?????";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 1:
		        	Game.dialogo.textoUm = "nao esperava por isso... mas fazer o que ne...";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 2:
		        	Game.dialogo.textoUm = "eu sinto falta da ideia";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 3:
		        	Game.dialogo.textoUm = " de como eu me sentia, era um tempo de ouro";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 4:
		        	Game.dialogo.textoUm = "mas esses momentos nao existe mais";
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 5:
		        	if (Game.inventario.sword == 0) {
		        		Game.dialogo.textoUm = "ah e pegue aquela espada ali, ela era minha";
		        	} else if (Game.inventario.sword == 1) {
		        		Game.dialogo.textoUm = "ah parece que voce ja pegou a minha espada.";
		        	}
		        	Game.inventario.inventarioAberto = false;
		        	break;
		        case 6:
		        	Game.dialogo.textoUm = "";
		        	Game.inventario.inventarioAberto = false;
		        	Game.dialogo.escolendo = true;
		        	Game.player.interagindo = false;
		        	Game.mundo.escolhaFeitaOutro = true;
		        	break;
			 
			 }
		 }
			 
			 public void dialogoCinco(Graphics g) {
					
				 switch (Game.dialogo.linhaDialogo) {
			        case 0:
			        	Game.dialogo.textoUm = " nao fique me emcarando";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 1:
			        	Game.dialogo.textoUm = "desculpe te alugar dessa forma...";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 2:
			        	Game.dialogo.textoUm = "acho que eu fiquei um poco sentimental";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 3:
			        	Game.dialogo.textoUm = " bem, vamos indo";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 4:
			        	Game.dialogo.textoUm = "antes que eu me esqueca";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 5:
			        	if (Game.inventario.sword == 0) {
			        		Game.dialogo.textoUm = "ah e pegue aquela espada ali, ela era minha";
			        	} else if (Game.inventario.sword == 1) {
			        		Game.dialogo.textoUm = "ah parece que voce ja pegou a minha espada.";
			        	}
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 6:
			        	Game.dialogo.textoUm = "";
			        	Game.inventario.inventarioAberto = false;
			        	Game.dialogo.escolendo = true;
			        	Game.player.interagindo = false;
			        	Game.mundo.escolhaFeitaOutro = true;
			        	break;
				 
				 }
		
	}
			 
			 public void dialogoSeis(Graphics g) {
					
				 switch (Game.dialogo.linhaDialogo) {
			        case 0:
			        	Game.dialogo.textoUm = " esse lugar so tem almas perdidas";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 1:
			        	Game.dialogo.textoUm = "depois dessa guerra sem sentido";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 2:
			        	Game.dialogo.textoUm = "soldados lutando numa gurra que ja acabou";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 3:
			        	Game.dialogo.textoUm = " wendigos comendo seus camaradas pois nao tem";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 4:
			        	Game.dialogo.textoUm = "suprimentos suficientes... que ridiculo";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 5:
			        	Game.dialogo.textoUm = "ela tem que pagar";
			        	Game.inventario.inventarioAberto = false;
			        	break;
			        case 6:
			        	Game.dialogo.textoUm = "";
			        	Game.inventario.inventarioAberto = false;
			        	Game.dialogo.escolendo = true;
			        	Game.player.interagindo = false;
			        	break;
				 
				 }
		
	}
			 
			 public void dialogoTresOpcaoUm(Graphics g) {
					int x = 40;
					int y = 80;
					int largura = 200;
					int altura = 30;

				    
					g.drawImage(Entidade.escolhaDeFala , x, y, jframe);
				    g.setColor(Color.BLACK);
			        g.setFont(new Font("Arial", Font.PLAIN, 12));
			        g.drawString("quem e essa ?", x + 15, y + 20);
				    
			        g.drawImage(Entidade.escolhaDeFala , x, y + 34, jframe);;
				    g.setColor(Color.BLACK);
			        g.setFont(new Font("Arial", Font.PLAIN, 12));
			        g.drawString("o que realmente aconteceu?", x + 15, y + 53);
			        
			        g.drawImage(Entidade.escolhaDeFala , x, y + 68, jframe);
				    
			        if (Game.mundo.eventoBossMorto == 0) {
			        	g.setColor(Color.BLACK);
				        g.setFont(new Font("Arial", Font.PLAIN, 12));
				        g.drawString("v%&$*#@! ?????????", x + 15, y + 88);
			        } else {
			        	g.setColor(Color.BLACK);
				        g.setFont(new Font("Arial", Font.PLAIN, 12));
				        g.drawString("voce fala como se importasse.", x + 15, y + 88);
			        }
					
					 switch (Game.dialogo.opcaoDialogo) {
				        case 0:
				        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 8, jframe);
				    	    g.setColor(Color.WHITE);
				            g.setFont(new Font("Arial", Font.PLAIN, 12));
				            g.drawString("quem e essa ?", x + 15, y + 20);
				            
				            if (Game.player.selecionado) {
				            	opcaoUm02 = true;
				            	Game.dialogo.linhaDialogo = 0;
				            	
				            }
				            
				        	break;
				        case 1:
				        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 42, jframe);
				    	    g.setColor(Color.WHITE);
				            g.setFont(new Font("Arial", Font.PLAIN, 12));
				            g.drawString("o que realmente aconteceu?", x + 15, y + 53);
				            
				            if (Game.player.selecionado) {
				            	opcaoDois02 = true;
				            	Game.dialogo.linhaDialogo = 0;
				            }
				            
				        	break;
				        case 2:
				        	g.drawImage(Entidade.confirmacaoDeFala , x + 196, y + 76, jframe);
				        	if (Game.mundo.eventoBossMorto == 0) {
				        		 g.setColor(Color.WHITE);
						         g.setFont(new Font("Arial", Font.PLAIN, 12));
						         g.drawString("v%&$*#@! ?????????", x + 15, y + 88);
						            
						            if (Game.player.selecionado) {
						            	opcaoTres02 = true;
						            	Game.dialogo.linhaDialogo = 0;
						            		Game.mundo.esteveVoid = 0;
						            }
				        	} else {
				        		 g.setColor(Color.WHITE);
						         g.setFont(new Font("Arial", Font.PLAIN, 12));
						         g.drawString("voce fala como se importasse.", x + 15, y + 88);
						            
						            if (Game.player.selecionado) {
						            	opcaoTres02Dois = true;
						            	Game.dialogo.linhaDialogo = 0;
						            }
				        	}
				    	   
				        	break;
				      
					 }
					
				}
				
				public void dialogoSete(Graphics g) {
					
					 switch (Game.dialogo.linhaDialogo) {
				        case 0:
				        	Game.dialogo.textoUm = " ela?";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 1:
				        	Game.dialogo.textoUm = "a rainha desse reino";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 2:
				        	Game.dialogo.textoUm = "e a rasao dessa merda de guerra ter";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 3:
				        	Game.dialogo.textoUm = " comecado";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 4:
				        	Game.dialogo.textoUm = "mas vamos deixar isso quieto";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 5:
				        	Game.dialogo.textoUm = "... *sun*";
				        	Game.inventario.inventarioAberto = false;
				        	break;
				        case 6:
				        	Game.dialogo.textoUm = "";
				        	Game.inventario.inventarioAberto = false;
				        	Game.dialogo.escolendo = true;
				        	Game.player.interagindo = false;
				        	Game.mundo.escolhaFeitaDoisOutro = true;
				        	break;
					 
					 }
				}
					 public void dialogoOito(Graphics g) {
							
						 switch (Game.dialogo.linhaDialogo) {
					        case 0:
					        	Game.dialogo.textoUm = "eu nao vou te falar assim tao facil";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 1:
					        	Game.dialogo.textoUm = "alem do mais voce nao precisa saber";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 2:
					        	Game.dialogo.textoUm = "meu objetivo continua o mesmo";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 3:
					        	Game.dialogo.textoUm = " eu so nao faco eu mesmo porque...";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 4:
					        	Game.dialogo.textoUm = "bem voce nao precisa saber tambem ";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 5:
					        	Game.dialogo.textoUm = "voce nao tem valor!";
					        	Game.inventario.inventarioAberto = false;
					        	break;
					        case 6:
					        	Game.dialogo.textoUm = "";
					        	Game.inventario.inventarioAberto = false;
					        	Game.dialogo.escolendo = true;
					        	Game.player.interagindo = false;
					        	Game.mundo.escolhaFeitaDoisOutro = true;
					        	break;
						 
						 }
					 }
						 
						 public void dialogoNove(Graphics g) {
								
							 switch (Game.dialogo.linhaDialogo) {
						        case 0:
						        	Game.dialogo.textoUm = "OI J@$%";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 1:
						        	Game.dialogo.textoUm = "quantas vezes a gente teve essa";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 2:
						        	Game.dialogo.textoUm = "conversa??";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 3:
						        	Game.dialogo.textoUm = "como que voce esta se sentindo ??";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 4:
						        	Game.dialogo.textoUm = "imagino que frustrado ja que nao consegue";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 5:
						        	Game.dialogo.textoUm = "controlar o seu corpo, bem... boa sorte.";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 6:
						        	Game.dialogo.textoUm = "";
						        	Game.inventario.inventarioAberto = false;
						        	Game.dialogo.escolendo = true;
						        	Game.player.interagindo = false;
						        	Game.mundo.escolhaFeitaDoisOutro = true;
						        	break;
							 
							 }
					
				}
						 
						 public void dialogoDez(Graphics g) {
								
							 switch (Game.dialogo.linhaDialogo) {
						        case 0:
						        	Game.dialogo.textoUm = "por que voce esta me perturbando de novo ??";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 1:
						        	Game.dialogo.textoUm = "vai la abrir o portao";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 2:
						        	Game.dialogo.textoUm = "depois a gente conversa mais";
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
						 
						 public void dialogoOnze(Graphics g) {
								
							 switch (Game.dialogo.linhaDialogo) {
						        case 0:
						        	Game.dialogo.textoUm = "...";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 1:
						        	Game.dialogo.textoUm = "tinha me esquecido como ela era bonita";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 2:
						        	Game.dialogo.textoUm = "...";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 3:
						        	Game.dialogo.textoUm = " nao e atoa que ela possui muitos";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 4:
						        	Game.dialogo.textoUm = "seguidores";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 5:
						        	Game.dialogo.textoUm = "eu achei que fosse verdade";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 6:
						        	Game.dialogo.textoUm = "hum?!";
						        	Game.inventario.inventarioAberto = false;
						        	Game.dialogo.escolendo = true;
						        	dialogoTresOpcaoUm(g);
						        	break;
							 
							 }
					
				}
						 
						 public void dialogoDoze(Graphics g) {
								
							 switch (Game.dialogo.linhaDialogo) {
						        case 0:
						        	Game.dialogo.textoUm = "Cuidado com o que fala";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 1:
						        	Game.dialogo.textoUm = "Voce pode ter certeza";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 2:
						        	Game.dialogo.textoUm = "que nao sobrou nada mais do";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 3:
						        	Game.dialogo.textoUm = "que puro ODIO";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 4:
						        	Game.dialogo.textoUm = "eu vou atras do que resta dela";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 5:
						        	Game.dialogo.textoUm = "so assim, eu terei paz";
						        	Game.inventario.inventarioAberto = false;
						        	break;
						        case 6:
						        	Game.dialogo.textoUm = "";
						        	Game.inventario.inventarioAberto = false;
						        	Game.dialogo.escolendo = true;
						        	Game.player.interagindo = false;
						        	Game.mundo.escolhaFeitaDoisOutro = true;
						        	break;
							 
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
	
	@Override
	public void render(Graphics g) {
		
		if (jogadorProximo && !Game.player.interagindo) {
			 g.drawImage(Entidade.balaoDeFala, this.getX() - Camera.x + 10, this.getY() - Camera.y - 60, null);
		}
		
		if (Game.mapaAtual == Game.mapaContador.casa03) {
			 g.drawImage(quadro, this.getX() - Camera.x + 35, this.getY() - Camera.y - 32, null);
		}
		
	    if (direcaoAtual == direita && movimentacao == 0) {
	        g.drawImage(npcRightP[0], this.getX() - Camera.x, this.getY() - Camera.y - 40, null);
	    }

	    if (direcaoAtual == esquerda && movimentacao == 0) {
	        g.drawImage(npcLeftP[0], this.getX() - Camera.x, this.getY() - Camera.y - 40, null);
	    }
	    
		if (jogadorProximo) {
			if(Game.player.interagindo) {
				imagem(g);
			}
		}
	    
	    if (jogadorProximo) {
        	Game.npcProx = outro;
        	if(Game.player.interagindo) {
        		if (Game.mapaAtual == Game.mapaContador.mapa00) {
        			dialogoUm();
        		} else if (Game.mapaAtual == Game.mapaContador.mapa02) {
        			if (Game.mundo.escolhaFeitaOutro == false) {
        				dialogoDois(g);
        				
        				if (opcaoUm == true) {
            				dialogoTres(g);
            			} else if (opcaoDois == true) {
            				dialogoQuatro(g);
            			} else if (opcaoTres == true) {
            				dialogoCinco(g);
            			}
        			} else if (Game.mundo.escolhaFeitaOutro == true) {
        				dialogoSeis(g);
        			}
        		} else if (Game.mapaAtual == Game.mapaContador.casa03) {
        			if (Game.mundo.escolhaFeitaDoisOutro == false) {
        				dialogoOnze(g);
        				
        				if (opcaoUm02 == true) {
            				dialogoSete(g);
            			} else if (opcaoDois02 == true) {
            				dialogoOito(g);
            			} else if (opcaoTres02 == true) {
            				dialogoNove(g);
            			} else if (opcaoTres02Dois == true) {
            				dialogoDoze(g);
            			}
        			} else if (Game.mundo.escolhaFeitaDoisOutro == true) {
        				dialogoDez(g);
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

