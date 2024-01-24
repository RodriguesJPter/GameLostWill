package holyStudio.Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import holyStudio.Graficos.SpriteSheet;
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
import holyStudio.entidade.Yellow;
import holyStudio.entidade.caxote;
import holyStudio.main.Game;
import holyStudio.main.Inventario;
import holyStudio.main.UserInterface;

public class Mundo {

	public static int WIDTH;
	public static int HEIGHT;
	public Tile[] tiles;
	
	public static int levelAtual = 0;
	
	public static int eventoBossMorto = 0;
	
	public static int esteveVoid = 1;
	
	
	
	// outro opcoes 
	public static boolean escolhaFeitaOutro = false;
	
	public static boolean escolhaFeitaDoisOutro = false;
	
	// nun opcao
	public static boolean escolhaFeitaNun = false;
	
	
	public Mundo(String path) {
		try {
			System.out.println("Boss Morto" + eventoBossMorto);
			System.out.println("Path: " + path);
			BufferedImage level = ImageIO.read(getClass().getResource(path));
			int[] pixel = new int[level.getWidth()* level.getHeight()];
			tiles = new Tile[level.getWidth() * level.getHeight()];
			WIDTH = level.getWidth();
			HEIGHT = level.getHeight();
			level.getRGB(0, 0, level.getWidth(), level.getHeight(), pixel, 0, level.getWidth());


			for(int x = 0; x < level.getWidth(); x++) {
				for(int y = 0; y < level.getHeight(); y++) {
					int pixelAtual = pixel[x + (y*level.getWidth())];
					tiles[x + (y*WIDTH)] = new Nada(x*16, y*16, Entidade.nada);

					
					
					switch (Game.posicaoPlayer) {
					case 0:
						if (pixelAtual == 0xFFf60000) {
							//Jogador (player)

							Game.player.setX(x*16);
							Game.player.setY(y*16);

						}
						break;
					case 1:
						if (pixelAtual == 0xFFff00d7) {
							//Jogador (player)

							Game.player.setX(x*16);
							Game.player.setY(y*16);

						}
						break;
					case 2:
						if (pixelAtual == 0xFF74ff74) {
							//Jogador (player)

							Game.player.setX(x*16);
							Game.player.setY(y*16);

						}
						break;
					case 3:
						if (pixelAtual == 0xFF0a3288) {
							//Jogador (player)

							Game.player.setX(x*16);
							Game.player.setY(y*16);

						}
						break;
					}
					
					if(pixelAtual == 0xFF322a72) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF7c75b9) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF3522d7) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte03);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFc1bbed) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte04);
						Game.entidade.add(solido);

					}  else if(pixelAtual == 0xFF46221b) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo03);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF952e1a) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terra02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF463d3b) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terra03);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF912e2e) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.tronco01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFd70b0b) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.tronco02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF91772e) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedra01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFd58e24) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedra02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF912e77) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaocasa);
						Game.entidade.add(solido);

					}  else if(pixelAtual == 0xFFd77bba) {
						PropGrama Grama = new PropGrama(x*16, y*16, 16, 16, Entidade.grama);
						Game.propG.add(Grama);

					}  else if(pixelAtual == 0xFF0048ab) {
						//nadaChao
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoP);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF000000) {
						//nada
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.vazio);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF3e2121) {
						Corredor corredro = new Corredor(x*16, y*16, 16, 16, Entidade.vazio);
						Game.corredor.add(corredro);

					} else if(pixelAtual == 0xFFf2ff00) {
						Yellow heWhoConsumes = new Yellow(x*16, y*16, 16, 16, Entidade.vazio);
						Game.thing.add(heWhoConsumes);

					} else if(pixelAtual == 0xFF004eff) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.fundo);
						Game.fundoCenario.add(ceu);

					} else if(pixelAtual == 0xFF639bff) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.iniciofundo);
						Game.fundoCenario.add(ceu);

					}else if(pixelAtual == 0xFF3f3f74) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.iniciofundoceu);
						Game.fundoCenario.add(ceu);

					} else if(pixelAtual == 0xFFbb2475) {
						//
						InimigoRato inimigoRato = new InimigoRato(x*16, y*16, 16, 16, Entidade.inimigoRato);
						Game.rato.add(inimigoRato);

					} else if(pixelAtual == 0xFFa32222) {
						//
						InimigoSoldado inimigosoldado = new InimigoSoldado(x*16, y*16, 16, 16, Entidade.inimigoSoldado);
						Game.soldado.add(inimigosoldado);

					} else if(pixelAtual == 0xFF00e1ed) {
						NpcMoon npcMoon = new NpcMoon(x*16, y*16, 16, 16, Entidade.npcMoon);
						Game.npcMoon.add(npcMoon);
						
					} else if(pixelAtual == 0xFF7d1ed3) {
							//
						NpcDoll npcDoll = new NpcDoll(x*16, y*16, 16, 16, Entidade.npcDoll);
						Game.npcDoll.add(npcDoll);

					}  else if(pixelAtual == 0xFF6bff00) {
						//
						NpcOutro npcOutro = new NpcOutro(x*16, y*16, 16, 16, Entidade.npcOutro);
						Game.npcOutro.add(npcOutro);

					} else if(pixelAtual == 0xFF92a336) {
						//
						NpcMercador npcMercador = new NpcMercador(x*16, y*16, 16, 16, Entidade.npcMercador);
						Game.npcMercador.add(npcMercador);

					} else if(pixelAtual == 0xFFe0d623) {
						NpcNun npcNun = new NpcNun(x*16, y*16, 16, 16, Entidade.npcMercador);
						Game.nun.add(npcNun);
						
					} else if(pixelAtual == 0xFFa7a01d) {
						Espinhos espinhos = new Espinhos(x*16, y*16, 16, 16, Entidade.espinho);
						Game.entidade.add(espinhos);

					} else if(pixelAtual == 0xFF878018) {
						BlocoParaInimigo  fimTrajetoria = new BlocoParaInimigo(x*16, y*16, 16, 16, Entidade.nada);
						Game.entidade.add(fimTrajetoria);

					} else if(pixelAtual == 0xFF524e0e) {
						NpcUndead undead = new NpcUndead(x*16, y*16, 16, 16, Entidade.nada);
						Game.undead.add(undead);

					} else if(pixelAtual == 0xFF3e3b13) {
						InimigoSoldadoRival soldadoRival = new InimigoSoldadoRival(x*16, y*16, 16, 16, Entidade.nada);
						Game.rival.add(soldadoRival);

					} else if(pixelAtual == 0xFFc17e7e) {
						
						InimigoIronDoll ironDoll = new InimigoIronDoll (x*16, y*16, 16, 16, Entidade.nada);
						Game.ironDoll.add(ironDoll);

					} else if(pixelAtual == 0xFF802828) {
						//
						PosteUm poste= new PosteUm(x*16, y*16, 16, 16, Entidade.poste1);
						Game.poste.add(poste);

					}   else if(pixelAtual == 0xFF802828) {
						//
						caxote poste= new caxote(x*16, y*16, 16, 16, Entidade.caixote);
						Game.caixa.add(poste);

					} else if(pixelAtual == 0xFF5c1751) {
						PropEspada propes= new PropEspada(x*16, y*16, 16, 16, Entidade.propespada);
						Game.prope.add(propes);

					} else if(pixelAtual == 0xFFa32828) {
						PropCenarioUm propes= new PropCenarioUm(x*16, y*16, 16, 16, Entidade.propPilhaCorpos);
						Game.propUm.add(propes);

					} else if(pixelAtual == 0xFF8d8d8d) {
						EstatuaUm estatua01= new EstatuaUm(x*16, y*16, 16, 16, Entidade.estatuaUm);
						Game.estatua01.add(estatua01);

					}
					
					else if(pixelAtual == 0xFFd7ff00) {
						//979e72
						InimigoWendigo wendigo = new InimigoWendigo(x*16, y*16, 16, 16, Entidade.inimigoWendigo);
						Game.wendigo.add(wendigo);
					}
					
					else if(pixelAtual == 0xFF584119) {
						//979e72
						PortaMadeira porta = new PortaMadeira(x*16, y*16, 16, 16, Entidade.portaM);
						Game.porta.add(porta);
					} 
					else if(pixelAtual == 0xFF612e2e) {
						//979e72
						PortaMadeiraDois porta = new PortaMadeiraDois(x*16, y*16, 16, 16, Entidade.portaM);
						Game.portaDois.add(porta);
					} 
					else if(pixelAtual == 0xFF840000) {
						//979e72
						PortaMadeiraTres porta = new PortaMadeiraTres(x*16, y*16, 16, 16, Entidade.portaM);
						Game.portaTres.add(porta);
					} 
					else if(pixelAtual == 0xFFffffff) {
						//ffffff
						BlocoTroca01 bt01 = new BlocoTroca01(x*16, y*16, 16, 16, Entidade.blocoT01);
						Game.bt01.add(bt01);
					}
					else if(pixelAtual == 0xFF918026) {
						//ffffff
						BlocoTroca02 bt02 = new BlocoTroca02(x*16, y*16, 16, 16, Entidade.blocoT01);
						Game.bt02.add(bt02);
					}
					
					else if(pixelAtual == 0xFF347734) {
						//ffffff
						BlocoTroca03 bt03 = new BlocoTroca03(x*16, y*16, 16, 16, Entidade.blocoT01);
						Game.bt03.add(bt03);
					}
					else if(pixelAtual == 0xFF8aacf6) {
						//ffffff
						BlocoTroca04 bt04 = new BlocoTroca04(x*16, y*16, 16, 16, Entidade.blocoT01);
						Game.bt04.add(bt04);
					}
					
					switch (levelAtual) {
					case 0:
						if(pixelAtual == 0xFF278d72) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaM01);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF76c6b0) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaM02);
							Game.entidade.add(solido);
						} 
						if(pixelAtual == 0xFF1d6e58) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaM03);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFe0c018) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaMR);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF16c5cf) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaML);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF663931) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloM01);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF9a6d64) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloM02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF344277) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloMR);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFcf169e) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraMR);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFd37b64) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloML);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF8764d3) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraML);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF260788) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaML02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF880707) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaMR02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF793acf) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraML02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF3acf69) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraMR02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFd39090) {
							Casa01 solido = new Casa01(x*16, y*16, 16, 16, Entidade.casa01);
							Game.casaUm.add(solido);
						}
						if(pixelAtual == 0xFFa7000e) {
							 BlocoBossRoom solido = new BlocoBossRoom(x*16, y*16, 16, 16, Entidade.bossParede);
							 Game.BBR.add(solido);
						}
						break;
					case 1: 
						
						 if(pixelAtual == 0xFF278d72) {
								Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama01);
								Game.entidade.add(solido);
							}
						 if(pixelAtual == 0xFF76c6b0) {
								Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama02);
								Game.entidade.add(solido);
							} 
						 if(pixelAtual == 0xFF1d6e58) {
								Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama03);
								Game.entidade.add(solido);
							}
						 if(pixelAtual == 0xFF663931) {
								Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo01);
								Game.entidade.add(solido);
							}
						 if(pixelAtual == 0xFF9a6d64) {
								Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo02);
								Game.entidade.add(solido);
							}
						 if(pixelAtual == 0xFFd39090) {
								Casa01 solido = new Casa01(x*16, y*16, 16, 16, Entidade.casa01);
								Game.casaUm.add(solido);
							}
						 if(pixelAtual == 0xFF8da350) {
								Catedral01 catedral = new Catedral01(x*16, y*16, 16, 16, Entidade.catedral);
								Game.catedral.add(catedral);
							}
						break;
					case 3:
						if(pixelAtual == 0xFF278d72) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedregulho01);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF76c6b0) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedregulho02);
							Game.entidade.add(solido);
						} 
						if(pixelAtual == 0xFF1d6e58) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedregulho03);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFe0c018) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedregulhoR);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF16c5cf) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.pedregulhoL);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF663931) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloGM01);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF9a6d64) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloGM02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF344277) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraGR);
							
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFcf169e) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloGMR);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFFd37b64) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraGL);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF8764d3) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.soloGML);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF260788) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaML02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF880707) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.gramaMR02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF793acf) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraML02);
							Game.entidade.add(solido);
						}
						if(pixelAtual == 0xFF3acf69) {
							Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terraMR02);
							Game.entidade.add(solido);
						}
						break;
					
					}
					switch (eventoBossMorto) {
					case 0:
						if(pixelAtual == 0xFFb01c2b) {
							BossDogKnight boss = new BossDogKnight(x*16, y*16, 16, 16, Entidade.bossDog);
							Game.dogK.add(boss);
						}
						break;
					case 1:
						if(pixelAtual == 0xFFb01c2b) {
							
						}
						break;
					}



				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void render(Graphics g) {
		int xi = Camera.x/16;
		int yi = Camera.y/16;
		int xf = xi + (Game.WIDTH/10);
		int yf = yi + (Game.HEIGHT/10);
		for(int x = xi; x < xf; x++) {
			for(int y = yi; y < yf; y++) {
				if (x < 0 || y < 0 || x >= WIDTH|| y >= HEIGHT)
					continue;
				Tile tile = tiles[x + (y*WIDTH)];
				tile.render(g);
			}
		}

	}
	
	public static void newLevel(String level) {
		
		Game.inventario = new Inventario();
	    Game.ui = new UserInterface();
		Game.entidade = new ArrayList<>();
		Game.sprite = new SpriteSheet("/SpritesheetQuatro.png");
		Game.fundoCenario = new ArrayList<>();
		Game.BBR = new ArrayList<>();
		Game.prope = new ArrayList<>();
		Game.propUm = new ArrayList<>();
		Game.corredor = new ArrayList<>();
		Game.propG = new ArrayList<>();
		Game.npcMoon = new ArrayList<>();
		Game.npcOutro = new ArrayList<>();
		Game.npcDoll = new ArrayList<>();
		Game.npcMercador = new ArrayList<>();
		Game.estatua01 = new ArrayList<>();
		Game.rato = new ArrayList<>();
		Game.will = new ArrayList<>();
		Game.porta = new ArrayList<>();
		Game.casaUm = new ArrayList<>();
		Game.catedral = new ArrayList<>();
		Game.caixa = new ArrayList<>();
		Game.soldado = new ArrayList<>();
		Game.dogK = new ArrayList<>();
		Game.wendigo = new ArrayList<>();
		Game.bt01 = new ArrayList<>();
		Game.bt02 = new ArrayList<>();
		Game.bt03 = new ArrayList<>();
		Game.bt04 = new ArrayList<>();
		Game.ceu = new SpriteSheet("/ceu01.png");
		Game.player = new Player(0, 0, 16, 16, Game.sprite.getSprite(23, 0, 35, 50));
		Game.entidade.add(Game.player);
		Game.poste = new ArrayList<>();
		Game.mundo = new Mundo("/" + level);
		
		
	}

}
