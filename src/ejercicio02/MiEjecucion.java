package ejercicio02;

public class MiEjecucion extends Thread {
    public void run() {
        ir();
    }
    public void ir() {
        hacermas();
    }
    public void hacermas(){
        System.out.println("En la pila");
    }
}
