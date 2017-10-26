package dkeep.logic;

import java.awt.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class State {
	private Hero h1;
	private Key k1;
	private Dragon d1;
	private Exiit e1;
	private Sword s1;
	private Mapa m1;
	private boolean state;
	private ArrayList<Dragon> ListD;

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

	public Dragon getD1(int i) {
		return ListD.get(i);
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

	public ArrayList<Dragon> getListD() {
		return ListD;
	}

	public void setListD(ArrayList<Dragon> listD) {
		ListD = listD;
	}

	// metodos
	public void new_game(int DragonNumber, int[][] l) {

		char[][] map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		this.h1 = new Hero(1, 1);
		this.k1 = new Key();
		this.s1 = new Sword(4, 1);

		ListD = new ArrayList<Dragon>();
		for (int i = 0; i < DragonNumber;) {
			ListD.add(new Dragon(l[i][0], l[i][1]));
			i++;
		}
		this.e1 = new Exiit(9, 3);
		this.m1 = new Mapa(map);
		this.state = true;
		this.m1.CalcularXYExit(e1, ListD.get(0), h1, s1);
		
		
	}

	public String next_move(Scanner leitor) {
		System.out.print("Insira um movimento(w,s,d,a): ");
		return leitor.nextLine();
	}

	public int dragon_number(Scanner leitor) {
		int num = 0;

		while (num < 1 || num > 6) {
			try {
				System.out.print("Numero de dragoes no jogo(max 6): ");
				num = leitor.nextInt();
				leitor.nextLine();
			} catch (InputMismatchException excepcao) {
				System.out.println("ERRO!! Apenas inteiros por favor.");
				leitor.next();
			}
		}

		return (num);
	}
	
	public boolean lerTipoMov(Scanner leitor) {
		String tipoMov=new String();
		while (!tipoMov.equals("s") && !tipoMov.equals("n") ) {
			
			System.out.print("Move na diagonal?[s][n]: ");
			tipoMov = leitor.nextLine();
		
		}
		if(tipoMov.equals("s"))
			return true;
		if(tipoMov.equals("n"))
			return false;
		return false;
	}
	

	public boolean check_state() {
		return isState();
	}
	//////

	public void equal(String c) {
		if (c.equals("w")) {
			h1.mov_up();
		} else if (c.equals("s"))
			h1.mov_down();
		else if (c.equals("a"))
			h1.mov_left();
		else if (c.equals("d"))
			h1.mov_right();

		d1.setMove(true);
	}

	public void equal2(int x, int y, String c) {

		boolean canMove = false;
		String Imprimir = "";

		for (int j = 0; j < ListD.size(); j++) { // para cada dragï¿½o
			d1 = ListD.get(j);
			d1.setMove(false);

			if (this.m1.nextIsWall(x, y, h1, e1)) { // Se for parede, jï¿½ nï¿½o verifica os proximos dragoes pq nï¿½o
													// depende
													// de d1
				Imprimir = "Ha Parede";
				j = ListD.size();
			} else if (this.m1.nextIsExit(x, y, h1, e1, ListD.size())) { // nao depende de d1, o mesmo q nextIsWall
				if (this.m1.getFinish()) {
					j = ListD.size();
					canMove = true;
				} else {
					j = ListD.size();
					Imprimir = "Porta encerrada!";
				}
			} else if (this.m1.nextIsDragon(x, y, h1, e1, d1, s1, k1)) {
				j = ListD.size();
				Imprimir = "YOU lOSE! GAME OVER!";
				this.setState(false);
				canMove = true;
			} else {
				if (this.m1.nextIsSword(x, y, h1, e1, s1)) {
					j = ListD.size();
					if (!h1.isHeroHas()) {
						Imprimir = "ESPADA ADQUIRIDA!";
					}
				}
				canMove = true;
			}
		}
		if (canMove)
			equal(c);
		if (!Imprimir.equals(""))
			System.out.println(Imprimir);
	}

	public boolean movHero(String c) {
		if (c.equals("w")) {
			equal2(-1, 0, c);
		} else if (c.equals("s")) {
			equal2(1, 0, c);
		} else if (c.equals("d")) {
			equal2(0, 1, c);
		} else if (c.equals("a")) {
			equal2(0, -1, c);
		} else {
			System.out.println("Movimento Incorrecto");
			return false;
		}
		if (d1.getMove())
			return true;
		return false;
	}

	public boolean MoveDragonInDiagonal(int num, Dragon d1) {
		if (d1.DragonIsInCorner(d1.testmov_dragon_x(num), d1.testmov_dragon_Y(num)) != 0) {
			d1.mov_dragon(num);
			if (m1.CorrectMoveDragon(h1, e1, d1, s1,
					d1.SecondMoveDragon(num, d1.DragonIsInCorner(d1.getX(), d1.getY())))) {
				d1.mov_dragon(d1.SecondMoveDragon(num, d1.DragonIsInCorner(d1.getX(), d1.getY())));
				return true;
			} else
				d1.mov_dragon(d1.movInvers(num)); // repõe posição de dragão se não conseguir mover na diagonal
		}
		return false;
	}

	public void movDragon() {
		Random rnd = new Random();

		int num = 0;
		for (int j = 0; j < ListD.size(); j++) {
			d1 = ListD.get(j);
			do {
				num = (rnd.nextInt(4) + 1);
			} while (!m1.CorrectMoveDragon(h1, e1, d1, s1, num));

			if(this.getM1().getTipoMov()) { // é para mover na diagonal
				if (!MoveDragonInDiagonal(num, d1))
					d1.mov_dragon(num);
				
			} else { // não é para mover na diagonal
				d1.mov_dragon(num);
			}

			if (!m1.CheckHeroLife(h1, d1)) // dragao mata o Hero
				this.setState(false);
		}
	}

}
