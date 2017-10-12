package user;

import java.util.Scanner;

import game.logic.State;

public class Main {

	private Scanner leitor;

	public static void main(String[] args) {

		int[][] dragonPos=new int[6][2];
				dragonPos[0][0]=3;
				dragonPos[0][1]=1;
				dragonPos[1][0]=8;
				dragonPos[1][1]=8;
				dragonPos[2][0]=1;
				dragonPos[2][1]=7;
				dragonPos[3][0]=8;
				dragonPos[3][1]=1;
				dragonPos[4][0]=1;
				dragonPos[4][1]=8;
				dragonPos[5][0]=5;
				dragonPos[5][1]=6;

		
		
		
		
		Scanner leitor = new Scanner(System.in);
			State s1 = new State();
			
			s1.new_game(s1.dragon_number(leitor),dragonPos);
			s1.getM1().imprimir(s1.getE1(),s1.getListD(),s1.getH1(),s1.getS1());

		
		while (s1.isState()) {
		
			String move = s1.next_move(leitor);
			
			if(s1.movHero(move)) {
				if(s1.isState()) 
					s1.movDragon();
				s1.getM1().imprimir(s1.getE1(),s1.getListD(),s1.getH1(),s1.getS1());
			}
			if (s1.getM1().getFinish() || !s1.getH1().isLife()) {
				break;
			}
		}

	}

}
