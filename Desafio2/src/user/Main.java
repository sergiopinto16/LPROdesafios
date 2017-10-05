package user;

import java.util.Scanner;

import game.logic.State;

public class Main {

	private Scanner leitor;

	public static void main(String[] args) {

		int[] dragonPos=new int[12];
				dragonPos[0]=3;
				dragonPos[1]=1;
				dragonPos[2]=8;
				dragonPos[3]=8;
				dragonPos[4]=8;
				dragonPos[5]=4;
				dragonPos[6]=8;
				dragonPos[7]=1;
				dragonPos[8]=1;
				dragonPos[9]=8;
				dragonPos[10]=5;
				dragonPos[11]=6;

		
		
		
		
		Scanner leitor = new Scanner(System.in);
			State s1 = new State();
			
			s1.new_game(s1.dragon_number(leitor),dragonPos);
			s1.getM1().imprimir(s1.getE1(),s1.getListD(),s1.getH1(),s1.getS1());

		
		while (true) {
		
			String move = s1.next_move(leitor);
			if(s1.movHero(move)) {
				s1.movDragon();
				s1.getM1().imprimir(s1.getE1(),s1.getListD(),s1.getH1(),s1.getS1());
			}
			if (s1.getM1().getFinish() || !s1.getH1().isLife()) {
				break;
			}
		}

	}

}
