package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class PosteUm extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    private int index = 0;
    private int maxIndex = 2;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 

    private int maskx = 0, masky = 0, maskw = 16, maskh = 16;

    private BufferedImage[] lustre;

    public PosteUm(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
        lustre = new BufferedImage[3]; 
        for (int i = 0; i < 3; i++) {
            lustre[i] = Game.sprite.getSprite(704 + (i * 32), 336, 32, 80);
        }
    }

    @Override
    public void tick() {
        if (!colisao((int) x, (int) (y + 65))) {
            y += 2;
        }

        frameDelay++;

        if (frameDelay >= maxFrameDelay) {
            frames++;
            frameDelay = 0;

            if (frames >= maxFrames) {
                frames = 0;
                index++;

                if (index > maxIndex) {
                    index = 0;
                }
            }
        }
    }

    public boolean colisao(int nextx, int nexty) {
        Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
        for (Entidade entidade : Game.entidade) {
            if (entidade instanceof Solido) {
                Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
                if (player.intersects(solido)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(lustre[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
    }
}
