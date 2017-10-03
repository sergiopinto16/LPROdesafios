package game.logic;


public class Hero extends element {
    
    private boolean life;
    
    //metodos especiais

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        this.life=true;
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
    //metodos
    
   

	public void mov_up(){
        this.x--;
    }
    public void mov_down(){
        this.x++;
    }
    public void mov_right(){
        this.y++;
    }     
    public void mov_left(){
        this.y--;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }
    
    
}
