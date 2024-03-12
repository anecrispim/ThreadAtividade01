package Ex01;

import java.util.Scanner;

public class MainCorrida {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos corredores irão participar da corrida? ");
        int numCorredores = scanner.nextInt();
        
        String[] nomeCorredor = new String[numCorredores];
        for (int i = 0; i < numCorredores; i++) {
            System.out.print("Digite o nome do corredor " + (i + 1) + ": ");
            nomeCorredor[i] = scanner.next();
            
        }

        for (int i = 0; i < nomeCorredor.length; i++) {
        	new Thread(new Corredor(nomeCorredor[i], 50)).start();
		}
        
        scanner.close();
	}

}
