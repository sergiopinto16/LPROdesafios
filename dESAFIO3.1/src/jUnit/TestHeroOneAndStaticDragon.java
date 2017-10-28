package jUnit;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

//import org.junit.jupiter.api.Test;
import dkeep.logic.*;

public class TestHeroOneAndStaticDragon { //s

	//teste considerando 
	
	
	@Test
	public void testHeroMoveFreeCell() {
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,1));
		stat.setK1(new Key());
		stat.setS1(new Sword(4,1));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(9, 3));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		//s1.new_game(dragonNumber , l);
		stat.movHero("d");						//ao movimentar em d o dragao se move para a direita
		assertEquals(1, stat.getH1().getX());
		assertEquals(2, stat.getH1().getY());
		
	}
	
	@Test
	public void testHeroFailsMoveIntoAWall() {
		State s1=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		
		
		s1.new_game(dragonNumber , l);	
		s1.movHero("a");					//ao movimentar-se em a o dragao n√£o se movimenta para a esquerda devido a parede
		assertEquals(1, s1.getH1().getX());
		assertEquals(1, s1.getH1().getY());
	}
	
	@Test
	public void testHeroTakeSword() {
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,1));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(9, 3));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		stat.movHero("d");
		assertEquals(stat.getH1().getSimbolo(), "A");
		
	}

	
	@Test
	public void UnarmedHeroMovesIntoACellThatIsAdjacentToADragonAndDies(){
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,1));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(9, 3));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		stat.movHero("s");

		assertEquals(stat.getD1(0).getX(),stat.getH1().getX()+1);
		assertEquals(stat.getD1(0).getY(),stat.getH1().getY());
		assertEquals(false, stat.check_state());
	}
	
	@Test
	public void ArmedHeroMovesIntoACellThatIsAdjacentToADragonAndSlaysHim(){
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,1));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(9, 3));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		//set Hero Armado.
		stat.getH1().setSimbolo("A");
		stat.getH1().setHeroHas(true);
		stat.movHero("s");
		assertEquals(false,stat.getD1(0).getLife());
		
		
		
	}

	@Test
	public void HeroMovesIntoTheExitCellAfterWieldingTheSwordAndKillingTheDragon(){
		System.out.println("HeroMovesIntoTheExitCellAfterWieldingTheSwordAndKillingTheDragon");
		
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,8));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(1, 9));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		//set Hero Armado.
		stat.getH1().setSimbolo("A");
		stat.getH1().setHeroHas(true);
		//Set Dragon dead
		stat.getK1().setChave(true);
		stat.getE1().setSaida(stat.getE1().getSaida() + 1); //set na saida o numero de dragoes mortos
		stat.getD1(0).setLife(false);
		
		stat.movHero("d");
		System.out.println("FIM!");
		assertEquals(true,stat.getM1().getFinish());
		
		
	}
	
	@Test
	public void HeroFailsToMoveIntoTheExitCellWithoutHavingWieldedTheSword(){
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,8));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>(); //commit
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(1, 9));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		stat.movHero("d");
		assertEquals(1,stat.getH1().getX());
		assertEquals(8,stat.getH1().getY());
		
	}
	
	
	@Test
	public void ArmedHeroFailsToMoveIntoTheExitCellWithoutHavingSlainTheDragon(){
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		State stat=new State();
		int dragonNumber=1;
		int[][] l=new int[1][2];
		l[0][0]=3;
		l[0][1]=1;
		
		stat.setH1(new Hero(1,8));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		ListHelp.add(new Dragon(l[0][0], l[0][1]));
		stat.setListD(ListHelp);

		stat.setE1(new Exiit(1, 9));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		stat.getH1().setHeroHas(true);
		
		stat.movHero("d");
		assertEquals(1,stat.getH1().getX());
		assertEquals(8,stat.getH1().getY());
	}
	
	@Test
	public void TestAllFourCornerDragonMovementPossibilities(){
		System.out.println("TestAll corner dragon move");
		
		char[][] map = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' }, 
				{ 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		//in map it¥s possible all 4 diagonal moves
		
		
		State stat=new State();
		int dragonNumber=4;
		//create all 4 dragons
		int[][] l=new int[4][2];
		l[0][0]=2; //d1 moves "w" "d" //(1,2)
		l[0][1]=1;
		l[1][0]=7; //d2 moves "s" "d" //(8,2)
		l[1][1]=1;
		l[2][0]=1; //d3 moves "d" "s" //(2,8)
		l[2][1]=7;
		l[3][0]=8; //d4 moves "d" "w" //(7,8)
		l[3][1]=7;
		
		//hero de forma a possibilitar os dragons moves
		stat.setH1(new Hero(5,4));
		stat.setK1(new Key());
		stat.setS1(new Sword(1,2));
		

		ArrayList<Dragon> ListHelp = new ArrayList<Dragon>();
		for(int i=0;i<dragonNumber;i++) {
			ListHelp.add(new Dragon(l[i][0], l[i][1]));
		}
		stat.setListD(ListHelp);
		stat.setE1(new Exiit(4, 9));
		stat.setM1(new Mapa(map));
		stat.setState(true);
		
		
		stat.MoveDragonInDiagonal(1,stat.getListD().get(0)); //move dragon 1 na diagonal primeiro para "w"
		assertEquals(stat.getD1(0).getX(), 1);
		assertEquals(stat.getD1(0).getY(), 2);
		
		stat.MoveDragonInDiagonal(3,stat.getListD().get(1)); //move dragon 2 na diagonal primeiro para "s"
		assertEquals(stat.getD1(1).getX(), 8);
		assertEquals(stat.getD1(1).getY(), 2);

		stat.MoveDragonInDiagonal(2,stat.getListD().get(2)); //move dragon 3 na diagonal primeiro para "d"
		assertEquals(stat.getD1(2).getX(), 2);
		assertEquals(stat.getD1(2).getY(), 8);

		stat.MoveDragonInDiagonal(2,stat.getListD().get(3)); //move dragon 4 na diagonal primeiro para "d"
		assertEquals(stat.getD1(3).getX(), 7);
		assertEquals(stat.getD1(3).getY(), 8);

		
	}
	
}
