package Ex03;

public class MainSemaforo {

	public static void main(String[] args) {
		Semaforo[] semaforos = new Semaforo[4];
        Thread[] threads = new Thread[4];

        // Iniciando quatro semáforos e threads correspondentes
        for (int i = 0; i < 4; i++) {
            semaforos[i] = new Semaforo(i + 1); // Cria um novo semáforo com número de 1 a 4
            threads[i] = new Thread(semaforos[i]); // Cria uma nova thread com o semáforo correspondente
        }

        // Define o array de semáforos em cada instância de semáforo
        Semaforo.setSemaforos(semaforos);

        // Inicia todas as threads
        for (Thread thread : threads) {
            thread.start();
        }
	}

}
