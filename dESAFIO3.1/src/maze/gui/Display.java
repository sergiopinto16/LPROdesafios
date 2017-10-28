package maze.gui;

/*
 * Para o programador 'x' significa vertical e 'y' horizontal
 * Para o paintIcon 'x' significa horizontal e 'y' vertical
 * Dragoes com posição x = 9 e y = 9 estão mortos !!
 * */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Display extends JPanel {
//-----------Pixeis dos icones-------------
	int x_pixel; //	posiçao na vertical
	int y_pixel; // posição na horizontal
//-----------Posiçoes x dos elementos------
	private	int x_sword;
	private int [] x_dragons;	// Posicoes dos dragoes em X
	private	int x_door;
	private	int x_hero;
//------------Posições y dos elementos-----
	private	int y_door;
	private int [] y_dragons; 
	private	int y_sword;
	private	int y_hero;
//------------Icones a serem usados--------
	private ImageIcon dragon;
	private ImageIcon door;
	private ImageIcon sword;
	private ImageIcon wall;
	private ImageIcon hero;
	private ImageIcon background;
//----------Atributos auxiliares-----
	private boolean ativo;
	private int numDragons;
	
	/**
	 * Create the panel.
	 */
	public Display() {
		this.numDragons = 0;
		this.ativo = false;
		setX_pixel(35);
		setY_pixel(40);
		this.dragon = new ImageIcon(Display.class.getResource("dragon.jpg"));
		this.door = new ImageIcon(Display.class.getResource("door_closed.jpg"));
		this.hero = new ImageIcon(Display.class.getResource("hero.jpg"));
		this.sword = new ImageIcon(Display.class.getResource("sword.png"));
		this.wall = new ImageIcon(Display.class.getResource("wall.png"));
		this.background = new ImageIcon(Display.class.getResource("background.jpg"));
	}
//--------------Definir Posições dos Elementos na interface-----
	public void PosHero(int x,int y) {
		setX_hero(x);
		setY_hero(y);
		repaint();
	}

	public void PosDragon(int pos,int x,int y) {
		setY_dragons(y, pos);
		setX_dragons(x, pos);
		repaint();
		
	}
	public void PosSword(int x,int y) {
		setX_sword(x);
		setY_sword(y);
		repaint();
	}
	public void PosExit(int x,int y) {
		setX_door(x);
		setY_door(y);
		repaint();
	}
	public void changeImage(String tipoPorta) {
		this.door = new ImageIcon(Display.class.getResource(tipoPorta));
	}
//---------------------------------------------------------------
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBounds(30, 80, 400, 350);
		//this.background.paintIcon(this,g,0,0);
		if(this.ativo)
			{
		paintWall(g);
		this.door.paintIcon(this, g, getY_door()*getY_pixel(), getX_door()*getX_pixel());
		this.hero.paintIcon(this, g, getY_hero()*getY_pixel(), getX_hero()*getX_pixel());
		paintSword(g); 
		paintNumDragons(g);
		
		}
		
		/*
		 * dragon.paintIcon(this, g, this.x_dragon, this.y_dragon);  
		 * hero.paintIcon(this, g, 30, 50);
		 */
		

	}
	private void paintSword(Graphics g) {
		if(! (getY_sword() == 9 && getX_sword() == 9) ) {   // so imprime se ela noa estiver na POS 9 vs 9
		this.sword.paintIcon(this, g,getY_sword()*getY_pixel(), getX_sword()*getX_pixel());
		}
	}
private void paintNumDragons(Graphics g) {
	for(int i=0;i<this.numDragons;i++) {
		if(! (getY_dragons(i) == 9 && getX_dragons(i) == 9) )  //Se dragoes estiverem mortos (posicao 9 vs 9) nao sao pintados 
		this.dragon.paintIcon(this, g, getY_dragons(i)*getY_pixel(), getX_dragons(i)*getX_pixel());
	}
	}
	
	private void paintWall(Graphics g) {
		
		// 40 pixeis de largura vs 25 pixeis de altura
		for (int j = 0; j < 10; j++) { //correr as linhas
			for (int i = 0; i < 10; i++) { // correr colunas
				if(j==0 || j == 9){
					wall.paintIcon(this, g, i*getY_pixel(), j*getX_pixel()); 
				} else if(j == 1 && (i == 0 || i == 9)) {
					wall.paintIcon(this, g, i*getY_pixel(), j*getX_pixel());
				}else if((j == 2 || j ==3 || j == 4 || j == 6 || j == 7) && (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9)) {
					wall.paintIcon(this, g, i*getY_pixel(), j*getX_pixel());
				}else if(j == 5 && (i == 0 || i == 7 || i == 9)) {
					wall.paintIcon(this, g, i*getY_pixel(), j*getX_pixel());
				}else if(j == 8 && (i == 0 || i == 2 || i==3 || i == 9)) {
					wall.paintIcon(this, g, i*getY_pixel(), j*getX_pixel());
				}
				
			}
		}

	}
	//-----------------GETTERS E SETTERS-------------
	

		public int getX_sword() {
			return x_sword;
		}

		public void setX_sword(int x_sword) {
			this.x_sword = x_sword;
		}

		public int getX_door() {
			return x_door;
		}

		public void setX_door(int x_door) {
			this.x_door = x_door;
		}

		public int getX_hero() {
			return x_hero;
		}

		public void setX_hero(int x_hero) {
			this.x_hero = x_hero;
		}

		public int getY_door() {
			return y_door;
		}

		public void setY_door(int y_door) {
			this.y_door = y_door;
		}

		public int getY_sword() {
			return y_sword;
		}

		public void setY_sword(int y_sword) {
			this.y_sword = y_sword;
		}

		public int getY_hero() {
			return y_hero;
		}

		public void setY_hero(int y_hero) {
			this.y_hero = y_hero;
		}

		public ImageIcon getDragon() {
			return dragon;
		}

		public void setDragon(ImageIcon dragon) {
			this.dragon = dragon;
		}

		public ImageIcon getDoor() {
			return door;
		}

		public void setDoor(ImageIcon door) {
			this.door = door;
		}

		public ImageIcon getSword() {
			return sword;
		}

		public void setSword(ImageIcon sword) {
			this.sword = sword;
		}

		public ImageIcon getWall() {
			return wall;
		}

		public void setWall(ImageIcon wall) {
			this.wall = wall;
		}

		public ImageIcon getHero() {
			return hero;
		}

		public void setHero(ImageIcon hero) {
			this.hero = hero;
		}

		public boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}

		public int getX_pixel() {
			return x_pixel;
		}

		public void setX_pixel(int x_pixel) {
			this.x_pixel = x_pixel;
		}

		public int getY_pixel() {
			return y_pixel;
		}

		public void setY_pixel(int y_pixel) {
			this.y_pixel = y_pixel;
		}
		public int getNumDragons() {
			return numDragons;
		}
		public void setNumDragons(int numDragons) {
			this.y_dragons = new int[numDragons];
			this.x_dragons = new int[numDragons];
			this.numDragons = numDragons;
		}
		public int getY_dragons(int pos) {
			return y_dragons[pos];
		}
		public void setY_dragons(int y_dragons, int pos) {
			this.y_dragons[pos] = y_dragons;
		}
		public int getX_dragons(int pos) {
			return x_dragons[pos];
		}
		public void setX_dragons(int x_dragons,int pos) {
			this.x_dragons[pos] = x_dragons;
		}
		
		
}
