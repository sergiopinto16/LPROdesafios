package game.logic;

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
	private ArrayList<Dragon> DragonAll;

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

	public ArrayList<Dragon> getListD() {
		return ListD;
	}

	public void setListD(ArrayList<Dragon> listD) {
		ListD = listD;
	}

	// metodos
	public void new_game(int DragonNumber, int[][] l) {

		this.h1 = new Hero(1, 1);
		this.k1 = new Key();
		this.s1 = new Sword(4, 1);

		ListD = new ArrayList<Dragon>();
		for (int i = 0; i < DragonNumber;) {
			ListD.add(new Dragon(l[i][0], l[i][1]));
			i++;
		}
		this.e1 = new Exiit(9, 3);
		this.m1 = new Mapa();
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

		for (int j = 0; j < ListD.size(); j++) { // para cada dragão
			d1 = ListD.get(j);
			d1.setMove(false);

			if (this.m1.nextIsWall(x, y, h1, e1)) { // Se for parede, já não verifica os proximos dragoes pq não depende
													// de d1
				Imprimir = "Há Parede";
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

	public void movDragon() {
		Random rnd = new Random();

		int num = 0;
		for (int j = 0; j < ListD.size(); j++) {
			d1 = ListD.get(j);
			do {
				num = (rnd.nextInt(4) + 1);
			} while (!m1.CorrectMoveDragon(h1, e1, d1, s1, num));

			d1.mov_dragon(num);
			///// VERIFICA SE PODE ANDAR NA DIAGONAL NOS CANTOS/////////
			if (m1.DragonIsInCornerTL(d1)) { // verifica se está no canto TOP LEFT
				System.out.println(num);
				switch (num) {
				case 1:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 2)) {
						d1.mov_dragon(2);
					}
					break;
				case 4:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 3)) {
						d1.mov_dragon(3);
					}
					break;
				}
			} else if (m1.DragonIsInCornerBL(d1)) {// verifica se está no canto BOTTOM LEFT
				System.out.println(num);
				switch (num) {
				case 2:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 1)) {
						d1.mov_dragon(1);
					}
					break;
				case 3:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 2)) {
						d1.mov_dragon(2);
					}
					break;
				}
			} else if (m1.DragonIsInCornerTR(d1)) {// verifica se está no canto TOP RIGHT
				System.out.println(num);
				switch (num) {
				case 1:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 4)) {
						d1.mov_dragon(4);
					}
					break;
				case 2:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 3)) {
						d1.mov_dragon(3);
					}
					break;
				}
			} else if (m1.DragonIsInCornerBR(d1)) {// verifica se está no canto BOTTOM RIGHT
				System.out.println(num);
				switch (num) {
				case 2:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 1)) {
						d1.mov_dragon(1);
					}
					break;
				case 3:
					if (m1.CorrectMoveDragon(h1, e1, d1, s1, 4)) {
						d1.mov_dragon(4);
					}
					break;
				}
			}

			if (!m1.CheckHeroLife(h1, d1)) // dragao mata o Hero
				this.setState(false);
		}
	}

}
