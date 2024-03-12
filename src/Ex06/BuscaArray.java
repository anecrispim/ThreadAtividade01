package Ex06;
import java.util.concurrent.atomic.AtomicBoolean;

public class BuscaArray {
	private static int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    private static final int x = 13;
    private static final int nThreads = 5;
    private static final int elementosPorThread = array.length / nThreads; 
    private static final AtomicBoolean encontrado = new AtomicBoolean(false); 
    
    public static int buscar() {
        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            final int inicio = i * elementosPorThread;
            final int fim = (i == nThreads - 1) ? array.length : (i + 1) * elementosPorThread;
            threads[i] = new Thread(() -> {
                for (int j = inicio; j < fim; j++) {
                    if (array[j] == x) {
                        encontrado.set(true);
                        return;
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (encontrado.get()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == x) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int resultado = buscar();
        if (resultado != -1) {
            System.out.println("Número " + x + " encontrado no índice " + resultado);
        } else {
            System.out.println("Número " + x + " não encontrado no array.");
        }
    }
}
