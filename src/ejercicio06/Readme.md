# 6. simulación de Carrera Multithread:
Imagina que estás organizando una carrera de atletismo con varios corredores.
Quieres simular esta carrera utilizando múltiples hilos en Java. Cada corredor será
representado por un hilo independiente que avanzará en la pista de carreras.
Crea una clase llamada Corredor que serán los hilos. Dentro de esta clase, define
los atributos necesarios como el nombre del corredor y la distancia recorrida. Cada
corredor sabe la distancia que recorrió, por lo que deberá imprimir su nombre y el
avance (aleatorio entre 1 y 10), por cada paso que realiza. Entre cada paso
realizado descansa. Una vez que haga 100 pasos, el corredor habrá terminado.
En la clase principal, crea un arreglo de objetos Corredor (instancias de la clase
Corredor) y para cada corredor en el arreglo, crea un objeto Thread y pasar la
instancia del corredor como argumento al constructor del Thread.
Inicia todos los hilos creados usando el método start(). Utiliza Thread.sleep() dentro
del método run() de cada corredor para simular el tiempo entre pasos.
Al finalizar la carrera se desea saber qué corredor hizo la mayor distancia y cual fue.

```java
import java.util.Random;

public class Runner implements Runnable {
    private String name;
    private int distanceCovered;

    public String getName() {
        return name;
    }
    public int getDistanceCovered() {
        return distanceCovered;
    }

    public Runner(String name) {
        this.name = name;
        this.distanceCovered = 0;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (this.distanceCovered < 100) {
            int move = rnd.nextInt(10) + 1;
            this.distanceCovered += move;
            System.out.println(this.name + " avanza " + move + " pasos. Total: " + this.distanceCovered);
        
            try {
                // Simulando tiempo entre pasos
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Race {
    public static void main(String[] args) {
        int cantRunner = 5;
        Runner[] race = new Runner[cantRunner];
        Thread[] tRace = new Thread[cantRunner];
        
        for (int i = 0; i < cantRunner; i++) {
            race[i] = new Runner("#" + i);
            tRace[i] = new Thread(race[i]);
            tRace[i].start();
        }

        try {    
            for (Thread thread : tRace) {
                thread.join();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        String winner = "";
        int maxDistance = -1;

        for (Runner runner : race) {
            if (runner.getDistanceCovered() > maxDistance) {
                winner = runner.getName();
                maxDistance = runner.getDistanceCovered();
            }
        }
        System.out.println("El ganador es: " + winner + " recorriendo " + maxDistance);

    }
}
```