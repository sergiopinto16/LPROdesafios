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
	public int movInvers(int num) {
		switch(num) {
		case 1: return 3;
		case 2: return 4;
		case 3: return 1;
		case 4: return 2;
		default: return 0;
		}
	}
	public int testmov_dragon_x(int num) {
		if(num==1) {
			return (this.getX()-1);
		}
		
		if(num==3) {
			return (this.getX()+1);
		}
		return this.getX();
		
	}
	public int testmov_dragon_Y(int num) {
		
		if(num==2) {
			return (this.getY()+1);
		}
		if(num==4) {
			return (this.getY()-1);
		}
		return this.getY();
		
	}
	
	public int DragonIsInCorner(int x, int y) {
		if(x==1 && y==1)
			return 1; //TL
		if(x==1 && y==8)
			return 2; //TR
		if(x==8 && y==1)
			return 4; //BL
		if(x==8 && y==8)
			return 3; //BR
		return 0;
	}
	
	public int SecondMoveDragon(int antmov,int corner) {
		if(corner==0)
			return 0;
		switch(antmov) {
		case 1:{
			if(corner==1)
				return 2;
			if(corner==2)
				return 4;
			break;
		}
		case 2:	{
			if(corner==2)
				return 3;
			if(corner==3)
				return 1;
			break;
		}
		case 3:	{
			if(corner==3)
				return 4;
			if(corner==4)
				return 2;
			break;
		}
		case 4:{
			if(corner ==1)
				return 3;
			if(corner==4)
				return 1;
			break;
		}
		}
		
		return 0;
			
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
