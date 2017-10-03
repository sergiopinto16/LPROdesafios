package user;

import java.util.Scanner;


import game.logic.State;

public class Main {

	private Scanner leitor;

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
			State s1 = new State();
			s1.new_game();
			s1.getM1().imprimir(s1.getE1(),s1.getD1(),s1.getH1(),s1.getK1());

		while (true) {
		
			String move = s1.next_move(leitor);
			s1.movHero(move);
			s1.getM1().imprimir(s1.getE1(),s1.getD1(),s1.getH1(),s1.getK1());
			if (s1.getM1().getFinish() || !s1.getH1().isLife()) {
				break;
			}
		}

	}

}
