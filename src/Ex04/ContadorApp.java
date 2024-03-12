package Ex04;
import java.util.Scanner;

public class ContadorApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContadorThread contadorThread1 = new ContadorThread(1,"1");
        ContadorThread contadorThread2 = new ContadorThread(2, "2");

        System.out.println("Bem-vindo ao aplicativo do contador.");
        System.out.println("Digite 'start1' para iniciar o Contador 1.");
        System.out.println("Digite 'start2' para iniciar o Contador 2.");
        System.out.println("Digite 'pause1' para pausar o Contador 1.");
        System.out.println("Digite 'pause2' para pausar o Contador 2.");
        System.out.println("Digite 'stop1' para parar o Contador 1 e exibir o valor.");
        System.out.println("Digite 'stop2' para parar o Contador 2 e exibir o valor.");
        System.out.println("Digite 'exit' para sair.");

        boolean running = true;
        while (running) {
            String input = scanner.nextLine();
            switch (input) {
                case "start1":
                    contadorThread1.start();
                    break;
                case "start2":
                    contadorThread2.start();
                    break;
                case "pause1":
                    contadorThread1.pause();
                    break;
                case "pause2":
                    contadorThread2.pause();
                    break;
                case "stop1":
                    contadorThread1.stopContador();
                    System.out.println("Contador 1: " + contadorThread1.getContador());
                    break;
                case "stop2":
                    contadorThread2.stopContador();
                    System.out.println("Contador 2: " + contadorThread2.getContador());
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }

        scanner.close();
    }
}
