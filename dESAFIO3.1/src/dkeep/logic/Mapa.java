package dkeep.logic;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {

	// atributos
	private char[][] map ;

	private boolean finish;
	private boolean tipoMov;
	
	
	public Mapa(char [][] mapa) {
		this.map=mapa.clone();
		this.finish=false;
		this.tipoMov = false; //nao anda na diagonal
	}

	// metodos
	public void imprimir(Exiit e1, ArrayList<Dragon> dl1, Hero h1, Sword s1) {

		Dragon d1;
		String c = ""; // o que escrever
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				for (int j = 0; j < dl1.size(); j++) {
					d1 = dl1.get(j);
					if (i == h1.getX() && k == h1.getY()) { // representar heroi
						c = h1.getSimbolo() + "|";
					} else if (i == s1.getX() && k == s1.getY()) { // representar SWORD
						if (!h1.isHeroHas()) {
							if (s1.getX() == d1.getX() && s1.getY() == d1.getY()) {
								j = dl1.size();
								c = "F|";
							} else
								c = "S|";
						} else
							c = this.map[i][k] + "|";
					} else if (i == d1.getX() && k == d1.getY()) { // representar DRAGON
						if (s1.getX() == d1.getX() && s1.getY() == d1.getY()) {
							if (h1.isHeroHas()) {
								j = dl1.size();
								c = "D|";
							}
							// j� escreveu na compara��o da SWORD (em cima)
						} else {
							if (d1.getLife()) {
								j = dl1.size(); // para sair do ciclo, j� n�o precisa de verificar os proximos dragoes
								c = "D|";
							} else
								c = this.map[i][k] + "|";
						}
					} else if (i == e1.getX() && k == e1.getY()) { // representar EXIT
						c = "E|";
					} else { // representar "X" ou " " (mapa)
						c = this.map[i][k] + "|";
					}
				}
				System.out.print(c);
			}
			System.out.println("");
		}
	}

	public boolean nextIsWall(int x, int y, Hero h1, Exiit e1) { // retorna 1 se for parede
		if (this.map[h1.getX() + x][h1.getY() + y] == 'X') {
			if (h1.getX() + x == e1.getX() && h1.getY() + y == e1.getY())
				return false;
			return true;
		}
		return false;
	}

	public boolean nextIsImpToDragon(int x, int y, Dragon d1, Hero h1) { // retorna 1 se for parede
		if (this.map[d1.getX() + x][d1.getY() + y] == 'X' || HeroClose(x, y, d1, h1)) {
			return true;
		}
		return false;
	}

	public boolean HeroClose(int x, int y, Dragon d1, Hero h1) {

		if (!h1.isHeroHas()) { // se n�o tiver espada n�o pode ficar perto
			// movimentar-se no y
			if (y != 0 && d1.getY() + y == h1.getY() && (d1.getX() + 1 == h1.getX() || d1.getX() - 1 == h1.getX()))
				return true;
			if (x != 0 && d1.getX() + x == h1.getX() && (d1.getY() + 1 == h1.getY() || d1.getY() - 1 == h1.getY()))
				return true;
		}

		return false;
	}

	public boolean nextIsDragon(int x, int y, Hero h1, Exiit e1, Dragon d1, Sword s1, Key k1) { // retorna 1 se for
																								// drag�o
		if ((h1.getX() + (2 * x) == d1.getX() && h1.getY() + (2 * y) == d1.getY())
				|| (h1.getX() + x == d1.getX() && (h1.getY() + 1 == d1.getY() || h1.getY() - 1 == d1.getY()))
				|| (h1.getY() + y == d1.getY() && (h1.getX() + 1 == d1.getX() || h1.getX() - 1 == d1.getX()))) {
			if (h1.isHeroHas()) {
				if (d1.getLife()) { // caso o dragao esteja morto n�o entra no if
					k1.setChave(true);
					e1.setSaida(e1.getSaida() + 1);
					d1.setLife(false);
					System.out.println("DRAG�O MORTO! CHAVE ADQUIRIDA!");
				}

				return false;
			} else {
				System.out.println("Heroi n�o t�m espada!");
				h1.setLife(false);
				return true;
			}
		}
		return false;
	}

	public boolean nextIsSword(int x, int y, Hero h1, Exiit e1, Sword s1) { // retorna 1 se for parede
		if (h1.getX() + x == s1.getX() && h1.getY() + y == s1.getY()) {
			h1.setHeroHas(true);
			return true;
		}
		return false;
	}

	public boolean nextIsExit(int x, int y, Hero h1, Exiit e1, int numDrag) { //
		if (h1.getX() + x == e1.getX() && h1.getY() + y == e1.getY()) {
			if (e1.getSaida() == numDrag) {
				System.out.println("Parabens! Saida encontrada");
				this.finish = true;
				return true;
			} else {
				System.out.println("Existem Dragoes vivos");
				return true;
			}
		}
		return false;
	}

	public void CalcularXYExit(Exiit e1, Dragon d1, Hero h1, Sword s1) {
		Random rnd = new Random();
		int a = 1;
		int num = (rnd.nextInt(10));

		if (num == 0) {
			do {
				e1.setX(num);
				e1.setY((rnd.nextInt(8) + 1));
			} while (this.map[e1.getX() + 1][e1.getY()] == 'X'
					|| (e1.getX() + (2 * (1)) == d1.getX() && e1.getY() == d1.getY())
					|| (e1.getX() + 1 == d1.getX() && e1.getY() == d1.getY())
					|| (e1.getX() + 1 == d1.getX() && e1.getY() + 1 == d1.getY())
					|| (e1.getX() - 1 == d1.getX() && e1.getY() + 1 == d1.getY())); // saida n�o tem parede � frente(em
																					// x) nem dragao em 2 quadrados de
																					// distancia (em x) nem na
																					// diagonal););

		} else if (num == 9) {
			do {
				e1.setX(num);
				e1.setY((rnd.nextInt(8) + 1));
			} while (this.map[e1.getX() - 1][e1.getY()] == 'X'
					|| (e1.getX() + (2 * (-1)) == d1.getX() && e1.getY() == d1.getY())
					|| (e1.getX() - 1 == d1.getX() && e1.getY() == d1.getY())
					|| (e1.getX() + 1 == d1.getX() && e1.getY() - 1 == d1.getY())
					|| (e1.getX() - 1 == d1.getX() && e1.getY() - 1 == d1.getY())); // saida n�o tem parede � frente(em
																					// x) nem dragao em 2 quadrados de
																					// distancia (em x));

		} else {
			do {
				a = 1;
				if ((rnd.nextInt(10) + 0) < 5)
					e1.setY(0);
				else {
					e1.setY(9);
					a = -1;
				}
				e1.setX(num);
			} while (this.map[e1.getX()][e1.getY() + a] == 'X'
					|| (e1.getX() == d1.getX() && e1.getY() + (2 * a) == d1.getY())
					|| (e1.getX() == d1.getX() && e1.getY() + a == d1.getY())
					|| (e1.getX() + 1 == d1.getX() && e1.getY() + a == d1.getY())
					|| (e1.getX() + 1 == d1.getX() && e1.getY() - a == d1.getY())); // saida n�o tem parede � frente(em
																					// y) nem dragao em 2 quadrados de
																					// distancia (em y)
		}

		// System.out.println(e1.x);
		// System.out.println(e1.y);
	}

	public boolean CorrectMoveDragon(Hero h1, Exiit e1, Dragon d1, Sword s1, int num) { // 1 para cima , 2 direita, 3
																						// baixo, 4 esquerda

		switch (num) {
		case 1: {
			if (nextIsImpToDragon(-1, 0, d1, h1)) // se n�o for possivel andar para cima, retorna false
				return false;

			return true;
		}
		case 2: {
			if (nextIsImpToDragon(0, 1, d1, h1))
				return false;

			return true;
		}
		case 3: {
			if (nextIsImpToDragon(1, 0, d1, h1))
				return false;

			return true;
		}
		case 4: {
			if (nextIsImpToDragon(0, -1, d1, h1))
				return false;

			return true;
		}
		default:
			return false;
		}

	}

	public boolean CheckDragonClose(Hero h1, Dragon d1) {
		if (h1.getX() + 1 == d1.getX() && h1.getY() == d1.getY()) {
			h1.setLife(false);
			return true;
		}
		if (h1.getX() - 1 == d1.getX() && h1.getY() == d1.getY()) {
			h1.setLife(false);
			return true;
		}
		if (h1.getX() == d1.getX() && h1.getY() + 1 == d1.getY()) {
			h1.setLife(false);
			return true;
		}
		if (h1.getX() == d1.getX() && h1.getY() - 1 == d1.getY()) {
			h1.setLife(false);
			return true;
		}

		return false;

	}

	public boolean CheckHeroLife(Hero h1, Dragon d1) { // returna true se hero ficar vivo
		if (!h1.isHeroHas()) { // caso hero n�o t�m espada!
			if ((h1.getX() == d1.getX() && h1.getY() == d1.getY()) || CheckDragonClose(h1, d1)) {
				System.out.println("Dragao atacou Heroi");
				System.out.println("YOU lOSE! GAME OVER!");
				return false;
			}
		}
		return true;
	}

	////// GETTERS E SETTERS//////////

	public boolean getFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public char[][] getMap() {
		return this.map;
	}
	public void setMap(char[][] mapa) {
		this.map=mapa.clone();
	}
	public boolean getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(boolean tipoMov) {
		this.tipoMov = tipoMov;
	}

}
