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
        finish = false;
    }

    //metodos
    public void imprimir() {

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i == this.h1.x && k == this.h1.y) {
                    System.out.print("H|");
                } else if (i == this.k1.x && k == this.k1.y) {
                    System.out.print("K|");
                } else if (i == this.d1.x && k == this.d1.y) {
                    System.out.print("D|");
                } else if (i == this.e1.x && k == this.e1.y) {
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
        if (this.map[h1.x + x][h1.y + y] == 'X') {
        	if(h1.x +x== e1.x && h1.y+y==e1.y)
        		return false;
            return true;
        }
        return false;
    }

    public boolean nextIsDragon(int x, int y) { //retorna 1 se for parede
        if (h1.x + (2 * x) == d1.x && h1.y + (2 * y) == d1.y) {

            h1.setLife(false);
            return true;
        }
        return false;
    }

    public boolean nextIsKey(int x, int y) { //retorna 1 se for parede
        if (h1.x + x == k1.x && h1.y + y == k1.y) {
            e1.saida = true;
            return true;
        }
        return false;
    }

    public boolean nextIsExit(int x, int y) { //
        if (h1.x + x == e1.x && h1.y + y == e1.y) {
            if (e1.saida == true) {
                System.out.println("Parabens! Saida encontrada");
                this.finish = true;
                return true;
            } else {
                System.out.println("NÃ£o tem a Key");
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
    			e1.x=num;
    			e1.y=(rnd.nextInt(8) + 1);
    		}
    		while(this.map[e1.x + 1][e1.y] == 'X'|| (e1.x + (2*(1))== d1.x  && e1.y == d1.y) ||(e1.x + 1== d1.x && e1.y  == d1.y) || (e1.x + 1== d1.x && e1.y +1 == d1.y) || (e1.x - 1== d1.x && e1.y +1 == d1.y));  //saida não tem parede á frente(em x) nem dragao em 2 quadrados de distancia (em x) nem na diagonal););
    		
    	}
    	else if(num==9) {
    		do{
    			e1.x=num;
    			e1.y=(rnd.nextInt(8) + 1);
    		}
    		while(this.map[e1.x - 1][e1.y] == 'X' || (e1.x + (2*(-1)) == d1.x && e1.y == d1.y) ||(e1.x - 1== d1.x && e1.y  == d1.y)|| (e1.x + 1== d1.x && e1.y -1 == d1.y) || (e1.x - 1== d1.x && e1.y -1 == d1.y));  //saida não tem parede á frente(em x) nem dragao em 2 quadrados de distancia (em x));
    		
    	}
    	else {
    		do{
    			a=1;
    			if((rnd.nextInt(10) + 0)<5)
    				e1.y=0;
    			else { 
    				e1.y=9;
    				a=-1;
    			}
    				e1.x=num;
    		}
    		while(this.map[e1.x][e1.y+a] == 'X' || (e1.x== d1.x && e1.y + (2 * a) == d1.y) ||(e1.x== d1.x && e1.y + a  == d1.y)|| (e1.x + 1== d1.x && e1.y +a == d1.y) || (e1.x + 1== d1.x && e1.y -a == d1.y) );  //saida não tem parede á frente(em y) nem dragao em 2 quadrados de distancia (em y)
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
