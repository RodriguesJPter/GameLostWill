package holyStudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import holyStudio.entidade.Entidade;
import holyStudio.entidade.NpcOutro;

public class Dialogos {
	
	public static NpcOutro outro;
	
	
	public int X = 20;
	public int Y = 200;
	public int largura = 350;
	public int altura = 30;
	
	public boolean visivel = false;
	
	public int linhaDialogo = 0;
	
	public int opcaoDialogo = 0;
	
	public int estadoAtualloja = 0;
	public boolean comprando = false;
	public boolean compra = false;
	
	public boolean escolendo = false;
	public static JFrame jframe;
	
	public String textoUm = "";
	public String instrucao = "Press E >>";
	
	public static String notificacao = "";
	
	public static boolean frasco = false;
	public static boolean espada = false;
	public static boolean chave = false;
	public static boolean candle = false;
	
	public void render(Graphics g) {
		
		
		dialogo(g);
		
		notificacao(g);
		
		
		if (Game.player.interagindo == false) {
			textoUm = "";
		}
	}
	
	
	
	public void dialogo(Graphics g) {
		
		Color corFundoDialogo = new Color(107, 87, 30);
		
		Color corBordaDialogo = new Color(235, 189, 59);
		
		if (!textoUm.isEmpty()) {
			g.setColor(corBordaDialogo);
            g.drawRect(X - 1, Y - 1, largura + 1, altura + 1);
            g.setColor(corFundoDialogo);
            g.fillRect(X, Y, largura, altura);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(textoUm, X + 10, Y + 15);
            g.setFont(new Font("Arial", Font.PLAIN, 8));
            g.drawString(instrucao, X + 305, Y + 26);
            
            g.drawImage(Entidade.decoracaoFalaUm , X - 6, Y - 8, jframe);
            g.drawImage(Entidade.decoracaoFalaDois , X + 322, Y + 3, jframe);
            
        } else if (textoUm.isEmpty()) {
        	
        }
		
		
	}

    public void notificacao(Graphics g) {
		
		Color corFundoDialogo = new Color(107, 87, 30);
		
		Color corBordaDialogo = new Color(235, 189, 59);
		
	
		
		 if (!notificacao.isEmpty()) {
			 
			 
			 	if (Game.dialogo.frasco == true) {
	            	g.drawImage(Entidade.itemicomPotion, X + 132, Y - 187, jframe);
	            } else if (Game.dialogo.espada == true) {
	            	g.drawImage(Entidade.itemicomSword, X + 132, Y - 187, jframe);
	            } else if (Game.dialogo.chave == true) {
	            	g.drawImage(Entidade.itemicomKey, X + 132, Y - 187, jframe);
	            } else if (Game.dialogo.candle == true) {
	            	g.drawImage(Entidade.itemicomCandle, X + 132, Y - 187, jframe);
	            }
			 
			 
	            g.drawImage(Entidade.balaoNotificacao, X + 115, Y - 190, jframe);
	            g.setColor(Color.white);
	            g.setFont(new Font("Arial", Font.PLAIN, 8));
	            g.drawString(notificacao, X + 150 , Y - 178);
	            
	           

	            agendarTarefaEsvaziarNotificacao();

	        } else if (textoUm.isEmpty()) {
	            // Restante do código...
	        }
		
		
	}
    
    private void agendarTarefaEsvaziarNotificacao() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                notificacao = "";

                Game.dialogo.frasco = false;
        		Game.dialogo.espada = false;
        		Game.dialogo.chave = false;
        		Game.dialogo.candle = false;
                
                timer.cancel();
            }
        }, 3000); // 5000 milissegundos = 5 segundos
    }


	public void setTexto(String texto) {
		this.textoUm = texto;
		
	}
}
