package holyStudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import holyStudio.Graficos.SpriteSheet;
import holyStudio.Mundo.Mundo;
import holyStudio.entidade.BlocoBossRoom;
import holyStudio.entidade.BlocoParaInimigo;
import holyStudio.entidade.BlocoTroca01;
import holyStudio.entidade.BlocoTroca02;
import holyStudio.entidade.BlocoTroca03;
import holyStudio.entidade.BlocoTroca04;
import holyStudio.entidade.BossDogKnight;
import holyStudio.entidade.Casa01;
import holyStudio.entidade.Catedral01;
import holyStudio.entidade.Ceu;
import holyStudio.entidade.Corredor;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.Espinhos;
import holyStudio.entidade.EstatuaUm;
import holyStudio.entidade.InimigoIronDoll;
import holyStudio.entidade.InimigoRato;
import holyStudio.entidade.InimigoSoldado;
import holyStudio.entidade.InimigoSoldadoRival;
import holyStudio.entidade.InimigoWendigo;
import holyStudio.entidade.NpcDoll;
import holyStudio.entidade.NpcMercador;
import holyStudio.entidade.NpcMoon;
import holyStudio.entidade.NpcNun;
import holyStudio.entidade.NpcOutro;
import holyStudio.entidade.NpcUndead;
import holyStudio.entidade.Player;
import holyStudio.entidade.PortaMadeira;
import holyStudio.entidade.PortaMadeiraDois;
import holyStudio.entidade.PortaMadeiraTres;
import holyStudio.entidade.PosteUm;
import holyStudio.entidade.PropCenarioUm;
import holyStudio.entidade.PropEspada;
import holyStudio.entidade.PropGrama;
import holyStudio.entidade.Solido;
import holyStudio.entidade.Will;
import holyStudio.entidade.Yellow;
import holyStudio.entidade.caxote;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {


	private static final long serialVersionUID = 1L;

	public static JFrame jframe;
	
	private Timer timer;

	private Thread thread;
	
	private boolean isRunning = true;

	public final String titulo = "Lost Will";

	public static int WIDTH = 390;
	public static int HEIGHT = 240;
	public static int SCALE = 3;

	private BufferedImage fundo;
	
	public static List<Yellow> thing;
	
	public static List<BlocoBossRoom> BBR;

	public static List<Entidade> entidade;
	public static SpriteSheet sprite;
	
	public static SpriteSheet spriteDois;

	public static List<Solido> solido;
	public static List<Espinhos> espinho;
	
	public static List<NpcNun> nun;
	
	public static List<InimigoRato> rato;
	
	public static List<InimigoSoldado> soldado;
	
	public static List<InimigoWendigo> wendigo;
	
	public static List<InimigoSoldadoRival> rival;
	
	public static List<InimigoIronDoll> ironDoll;
	
	public static List<NpcUndead> undead;
	
	public static List<BossDogKnight> dogK;
	public static BossDogKnight BossUm;
	
	public static List<PortaMadeira> porta;
	public static List<PortaMadeiraDois> portaDois;
	public static List<PortaMadeiraTres> portaTres;
	
	public static PortaMadeira portUm;
	public static PortaMadeiraDois portDois;
	public static PortaMadeiraTres portTres;
	
	public static List<BlocoTroca01> bt01;
	public static BlocoTroca01 b01;
	
	public static List<BlocoTroca02> bt02;
	public static BlocoTroca02 b02;
	
	public static List<BlocoTroca03> bt03;
	public static BlocoTroca03 b03;
	
	public static List<BlocoTroca04> bt04;
	public static BlocoTroca04 b04;
	
	public static List<PropGrama> propG;
	
	public static InimigoSoldado soldier;
	
	public static List<NpcMoon> npcMoon;
	
	public static NpcMoon moon;
	
	public static List<NpcOutro> npcOutro;
	
	public static NpcOutro outro;
	
	public static List<PropEspada> prope;
	public static PropEspada props;
	
	public static List<PropCenarioUm> propUm;
	
	public static List<Corredor> corredor;
	
	public static List<EstatuaUm> estatua01;
	
	public static List<BlocoParaInimigo> fimTrajetoria;
	
	public static List<NpcDoll> npcDoll;
	
	public static NpcDoll doll;
	
	public static List<NpcMercador> npcMercador;
	
	public static NpcMercador mercador;

	public static List<PosteUm> poste;
	
	public static List<caxote> caixa;
	
	public static List<Casa01> casaUm;
	public static List<Catedral01> catedral;
	
	public static List<Will> will;
	
	public static List<Ceu> fundoCenario;
	public static SpriteSheet ceu;

	public static Player player;
	
	public static Entidade enti;	
	
	private boolean enterPressionado = false;
	
	private boolean trocaDeCenario = false;
	
	public static Mundo mundo;
	public static UserInterface ui;
	
	public static Dialogos dialogo;
	
	public static Inventario inventario;

	public static String npcProx;
	
	public static int level = 1, levelMaximo = 20;
	public static int casa = 1, casaMaximo = 20;
	
	public static ContadorDeEntidade mapaContador;
	
	public static String  mapaAtual = mapaContador.mapa00;
	public static String mapaAnterior;
	
	
	public static int posicaoPlayer = 0;
	
	public Game() {
		addMouseListener(this);
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		inventario = new Inventario();
	    ui = new UserInterface();
	    dialogo = new Dialogos();
		fundo = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		entidade = new ArrayList<>();
		sprite = new SpriteSheet("/SpritesheetQuatro.png");
		fundoCenario = new ArrayList<>();
		thing = new ArrayList<>();
		BBR = new ArrayList<>();
		prope = new ArrayList<>();
		propUm = new ArrayList<>();
		corredor = new ArrayList<>();
		propG = new ArrayList<>();
		npcMoon = new ArrayList<>();
		npcOutro = new ArrayList<>();
		npcDoll = new ArrayList<>();
		npcMercador = new ArrayList<>();
		nun = new ArrayList<>();
		estatua01 = new ArrayList<>();
		rato = new ArrayList<>();
		will = new ArrayList<>();
		porta = new ArrayList<>();
		portaDois = new ArrayList<>();
		portaTres = new ArrayList<>();
		casaUm = new ArrayList<>();
		catedral = new ArrayList<>();
		caixa = new ArrayList<>();
		rival = new ArrayList<>();
		soldado = new ArrayList<>();
		dogK = new ArrayList<>();
		wendigo = new ArrayList<>();
		ironDoll = new ArrayList<>();
		undead = new ArrayList<>();
		bt01 = new ArrayList<>();
		bt02 = new ArrayList<>();
		bt03 = new ArrayList<>();
		bt04 = new ArrayList<>();
		ceu = new SpriteSheet("/ceu01.png");
		BossUm = new BossDogKnight(0, 0, 16, 16, sprite.getSprite(704, 144, 16, 16));
		portUm = new PortaMadeira(0, 0, 16, 16, sprite.getSprite(704, 144, 16, 16));
		portDois = new PortaMadeiraDois(0, 0, 16, 16, sprite.getSprite(704, 144, 16, 16));
		portTres = new PortaMadeiraTres(0, 0, 16, 16, sprite.getSprite(704, 144, 16, 16));
		moon = new NpcMoon(0, 336, 25, 53, sprite.getSprite(0, 336, 16, 16));
		outro = new NpcOutro(0, 336, 25, 53, sprite.getSprite(0, 336, 16, 16));
		props = new PropEspada(0, 0, 16, 16, sprite.getSprite(432, 310, 16, 16));
		soldier = new InimigoSoldado(3, 768, 46, 57, sprite.getSprite(3, 768, 46, 57));
		mercador = new NpcMercador(64, 400, 49, 51, sprite.getSprite(64, 400, 49, 51));
		player = new Player(0, 0, 35, 50, sprite.getSprite(0, 0, 35, 50));
		entidade.add(player);
		poste = new ArrayList<>();
		b01 = new BlocoTroca01(0, 0, 16, 16, sprite.getSprite(704, 144, 16, 16));
		mundo = new Mundo(mapaContador.mapa00);
		
	}

	public void initFrame() {
		jframe = new JFrame("Lost will");
		jframe.add(this);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	private void telaMorte(Graphics g){
	    int inventarioX = 55;
	    int inventarioY = 10;
	    int larguraInventario = 150;
	    int alturaInventario = 100;
	    int campoX = 30;
		int campoY = 115;
		int campoHeight = 20;

	    g.setColor(Color.BLACK);
	    g.fillRect(inventarioX - 100, inventarioY - 100, larguraInventario + 500, alturaInventario + 500);
	    g.setColor(Color.RED);
	    g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("VOCE MORREU", campoX + 85, campoY - 12);
        
        
        g.setColor(Color.RED);
	    g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("Pressione [E] para continuar", campoX + 92, campoY + 62);
        
        
//        g.setColor(Color.RED);
//	    g.fillRect(inventarioX + 50, inventarioY + 86, campoX + 17 , campoY - 100);
	    
//	    g.setColor(Color.BLACK);
//	    g.setFont(new Font("Arial", Font.PLAIN, 10));
//        g.drawString("voltar", inventarioX + 51, inventarioY + 96);
        
        
        if (Game.player.selecionado == true) {
        	Game.player.life = Game.player.maxLife;
        		Game.player.selecionado = false;
        		ressucitar();
        		System.out.println("Game Over");
        	} else {
        		
        	}
	   
	}
	
	
	 public void ressucitar() {
		 Game.level++;
			String Level = "level3.png";
			if(Game.level > Game.levelMaximo) {
				Game.level = 1;
			}	
				if(Game.player.morto == true && player.checkpointUm == true) {
						Level = "level3.png";
						Game.mapaAtual = Game.mapaContador.mapa03;
						Mundo.levelAtual = 0;
						Game.mapaAnterior = Game.mapaContador.mapa02;
						Game.posicaoPlayer = 3;
						Game.player.direcaoAtual = Game.player.direita;
						Game.player.morto = false;
						System.out.println("ressucitado");
						limpaCenario();
					
				 } else if(Game.player.morto == true && player.checkpointDois == true) {
						Level = "level0.png";
						Game.mapaAtual = Game.mapaContador.mapa00;
						Mundo.levelAtual = 0;
						Game.mapaAnterior = Game.mapaContador.mapa01;
						Game.posicaoPlayer = 3;
						Game.player.direcaoAtual = Game.player.direita;
						Game.player.morto = false;
						System.out.println("ressucitado");
						limpaCenario();
					
				 } 
				
			Mundo.newLevel(Level);

			
			System.out.println(Game.mapaAtual);
			System.out.println(Game.mapaAnterior);
			System.out.println(Game.posicaoPlayer);
	 }
	 
	 public void limpaCenario() {
			Game.bt01.clear();
			Game.bt02.clear();
			Game.bt03.clear();
			Game.bt04.clear();
			Game.casaUm.clear();
			Game.catedral.clear();
			Game.wendigo.clear();
			Game.soldado.clear();
			Game.undead.clear();
			Game.rato.clear();
			Game.dogK.clear();
			Game.BBR.clear();
			Game.fundoCenario.clear();
			Game.propUm.clear();
			Game.corredor.clear();
			Game.porta.clear();
			Game.portaDois.clear();
			Game.portaTres.clear();
			Game.ironDoll.clear();
			Game.nun.clear();
			Game.rival.clear();
			
	 }
	
	public static void main(String[] args) {
	 Game game = new Game();
	 game.start();
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}

	}
	
	public void tick() {
		
		for (BossDogKnight entiDog : dogK) {
			entiDog.tick();
		}
		
		for (NpcNun entiNun : nun) {
			entiNun.tick();
		}
		
		for (Ceu entiCeu : fundoCenario) {
			entiCeu.tick();
		}
		
		for (NpcUndead entiundead : Game.undead) {
			entiundead.tick();
		}
		for (InimigoWendigo entiWendigo : Game.wendigo) {
			entiWendigo.tick();
		}
		
		for (InimigoSoldado entisoldado : Game.soldado) {
			entisoldado.tick();
		}
		for (InimigoSoldadoRival entisoldadoRival : Game.rival) {
			entisoldadoRival.tick();
		}
		
		for (InimigoIronDoll entiIdoll : Game.ironDoll) {
			entiIdoll.tick();
		}

		for (Entidade enti : entidade) {
			enti.tick();
		}

		if (mundo.eventoBossMorto == 0) {
			for (BlocoBossRoom entiBBR : BBR) {
				entiBBR.tick();
			}
		}
		
		for (NpcOutro entiNpcOutro : npcOutro) {
			entiNpcOutro.tick();
		}

		for (PropEspada entiprope : prope) {
			entiprope.tick();
		}
		for (PropCenarioUm entipropeUm : propUm) {
			entipropeUm.tick();
		}
		
		for (EstatuaUm entiesta01 : estatua01) {
			entiesta01.tick();
		}
		
		for (PortaMadeira entiporta : porta) {
			entiporta.tick();
		}
		
		for (PortaMadeiraDois entiportaDois : portaDois) {
			entiportaDois.tick();
		}
		
		for (PortaMadeiraTres entiportaTres : portaTres) {
			entiportaTres.tick();
		}
		
		for (BlocoTroca01 entibt01 : bt01) {
			entibt01.tick();
		}
		for (BlocoTroca02 entibt02 : bt02) {
			entibt02.tick();
		}
		for (BlocoTroca03 entibt03 : bt03) {
			entibt03.tick();
		}
		for (BlocoTroca04 entibt04 : bt04) {
			entibt04.tick();
		}
		
		for (Yellow enti : Game.thing) {
			enti.tick();
		}
		
		for (NpcMercador entiNpcmercador : Game.npcMercador) {
			entiNpcmercador.tick();
		}
		
		for (NpcMoon entiNpcMoon : Game.npcMoon) {
			entiNpcMoon.tick();
		}
		
	}
	
	public static void endGame() {
	    	System.exit(0); 
	}

	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();
			if(buffer == null) {
				this.createBufferStrategy(3);
				return;
			}
			Graphics g = fundo.getGraphics();
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 0, WIDTH, HEIGHT);

			mundo.render(g);

			for (Ceu entiCeu : fundoCenario) {
				entiCeu.render(g);
			}
			if (mundo.eventoBossMorto == 0) {
				for (BlocoBossRoom entiBBR : BBR) {
					entiBBR.render(g);
				}
			}

			for (PosteUm entiPoste : poste) {
				entiPoste.render(g);
			}
			
			for (PropGrama entiGrama : propG) {
				entiGrama.render(g);
			}
			for (Casa01 entiCasaUm : casaUm) {
				entiCasaUm.render(g);
			}
			
			for (Catedral01 entiCatedral : catedral) {
				entiCatedral.render(g);
			}
			
			for (PortaMadeira entiporta : porta) {
				entiporta.render(g);
			}
			for (PortaMadeiraDois entiportaDois : portaDois) {
				entiportaDois.render(g);
			}
			for (PortaMadeiraTres entiportaTres : portaTres) {
				entiportaTres.render(g);
			}
			for (Corredor enticorredor : corredor) {
				enticorredor.render(g);
			}
			
			for (PropEspada entiprope : prope) {
				entiprope.render(g);
			}
			
			for (EstatuaUm entiesta01 : estatua01) {
				entiesta01.render(g);
			}
			
			for (NpcUndead entiundead : undead) {
				entiundead.render(g);
			}
			
			for (InimigoSoldado entiSoldado : soldado) {
				entiSoldado.render(g);
			}
			
			for (InimigoSoldadoRival entiSoldadoRival : rival) {
				entiSoldadoRival.render(g);
			}
			
			for (InimigoWendigo entiWendigo : wendigo) {
				entiWendigo.render(g);
			}
			
			for (Entidade enti : entidade) {
				enti.render(g);
			}
			
			for (NpcMoon entiNpcMoon : npcMoon) {
				entiNpcMoon.render(g);
			}
			
			for (NpcDoll entiNpcDoll : npcDoll) {
				entiNpcDoll.render(g);
			}
			
			for (NpcOutro entiNpcOutro : npcOutro) {
				entiNpcOutro.render(g);
			}
			for (NpcNun entiNun : nun) {
				entiNun.render(g);
			}
			
			for (NpcMercador entiNpcMercador : npcMercador) {
				entiNpcMercador.render(g);
			}
			
			for (BlocoTroca01 entibt01 : bt01) {
				entibt01.render(g);
			}
			for (BlocoTroca02 entibt02 : bt02) {
				entibt02.render(g);
			}
			for (BlocoTroca03 entibt03 : bt03) {
				entibt03.render(g);
			}
			
			for (BlocoTroca04 entibt04 : bt04) {
				entibt04.render(g);
			}
			
			for (PropCenarioUm entipropeUm : propUm) {
				entipropeUm.render(g);
			}
			
			for (Corredor enticorredor : corredor) {
				enticorredor.render(g);
			}
			
			
			
			for (BossDogKnight entiDog : dogK) {
				entiDog.render(g);
			}
			
			for (InimigoIronDoll entiIdoll : ironDoll) {
				entiIdoll.render(g);
			}
			
			
			for (Yellow enti : thing) {
				enti.render(g);
			}
			
			if (mapaAtual == mapaContador.mapa07) {
				
			} else {
			ui.render(g);
			
			inventario.render(g);
			
			
			}
			
			dialogo.render(g);
			
			if (Game.player.life <= 0) {
				Game.player.morto = true;
				telaMorte(g);
				Game.inventario.numeroDeWill -= Game.inventario.numeroDeWill;
			}
			
			if ( Game.player.controller.finalDoJogo == true) {
				Game.player.controller.telaFim(g);
			}
			g = buffer.getDrawGraphics();
		    g.drawImage(fundo, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		    buffer.show();

	}
	
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0f;
		double ms = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();

		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ms;
			lastTime = now;

				if(delta > 1) {
					tick();
					render();
					frames++;
					delta--;
				}

				if(System.currentTimeMillis() - timer >= 1000) {
					System.out.println("FPS : " + frames );
					frames = 0;
					timer +=1000;
				}
				
				if (mapaAtual == mapaContador.mapa02 || mapaAtual == mapaContador.mapa01 ||
					mapaAtual == mapaContador.mapa04 ||mapaAtual == mapaContador.mapa05 ||
					mapaAtual == mapaContador.mapa07) {
					frames = 60;
				}

		}
		stop();

	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// Nao vamos trabalhar nela

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if ( Game.player.controller.finalDoJogo == false) {
			
		if (player.interagindo) {
			 if (Game.dialogo.escolendo == true && !Game.mercador.opcaoTres == true) {
						if (e.getKeyCode() == KeyEvent.VK_D) {
					        dialogo.opcaoDialogo = (dialogo.opcaoDialogo + 1) % 3;
					        System.out.println("Tecla D pressionada");
					    } else if (e.getKeyCode() == KeyEvent.VK_A) {
					    	dialogo.opcaoDialogo = (dialogo.opcaoDialogo - 1) % 3; 
					        System.out.println("Tecla A pressionada");
					        if (dialogo.opcaoDialogo < 0) {
					        	dialogo.opcaoDialogo = 2;
					        }
					    }
			} else if (dialogo.comprando == true) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					dialogo.estadoAtualloja = (dialogo.estadoAtualloja + 1) % 4;
			        System.out.println("Tecla D pressionada mercador");
			    } else if (e.getKeyCode() == KeyEvent.VK_A) {
			    	dialogo.estadoAtualloja = (dialogo.estadoAtualloja - 1) % 4; 
			        System.out.println("Tecla A pressionada mercador");
			        if (dialogo.estadoAtualloja < 0) {
			        	dialogo.estadoAtualloja = 3;
			        }
			    }
			}
		    
		} else if (inventario.inventarioAberto) {
			 if (inventario.ItemUm) {
				    if (e.getKeyCode() == KeyEvent.VK_D) {
				        inventario.estadoAtualInventarioItemUm = (inventario.estadoAtualInventarioItemUm + 1) % 3;
				        System.out.println("Tecla D pressionada aba de item1");
				    } else if (e.getKeyCode() == KeyEvent.VK_A) {
				        inventario.estadoAtualInventarioItemUm = (inventario.estadoAtualInventarioItemUm - 1) % 3;
				        System.out.println("Tecla A pressionada aba de item1");
				        if (inventario.estadoAtualInventarioItemUm < 0) {
				        	inventario.estadoAtualInventarioItemUm = 2;
				        }
				        
				    }
				}else if(inventario.ItemDois){
					if (e.getKeyCode() == KeyEvent.VK_D) {
				        inventario.estadoAtualInventarioItemDois = (inventario.estadoAtualInventarioItemDois + 1) % 4;
				        System.out.println("Tecla D pressionada aba de item2");
				    } else if (e.getKeyCode() == KeyEvent.VK_A) {
				        inventario.estadoAtualInventarioItemDois = (inventario.estadoAtualInventarioItemDois - 1) % 4; 
				        System.out.println("Tecla A pressionada aba de item2");
				        if (inventario.estadoAtualInventarioItemDois < 0) {
				        	inventario.estadoAtualInventarioItemDois = 3;
				        }
				        
				    }
				} else if(inventario.ItemTres){
					if (e.getKeyCode() == KeyEvent.VK_D) {
				        inventario.estadoAtualInventarioItemTres = (inventario.estadoAtualInventarioItemTres + 1) % 4;
				        System.out.println("Tecla D pressionada aba de item3");
				        
				    } else if (e.getKeyCode() == KeyEvent.VK_A) {
				        inventario.estadoAtualInventarioItemTres = (inventario.estadoAtualInventarioItemTres - 1) % 4; 
				        System.out.println("Tecla A pressionada aba de item3");
				        if (inventario.estadoAtualInventarioItemTres < 0) {
				        	inventario.estadoAtualInventarioItemTres = 3;
				        }
				        
				    }
				} else {
					if (e.getKeyCode() == KeyEvent.VK_D) {
				        inventario.estadoAtualInventario = (inventario.estadoAtualInventario + 1) % 4;
				        System.out.println("Tecla D pressionada");
				    } else if (e.getKeyCode() == KeyEvent.VK_A) {
				        inventario.estadoAtualInventario = (inventario.estadoAtualInventario - 1) % 4; 
				        System.out.println("Tecla A pressionada");
				        if (inventario.estadoAtualInventario < 0) {
				        	inventario.estadoAtualInventario = 3;
				        }
				    }
				}
		    
		} else {
		    if (e.getKeyCode() == KeyEvent.VK_D) {
		        player.right = true;
		        player.left = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_A) {
		        player.left = true;
		        player.right = false;
		    }
		}

	    
		if(e.getKeyCode() == KeyEvent.VK_W) {
			if  (player.usandoEscada == true) {
				player.up = true;
			}
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.jump = true;
		} 
		if(e.getKeyCode() == KeyEvent.VK_Q){
			
			if (PortaMadeira.jogadorProximo ||PortaMadeiraDois.jogadorProximo ||PortaMadeiraTres.jogadorProximo) {
				player.interagindoComPorta = true;	
				System.out.println("era pra abrir a porta ");
			}else if (NpcMercador.jogadorProximo || NpcMoon.jogadorProximo || NpcOutro.jogadorProximo ||
					PropEspada.jogadorProximo || NpcNun.jogadorProximo) {
				player.interagindo = !player.interagindo;	
			} else {
				inventario.inventarioAberto = false;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_C){
			player.usandocura = true;
			System.out.println("Tecla C pressionada");
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if (mapaAtual == mapaContador.mapa02 && dialogo.linhaDialogo == 6 ||
				mapaAtual == mapaContador.mapa06 && dialogo.linhaDialogo == 6 ||
				mapaAtual == mapaContador.casa03 && dialogo.linhaDialogo == 6 ||
				mapaAtual == mapaContador.mapa00 && dialogo.linhaDialogo == 6) {
				  player.selecionado = true;
			  }
			if (Game.dialogo.comprando == true) {
				Game.dialogo.compra = true; 
			}
			System.out.println("Tecla J pressionada");
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
		    System.out.println("Tecla I pressionada");
		    inventario.inventarioAberto = !inventario.inventarioAberto;
		    dialogo.comprando = false;
		    player.interagindo = false;	
		    
		}
		 if (e.getKeyCode() == KeyEvent.VK_F) {
	            ui.estadoAtual = (ui.estadoAtual + 1) % 3;
	            System.out.println("Tecla f pressionada");
	        }
		 if (e.getKeyCode() == KeyEvent.VK_E) {
			  if (inventario.inventarioAberto) {
				  if (dialogo.comprando == false || inventario.inventarioAberto) {
					  player.selecionado = true;
				  } else if (Game.mercador.opcaoTres == true) {
					     player.selecionado = true;
						 dialogo.compra = true;
			  } 
			  } else if (player.interagindo) {
				  if (mapaAtual == mapaContador.casa03 && dialogo.linhaDialogo == 6 ||
						  mapaAtual == mapaContador.mapa02 && dialogo.linhaDialogo == 6 ||
						  mapaAtual == mapaContador.mapa06 && dialogo.linhaDialogo == 6 ||
						  mapaAtual == mapaContador.mapa00 && dialogo.linhaDialogo == 6 ||
						  mapaAtual == mapaContador.mapa08 && dialogo.linhaDialogo == 6) {
					  player.selecionado = true;
					 
				  } else {
				  dialogo.linhaDialogo = (dialogo.linhaDialogo +1) % 7; 
				  }
			  } else {
				  if (player.morto == true) {
					  player.selecionado = true;
				  } else {
					  player.selecionado = true;
				  }
				 
			  }
		 }
		
	  }   	
	}
	

	public void iniciarTrocaTexto() {
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new AcaoAtaque(), 0, 2500); 
	}
	
	private boolean dialogoReiniciado = false;

	private class AcaoAtaque extends TimerTask {
	    @Override
	    public void run() {
	    	if (Game.player.leftA ) {
	    		
	    	}
	    	
	    	
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
		
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_E ) {
			player.selecionado = false;
			dialogo.compra = false;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getButton() == MouseEvent.BUTTON1) {
				 if(player.direcaoAtual == player.atacandoR) {
							player.rightA = true;
							player.comboAtaque = (player.comboAtaque + 1) % 2;
					 
					} else if(player.direcaoAtual == player.atacandoL) {
							player.leftA = true;
							player.comboAtaque = (player.comboAtaque + 1) % 2;
				}
			        System.out.println("Botão esquerdo do mouse pressionado!");
			    }
		 if(e.getButton() == MouseEvent.BUTTON3){
			 if(player.direcaoAtual == player.atacandoR) {
				 if (player.podeAtacar == true) {
					if (Game.player.estamina > 0) {
						
					}
				 }
				} else if(player.direcaoAtual == player.atacandoL) {
					if (player.descansadoUmPouco == true) {
						if (Game.player.estamina > 0) {
					}
				}
			}
			 System.out.println("Botão direito do mouse pressionado!");
		 }
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
