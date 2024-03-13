package Ex03;

public class Semaforo implements Runnable {
	private static Semaforo[] semaforos;
	private boolean aberto; 
	private int numSemaforo;
	
	public Semaforo(int num) {
		this.aberto = false;
		this.numSemaforo = num;
	}
	
	public synchronized void abrir() {
		for (Semaforo sem : semaforos) {
            if (sem != this) {
                sem.fechar(); // Fecha todos os outros semáforos
            }
        }
        this.aberto = true;
        notifyAll();
    }
    
    public void aguardar() throws InterruptedException {
        while (this.aberto) {
            wait();
        }
    }
    
    public void fechar() {
        this.aberto = false;
    }
    
    public String getStatus() {
        return this.aberto ? "Aberto" : "Fechado";
    }
    
    public static void setSemaforos(Semaforo[] semaforos) {
        Semaforo.semaforos = semaforos;
    }
	
	public void run() {
		try {
	        while (true) {
	        	
	        	abrir();
	        	aguardar();
	            System.out.println("Semaforo " + this.numSemaforo + " está: " + getStatus());
	            Thread.sleep(2000);
	            fechar();
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
