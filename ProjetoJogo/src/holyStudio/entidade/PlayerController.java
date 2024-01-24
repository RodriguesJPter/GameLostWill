package holyStudio.entidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import holyStudio.Mundo.Mundo;
import holyStudio.main.Game;

public class PlayerController {
	
	public int Void = 1;
	
	public boolean esteveNoVoid = false;
	
	public PlayerInfo info;
	
	public static boolean finalDoJogo = false;
	
	 public void controleMapaBt01() {
		 Game.level++;
			String Level = "casa1.png";
			if(Game.level > Game.levelMaximo) {
				Game.level = 1;
			}	
			 if (Game.mapaAtual == Game.mapaContador.mapa01 && Game.mapaAnterior == Game.mapaContador.mapa00 || 
						Game.mapaAtual == Game.mapaContador.mapa01 && Game.mapaAnterior == Game.mapaContador.mapa02) {
				Level = "level0.png";
				Game.mapaAtual = Game.mapaContador.mapa00;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa01;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa01 || 
					Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa03 || 
					Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa08) {
				Level = "level1.png";
				Game.mapaAtual = Game.mapaContador.mapa01;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa02;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa02 ||
					Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa06 ||
					Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa04) {
				Level = "level2.png";
				Game.mapaAtual = Game.mapaContador.mapa02;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa03;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa03 ||
					Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa05 ||
					Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa07) {
				Level = "level5.png";
				Game.mapaAtual = Game.mapaContador.mapa05;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa04;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.mapa03 || 
					Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa01 || 
					Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa02 || 
					Game.mapaAtual == Game.mapaContador.mapa06 && Game.mapaAnterior == Game.mapaContador.casa03) {
				Level = "level3.png";
				Game.mapaAtual = Game.mapaContador.mapa03;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa06;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.casa01 && Game.mapaAnterior == Game.mapaContador.mapa06) {
				Level = "level6.png";
				Game.mapaAtual = Game.mapaContador.mapa06;
				Mundo.levelAtual = 1;
				Game.mapaAnterior = Game.mapaContador.casa01;
				Game.posicaoPlayer = 2;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			}  else if (Game.mapaAtual == Game.mapaContador.casa02 && Game.mapaAnterior == Game.mapaContador.mapa06) {
				Level = "level6.png";
				Game.mapaAtual = Game.mapaContador.mapa06;
				Mundo.levelAtual = 1;
				Game.mapaAnterior = Game.mapaContador.casa02;
				Game.posicaoPlayer = 0;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.casa03 && Game.mapaAnterior == Game.mapaContador.mapa06) {
				Level = "level6.png";
				Game.mapaAtual = Game.mapaContador.mapa06;
				Mundo.levelAtual = 1;
				Game.mapaAnterior = Game.mapaContador.casa03;
				Game.posicaoPlayer = 1;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			}
			Mundo.newLevel(Level);
			
			System.out.println(Game.mapaAtual);
			System.out.println(Game.mapaAnterior);
			System.out.println(Game.posicaoPlayer);
	 } 
	 public void controleMapaBt02() {
		 Game.level++;
			String Level = "casa1.png";
			if(Game.level > Game.levelMaximo) {
				Game.level = 1;
			}	
			
			if (Game.mapaAtual == Game.mapaContador.mapa06 && Game.inventario.chave == 1) {
				
				finalDoJogo = true;
				
			} else if (Game.mapaAtual == Game.mapaContador.mapa06 && Game.inventario.chave == 0) {
				Level = "level6.png";
				Game.mapaAtual = Game.mapaContador.mapa06;
				Mundo.levelAtual = 1;
				Game.mapaAnterior = Game.mapaContador.mapa03;
				Game.posicaoPlayer =1 ;
				Game.player.direcaoAtual = Game.player.esquerda;
				limpaCenario();
			
			} else {
			 
			if (Game.mapaAtual == Game.mapaContador.mapa00 ) {
				Level = "level1.png";
				Game.mapaAtual = Game.mapaContador.mapa01;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa00;
				Game.posicaoPlayer = 0;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa01 && Game.mapaAnterior == Game.mapaContador.mapa00 ||
					Game.mapaAtual == Game.mapaContador.mapa01 && Game.mapaAnterior == Game.mapaContador.mapa02) {
				Level = "level2.png";
				Game.mapaAtual = Game.mapaContador.mapa02;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa01;
				Game.posicaoPlayer = 0;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa01 ||
					Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa03 ||
					Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa08) {
				Level = "level3.png";
				Game.mapaAtual = Game.mapaContador.mapa03;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa02;
				Game.posicaoPlayer = 0;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa03||
					Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa05||
					Game.mapaAtual == Game.mapaContador.mapa04 && Game.mapaAnterior == Game.mapaContador.mapa07 ) {
				Level = "level3.png";
				Game.mapaAtual = Game.mapaContador.mapa03;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa04;
				Game.posicaoPlayer = 2;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa02||
					Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa04 ||
					Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa06) {
				Level = "level6.png";
				Game.mapaAtual = Game.mapaContador.mapa06;
				Mundo.levelAtual = 1;
				Game.mapaAnterior = Game.mapaContador.mapa03;
				Game.posicaoPlayer = 0;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
			} else if (Game.mapaAtual == Game.mapaContador.mapa07 && Game.mapaAnterior == Game.mapaContador.mapa05 ) {
				Level = "level4.png";
				Game.mapaAtual = Game.mapaContador.mapa04;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa07;
				Game.posicaoPlayer = 0;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
		
			} else if (Game.mapaAtual == Game.mapaContador.mapa08 && Game.mapaAnterior == Game.mapaContador.mapa02) {
				Level = "level2.png";
				Game.mapaAtual = Game.mapaContador.mapa02;
				Mundo.levelAtual = 0;
				Game.mapaAnterior = Game.mapaContador.mapa08;
				Game.posicaoPlayer = 2;
				Game.player.direcaoAtual = Game.player.direita;
				limpaCenario();
			} 
			
			}
			
			Mundo.newLevel(Level);
			
			System.out.println(Game.mapaAtual);
			System.out.println(Game.mapaAnterior);
			System.out.println(Game.posicaoPlayer);
	 }
	 public void controleMapaBt03() {
		 
		 
		 if (Game.mapaAtual == Game.mapaContador.mapa07) {
			 	Mundo.esteveVoid = 1;
		 } else {
			 	Game.level++;
				String Level = "casa1.png";
				if(Game.level > Game.levelMaximo) {
					Game.level = 1;
				}	
				 if (Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa02 ||
					 Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa06 ||
					 Game.mapaAtual == Game.mapaContador.mapa03 && Game.mapaAnterior == Game.mapaContador.mapa04) {
					Level = "level4.png";
					Game.mapaAtual = Game.mapaContador.mapa04;
					Mundo.levelAtual = 0;
					Game.mapaAnterior = Game.mapaContador.mapa03;
					Game.posicaoPlayer = 1;
					Game.player.direcaoAtual = Game.player.esquerda;
					limpaCenario();
				} else if(Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa03 ||
						 Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa01 ||
						 Game.mapaAtual == Game.mapaContador.mapa02 && Game.mapaAnterior == Game.mapaContador.mapa08) {
					Level = "level8.png";
					Game.mapaAtual = Game.mapaContador.mapa08;
					Mundo.levelAtual = 3;
					Game.mapaAnterior = Game.mapaContador.mapa02;
					Game.posicaoPlayer = 1;
					Game.player.direcaoAtual = Game.player.esquerda;
					limpaCenario();
				}
				
					
				Mundo.newLevel(Level);
				
				System.out.println(Game.mapaAtual);
				System.out.println(Game.mapaAnterior);
				System.out.println(Game.posicaoPlayer);
		 }
		 
	 }
	 
