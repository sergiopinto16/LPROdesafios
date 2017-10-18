package jUnit;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

//import org.junit.jupiter.api.Test;
import dkeep.logic.*;

public class TestHeroOneAndStaticDragon {

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
		s1.movHero("a");					//ao movimentar-se em a o dragao não se movimenta para a esquerda devido a parede
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

		assertEquals(stat.getD1().getX(),stat.getH1().getX()+1);
		assertEquals(stat.getD1().getY(),stat.getH1().getY());
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
		assertEquals(false,stat.getD1().getLife());
		
		
		
	}

	
	@Test
	public void HeroMovesIntoTheExitCellAfterWieldingTheSwordAndKillingTheDragon(){
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
		stat.getD1().setLife(false);
		
		stat.movHero("d");
		assertEquals(false,stat.check_state());
		
		
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

	
}
