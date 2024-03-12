package Ex01;

public class Corredor implements Runnable {
	private String nome;
	private int metros;
	
	public Corredor(String nome, int metros) {
		this.nome = nome;
		this.metros = metros;
	}
	
	public void run() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < metros) {
			int distanciaAtual = (int) (Math.random() * 10) + 1; // gera um num aleaorio de 1 a 10
			distanciaPercorrida += distanciaAtual;
			
			if (distanciaPercorrida >= metros) {
				distanciaPercorrida = metros;
			}
			//Thread.currentThread();
			//Thread.yield();
			System.out.println(nome + " percorreu " + distanciaAtual + " metros. Distância total percorrida: " + distanciaPercorrida + " metros.");
            try {
                Thread.sleep(1000); // Pausa a execução por 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
		System.out.println(nome + " terminou a corrida!");
	}

}