	 public void controleMapaBt04() {
		 Game.level++;
			String Level = "casa1.png";
			if(Game.level > Game.levelMaximo) {
				Game.level = 1;
			}	
			if(Mundo.esteveVoid == 0) {
				if(Game.mapaAtual == Game.mapaContador.mapa05 && Game.mapaAnterior == Game.mapaContador.mapa04) {
					Level = "level7.png";
					Game.mapaAtual = Game.mapaContador.mapa07;
					Mundo.levelAtual = 0;
					Game.mapaAnterior = Game.mapaContador.mapa05;
					Game.posicaoPlayer = 0;
					Game.player.direcaoAtual = Game.player.direita;
					limpaCenario();
					
				 } 
				
			} else if (Mundo.esteveVoid == 1) {
				 if(Game.mapaAtual == Game.mapaContador.mapa05 && Game.mapaAnterior == Game.mapaContador.mapa04) {
						Level = "level4.png";
						Game.mapaAtual = Game.mapaContador.mapa04;
						Mundo.levelAtual = 0;
						Game.mapaAnterior = Game.mapaContador.mapa05;
						Game.posicaoPlayer = 0;
						Game.player.direcaoAtual = Game.player.direita;
						limpaCenario();
					 } 
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
			
			
			if (Game.mapaAtual == Game.mapaContador.mapa07) {
				esteveNoVoid = false;
			}
			
	 }
	 
	 
	 void bossAtacado(BossDogKnight boss) {
			  Game.player.empurrao();
			    boss.life -= Game.player.dano;
			    
			    if (boss.life <= 0 && !boss.isRemovido) {
			        Game.dogK.remove(boss);
			        boss.life = 0;
			        Game.inventario.numeroDeWill += 100;
			        Game.mundo.eventoBossMorto = 1;
			        Game.inventario.chave += 1;
			        Game.dialogo.notificacao = "+1 chave";
			        boss.isRemovido = true;

			        Game.dialogo.chave = true;
			        Game.dialogo.frasco = false;
			        Game.dialogo.espada = false;
			    }
		  
		}
	 
	
	 
		public boolean damageRato(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (InimigoRato entidade : Game.rato) {
				if(entidade instanceof InimigoRato) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.pl = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean damageSoldado(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (InimigoSoldado entidade : Game.soldado) {
				if(entidade instanceof InimigoSoldado) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.pl2 = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean damageBossDog(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (BossDogKnight entidade : Game.dogK) {
				if(entidade instanceof BossDogKnight) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.bossUm = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean damageWendigo(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (InimigoWendigo entidade : Game.wendigo) {
				if(entidade instanceof InimigoWendigo) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.pl3 = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean damageRival(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (InimigoSoldadoRival entidade : Game.rival) {
				if(entidade instanceof InimigoSoldadoRival) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.pl5 = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean damageIronDoll(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (InimigoIronDoll entidade : Game.ironDoll) {
				if(entidade instanceof InimigoIronDoll) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.pl4 = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		public boolean him(int nextx, int nexty) {
			Rectangle player = new Rectangle(nextx + Game.player.maskx, nexty + Game.player.masky, Game.player.maskw, Game.player.maskh);
			for (Yellow entidade : Game.thing) {
				if(entidade instanceof Yellow) {
					Rectangle inimigo = new Rectangle(entidade.getX() + Game.player.maskx, entidade.getY()+Game.player.masky, Game.player.maskw, Game.player.maskh);
					if(player.intersects(inimigo)) {
						Game.player.him = entidade;
						return true;

					}
				}

			}
			return false;
		}
		
		
		public void telaFim(Graphics g){
		    int inventarioX = 55;
		    int inventarioY = 10;
		    int larguraInventario = 150;
		    int alturaInventario = 100;
		    int campoX = 30;
			int campoY = 115;
			int campoHeight = 20;

		    g.setColor(Color.BLACK);
		    g.fillRect(inventarioX - 100, inventarioY - 100, larguraInventario + 500, alturaInventario + 500);
		    g.setColor(Color.WHITE);
		    g.setFont(new Font("Arial", Font.BOLD, 20));
	        g.drawString("Fim da Demo", campoX + 85, campoY - 12);
	        
	        
		   
		}
		
		
		public void danoPlayer() {
		
		}
		
		public void ganhandoRecompensa() {
			
			
			
			
		}


}