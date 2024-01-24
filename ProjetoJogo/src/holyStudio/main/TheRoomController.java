package holyStudio.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import holyStudio.Mundo.Camera;
import holyStudio.entidade.BlocoTroca01;
import holyStudio.entidade.Catedral01;
import holyStudio.entidade.EntidadeTheRoom;
import holyStudio.entidade.ventilador;

public class TheRoomController {
	
	public int controleDoRoom = 0;
	
	public int controleDoJogo = 0;
	
	public int controleListaJogo = 0;
	
	public int frameHM = 0;
	
	public int jogoHM = 0;
	
	public boolean jogoRodando = false;
	
	public boolean tvLigada = false;
	
	public boolean vgAberto = false;
	
	public boolean escolendoJogo = false;
	
	public boolean selecionadno = false;
	
	public boolean direita = false;
	
	public boolean esquerda = false;
	
	public boolean selecionadoTV = false;
	
	public boolean selecionadoConsole = false;
	
	public boolean selecionadoEstante = false;
	
	public boolean selecionadoJogo = false;
	
	public static JFrame jframe;
	
	public static ventilador ventilador;
	
	
	public int lifeHM = 5;
	
	
	public void TheRoomController (Graphics g) {
		render(g);
		
		ventilador = new ventilador(16, 432, 54, 55, TheRoom.sprite.getSprite(16, 432, 54, 55));
		
	}
	
	public void tick() {
		
	    
	}

	
	public void room(Graphics g) {
		Color chao = new Color(52, 46, 52);
		Color parede = new Color(11, 24, 6);
		
		g.setColor(parede);
	    g.fillRect(0, 0, 500, 500);
		
		g.setColor(Color.GRAY);
	    g.fillRect(0, 230, 300, 200);
	    
	    g.setColor(chao);
	    g.fillRect(0, 240, 300, 200);
	}
	
	public void moveis(Graphics g) {
	    int campoX = 20;
	    int campoY = 20;
	    
//	    g.setColor(corMarromEscuro);
//	    g.fillRect(0, 230, 300, 200); 
	    
	    g.drawImage(EntidadeTheRoom.moveis, campoX, campoY, jframe);
	}

	 
	 public void jogoRodando(Graphics g) {
		 	int campoX = 43;
			int campoY = 34;
			
			g.drawImage(EntidadeTheRoom.telaDesligado , campoX, campoY, jframe);
			
		if (selecionadoTV == true && jogoHM == 0) {	
			g.drawImage(EntidadeTheRoom.telaNull , campoX, campoY, jframe);
		} else if (selecionadoTV == true && jogoHM == 1) {
			g.drawImage(EntidadeTheRoom.JogoHMRodandoFrame01 , campoX, campoY, jframe);
		} else if (selecionadoTV == true && jogoHM == 2) {
			g.drawImage(EntidadeTheRoom.JogoHMRodandoFrame02 , campoX, campoY, jframe);
		} else if (selecionadoTV == true && jogoHM == 3) {
			g.drawImage(EntidadeTheRoom.JogoHMRodandoFrame03 , campoX, campoY, jframe);
		}
		else if (selecionadoTV == true && jogoHM == 4) {
			g.drawImage(EntidadeTheRoom.JogoHMRodandoFrame04 , campoX, campoY, jframe);
		}
			
		 
	 }
	 
	 public void insiraOJogo(Graphics g) {
		 	int campoX = 43;
			int campoY = 34;
			
			g.drawImage(EntidadeTheRoom.localCd , campoX + 193, campoY + 11, jframe);
	 }
	 
