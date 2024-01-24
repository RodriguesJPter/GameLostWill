package holyStudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import holyStudio.Graficos.SpriteSheet;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.EntidadeTheRoom;

public class TheRoom extends Canvas implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	public static List<EntidadeTheRoom> entidade;
	
	public static TheRoomController controle;

    public static JFrame jframe;
    private Thread thread;
    private boolean isRunning = true;
    private BufferedImage fundo;
    public static SpriteSheet sprite;

    public static int WIDTH = 300;
    public static int HEIGHT = 300;
    public static int SCALE = 2;

    public TheRoom() {
        addKeyListener(this);
        setSize(WIDTH * SCALE, HEIGHT * SCALE); 
        initFrame();
        
        controle = new TheRoomController();
        
        entidade = new ArrayList<>();
        
        sprite = new SpriteSheet("/theRoom.png");
        
        fundo = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    public void initFrame() {
        jframe = new JFrame("The Room");
        jframe.add(this);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        TheRoom room = new TheRoom();
        room.start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
   
    

    public void tick() {
    	for (EntidadeTheRoom enti : entidade) {
			enti.tick();
		}
    }

    public void render() {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = fundo.getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (EntidadeTheRoom enti : entidade) {
			enti.render(g);
		}
        
        controle.render(g);

        g = buffer.getDrawGraphics();
        g.drawImage(fundo, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        buffer.show();
        
        
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
        stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implemente ações ao digitar teclas, se necessário
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	if (controle.escolendoJogo == true) {
    		if(e.getKeyCode() == KeyEvent.VK_D) {
    			controle.direita = true;
    			controle.controleListaJogo = (controle.controleListaJogo  + 1) % 4;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			controle.esquerda = true;
			
			controle.controleListaJogo  = (controle.controleListaJogo  - 1) % 4;
			if (controle.controleListaJogo < 0) {
				controle.controleListaJogo = 3;
	        }
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			controle.escolendoJogo = false;
			System.out.println("tecla Q pressionado");
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			controle.selecionadoJogo = true;
		}
			
    } else {

	    	if(e.getKeyCode() == KeyEvent.VK_D) {
	    		controle.direita = true;
	    		
	    		controle.controleDoRoom = (controle.controleDoRoom  + 1) % 3;
	    		
			} else if(e.getKeyCode() == KeyEvent.VK_A) {
				controle.esquerda = true;
				
				controle.controleDoRoom  = (controle.controleDoRoom  - 1) % 3;
				if (controle.controleDoRoom < 0) {
					controle.controleDoRoom= 2;
		        }
			}
		}
    	if(e.getKeyCode() == KeyEvent.VK_E){
    		controle.jogoHM  = (controle.jogoHM  + 1) % 5;
    		if (controle.controleDoRoom < 1) {
				controle.controleDoRoom= 1;
	        }
    	}
    	
    	
    	if(e.getKeyCode() == KeyEvent.VK_ENTER){
    		if (controle.controleDoRoom == 0) {
    			controle.selecionadoTV = !controle.selecionadoTV ;
    		} else if (controle.controleDoRoom == 1) {
    			controle.selecionadoConsole = !controle.selecionadoConsole;
    		} else if (controle.controleDoRoom == 2) {
    			controle.selecionadoEstante = !controle.selecionadoEstante;
    		}
			System.out.println("Tecla enter pressionada");
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_D) {
    		controle.direita = false;
    		
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			controle.esquerda = false;
		}
    	
    	if(e.getKeyCode() == KeyEvent.VK_ENTER){
//			controle.selecionado = false;
//			System.out.println("Tecla enter desfeita");
		}
    }
}
