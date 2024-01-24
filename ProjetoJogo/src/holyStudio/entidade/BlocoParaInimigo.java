package holyStudio.entidade;

import java.awt.image.BufferedImage;

public class BlocoParaInimigo extends Entidade {

    public BlocoParaInimigo(int x, int y, int width, int height, BufferedImage chao) {
        super(x, y, width, height, chao);
    }

    public double calcularDistanciaAoJogador(Player jogador) {
        double distancia = Math.sqrt(Math.pow(jogador.getX() - this.getX(), 2) + Math.pow(jogador.getY() - this.getY(), 2));
        return distancia;
     
    }
}
