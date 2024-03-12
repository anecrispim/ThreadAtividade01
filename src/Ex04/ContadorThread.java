package Ex04;

public class ContadorThread extends Thread {
	private int contador;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    public ContadorThread(int inicial) {
        this.contador = inicial;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!paused) {
                contador++;
            }
        }
    }

    public void pause() {
        paused = !paused;
    }

    public void stopContador() {
        running = false;
    }

    public int getContador() {
        return contador;
    }
}
