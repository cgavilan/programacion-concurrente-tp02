package ejercicio05;

public class MiHilo implements Runnable {
    
    private String nombreHilo;
    
    public MiHilo(String nombre) {
        this.nombreHilo = nombre;
    }
    
    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aquí
    @Override
    public void run(){
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + this.nombreHilo + ", el recuento " + contar);
            }
        } catch (InterruptedException e) {
            System.out.println(this.nombreHilo + " interrumpido.");
        }
        System.out.println("Terminando " + this.nombreHilo);
    }
}
