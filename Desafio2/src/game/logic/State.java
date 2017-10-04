package game.logic;

import java.util.Scanner;

public class  State {
	private Hero h1;
	private Key k1;
	private Dragon d1;
	private Exiit e1;
	private Sword s1;
	private Mapa m1;
	private boolean state;

	// metodos especiais

	public Hero getH1() {
		return h1;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setH1(Hero h1) {
		this.h1 = h1;
	}

	public Key getK1() {
		return k1;
	}

	public void setK1(Key k1) {
		this.k1 = k1;
	}

	
	public Sword getS1() {
		return s1;
	}

	public void setS1(Sword s1) {
		this.s1 = s1;
	}

	public Dragon getD1() {
		return d1;
	}

	public void setD1(Dragon d1) {
		this.d1 = d1;
	}

	public Exiit getE1() {
		return e1;
	}

	public void setE1(Exiit e1) {
		this.e1 = e1;
	}

	public Mapa getM1() {
		return m1;
	}

	public void setM1(Mapa m1) {
		this.m1 = m1;
	}

	// metodos
	public void new_game() {
		this.h1 = new Hero(1, 1);
		this.k1 = new Key();
		this.s1 = new Sword(5, 8);
		this.d1 = new Dragon(3, 1);
		this.e1 = new Exiit(9, 3);
		this.m1 = new Mapa();
		this.state = false;
		this.m1.CalcularXYExit(e1,d1,h1,s1);
	}
	public String next_move(Scanner leitor) {
		System.out.print("Insira um movimento(w,s,d,a): ");
		return leitor.nextLine();
	}
	public boolean check_state() {
		return isState();
	}
	//////
	
	public void equal(String c){
		if (c.equals("w"))
			h1.mov_up();
		else if(c.equals("s"))
			h1.mov_down();
		else if(c.equals("a"))
			h1.mov_left();
		else if(c.equals("d"))
			h1.mov_right();
	}
	
	public void equal2(int x, int y, String c) {
		if (this.m1.nextIsWall(x, y,h1,e1)) {
            System.out.println("É Parede");
        } else if (this.m1.nextIsExit(x, y,h1,e1)) {
            if (this.m1.getFinish()) {
                equal(c);
            } else {
                System.out.println("Porta encerrada!");
            }
        } else if (this.m1.nextIsDragon(x, y,h1,e1,d1,s1,k1)) {
            System.out.println("YOU lOSE! GAME OVER!");
            equal(c);
        } else {
            if (this.m1.nextIsSword(x, y,h1,e1,s1)) {
            	if(!h1.isHeroHas())
            		System.out.println("ESPADA ADQUIRIDA!");
            }
            equal(c);
        }
	}
	
	public void movHero(String c) {
        if (c.equals("w")) {
            equal2(-1,0,c);
        } else if (c.equals("s")) {
        	equal2(1,0,c); 
        } else if (c.equals("d")) {
        	equal2(0,1,c);
        } else if (c.equals("a")) {
        	equal2(0,-1,c);
        } else {
            System.out.println("Movimento Incorrecto");
        }

    }

}
