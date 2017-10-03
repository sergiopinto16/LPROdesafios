package game.logic;
import java.util.Random;

public class Mapa {

    //atributos
    char[][] map = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    private Hero h1;
    private Key k1;
    private Dragon d1;
    private Exiit e1;
    private boolean finish;

    public Mapa(Hero h1, Key k1, Dragon d1, Exiit e1) {
        this.h1 = h1;
        this.k1 = k1;
        this.d1 = d1;
        this.e1 = e1;
        this.finish = false;
    }

    //metodos
    public void imprimir() { //alteração mapa

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i == this.h1.getX() && k == this.h1.getY()) {
                    System.out.print("H|");
                } else if (i == this.k1.getX() && k == this.k1.getY()) {
                    System.out.print("K|");
                } else if (i == this.d1.getX() && k == this.d1.getY()) {
                    System.out.print("D|");
                } else if (i == this.e1.getX() && k == this.e1.getY()) {
                        System.out.print("E|");
                } else {
                    System.out.print(this.map[i][k] + "|");
                }
            }
            System.out.println("");
        }
    }

    public void movHero(String c) {
        if (c.equals("w")) {
            if (nextIsWall(-1, 0)) {
                System.out.println("Ã‰ Parede");
            } else if (nextIsExit(-1, 0)) {
                if (this.finish) {
                    h1.mov_up();
                } else {
                    System.out.println("Porta encerrada!");
                }
            } else if (nextIsDragon(-1, 0)) {
                System.out.println("YOU lOSE! GAME OVER!");
                h1.mov_up();
            } else {
                if (nextIsKey(-1, 0)) {
                    System.out.println("Porta aberta !");
                }
                h1.mov_up();
            }
        } else if (c.equals("s")) {
            if (nextIsWall(1, 0)) {
                System.out.println("Ã‰ Parede");
            } else if (nextIsExit(1, 0)) {
                if (this.finish) {
                    h1.mov_down();
                } else {
                    System.out.println("Porta encerrada!");
                }
            } else if (nextIsDragon(1, 0)) {
                System.out.println("YOU lOSE! GAME OVER!");
                h1.mov_down();
            } else {
                if (nextIsKey(1, 0)) {
                    System.out.println(" Porta aberta !");
                }
                h1.mov_down();
            }
        } else if (c.equals("d")) {

            if (nextIsExit(0, 1)) {
                if (this.finish) {
                    h1.mov_right();
                } else {
                    System.out.println("Porta encerrada!");
                }
            } else if (nextIsWall(0, 1)) {
                System.out.println("Ã‰ Parede");
            } else if (nextIsDragon(0, 1)) {
                System.out.println("YOU lOSE! GAME OVER!");
                h1.mov_right();
            } else {
                if (nextIsKey(0, 1)) {
                    System.out.println("Porta aberta !");
                }
                h1.mov_right();
            }

        } else if (c.equals("a")) {
            if (nextIsWall(0, -1)) {
                System.out.println("Ã‰ Parede");
            } else if (nextIsExit(0, -1)) {
                if (this.finish) {
                    h1.mov_left();
                } else {
                    System.out.println("Porta encerrada!");
                }
            } else if (nextIsDragon(0, -1)) {
                System.out.println("YOU lOSE! GAME OVER!");
                h1.mov_left();
            } else {
                if (nextIsKey(0, -1)) {
                    System.out.println("Porta aberta !");
                }
                h1.mov_left();
            }
        } else {
            System.out.println("Movimento Incorrecto");
        }

    }

    public boolean nextIsWall(int x, int y) { //retorna 1 se for parede
        if (this.map[h1.getX() + x][h1.getY() + y] == 'X') {
        	if(h1.getX() +x== e1.getX() && h1.getY()+y==e1.getY())
        		return false;
            return true;
        }
        return false;
    }

    public boolean nextIsDragon(int x, int y) { //retorna 1 se for parede
        if (h1.getX() + (2 * x) == d1.getX() && h1.getY() + (2 * y) == d1.getY()) {

            h1.setLife(false);
            return true;
        }
        return false;
    }

    public boolean nextIsKey(int x, int y) { //retorna 1 se for parede
        if (h1.getX() + x == k1.getX() && h1.getY() + y == k1.getY()) {
            e1.setSaida(true);
            return true;
        }
        return false;
    }

    public boolean nextIsExit(int x, int y) { //
        if (h1.getX() + x == e1.getX() && h1.getY() + y == e1.getY()) {
            if (e1.getSaida() == true) {
                System.out.println("Parabens! Saida encontrada");
                this.finish = true;
                return true;
            } else {
                System.out.println("NÃo tem a Key");
                return true;
            }
        }
        return false;
    }
    
    
    public void CalcularXYExit() {
    	Random rnd = new Random();
    	int a=1;
    	int num = (rnd.nextInt(10)) ;
    	
    	if(num==0) {
    		do{
    			e1.setX(num);
    			e1.setY((rnd.nextInt(8) + 1));
    		}
    		while(this.map[e1.getX() + 1][e1.getY()] == 'X'|| (e1.getX() + (2*(1))== d1.getX()  && e1.getY() == d1.getY()) ||(e1.getX() + 1== d1.getX() && e1.getY()  == d1.getY()) || (e1.getX() + 1== d1.getX() && e1.getY() +1 == d1.getY()) || (e1.getX() - 1== d1.getX() && e1.getY() +1 == d1.getY()));  //saida não tem parede á frente(em x) nem dragao em 2 quadrados de distancia (em x) nem na diagonal););
    		
    	}
    	else if(num==9) {
    		do{
    			e1.setX(num);
    			e1.setY((rnd.nextInt(8) + 1));
    		}
    		while(this.map[e1.getX() - 1][e1.getY()] == 'X' || (e1.getX() + (2*(-1)) == d1.getX() && e1.getY() == d1.getY()) ||(e1.getX() - 1== d1.getX() && e1.getY()  == d1.getY())|| (e1.getX() + 1== d1.getX() && e1.getY() -1 == d1.getY()) || (e1.getX() - 1== d1.getX() && e1.getY() -1 == d1.getY()));  //saida não tem parede á frente(em x) nem dragao em 2 quadrados de distancia (em x));
    		
    	}
    	else {
    		do{
    			a=1;
    			if((rnd.nextInt(10) + 0)<5)
    				e1.setY(0);
    			else { 
    				e1.setY(9);
    				a=-1;
    			}
    				e1.setX(num);
    		}
    		while(this.map[e1.getX()][e1.getY()+a] == 'X' || (e1.getX()== d1.getX() && e1.getY() + (2 * a) == d1.getY()) ||(e1.getX()== d1.getX() && e1.getY() + a  == d1.getY())|| (e1.getX() + 1== d1.getX() && e1.getY() +a == d1.getY()) || (e1.getX() + 1== d1.getX() && e1.getY() -a == d1.getY()) );  //saida não tem parede á frente(em y) nem dragao em 2 quadrados de distancia (em y)
    	}
    	
    	//System.out.println(e1.x);
    	//System.out.println(e1.y);
    }
    
////// GETTERS E SETTERS//////////

    public Hero getH1() {
        return h1;
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

    public boolean getFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

}
