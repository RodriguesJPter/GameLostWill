package holyStudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import holyStudio.entidade.Entidade;
import holyStudio.entidade.Player;
import holyStudio.entidade.PlayerInfo;

public class Inventario {
	
	private boolean mostrarMensagem = false;
	private String mensagem = "";
	private Timer temporizador = new Timer();
	
	public boolean estadoAlternado = false;
	
	public int estadoAtual = 0;
	
	public int estadoAtualloja = 0;
	
	public static boolean inventarioAberto = false;
	public static boolean recebendoRecompensa = false;
	
	public static JFrame jframe;
	
	
	public static int medalsol = 0;
		
	public static int moonsword = 0;
		
	public static int sword = 0;
		
	public static int adaga = 1;
	
	public static int laminaDupla = 0;

	public static int chave = 0;
		
	public static int lagrima = 0;
		
	public static int coracao = 0;
	
	public static int candle = 0;
		
	public static int numeroFrasco = 0;
		
	public static int cranio = 0;
		
	public static int bonuscranio = 10;
		
	public static int numeroDeWill = 0;
	
	private String descricaoItemUm = "";
	private String descricaoItemDois = "";
	private String descricaoItemTres = "";
	private String descricaoItemQuatro = "";
	private String descricaoItemCinco = "";
	private String descricaoItemSeis = "";
	private String descricaoItemSete = "";
	private String descricaoItemOito = "";
	private String descricaoItemNove = "";
	private String descricaoItemDez = "";
	private String descricaoItemOnze = "";
	private String descricaoItemDoze = "";
	

	public int estadoAtualInventario = 0;
	
	public int estadoAtualInventarioItemUm = 0;
	
	public int estadoAtualInventarioItemDois = 0;
	
	public int estadoAtualInventarioItemTres = 0;
	
	public boolean ItemUm = false;
	
	public boolean ItemDois = false;
	
	public boolean ItemTres = false;
	
	public boolean mapaAberto = false;

