package game.logic;

/**
 *
 * @author GonçaloSilva
 */
public class Exiit extends Element {

	private boolean saida;

	public Exiit(int x, int y) {
		super(x, y);
		this.saida = false;
	}

	public boolean getSaida() {
		return saida;
	}

	public void setSaida(boolean saida) {
		this.saida = saida;
	}

}
