package game.logic;

/**
 *
 * @author GonçaloSilva
 */
public class Key extends Element{
   //atributos herdados da classe element
	

	public Key(int x, int y) {
		super(x, y);
		
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
    
}
