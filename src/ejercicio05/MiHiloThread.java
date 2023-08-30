package ejercicio05;

public class MiHiloThread extends Thread {

    public MiHiloThread(String name) {
        this.setName(name);
    }

    public void run() {
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + this.getName() + ", el recuento " + contar);
            }
        } catch (InterruptedException e) {
            System.out.println(this.getName() + " interrumpido.");
        }
        System.out.println("Terminando " + this.getName());
    }
}
