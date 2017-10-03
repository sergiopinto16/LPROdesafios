package game.logic;
/**
 *
 * @author GonçaloSilva
 */
public class Dragon extends Element{
   
   private boolean life;

	public Dragon(int x, int y) {
		super(x, y);
		life=true;
	}

	public boolean getLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

    
}