	public void render(Graphics g) {
		
		if (inventarioAberto) {
			renderInventario(g);
			if (ItemUm == true) {
				renderPageUm(g);
			}
			if (ItemDois == true) {
				renderPaginaDois(g);
			}

			if (ItemTres == true) {
				renderPaginaTres(g);
			}

		}
		
		
	}
	private void renderInventario(Graphics g){
	    int inventarioX = 115;
	    int inventarioY = 75;
	    int larguraInventario = 160;
	    int alturaInventario = 100;
	    int campoX = 85;
		int campoY = 70;
		int campoHeight = 20;
		
		int campoItemX = 16;
		int campoItemY = 16;
		
		int campoDescricaoX = 50;
		int campoDescricaoY = 92;
		
		int campoButtonX =105;
		int campoButtonY = 70;
		
		Color corPaginaVelha = new Color(210, 200, 170);
		
		Color corMarromEscuro = new Color(139, 69, 19); 
		
		Color corPaginaVelhaMaisEscura = new Color(160, 150, 120); 
		
		Color corMarromMaisEscuro = new Color(100, 50, 10);
		
		g.drawImage(Entidade.BookInventario , inventarioX - 103, inventarioY - 50, jframe); 
	    
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Inventario", campoX + 10, campoY - 5);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 82, 76, 3, 99);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.drawString("Status", campoX - 45, campoY + campoHeight + 10);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString("Level: " + Player.PlayerLevel, campoX - 45, campoY + campoHeight + 20);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString("HP: " + Player.maxLife , campoX - 45, campoY + campoHeight + 30);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString("HE: " + Player.maxestamina, campoX - 45, campoY + campoHeight + 40);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString("For: " + Player.forca, campoX - 45, campoY + campoHeight + 50);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString("Dano: " + Player.dano, campoX - 45, campoY + campoHeight + 60);
        
		
        
        g.drawImage(Entidade.iconI , campoButtonX, campoButtonY, jframe);
        
        g.drawImage(Entidade.iconAm ,campoButtonX + 26, campoButtonY, jframe);
        
        g.drawImage(Entidade.iconK , campoButtonX + 53, campoButtonY, jframe);
        
        g.drawImage(Entidade.circlemagic , campoButtonX + 110, campoButtonY + 40, jframe);
        
        if(Game.mundo.escolhaFeitaDoisOutro == true) {
        	g.drawImage(Entidade.pintura01 , campoButtonX + 145, campoButtonY + 5, jframe);
        }
        
        if (mapaAberto == false) {
        	g.drawImage(Entidade.mapa01 , campoButtonX + 100, campoButtonY - 5, jframe); 
        }

        switch (estadoAtualInventario) {
        case 0:
        	mapaAberto = false;
            g.drawImage(Entidade.iconIA , campoButtonX - 1, campoButtonY, jframe);
            if (Game.player.selecionado) {
            	ItemUm = true;
            }
            
       	 break;
        case 1:
        	mapaAberto = false;
            g.drawImage(Entidade.iconAmA ,campoButtonX + 26, campoButtonY, jframe);
            if (Game.player.selecionado) {
            	ItemDois = true;
            }
            break;
        case 2:
        	mapaAberto = false;
            g.drawImage(Entidade.iconKA , campoButtonX + 53, campoButtonY, jframe); 
            if (Game.player.selecionado) {
            	ItemTres = true;
            }
            break;
        case 3:
        	mapaAberto = true;
            g.drawImage(Entidade.mapa02 , campoButtonX + 100, campoButtonY - 10, jframe); 
            g.drawImage(Entidade.iconMapaOff , campoButtonX + 122, campoButtonY + 22, jframe); 
            g.drawImage(Entidade.iconMapaOff , campoButtonX + 116, campoButtonY + 25, jframe); 
            g.drawImage(Entidade.iconMapaOff , campoButtonX + 119, campoButtonY + 50, jframe);
            
            if (Game.mapaAtual == Game.mapaContador.mapa00 || Game.mapaAtual == Game.mapaContador.mapa01 ||
            		Game.mapaAtual == Game.mapaContador.mapa04 || Game.mapaAtual == Game.mapaContador.mapa03 
            		|| Game.mapaAtual == Game.mapaContador.mapa02) {
            	g.drawImage(Entidade.iconMapaOn , campoButtonX + 122, campoButtonY + 22, jframe); 
            } else if (Game.mapaAtual == Game.mapaContador.mapa05) {
            	g.drawImage(Entidade.iconMapaOn , campoButtonX + 116, campoButtonY + 25, jframe); 
            } else if (Game.mapaAtual == Game.mapaContador.mapa06) {
            	g.drawImage(Entidade.iconMapaOn , campoButtonX + 119, campoButtonY + 50, jframe); 
            }
            
            break;
        }
        
        g.drawImage(Entidade.magicBook , campoButtonX - 5, campoButtonY + 80, jframe);
        
	}
	
