package ejercicio01;

public class Recurso {
    static void uso(){
        Thread t = Thread.currentThread();
        System.out.println("en Recurso:" + t.getName());
    }
}
