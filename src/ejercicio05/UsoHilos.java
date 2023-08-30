package ejercicio05;

public class UsoHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciado.");

        // Primero, construye un objeto unHilo.
        MiHilo mh = new MiHilo("#1");

        // Luego, construye un hilo de ese objeto.
        Thread tmh = new Thread(mh);

        // Finalmente, comienza la ejecución del hilo.
        tmh.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo Principal interrumpido");
            }
        }
        System.out.println("Hilo principal finalizado.");
        
    }
}
