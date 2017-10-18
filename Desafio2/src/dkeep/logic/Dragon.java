package dkeep.logic;
/**
 *
 * @author GonçaloSilva
 */
public class Dragon extends Element{
   
   private boolean life;
   private boolean move;

	public Dragon(int x, int y) {
		super(x, y);
		life=true;
		this.move=false;
	}
	
	public boolean getLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	
	public boolean getMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public void mov_dragon(int num) {  //1 para cima  2 direita    3 baixo   4 esquerda
		if(num==1) {
			this.setX(this.getX()-1);
		}
		if(num==2) {
			this.setY(this.getY()+1);
		}
		if(num==3) {
			this.setX(this.getX()+1);
		}
		if(num==4) {
			this.setY(this.getY()-1);
		}
		
		
	}

	
	public boolean DragonIsInCornerTL( Dragon d1) { // saber se drag�o est� no canto
		if(d1.getX() == 1 && d1.getY() == 1) return true;
		return false;
	}

	public boolean DragonIsInCornerBL( Dragon d1) { // saber se drag�o est� no canto
		if(d1.getX() == 8 && d1.getY() == 1) return true;
		return false;
	}

	public boolean DragonIsInCornerTR(Dragon d1) { // saber se drag�o est� no canto
		if(d1.getX() == 1 && d1.getY() == 8) return true;
		return false;
	}

	public boolean DragonIsInCornerBR( Dragon d1) { // saber se drag�o est� no canto
		if(d1.getX() == 8 && d1.getY() == 8) return true;
		return false;
	}

	
    
}
