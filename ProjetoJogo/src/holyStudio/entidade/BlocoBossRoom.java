package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.Mundo.Mundo;
import holyStudio.main.Game;

public class BlocoBossRoom extends Entidade {

    private int frames = 0;
    private int maxFrames = 8; 
    private int index = 0;
    private int maxIndex = 2;
    private int frameDelay = 0;
    private int maxFrameDelay = 3; 

    private BufferedImage[] blocoBoss;

    public BlocoBossRoom(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
       blocoBoss  = new BufferedImage[3]; 
        for (int i = 0; i < 3; i++) {
        	blocoBoss[i] = Game.sprite.getSprite(512 + (i * 16), 192, 16, 16);
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
    	
		
//	  g.setColor(Color.LIGHT_GRAY);
//      g.fillRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
//
//      g.setColor(Color.BLACK);
//      g.drawRect(this.getX()-Camera.x, this.getY()-Camera.y, 16, 16);
      
    	
    	if(Mundo.eventoBossMorto == 0) {
    		 g.drawImage(blocoBoss[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
    	}
    }
}
