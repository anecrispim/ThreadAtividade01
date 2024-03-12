package Ex05;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ContadorCompartilhado contadorCompartilhado = new ContadorCompartilhado();
        Scanner scanner = new Scanner(System.in);

        Thread threadIncremento = new Thread(() -> {
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("i")) {
                    contadorCompartilhado.incrementar();
                } else if (input.equalsIgnoreCase("d")) {
                    contadorCompartilhado.decrementar();
                }
            }
        });

        threadIncremento.start();
        
	}

}
