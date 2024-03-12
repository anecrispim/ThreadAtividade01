package Ex02;

public class Contador implements Runnable {
	private int limite;
	
	public Contador (int limite) {
		this.limite = limite;
	}
	
	
	public void run() {
		for (int i = 1; i <= this.limite; i++) {
			synchronized (this) {
				System.out.println(i);
			}
		}
	}
	
	
}
