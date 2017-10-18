package dkeep.logic;


public class Hero extends Element {
     
   

	private boolean life;
	private boolean HeroHas;
	private String simbolo;
	
    //metodos especiais

	public Hero(int x, int y) {
		super(x, y);
		this.life=true;
		this.HeroHas=false;
		this.simbolo="H";
	}
   
    
    //metodos
    

	public boolean isHeroHas() {
		return HeroHas;
	}

	public void setHeroHas(boolean heroHas) {
		HeroHas = heroHas;
		this.setSimbolo("A");
	}

   

	public String getSimbolo() {
		return simbolo;
	}


	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}


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
