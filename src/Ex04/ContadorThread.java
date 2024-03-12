package Ex04;

public class ContadorThread extends Thread {
	private String nomeContador;
	private int contador;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    public ContadorThread(int inicial, String nome) {
        this.contador = inicial;
        this.nomeContador = nome;
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
            	System.out.println("Contador " + nomeContador + ": " + contador);
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
