package holyStudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import holyStudio.entidade.Entidade;

public class UserInterface{
	
	public boolean estadoAlternado = false;
	
	public static int estadoAtual = 0;
	

	
	public int maislevelHP = 0;
	
	public int maislevelHE = 0;
	
	public int nextLevel = 25;
	
	public static boolean temEspada = false;
	
	private String textoNoCampo = "";
	private int contador = 10;
	private String contagemWill = "";
	private String interacaoNpc = "";
	
	public static JFrame jframe;
	
	public static boolean confirmacao = false;

	public void render(Graphics g) {
		
		lifeBar(g);
//		estaminaBar(g);
		g.drawImage(Entidade.barra01 , 0, 0, jframe);
		g.drawImage(Entidade.barra01End , 67, 0, jframe);
		frascoNumero(g);
		contadorWill(g);
		contadorObjeto(g);
		onClickDoBotao(g);
//		dialogo(g);
			
		
	}
	
	public void levelUp (Graphics g) {
		    int lojinhaX = 100;
	        int lojinhaY = 22;
	        int larguraLojinha = 59;
	        int alturaLojinha = 90;
	        int campoX = 30;
	        int campoY = 35;
	        int campoHeight = 20;
	        int campoItemx = 52;
	        int campoItemY = 16;
	        
			    int ClojinhaX = 80;
		        int ClojinhaY = 40;
		        int ClarguraLojinha = 80;
		        int CalturaLojinha = 40;
	        
	        
	        
	        g.setColor(Color.LIGHT_GRAY);
	        g.fillRect(lojinhaX, lojinhaY, larguraLojinha, alturaLojinha);

	        g.setColor(Color.BLACK);
	        g.drawRect(lojinhaX, lojinhaY, larguraLojinha, alturaLojinha);

	        g.setFont(new Font("Arial", Font.PLAIN, 10));
	        g.drawString("Estatua", lojinhaX + 3, lojinhaY + campoHeight - 8);
	        
	        g.setColor(Color.DARK_GRAY);
	        g.fillRect(lojinhaX + 4, lojinhaY + 15, campoItemx, campoItemY + 2);
	        
	        g.setColor(Color.BLACK);
	        g.setFont(new Font("Arial", Font.PLAIN, 9));
	        g.drawString("Level     " + Game.player.PlayerLevel, lojinhaX + 4, lojinhaY + 24);
	        
	        g.setColor(Color.BLACK);
	        g.setFont(new Font("Arial", Font.PLAIN, 9));
	        g.drawString("Will       " + nextLevel, lojinhaX + 4, lojinhaY + 32);
	        
	        g.setColor(Color.GRAY);
	        g.fillRect(lojinhaX + 4, lojinhaY + 36, campoItemx, campoItemY);
	        
	        g.setColor(Color.BLACK);
	        g.setFont(new Font("Arial", Font.PLAIN, 9));
	        g.drawString("HP " + Game.player.life, lojinhaX + 6, lojinhaY + 48);

	        g.setColor(Color.GRAY);
	        g.fillRect(lojinhaX + 4, lojinhaY + 53, campoItemx, campoItemY);
	        
	        g.setColor(Color.BLACK);
	        g.setFont(new Font("Arial", Font.PLAIN, 9));
	        g.drawString("HE " + Game.player.estamina, lojinhaX + 6, lojinhaY + 64);
	        
	        g.setColor(Color.GRAY);
	        g.fillRect(lojinhaX + 4, lojinhaY + 70, campoItemx, campoItemY);
	        
	        g.setColor(Color.BLACK);
	        g.setFont(new Font("Arial", Font.PLAIN, 9));
	        g.drawString("For " + Game.player.forca, lojinhaX + 6, lojinhaY + 82);
	        
	        
	        switch (Game.dialogo.estadoAtualloja) {
	         case 0:
	        	g.setColor(Color.red);
	 	        g.fillRect(lojinhaX + 4, lojinhaY + 36, campoItemx, campoItemY);
	 	        g.setColor(Color.BLACK);
		        g.setFont(new Font("Arial", Font.PLAIN, 9));
		        g.drawString("HP " + Game.player.life, lojinhaX + 6, lojinhaY + 48);
		        
		        if (Game.player.selecionado == true) {
		        	if (Game.inventario.numeroDeWill >= nextLevel) {
		        		Game.player.maxLife += 5;
		        		Game.inventario.numeroDeWill -= nextLevel;
			        	Game.player.PlayerLevel += 1;
			         	maislevelHP += 5;
			        	nextLevel += 15;
		        		Game.player.selecionado = false;
			        	
		        	}
		        	
		        }
		        
	        	 break;
	         case 1:
	        	g.setColor(Color.red);
	 	        g.fillRect(lojinhaX + 4, lojinhaY + 53, campoItemx, campoItemY);
	 	        g.setColor(Color.BLACK);
		        g.setFont(new Font("Arial", Font.PLAIN, 9));
		        g.drawString("HE " + Game.player.maxestamina, lojinhaX + 6, lojinhaY + 64);
		        if (Game.player.selecionado == true) {
		        	if (Game.inventario.numeroDeWill >= nextLevel) {
		        		Game.player.maxestamina += 5;
		        		Game.inventario.numeroDeWill -= nextLevel;
			        	Game.player.PlayerLevel += 1;
			        	maislevelHE += 5;
			        	nextLevel += 15;
		        		Game.player.selecionado = false;
			        	
		        	}
		        	
		        }
	             break;
	         case 2:
	        	g.setColor(Color.red);
	 	        g.fillRect(lojinhaX + 4, lojinhaY + 70, campoItemx, campoItemY);
	 	        g.setColor(Color.BLACK);
		        g.setFont(new Font("Arial", Font.PLAIN, 9));
		        g.drawString("For " + Game.player.forca, lojinhaX + 6, lojinhaY + 82);
		        if (Game.player.selecionado == true) {
		        	if (Game.inventario.numeroDeWill >= nextLevel) {
		        		Game.player.forca += 2;
		        		Game.inventario.numeroDeWill -= nextLevel;
			        	Game.player.PlayerLevel += 1;
			        	nextLevel += 15;
		        		Game.player.selecionado = false;
			        	
		        	}
		        	
		        }
		        
	             break;
	         }
	}

