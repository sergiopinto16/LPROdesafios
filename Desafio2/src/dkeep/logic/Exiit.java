package dkeep.logic;

/**
 *
 * @author GonçaloSilva
 *///commint
public class Exiit extends Element {

	private int saida;

	public Exiit(int x, int y) {
		super(x, y);
		this.saida = 0;
	}

	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}

}