	public void renderPageUm(Graphics g) {
		
		int inventarioX = 105;
	    int inventarioY = 75;
	    int larguraInventario = 160;
	    int alturaInventario = 100;
	    int campoX = 113;
		int campoY = 70;
		int campoHeight = 20;
		
		int campoItemX = 16;
		int campoItemY = 16;
		
		int campoDescricaoX = 50;
		int campoDescricaoY = 92;
		
        Color corPaginaVelha = new Color(210, 200, 170);
		
		Color corMarromEscuro = new Color(139, 69, 19); 
		
		Color corPaginaVelhaMaisEscura = new Color(160, 150, 120); 
		
		Color corMarromMaisEscuro = new Color(100, 50, 10);

		 g.drawImage(Entidade.BookInventarioPagina , campoX - 27, campoY - 29, jframe);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 16, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 52, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 52, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 52, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 52, campoItemX , campoItemY);

	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 105, inventarioY - 15, campoDescricaoX + 38, campoDescricaoY + 45);
	    
	    g.setColor(corPaginaVelha);
	    g.fillRect(inventarioX + 105, inventarioY - 15, campoDescricaoX, campoDescricaoY - 35);
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemUm, inventarioX + 106 ,inventarioY + 55);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDois, inventarioX + 106 ,inventarioY + 65);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemTres, inventarioX + 106 ,inventarioY + 75);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemQuatro, inventarioX + 106 ,inventarioY + 85);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemCinco, inventarioX + 106 ,inventarioY + 95);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemSeis, inventarioX + 106 ,inventarioY + 105);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemSete, inventarioX + 106 ,inventarioY + 115);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemOito, inventarioX + 106 ,inventarioY + 125);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemNove, inventarioX + 106 ,inventarioY + 135);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDez, inventarioX + 106 ,inventarioY + 145);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemOnze, inventarioX + 106 ,inventarioY + 155);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDoze, inventarioX + 106 ,inventarioY + 165);
        
	    if (numeroFrasco >= 0) {
        g.drawImage(Entidade.frasco , campoX - 6, campoY + 21, jframe);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("" + numeroFrasco, campoX + 6, campoY + 36);
        }
        
        if (cranio == 1) {
             g.drawImage(Entidade.cranio , campoX + 15, campoY + 21, jframe);    
        }
            
       

        g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
	    
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("voltar", inventarioX + 6, inventarioY + 95);
        
	    
	    switch (estadoAtualInventarioItemUm) {
        case 0:
    	    g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 5, inventarioY + 16, campoItemX , campoItemY);
    	    if (numeroFrasco >= 0) {
    	    	g.drawImage(Entidade.itemDescripitionFBlood , campoX + 100, campoY - 6, jframe);
    	    	g.drawImage(Entidade.frasco , campoX - 6, campoY + 21, jframe);
    	        g.setColor(Color.WHITE);
    	        g.setFont(new Font("Arial", Font.PLAIN, 10));
    	        g.drawString("" + numeroFrasco, campoX + 6, campoY + 36);
    	        descricaoItemUm = "Frasco de sangue.";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "item usado pra ";
    	        descricaoItemQuatro = "cura ate as piores";
    	        descricaoItemCinco = "das feridas,";
    	        descricaoItemSeis = "contem sangue";
    	        descricaoItemSete = "dos deuses ";
    	        }
       	 break;
        case 1:
        	g.setColor(Color.RED);
        	g.fillRect(inventarioX + 23, inventarioY + 16, campoItemX , campoItemY);
    	    if (cranio == 1) {
    	    	g.drawImage(Entidade.itemDescripitionCat , campoX + 98, campoY - 6, jframe);
    	    	g.drawImage(Entidade.cranio , campoX + 15, campoY + 21, jframe);    
    	    	descricaoItemUm = "Cranio de um gato";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "Pertencia a um";
    	        descricaoItemQuatro = "Gato amado da ";
    	        descricaoItemCinco = "pra sentir o amor";
    	        descricaoItemSeis = "emando dele.";
    	        descricaoItemSete = "FOR + 3 ";
            } else {
            	  descricaoItemUm = "";
       	        descricaoItemDois = "";
       	        descricaoItemTres = "";
       	        descricaoItemQuatro = "";
       	        descricaoItemCinco = "";
       	        descricaoItemSeis = "";
       	        descricaoItemSete = " "; 
            }
            break;
        case 2:
        	g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
    	    
    	    g.setColor(Color.BLACK);
    	    g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("voltar", inventarioX + 6, inventarioY + 95);
            
            descricaoItemUm = "";
 	        descricaoItemDois = "";
 	        descricaoItemTres = "";
 	        descricaoItemQuatro = "";
 	        descricaoItemCinco = "";
 	        descricaoItemSeis = "";
 	        descricaoItemSete = " "; 
            
            if (Game.player.selecionado) {
            	ItemUm = false;
            	estadoAtualInventarioItemUm = 0;
            	Game.player.selecionado = false;
            }
            break;
       
          	 
        }
	    
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Itens Consumiveis", campoX - 12, campoY - 5);
        
        
        
	}
	
	
	public void renderPaginaDois(Graphics g) {
		int inventarioX = 115;
	    int inventarioY = 75;
	    int larguraInventario = 160;
	    int alturaInventario = 100;
	    int campoX = 113;
		int campoY = 70;
		int campoHeight = 20;
		
		int campoItemX = 16;
		int campoItemY = 16;
		
		int campoDescricaoX = 50;
		int campoDescricaoY = 92;
		
        Color corPaginaVelha = new Color(210, 200, 170);
		
		Color corMarromEscuro = new Color(139, 69, 19); 
		
		Color corPaginaVelhaMaisEscura = new Color(160, 150, 120); 
		
		Color corMarromMaisEscuro = new Color(100, 50, 10);
		
		g.drawImage(Entidade.BookInventarioPagina , campoX - 27, campoY - 29, jframe);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 16, 10 , 31);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 17, inventarioY + 16, 10  , 47);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 29, inventarioY + 16, 12 , 55);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 95, inventarioY + 5, campoDescricaoX + 11, campoDescricaoY);
	    
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemUm, inventarioX + 86 ,inventarioY + 15);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemDois, inventarioX + 86 ,inventarioY + 25);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemTres, inventarioX + 86 ,inventarioY + 35);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemQuatro, inventarioX + 86 ,inventarioY + 45);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemCinco, inventarioX + 86 ,inventarioY + 55);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemSeis, inventarioX + 86 ,inventarioY + 65);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString(descricaoItemSete, inventarioX + 86 ,inventarioY + 75);
	    
        
        g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
	    
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("voltar", inventarioX + 6, inventarioY + 95);
        
        if (moonsword == 1) {
	    	g.drawImage(Entidade.moonsword , campoX + 29, campoY + 21, jframe);
	    }
	    if (sword == 1) {
        	g.drawImage(Entidade.sword , campoX + 16, campoY + 21, jframe);
        }
        
        if (adaga == 1) {
        	g.drawImage(Entidade.adaga , campoX + 4, campoY + 21, jframe);
        }
        
	    switch (estadoAtualInventarioItemDois) {
        case 0:
    	    g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 5, inventarioY + 16, 10 , 31);
    	    if (adaga == 1) {
    	    	g.drawImage(Entidade.adaga , campoX + 4, campoY + 21, jframe);
    	        descricaoItemUm = "";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "";
    	        descricaoItemQuatro = "";
    	        descricaoItemCinco = "";
    	        descricaoItemSeis = "";
    	        descricaoItemSete = " ";
    	        }
       	 break;
        case 1:
        	g.setColor(Color.RED);
        	g.fillRect(inventarioX + 17, inventarioY + 16, 10  , 47);
        	if (sword == 1) {
    	    	g.drawImage(Entidade.sword , campoX + 16, campoY + 21, jframe);
    	    	 descricaoItemUm = "";
     	        descricaoItemDois = "";
     	        descricaoItemTres = "";
     	        descricaoItemQuatro = "";
     	        descricaoItemCinco = "";
     	        descricaoItemSeis = "";
     	        descricaoItemSete = " ";            
    	        }
            break;
        case 2:
        	g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 29, inventarioY + 16, 12 , 55);
        	if (moonsword == 1) {
        		g.drawImage(Entidade.moonsword , campoX + 29, campoY + 21, jframe);
    	    	descricaoItemUm = "";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "";
    	        descricaoItemQuatro = "";
    	        descricaoItemCinco = "";
    	        descricaoItemSeis = "";
    	        descricaoItemSete = " ";           
    	        }
            break;
        case 3:
        	g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
    	    
    	    g.setColor(Color.BLACK);
    	    g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("voltar", inventarioX + 6, inventarioY + 95);
            
            descricaoItemUm = "";
 	        descricaoItemDois = "";
 	        descricaoItemTres = "";
 	        descricaoItemQuatro = "";
 	        descricaoItemCinco = "";
 	        descricaoItemSeis = "";
 	        descricaoItemSete = " "; 
            
            if (Game.player.selecionado) {
            	ItemDois = false;
            	estadoAtualInventarioItemDois = 0;
            	Game.player.selecionado = false;
            }
          	 break;
          	 
        }
	    
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Armas", campoX - 12, campoY - 5);
	}
	
	public void renderPaginaTres(Graphics g) {
		
		int inventarioX = 105;
	    int inventarioY = 75;
	    int larguraInventario = 160;
	    int alturaInventario = 100;
	    int campoX = 113;
		int campoY = 70;
		int campoHeight = 20;
		
		int campoItemX = 16;
		int campoItemY = 16;
		
		int campoDescricaoX = 50;
		int campoDescricaoY = 92;
		
        Color corPaginaVelha = new Color(210, 200, 170);
		
		Color corMarromEscuro = new Color(139, 69, 19); 
		
		Color corPaginaVelhaMaisEscura = new Color(160, 150, 120); 
		
		Color corMarromMaisEscuro = new Color(100, 50, 10);

		 g.drawImage(Entidade.BookInventarioPagina , campoX - 27, campoY - 29, jframe);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 16, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 16, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 34, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 5, inventarioY + 52, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 23, inventarioY + 52, campoItemX , campoItemY);
	    
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 41, inventarioY + 52, campoItemX , campoItemY);
        
	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 59, inventarioY + 52, campoItemX , campoItemY);

	    g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 105, inventarioY - 15, campoDescricaoX + 38, campoDescricaoY + 45);
	    
	    g.setColor(corPaginaVelha);
	    g.fillRect(inventarioX + 105, inventarioY - 15, campoDescricaoX, campoDescricaoY - 35);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemUm, inventarioX + 106 ,inventarioY + 55);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDois, inventarioX + 106 ,inventarioY + 65);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemTres, inventarioX + 106 ,inventarioY + 75);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemQuatro, inventarioX + 106 ,inventarioY + 85);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemCinco, inventarioX + 106 ,inventarioY + 95);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemSeis, inventarioX + 106 ,inventarioY + 105);
        g.setColor(Color.BLACK);
	    g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemSete, inventarioX + 106 ,inventarioY + 115);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemOito, inventarioX + 106 ,inventarioY + 125);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemNove, inventarioX + 106 ,inventarioY + 135);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDez, inventarioX + 106 ,inventarioY + 145);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemOnze, inventarioX + 106 ,inventarioY + 155);
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawString(descricaoItemDoze, inventarioX + 106 ,inventarioY + 165);
	   
        
        if (chave == 1) {
            g.drawImage(Entidade.rustKey , campoX - 3, campoY + 21, jframe);
        }
        
        if (medalsol == 1) {
        	 g.drawImage(Entidade.medalSol , campoX + 15, campoY + 21, jframe);
        }
            
        if (candle == 1) {
            g.drawImage(Entidade.candle , campoX + 33, campoY + 21, jframe);
        }

        g.setColor(corPaginaVelhaMaisEscura);
	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
	    
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("voltar", inventarioX + 6, inventarioY + 95);
        
	    
	    switch (estadoAtualInventarioItemTres) {
        case 0:
        	g.setColor(Color.RED);
        	g.fillRect(inventarioX + 5, inventarioY + 16, campoItemX , campoItemY);
    	    if (chave == 1) {
    	    	g.drawImage(Entidade.itemDescripitionKey , campoX + 100, campoY - 6, jframe);
    	    	g.drawImage(Entidade.rustKey , campoX - 3, campoY + 21, jframe);
    	    	descricaoItemUm = "Chave velha";
     	        descricaoItemDois = "";
     	        descricaoItemTres = "uma chave";
     	        descricaoItemQuatro = "enferrujada";
     	        descricaoItemCinco = "";
     	        descricaoItemSeis = "";
     	        descricaoItemSete = " ";            
    	        }
       	 break;
        case 1:
        	g.setColor(Color.RED);
        	g.fillRect(inventarioX + 23, inventarioY + 16, campoItemX , campoItemY);
    	    if (medalsol == 1) {
    	    	g.drawImage(Entidade.itemDescripitionMedal , campoX + 100, campoY - 6, jframe);
    	    	g.drawImage(Entidade.medalSol , campoX + 15, campoY + 21, jframe);
    	    	descricaoItemUm = "medalha de solanes";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "medalhao dado";
    	        descricaoItemQuatro = "aos soldados";
    	        descricaoItemCinco = "do reino de";
    	        descricaoItemSeis = "solanes";
    	        descricaoItemSete = "  ";
     	        } else {
     	        	descricaoItemUm = "";
     	  	        descricaoItemDois = "";
     	  	        descricaoItemTres = "";
     	  	        descricaoItemQuatro = "";
     	  	        descricaoItemCinco = "";
     	  	        descricaoItemSeis = "";
     	  	        descricaoItemSete = " "; 
     	        }
            break;
        case 2:
        	g.setColor(Color.RED);
        	 g.fillRect(inventarioX + 41, inventarioY + 16, campoItemX , campoItemY);
    	    if (candle == 1) {
    	    	g.drawImage(Entidade.itemDescripitionCandle , campoX + 100, campoY - 6, jframe);
    	    	g.drawImage(Entidade.candle , campoX + 33, campoY + 21, jframe);
    	    	descricaoItemUm = "presente";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "um sentimento fam-";
    	        descricaoItemQuatro = "iliar vindo da vela.";
    	        descricaoItemCinco = "Por que eu estou ";
    	        descricaoItemSeis = "chorando?";
    	        descricaoItemSete = " ";
           } else {
        	    descricaoItemUm = "";
    	        descricaoItemDois = "";
    	        descricaoItemTres = "";
    	        descricaoItemQuatro = "";
    	        descricaoItemCinco = "";
    	        descricaoItemSeis = "";
    	        descricaoItemSete = " "; 
           }
            break;
        case 3:
        	g.setColor(Color.RED);
    	    g.fillRect(inventarioX + 4, inventarioY + 86, campoItemX + 14 , campoItemY - 5);
    	    
    	    g.setColor(Color.BLACK);
    	    g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("voltar", inventarioX + 6, inventarioY + 95);
            
            descricaoItemUm = "";
 	        descricaoItemDois = "";
 	        descricaoItemTres = "";
 	        descricaoItemQuatro = "";
 	        descricaoItemCinco = "";
 	        descricaoItemSeis = "";
 	        descricaoItemSete = " "; 
            
            if (Game.player.selecionado) {
            	ItemTres = false;
            	estadoAtualInventarioItemTres = 0;
            	Game.player.selecionado = false;
            } else {
            	descricaoItemUm = "";
       	        descricaoItemDois = "";
       	        descricaoItemTres = "";
       	        descricaoItemQuatro = "";
       	        descricaoItemCinco = "";
       	        descricaoItemSeis = "";
       	        descricaoItemSete = " "; 
            }
          	 break;
       
	    }
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Itens Chaves", campoX - 12, campoY - 5);
        
        
		}
	
	 public static void recompensa() {
	        Random random = new Random();
	        int resultadoDado = random.nextInt(6) + 1;  

	        System.out.println("Resultado do dado: " + resultadoDado);

	        if (resultadoDado == 6 || resultadoDado == 5 || 
	        		resultadoDado == 4 || resultadoDado == 3|| 
	        		resultadoDado == 2 || resultadoDado == 1) {
	        	Game.dialogo.notificacao = "+1 Potion";
	        	numeroFrasco += 1;
	        	
	        	Game.dialogo.frasco = true;
	    		Game.dialogo.espada = false;
	    		Game.dialogo.chave = false;
	    		Game.dialogo.candle = false;
	        	
	        } else {
	        }
	    }
    }