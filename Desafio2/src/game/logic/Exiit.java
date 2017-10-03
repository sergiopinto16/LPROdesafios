package game.logic;

/**
 *
 * @author GonçaloSilva
 */
public class Exiit extends Element{
  
  

private boolean saida;
 public Exiit(int x, int y) {
		super(x, y);
		 this.saida = false;
	}
 

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getSaida() {
		return saida;
	}

	public void setSaida(boolean saida) {
		this.saida = saida;
	}
    
}
