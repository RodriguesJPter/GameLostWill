package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Menu;

public class EntidadeMenu {
	
	private BufferedImage itemImage;

	public static Solido solido;

	private int maskx, masky,mwidth,mheight;
	

	public double x;
	public double y;
	public int width;
	public int height;
	public BufferedImage sprite;

	public EntidadeMenu(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public EntidadeMenu() {
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

	public static boolean isColidding(EntidadeMenu e1,EntidadeMenu e2) {
		Rectangle e1mask = new Rectangle(e1.getX() + e1.maskx,e1.getY() + e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2mask = new Rectangle(e2.getX() + e2.maskx,e2.getY() + e2.masky,e2.mwidth,e2.mheight);
		return e1mask.intersects(e2mask);
	}

	public void render(Graphics g) {

		g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);

	}

}