	 public void onClickDoBotao(Graphics g) {
		 
		 int contadorX = 25;
		 int contadorY = 11;
		 
		 
		 if (Game.inventario.sword == 1) {
			 temEspada = true;
		 }
		 
		 
		 switch (estadoAtual) {
         case 0:
             g.drawImage(Entidade.iconA, contadorX, contadorY, jframe);
             Game.player.armaescolida = Game.player.danoAdaga;
             Game.player.descansadoNivel = 20;
             break;
         case 1:
        	 if (Game.inventario.sword == 1) {
        		 g.drawImage(Entidade.iconS, contadorX, contadorY, jframe);
        		 Game.player.armaescolida = Game.player.danoSword;
        		 Game.player.descansadoNivel = 50;
        	 } else {
        		 if (Game.inventario.laminaDupla == 1) {
            		 g.drawImage(Entidade.iconL, contadorX, contadorY, jframe);
            		 Game.player.armaescolida = Game.player.danoLamina;
            	 } else {
            		 estadoAtual = 0;
            	 }
        	 }
             break;
         case 2:
        	 if (temEspada == false) {
        		estadoAtual = 0;
        	 } else {
        		 if (Game.inventario.laminaDupla == 1) {
            		 g.drawImage(Entidade.iconL, contadorX, contadorY, jframe);
            		 Game.player.armaescolida = Game.player.danoLamina;
            	 } else {
            		 estadoAtual = 0;
            	 } 
        	 }
        	 
             break;
         }
     }
	 
	
	public void frascoNumero(Graphics g) {
		int contadorX = 5;
		int contadorY = 9;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 8));
		g.drawImage(Entidade.frasco, contadorX, contadorY, jframe);
		g.drawString(" " + Game.inventario.numeroFrasco, contadorX + 12, contadorY + 14);
		
		
	}
	
	public void contadorWill(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 8));

		int contadorX = 360;
		int contadorY = 20;
		g.drawString(": " + Game.inventario.numeroDeWill, contadorX, contadorY);
		g.drawImage(Entidade.will , contadorX - 13, contadorY - 15, jframe);
	}

	public void contadorObjeto(Graphics g) {
		int campoX = 30;
		int campoY = 115;
		int campoWidth = 200;
		int campoHeight = 20;
		if (!Game.player.texto.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(campoX, campoY, campoWidth, campoHeight);
            g.setColor(Color.BLACK);
            g.drawRect(campoX, campoY, campoWidth, campoHeight);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(Game.player.texto, campoX + 5, campoY + campoHeight - 5);
        } 
	}
	
	
	
	public void lifeBar(Graphics g) {
		int inventarioXB = 16; 
        int inventarioYB = 5;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
        Color cordeSangueDois = new Color(71, 3, 3);
        Color cordeSangue = new Color(136, 8, 8);
        Color contorno = new Color(182, 138, 72);
        
		g.setColor(contorno);
		g.fillRect(inventarioXB, inventarioYB, 52, 7);

		g.setColor(cordeSangueDois);
		g.fillRect(inventarioX, inventarioY, 50, 5);

		g.setColor(cordeSangue);
		g.fillRect(inventarioX, inventarioY, (int) ((Game.player.life / Game.player.maxLife) * 50 + maislevelHP), 5);
	}
	
	public void estaminaBar(Graphics g) {
		int inventarioXB = 5; 
        int inventarioYB = 13;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
        
        Color cordeestamina = new Color(68, 166, 95);
		
		g.setColor(Color.ORANGE);
		g.fillRect(inventarioXB, inventarioYB, 42, 5);

		g.setColor(Color.red);
		g.fillRect(inventarioX, inventarioY, 40, 3);

		g.setColor(cordeestamina);
		g.fillRect(inventarioX, inventarioY, (int) ((Game.player.estamina / Game.player.maxestamina) * 40 + maislevelHE), 3);
	}
	
	public void dialogo(Graphics g) {
		int campoX = 30;
		int campoY = 115;
		int campoWidth = 200;
		int campoHeight = 20;
		if (!interacaoNpc.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(campoX, campoY, campoWidth, campoHeight);
            g.setColor(Color.BLACK);
            g.drawRect(campoX, campoY, campoWidth, campoHeight);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(interacaoNpc, campoX + 5, campoY + campoHeight - 5);
        } else if (interacaoNpc.isEmpty()) {
        	interacaoNpc = "";
        }
	}

	public void tick() {
        if (contador > 0) {
            contador--; 
        } else {
            textoNoCampo = "";
        }
	}
        public void setTexto(String texto){
    		this.interacaoNpc = texto;
    	}


    }

