package Ex02;

import java.util.Scanner;

public class MainContador {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número maior que 5000: ");
        int num = scanner.nextInt();
        
        final int QTD_THREADS = 5;
        
        for (int i = 0; i < QTD_THREADS; i++) {
			new Thread(new Contador(num)).start();
		}
        
        scanner.close();
	}

}