	 public void controleDasala(Graphics g) {
		 int campoX = 43;
		 int campoY = 34;
		 	
		 switch (controleDoRoom) {
	        case 0:
	        	g.drawImage(EntidadeTheRoom.selecionadoLigar , campoX - 6, campoY + 93, jframe);
	        	 if (selecionadoTV == true) {
	        		 tvLigada = true;
	        	 } else {
	        		 tvLigada = false;
	        	 }
	        	break;
	        case 1:
	        	g.drawImage(EntidadeTheRoom.selecionadoDisc , campoX + 198, campoY + 3, jframe);
	        	 if (selecionadoConsole == true) {
	        			 vgAberto = true;
	        	 } else {
	        		 	 vgAberto = false;
	        	 }
	        	break;
	        case 2:
	        	g.drawImage(EntidadeTheRoom.selecionadoJogos , campoX - 5, campoY + 120, jframe);
	        	
	        	if (selecionadoEstante == true) {
	        		escolendoJogo = true;
	        		
	        	} else {
	        		escolendoJogo = false;
	        	}
	        	
	        	
	        	
	        	break;
		 
		 }
	 }
	 public void estante(Graphics g) {
		 	int campoX = 40;
			int campoY = 155;
			
//			g.drawImage(EntidadeTheRoom.JogoHMPerfil , campoX, campoY, jframe);
//			
//			g.drawImage(EntidadeTheRoom.JogoDSPerfil , campoX + 50, campoY, jframe);
//			
//			g.drawImage(EntidadeTheRoom.JogoCSPerfil , campoX + 70, campoY, jframe);
	 }
	 
	 public void jogos(Graphics g) {
		 	int campoX = 40;
			int campoY = 155;
			
			switch (controleListaJogo) {
	        case 0:
	        	g.drawImage(EntidadeTheRoom.JogoHMCapa , campoX, campoY, jframe);
	        	break;
	        case 1:
	        	g.drawImage(EntidadeTheRoom.JogoDSCapa , campoX + 50, campoY, jframe);
	        	break;
	        case 2:
	        	g.drawImage(EntidadeTheRoom.JogoCSCapa , campoX + 70, campoY, jframe);
	        	break;	
	        case 3:
	        	
	    	    g.drawImage(EntidadeTheRoom.iconO , 10, 160, jframe);
	    	    
	        	if (selecionadoJogo == true) {
	        		selecionadoEstante = false;
	        	}
	        	break;
	        
		 
		 }
		 
	 }
	 
	 public void capaAberta(Graphics g) {
		 	int campoX = 40;
			int campoY = 155;
			
			g.drawImage(EntidadeTheRoom.JogoCapaAberta , campoX, campoY, jframe); 
			
			g.drawImage(EntidadeTheRoom.JogoHMPerfil , campoX, campoY, jframe); 
			
			
	 }
	 
	 public void controleDoJogo(Graphics g) {
		 int campoX = 80;
		 int campoY = 210;
		 
		 g.drawImage(EntidadeTheRoom.controle , campoX, campoY, jframe);
		 
		 if (direita == true) {
			 g.drawImage(EntidadeTheRoom.controleR , campoX, campoY, jframe);
		 } else if (esquerda == true) {
			 g.drawImage(EntidadeTheRoom.controleL , campoX, campoY, jframe);
		 } else if (selecionadoTV == true || selecionadoConsole == true 
				 || selecionadoEstante == true) {
			 g.drawImage(EntidadeTheRoom.controleX , campoX, campoY, jframe);
		 } else {
			 g.drawImage(EntidadeTheRoom.controle , campoX, campoY, jframe);
		 }
		 	
		 switch (controleDoJogo) {
	        case 0:
	        	break;
	        case 1:
	        	break;
	        case 2:
	        	break;
		 
		 }
	 }
	 
	 

	public void render(Graphics g) {
		room(g);
		g.drawImage(EntidadeTheRoom.telaDesligado , 43, 34, jframe);
		if (tvLigada == true) {
    		jogoRodando(g);
    	} 
		moveis(g);
		estante(g);
		if (vgAberto == true) {
			insiraOJogo(g);
		} 
		controleDasala(g);
		if (escolendoJogo == true) {
			jogos(g);
		}
		controleDoJogo(g);
		
	}

}
