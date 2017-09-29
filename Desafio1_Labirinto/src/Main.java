import java.util.Scanner;

public class Main {

	private Scanner leitor;

	public static void main(String[] args) {
		 
        Hero h1 = new Hero(1, 1);
        Key k1 = new Key(1, 2);
        Dragon d1 = new Dragon(3, 1);
        Exiit e1 = new Exiit(9, 3);
        Mapa m1 = new Mapa(h1, k1, d1, e1);

        m1.CalcularXYExit();
        
        m1.imprimir();


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
        }

    }

}


