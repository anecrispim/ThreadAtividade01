package Ex05;
import java.util.Random;

public class ContadorCompartilhado {
	private int contador = 0;

    public synchronized void incrementar() {
        int incremento = gerarNumeroAleatorio();
        contador += incremento;
        System.out.println("Incrementou " + incremento + ". Novo valor do contador: " + contador);
    }

    public synchronized void decrementar() {
        int decremento = gerarNumeroAleatorio();
        contador -= decremento;
        System.out.println("Decrementou " + decremento + ". Novo valor do contador: " + contador);
    }

    private int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(10) + 1; 
    }
}
