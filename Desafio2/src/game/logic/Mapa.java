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

    private boolean finish;


    //metodos
    public void imprimir(Exiit e1,Dragon d1,Hero h1,Key k1) { 

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i == h1.getX() && k == h1.getY()) {
                    System.out.print("H|");
                } else if (i == k1.getX() && k == k1.getY()) {
                    System.out.print("K|");
                } else if (i == d1.getX() && k == d1.getY()) {
                    System.out.print("D|");
                } else if (i == e1.getX() && k == e1.getY()) {
                        System.out.print("E|");
                } else {
                    System.out.print(this.map[i][k] + "|");
                }
            }
            System.out.println("");
        }
    }

    
    public boolean nextIsWall(int x, int y,Hero h1,Exiit e1) { //retorna 1 se for parede
        if (this.map[h1.getX() + x][h1.getY() + y] == 'X') {
        	if(h1.getX() +x== e1.getX() && h1.getY()+y==e1.getY())
        		return false;
            return true;
        }
        return false;
    }

    public boolean nextIsDragon(int x, int y,Hero h1,Exiit e1,Dragon d1) { //retorna 1 se for parede
        if (h1.getX() + (2 * x) == d1.getX() && h1.getY() + (2 * y) == d1.getY()) {
            h1.setLife(false);
            return true;
        }
        return false;
    }
 
    public boolean nextIsKey(int x, int y, Hero h1,Exiit e1, Key k1) { //retorna 1 se for parede
        if (h1.getX() + x == k1.getX() && h1.getY() + y == k1.getY()) {
            e1.setSaida(true);
            return true;
        }
        return false;
    }

    public boolean nextIsExit(int x, int y,Hero h1,Exiit e1) { //
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
    
    
    public void CalcularXYExit(Exiit e1,Dragon d1,Hero h1,Key k1) {
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

    public boolean getFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

}
