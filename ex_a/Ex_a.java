package ex_a;

import java.util.Random;
import java.util.Scanner;

public class Ex_a {

    public static void main(String[] args) {
        
        Hero h1 = new Hero(1, 1);
        Key k1 = new Key(1, 2);
        Dragon d1 = new Dragon(3, 1);
        
        int v[2];
        v=calcularXY(h1,k1,d1);
        
        Exiit e1 = new Exiit(9, 3);
        Mapa m1 = new Mapa(h1, k1, d1, e1);

        m1.imprimir();

        int x = 1, y = 1;

        Scanner leitor = new Scanner(System.in);

        //  refazer_mapa(map, 0, 0);
        while (true) {
            System.out.print("Insira um movimento(w,s,d,a): ");
            String move = leitor.nextLine();
            m1.movHero(move);
            m1.imprimir();
            if (m1.getFinish() || !h1.isLife()) {
                break;
            }
            System.out.println(h1.isLife());
        }

    }

    
    
    public int[] calcularXY(hero h1,key k1,dragon d1){
    	Random rnd = new Random();
    	
    	int num = (rnd.nextInt(9-1) + 1);
    	System.out.println(num);
    }
}
