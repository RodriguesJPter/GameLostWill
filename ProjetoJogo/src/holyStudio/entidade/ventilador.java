package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;
import holyStudio.main.TheRoom;

public class ventilador extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    public int index = 0;
    private int maxIndex = 4;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 


    public BufferedImage[] ventilador;
    
    public ventilador(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
        
        
        ventilador = new BufferedImage[4];
	    
	    for(int i = 0; i < 4; i++) {
	        ventilador[i] = TheRoom.sprite.getSprite(16 + (i * 55), 432, 54, 55);
	    }
    }

    @Override
    public void tick() {
        

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

    

    @Override
    public void render(Graphics g) {
        g.drawImage(ventilador[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
    }
}
