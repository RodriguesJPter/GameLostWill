package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Entidade {
	
	private BufferedImage itemImage;

	public static Solido solido;

	private int maskx, masky,mwidth,mheight;
	
	public static BufferedImage chaoP = Game.sprite.getSprite(512, 176, 16, 16);
	public static BufferedImage teto1 = Game.sprite.getSprite(448, 144, 16, 16);
	public static BufferedImage teto2 = Game.sprite.getSprite(400, 144, 16, 16);
	public static BufferedImage teto3 = Game.sprite.getSprite(416, 144, 16, 16);
	public static BufferedImage nada = Game.sprite.getSprite(930, 10, 16, 16);
	public static BufferedImage vazio = Game.sprite.getSprite(512, 144, 16, 16);
	public static BufferedImage grama01 = Game.sprite.getSprite(608, 240, 16, 16);
	public static BufferedImage grama02 = Game.sprite.getSprite(624, 240, 16, 16);
	public static BufferedImage grama03 = Game.sprite.getSprite(640, 240, 16, 16);
	
	//mapa 00
	public static BufferedImage gramaM01 = Game.sprite.getSprite(512, 304, 16, 16);
	public static BufferedImage gramaM02 = Game.sprite.getSprite(528, 304, 16, 16);
	public static BufferedImage gramaM03 = Game.sprite.getSprite(544, 304, 16, 16);
	public static BufferedImage gramaML = Game.sprite.getSprite(560, 304, 16, 16);
	public static BufferedImage gramaMR = Game.sprite.getSprite(592, 304, 16, 16);
	public static BufferedImage gramaML02 = Game.sprite.getSprite(512, 336, 16, 16);
	public static BufferedImage gramaMR02 = Game.sprite.getSprite(544, 336, 16, 16);
	
	//mapa 03
	public static BufferedImage pedregulho01 = Game.sprite.getSprite(592, 368, 16, 16);
	public static BufferedImage pedregulho02 = Game.sprite.getSprite(608, 368, 16, 16);
	public static BufferedImage pedregulho03 = Game.sprite.getSprite(624, 368, 16, 16);
	public static BufferedImage pedregulhoL = Game.sprite.getSprite(576, 368, 16, 16);
	public static BufferedImage pedregulhoR = Game.sprite.getSprite(640, 368, 16, 16);
	public static BufferedImage terraGL = Game.sprite.getSprite(576, 384, 16, 16);
	public static BufferedImage terraGR = Game.sprite.getSprite(640, 384, 16, 16);
	public static BufferedImage soloGM01 = Game.sprite.getSprite(592, 384, 16, 16);
	public static BufferedImage soloGM02 = Game.sprite.getSprite(608, 384, 16, 16);
	public static BufferedImage soloGM03 = Game.sprite.getSprite(624, 384, 16, 16);
	public static BufferedImage soloGML = Game.sprite.getSprite(576, 400, 16, 16);
	public static BufferedImage soloGMR = Game.sprite.getSprite(640, 400, 16, 16);
	
	public static BufferedImage solo01 = Game.sprite.getSprite(608, 256, 16, 16);
	public static BufferedImage solo02 = Game.sprite.getSprite(624, 256, 16, 16);
	public static BufferedImage solo03 = Game.sprite.getSprite(640, 256, 16, 16);
	public static BufferedImage soloM01 = Game.sprite.getSprite(512, 320, 16, 16);
	public static BufferedImage soloM02 = Game.sprite.getSprite(528, 320, 16, 16);
	public static BufferedImage soloM03 = Game.sprite.getSprite(544, 320, 16, 16);
	public static BufferedImage soloML = Game.sprite.getSprite(560, 320, 16, 16);
	public static BufferedImage soloMR = Game.sprite.getSprite(592, 320, 16, 16);
	public static BufferedImage terra01 = Game.sprite.getSprite(608, 272, 16, 16);
	public static BufferedImage terra02 = Game.sprite.getSprite(624, 272, 16, 16);
	public static BufferedImage terra03 = Game.sprite.getSprite(640, 272, 16, 16);
	public static BufferedImage terraM01 = Game.sprite.getSprite(512, 336, 16, 16);
	public static BufferedImage terraM02 = Game.sprite.getSprite(528, 336, 16, 16);
	public static BufferedImage terraM03 = Game.sprite.getSprite(544, 336, 16, 16);
	public static BufferedImage terraML = Game.sprite.getSprite(560, 336, 16, 16);
	public static BufferedImage terraMR = Game.sprite.getSprite(592, 336, 16, 16);
	public static BufferedImage terraML02 = Game.sprite.getSprite(512, 352, 16, 16);
	public static BufferedImage terraMR02 = Game.sprite.getSprite(544, 352, 16, 16);
	
	public static BufferedImage espinho = Game.sprite.getSprite(576, 192, 16, 16);
	
	public static BufferedImage bossParede = Game.sprite.getSprite(512, 192, 16, 16);	
	
	public static BufferedImage tronco01 = Game.sprite.getSprite(608, 304, 16, 16);
	public static BufferedImage tronco02 = Game.sprite.getSprite(640, 304, 16, 16);
	public static BufferedImage pedra01 = Game.sprite.getSprite(608, 320, 16, 16);
	public static BufferedImage pedra02 = Game.sprite.getSprite(640, 320, 16, 16);
	public static BufferedImage chaocasa = Game.sprite.getSprite(624, 336, 16, 16);
	
	public static BufferedImage ponte01 = Game.sprite.getSprite(576, 240, 16, 16);
	public static BufferedImage ponte02 = Game.sprite.getSprite(560, 240, 16, 16);
	public static BufferedImage ponte03 = Game.sprite.getSprite(544, 240, 16, 16);
	public static BufferedImage ponte04 = Game.sprite.getSprite(576, 256, 16, 16);
	
	public static BufferedImage escadaPontaL = Game.sprite.getSprite(464, 384, 16, 16);
	public static BufferedImage escadaPontaR = Game.sprite.getSprite(480, 384, 16, 16);
	public static BufferedImage escadaL = Game.sprite.getSprite(464, 400, 16, 16);
	public static BufferedImage escadaR = Game.sprite.getSprite(480, 400, 16, 16);
	public static BufferedImage escadaTerraL = Game.sprite.getSprite(464, 476, 16, 16);
	public static BufferedImage escadaTerraR = Game.sprite.getSprite(480, 476, 16, 16);
	public static BufferedImage escadaPontaL02 = Game.sprite.getSprite(464, 432, 16, 16);
	public static BufferedImage escadaPontaR02 = Game.sprite.getSprite(480, 432, 16, 16);
	
	public static BufferedImage grama = Game.sprite.getSprite(608, 224, 16, 16);

	public static BufferedImage escadaE = Game.sprite.getSprite(385, 113, 16, 16);
	public static BufferedImage escadaD = Game.sprite.getSprite(401, 113, 16, 16);

	public static BufferedImage iniciofundoceu = Game.ceu.getSprite(0, 0, 16, 16);

	public static BufferedImage iniciofundo = Game.ceu.getSprite(0, 160, 16, 16);

	public static BufferedImage fundo = Game.ceu.getSprite(0, 320, 16, 16);
	
	public static BufferedImage inimigoRato = Game.sprite.getSprite(512, 144, 16, 16);
	
	public static BufferedImage inimigoWendigo = Game.sprite.getSprite(16, 1024, 16, 16);
	
	public static BufferedImage inimigoSoldado = Game.sprite.getSprite(3, 768, 16, 16);
	
	public static BufferedImage bossDog = Game.sprite.getSprite(1850, 143, 85, 80);

	public static BufferedImage caixote = Game.sprite.getSprite(736, 272, 32, 32);
	
	public static BufferedImage npcMoon = Game.sprite.getSprite(1, 336, 16, 16);
	public static BufferedImage aparenciaMoon = Game.sprite.getSprite(772, 855, 74, 137);
	
	public static BufferedImage aparenciaNun = Game.sprite.getSprite(64, 848, 80, 144);
	
	public static BufferedImage npcDoll = Game.sprite.getSprite(80, 336, 16, 16);
	public static BufferedImage aparenciaDoll = Game.sprite.getSprite(527, 865, 51, 127);
	
	public static BufferedImage npcOutro = Game.sprite.getSprite(0, 400, 16, 16);
	public static BufferedImage aparenciaOutro = Game.sprite.getSprite(870, 845, 112, 134);
	public static BufferedImage aparenciaOutroDois = Game.sprite.getSprite(176, 832, 112, 160);
	
	public static BufferedImage npcMercador = Game.sprite.getSprite(64, 400, 16, 16);
	public static BufferedImage aparenciaMercador = Game.sprite.getSprite(608, 862, 133, 130);

	public static BufferedImage lixo = Game.sprite.getSprite(672, 80, 16, 16);
	
	public static BufferedImage medalSol = Game.sprite.getSprite(720, 48, 16, 16);
	
	public static BufferedImage chave = Game.sprite.getSprite(736, 48, 16, 16);
	
	public static BufferedImage coracao = Game.sprite.getSprite(736, 96, 16, 16);
	
	public static BufferedImage rustKey = Game.sprite.getSprite(752, 48, 16, 16);
	
	public static BufferedImage candle = Game.sprite.getSprite(768, 96, 16, 16);
	
	public static BufferedImage lagrima = Game.sprite.getSprite(736, 80, 16, 16);
	
	public static BufferedImage moonsword = Game.sprite.getSprite(688, 48, 16, 56);
	
	public static BufferedImage sword = Game.sprite.getSprite(704, 48, 16, 48);
	
	public static BufferedImage adaga = Game.sprite.getSprite(672, 48, 16, 32);
	
	public static BufferedImage poste1 = Game.sprite.getSprite(704, 336, 16, 48);
	
	public static BufferedImage frasco = Game.sprite.getSprite(720, 80, 16, 16);
	
	public static BufferedImage frascoG = Game.sprite.getSprite(720, 96, 16, 16);
	
	public static BufferedImage cranio = Game.sprite.getSprite(720, 64, 16, 16);
	
	public static BufferedImage propespada = Game.sprite.getSprite(432, 262, 16, 16);
	
	public static BufferedImage propPilhaCorpos = Game.sprite.getSprite(432, 262, 16, 16);
	
	public static BufferedImage will = Game.sprite.getSprite(656, 80, 16, 16);
	
	public static BufferedImage BookInventario = Game.sprite.getSprite(1216, 1488, 352, 240);
	public static BufferedImage BookInventarioPagina = Game.sprite.getSprite(1360, 1808, 224, 176);
	
	public static BufferedImage balaoNotificacao = Game.sprite.getSprite(566, 624, 109, 19);
	public static BufferedImage itemicomPotion = Game.sprite.getSprite(624, 656, 13, 13);
	public static BufferedImage itemicomKey = Game.sprite.getSprite(640, 656, 13, 13);
	public static BufferedImage itemicomSword = Game.sprite.getSprite(592, 672, 13, 13);
	public static BufferedImage itemicomCandle = Game.sprite.getSprite(608, 672, 13, 13);
	
	public static BufferedImage iconS = Game.sprite.getSprite(768, 48, 16, 16);
	public static BufferedImage iconM = Game.sprite.getSprite(768, 64, 16, 16);
	public static BufferedImage iconL = Game.sprite.getSprite(784, 48, 16, 16);
	public static BufferedImage iconA = Game.sprite.getSprite(768, 80, 16, 16);
	
	public static BufferedImage iconI = Game.sprite.getSprite(704, 607, 28, 88);
	public static BufferedImage iconAm = Game.sprite.getSprite(731, 607, 28, 88);
	public static BufferedImage iconK = Game.sprite.getSprite(759, 607, 28, 88);
	public static BufferedImage iconIA = Game.sprite.getSprite(787, 607, 28, 88);
	public static BufferedImage iconAmA = Game.sprite.getSprite(815,  607, 28, 88);
	public static BufferedImage iconKA = Game.sprite.getSprite(843,  607, 28, 88);
	public static BufferedImage magicBook = Game.sprite.getSprite(896,  624, 40, 58);
	
	
	public static BufferedImage pintura = Game.sprite.getSprite(786, 712, 83, 118);
	public static BufferedImage pinturacencura = Game.sprite.getSprite(696, 712, 83, 118);
	
	public static BufferedImage circlemagic = Game.sprite.getSprite(882, 731, 78, 82);
	
	public static BufferedImage estatuaUm = Game.sprite.getSprite(768, 473, 16, 16);
	public static BufferedImage portaM = Game.sprite.getSprite(704, 144, 16, 16);
	
	public static BufferedImage mapa01 = Game.sprite.getSprite(320, 896, 43, 55);
	public static BufferedImage mapa02 = Game.sprite.getSprite(383, 878, 101, 83);
	public static BufferedImage iconMapaOn = Game.sprite.getSprite(626, 84, 4, 4);
	public static BufferedImage iconMapaOff = Game.sprite.getSprite(634, 84, 4, 4);
	
	public static BufferedImage barra01 = Game.sprite.getSprite(512, 704, 32, 32);
	public static BufferedImage barra01End = Game.sprite.getSprite(544, 704, 16, 16);
	
	public static BufferedImage blocoT01 = Game.sprite.getSprite(976, 16, 16, 16);
	public static BufferedImage blocoT02 = Game.sprite.getSprite(976, 16, 16, 16);
	
	public static BufferedImage pintura01 = Game.sprite.getSprite(607, 719, 50, 58);
	
	public static BufferedImage casa01 = Game.sprite.getSprite(448, 2624, 16, 16);
	public static BufferedImage catedral = Game.sprite.getSprite(32, 2608, 16, 16);

	public static BufferedImage balaoDeFala = Game.sprite.getSprite(624, 32, 16, 32);
	public static BufferedImage decoracaoFalaUm = Game.sprite.getSprite(1008, 416, 96, 32);
	public static BufferedImage decoracaoFalaDois = Game.sprite.getSprite(1104, 416, 32, 32);
	
	public static BufferedImage escolhaDeFala = Game.sprite.getSprite(896, 1136, 224, 32);
	public static BufferedImage confirmacaoDeFala = Game.sprite.getSprite(1087, 1184, 16, 16);
	public static BufferedImage imagemDaLoja = Game.sprite.getSprite(1183, 1072, 128, 144);
	
	public static BufferedImage itemDescripitionFBlood = Game.sprite.getSprite(912,  112, 48, 48);
	public static BufferedImage itemDescripitionCat = Game.sprite.getSprite(832,  208, 48, 48);
	public static BufferedImage itemDescripitionKey = Game.sprite.getSprite(976,  112, 48, 48);
	public static BufferedImage itemDescripitionMedal = Game.sprite.getSprite(896,  208, 48, 48);
	public static BufferedImage itemDescripitionCandle = Game.sprite.getSprite(960,  208, 48, 48);

	public double x;
	public double y;
	public int width;
	public int height;
	public BufferedImage sprite;

	public Entidade(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public Entidade() {
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

	public static boolean isColidding(Entidade e1,Entidade e2) {
		Rectangle e1mask = new Rectangle(e1.getX() + e1.maskx,e1.getY() + e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2mask = new Rectangle(e2.getX() + e2.maskx,e2.getY() + e2.masky,e2.mwidth,e2.mheight);
		return e1mask.intersects(e2mask);
	}

	public void render(Graphics g) {

		g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);

	}

}
