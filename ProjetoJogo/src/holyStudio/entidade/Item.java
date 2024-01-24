package holyStudio.entidade;

import java.awt.image.BufferedImage;

import holyStudio.main.Game;

public class Item {
	private static String descricao;
	private static int preco;
	private static String nome;
    
    protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected BufferedImage sprite;
    
	public static BufferedImage lixo = Game.sprite.getSprite(672, 80, 16, 16);
	
	public static BufferedImage medalSol = Game.sprite.getSprite(720, 48, 16, 16);
	
	public static BufferedImage chave = Game.sprite.getSprite(736, 48, 16, 16);

    public Item(String nome, int preco, String descricao, int x, int y, int width, int height, BufferedImage sprite) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Métodos getters para obter informações sobre o item
    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
