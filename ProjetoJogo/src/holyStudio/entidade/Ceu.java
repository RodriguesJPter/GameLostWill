package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Ceu extends Entidade {
	
	public static BufferedImage	fundo0 = Game.ceu.getSprite(0, 0, 1024, 600);
	public static BufferedImage	fundo1 = Game.ceu.getSprite(1024, 1798, 2048, 600);
	public static BufferedImage	fundo2 = Game.ceu.getSprite(1024, 2398, 2048, 1200);
	public static BufferedImage	fundo3 = Game.ceu.getSprite(1040, 0, 720, 1000);
	public static BufferedImage	fundo4 = Game.ceu.getSprite(3072, 1798, 2048, 600);
	public static BufferedImage	fundo5 = Game.ceu.getSprite(0, 2398, 1024, 600);
	public static BufferedImage	fundo6 = Game.ceu.getSprite(0, 2998, 1024, 600);
	public static BufferedImage	fundo7 = Game.ceu.getSprite(0, 2998, 1024, 600);
	public static BufferedImage	fundo8 = Game.ceu.getSprite(0, 1798, 1024, 600);
	
	public static BufferedImage	casa1 = Game.ceu.getSprite(1109, 1074, 326, 167);
	public static BufferedImage	casa2 = Game.ceu.getSprite(1518, 1071, 334, 181);
	public static BufferedImage	casa3 = Game.ceu.getSprite(1102, 1302, 492, 187);
	

	public Ceu(int x, int y, int width, int height, BufferedImage chao) {
		super(x, y, width, height, chao);
		
		
	}
	
	@Override
	public void render(Graphics g) {
		if (Game.mapaAtual == Game.mapaContador.mapa00) {
			g.drawImage(fundo0, this.getX()-Camera.x + 53, this.getY()-Camera.y - 180, null);
			
		} else if (Game.mapaAtual == Game.mapaContador.mapa01) {
			g.drawImage(fundo1, this.getX()-Camera.x + 33, this.getY()-Camera.y - 180, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.mapa02) {
			g.drawImage(fundo2, this.getX()-Camera.x + 33, this.getY()-Camera.y - 180, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.mapa03) {
			g.drawImage(fundo3, this.getX()-Camera.x + 33, this.getY()-Camera.y - 60, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.mapa04) {
			g.drawImage(fundo4, this.getX()-Camera.x + 33, this.getY()-Camera.y - 180, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.mapa05) {
			g.drawImage(fundo5, this.getX()-Camera.x + 33, this.getY()-Camera.y - 180, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.mapa06) {
			g.drawImage(fundo6, this.getX()-Camera.x + 33, this.getY()-Camera.y - 204, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.casa01) {
			g.drawImage(casa1, this.getX()-Camera.x + 25, this.getY()-Camera.y - 25, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.casa02) {
			g.drawImage(casa2, this.getX()-Camera.x + 20, this.getY()-Camera.y - 31, null);
			
		}  else if (Game.mapaAtual == Game.mapaContador.casa03) {
			g.drawImage(casa3, this.getX()-Camera.x + 15, this.getY()-Camera.y - 43, null);
			
		}   else if (Game.mapaAtual == Game.mapaContador.mapa08) {
			g.drawImage(fundo8, this.getX()-Camera.x + 15, this.getY()-Camera.y - 43, null);
			
		}
	}
	

}
