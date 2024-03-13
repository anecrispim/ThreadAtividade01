package Ex03;

public class MainSemaforo {

	public static void main(String[] args) {
		Semaforo[] semaforos = new Semaforo[4];
        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            semaforos[i] = new Semaforo(i + 1);
            threads[i] = new Thread(semaforos[i]);
        }

        Semaforo.setSemaforos(semaforos);

        // Inicia todas as threads
        for (Thread thread : threads) {
            thread.start();
        }
	}

}
