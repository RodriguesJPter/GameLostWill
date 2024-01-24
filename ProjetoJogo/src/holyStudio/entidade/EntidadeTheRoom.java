package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;
import holyStudio.main.TheRoom;

public class EntidadeTheRoom {
	
	private BufferedImage itemImage;

	public static Solido solido;

	private int maskx, masky,mwidth,mheight;
	
	public static BufferedImage BotaoTheRoom = TheRoom.sprite.getSprite(448, 48, 16, 16);
	
	public static BufferedImage moveis = TheRoom.sprite.getSprite(13, 16, 266, 227);
	public static BufferedImage localCd = TheRoom.sprite.getSprite(98, 276, 51, 41);
	public static BufferedImage controle = TheRoom.sprite.getSprite(227, 290, 128, 92);
	public static BufferedImage controleL = TheRoom.sprite.getSprite(356, 290, 128, 92);
	public static BufferedImage controleR = TheRoom.sprite.getSprite(485, 290, 128, 92);
	public static BufferedImage controleX = TheRoom.sprite.getSprite(356, 383, 128, 92);
	public static BufferedImage telaNull = TheRoom.sprite.getSprite(33, 646, 113, 92);
	public static BufferedImage telaDesligado = TheRoom.sprite.getSprite(152, 646, 113, 92);
	
	public static BufferedImage selecionadoLigar = TheRoom.sprite.getSprite(351, 51, 21, 11);
	public static BufferedImage selecionadoDisc = TheRoom.sprite.getSprite(392, 54, 5, 8);
	public static BufferedImage selecionadoJogos = TheRoom.sprite.getSprite(350, 79, 210, 63);
	public static BufferedImage iconO = TheRoom.sprite.getSprite(415, 48, 16, 16);
	
//	public static BufferedImage moveisDois = TheRoom.sprite.getSprite(32, 2608, 16, 16);
	
	public static BufferedImage JogoHMPerfil = TheRoom.sprite.getSprite(18, 326, 7, 63);
	public static BufferedImage JogoHMCapa = TheRoom.sprite.getSprite(92, 326, 42, 62);
	public static BufferedImage JogoHMCd = TheRoom.sprite.getSprite(46, 278, 36, 36);
	
	public static BufferedImage JogoHMRodandoFrame01 = TheRoom.sprite.getSprite(32, 758, 115, 92);
	public static BufferedImage JogoHMRodandoFrame02 = TheRoom.sprite.getSprite(151, 758, 115, 92);
	public static BufferedImage JogoHMRodandoFrame03 = TheRoom.sprite.getSprite(270, 758, 115, 92);
	public static BufferedImage JogoHMRodandoFrame04 = TheRoom.sprite.getSprite(389, 758, 115, 92);
	
	public static BufferedImage JogoDSPerfil = TheRoom.sprite.getSprite(31, 517, 7, 63);
	public static BufferedImage JogoDSCapa = TheRoom.sprite.getSprite(43, 517, 42, 62);
	public static BufferedImage JogoDSCd = TheRoom.sprite.getSprite(46, 278, 36, 36);
	
	public static BufferedImage JogoCSPerfil = TheRoom.sprite.getSprite(90, 517, 7, 63);
	public static BufferedImage JogoCSCapa = TheRoom.sprite.getSprite(102, 517, 42, 62);
	public static BufferedImage JogoCSCd = TheRoom.sprite.getSprite(46, 278, 36, 36);
	
	public static BufferedImage JogoCapaAberta = TheRoom.sprite.getSprite(33, 322, 55, 72);

	public double x;
	public double y;
	public int width;
	public int height;
	public BufferedImage sprite;

	public EntidadeTheRoom(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public EntidadeTheRoom() {
		// TODO Auto-generated constructor stub
	}

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

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void tick() {

	}

	public static boolean isColidding(EntidadeTheRoom e1,EntidadeTheRoom e2) {
		Rectangle e1mask = new Rectangle(e1.getX() + e1.maskx,e1.getY() + e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2mask = new Rectangle(e2.getX() + e2.maskx,e2.getY() + e2.masky,e2.mwidth,e2.mheight);
		return e1mask.intersects(e2mask);
	}

	public void render(Graphics g) {

		g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);

	}

}
