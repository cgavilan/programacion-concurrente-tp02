# 5. Analizar el siguiente código:
```java
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
```

a. ¿Qué pasaría si quitamos el sleep()?

> Si quitamos el Thread.sleep(400) del método run() en la clase MiHilo, los hilos se ejecutarán sin ninguna pausa y competirán por los recursos de la CPU. Esto podría resultar en una ejecución mucho más rápida y podría causar que los mensajes de salida de los hilos se mezclen y se impriman de manera desordenada. Los hilos podrían imprimir varios mensajes sin dar lugar a que otros hilos impriman sus mensajes debido a la falta de pausa.

> La salida del programa sería mucho más impredecible y caótica sin el Thread.sleep(400). Los hilos se ejecutarían lo más rápido posible, y es probable que veas una mezcla desordenada de mensajes de todos los hilos en la salida, lo que dificultaría entender el flujo real de la ejecución.

> La función Thread.sleep(100) en el bucle principal también contribuye a crear una pausa en la ejecución del hilo principal y podría ayudar a dar más tiempo a los hilos secundarios para imprimir sus mensajes. Sin embargo, si quitas esta pausa, el hilo principal ejecutará su bucle en ráfagas rápidas, lo que podría hacer que la salida sea aún más caótica.

¿Cuál sería la salida del programa?

> La salida del programa sin el `Thread.sleep(400)` en el método `run()` sería bastante caótica debido a la competencia por los recursos de la CPU entre los hilos. La velocidad de ejecución de los hilos puede variar en diferentes momentos, lo que resultaría en una mezcla desordenada de mensajes de salida. Aquí tienes un ejemplo de cómo podría verse la salida, aunque ten en cuenta que debido a la naturaleza no determinista de los hilos, la salida real podría variar en diferentes ejecuciones:

```cmd
Hilo principal iniciado.
En #1, el recuento 0
En #1, el recuento 1
En #1, el recuento 2
. En #1, el recuento 3
En #1, el recuento 4
. . En #1, el recuento 5
En #1, el recuento 6
En #1, el recuento 7
En #1, el recuento 8
En #1, el recuento 9
. . . . . . . . . . . . . . . . . . . . . . . . . . . . . En #1, el recuento 10
En #1, el recuento 11
En #1, el recuento 12
En #1, el recuento 13
En #1, el recuento 14
En #1, el recuento 15
En #1, el recuento 16
En #1, el recuento 17
En #1, el recuento 18
En #1, el recuento 19
En #1, el recuento 20
En #1, el recuento 21
En #1, el recuento 22
En #1, el recuento 23
En #1, el recuento 24
En #1, el recuento 25
En #1, el recuento 26
En #1, el recuento 27
En #1, el recuento 28
En #1, el recuento 29
En #1, el recuento 30
En #1, el recuento 31
En #1, el recuento 32
En #1, el recuento 33
En #1, el recuento 34
En #1, el recuento 35
En #1, el recuento 36
En #1, el recuento 37
En #1, el recuento 38
En #1, el recuento 39
En #1, el recuento 40
En #1, el recuento 41
En #1, el recuento 42
En #1, el recuento 43
En #1, el recuento 44
En #1, el recuento 45
En #1, el recuento 46
En #1, el recuento 47
En #1, el recuento 48
En #1, el recuento 49
Hilo principal finalizado.
En #1, el recuento 11
En #1, el recuento 12
En #1, el recuento 13
En #1, el recuento 14
En #1, el recuento 15
En #1, el recuento 16
En #1, el recuento 17
En #1, el recuento 18
En #1, el recuento 19
En #1, el recuento 20
En #1, el recuento 21
En #1, el recuento 22
En #1, el recuento 23
En #1, el recuento 24
En #1, el recuento 25
En #1, el recuento 26
En #1, el recuento 27
En #1, el recuento 28
En #1, el recuento 29
En #1, el recuento 30
En #1, el recuento 31
En #1, el recuento 32
En #1, el recuento 33
En #1, el recuento 34
En #1, el recuento 35
En #1, el recuento 36
En #1, el recuento 37
En #1, el recuento 38
En #1, el recuento 39
En #1, el recuento 40
En #1, el recuento 41
En #1, el recuento 42
En #1, el recuento 43
En #1, el recuento 44
En #1, el recuento 45
En #1, el recuento 46
En #1, el recuento 47
En #1, el recuento 48
En #1, el recuento 49
Terminando #1
```

b. El main() ¿siempre termina al final, o puede suceder que termine antes que
el run()? ¿Por qué puede suceder esto?

> El método `main()` en Java no siempre termina al final. De hecho, puede suceder que termine antes de que todos los hilos hayan completado su ejecución en el método `run()`. Esto se debe a la naturaleza de la concurrencia y la ejecución de hilos en Java.

> Cuando se inician múltiples hilos utilizando el método `start()`, no hay garantía de cuándo cada hilo específico completará su ejecución en el método `run()`. Los hilos compiten por los recursos de la CPU, y su ejecución y planificación están a cargo del sistema operativo y el planificador de hilos. Esto significa que los hilos pueden ejecutarse en diferentes núcleos de CPU o pueden ser pausados y reanudados en momentos impredecibles.

> Dado que el método `main()` es solo otro hilo en el programa, puede seguir ejecutándose incluso si los hilos secundarios (como los que se crean en el ejemplo) aún no han terminado su ejecución. Esto significa que es posible que veas la salida de "Hilo principal finalizado." antes de que algunos de los hilos hayan terminado de imprimir sus mensajes.

> Para controlar y esperar a que los hilos secundarios completen su ejecución antes de que el hilo principal termine, se utilizan técnicas como `join()`. En el ejemplo que proporcionaste, se utiliza un bucle `for` para esperar a que cada hilo termine utilizando `thread.join()`, lo que asegura que el hilo principal espere hasta que todos los hilos secundarios hayan terminado antes de imprimir "Hilo principal finalizado.".

c. Realizar los cambios necesarios para implementar extendiendo la clase
Thread. NO usar la interfaz Runnable.

```java
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

public class UsoHilosThread {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciado.");

        // Primero, construye un objeto unHilo.
        MiHiloThread mh = new MiHiloThread("#1");

        // comienza la ejecución del hilo.
        mh.start();

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
```

d. Realice el ejercicio para que en vez de ejecutar un solo hilo, ejecute 3.
Realice el procedimiento varias veces. ¿Qué ocurre? ¿Se ejecutan en orden?

> Dada la siguiente implementacion es claro ver que los hilos compiten por la CPU la ejecucion no asegura un orden.


```java
ublic class UsoHilosThread {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciado.");

        // Primero, construye un objeto unHilo.
        MiHiloThread mh1 = new MiHiloThread("#1");
        MiHiloThread mh2 = new MiHiloThread("#2");
        MiHiloThread mh3 = new MiHiloThread("#3");

        // comienza la ejecución del hilo.
        mh1.start();
        mh2.start();
        mh3.start();

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
```

```cmd
Hilo principal iniciado.
. . . . En #1, el recuento 0
En #2, el recuento 0
. En #3, el recuento 0
. . . En #1, el recuento 1
En #2, el recuento 1
En #3, el recuento 1
. . . . En #1, el recuento 2
En #2, el recuento 2
En #3, el recuento 2
. . . . En #1, el recuento 3
En #2, el recuento 3
En #3, el recuento 3
. . . . En #1, el recuento 4
En #2, el recuento 4
En #3, el recuento 4
. . . . En #1, el recuento 5
En #2, el recuento 5
En #3, el recuento 5
. . . . En #1, el recuento 6
En #2, el recuento 6
En #3, el recuento 6
. . . . En #1, el recuento 7
En #2, el recuento 7
En #3, el recuento 7
. . . . En #1, el recuento 8
En #2, el recuento 8
En #3, el recuento 8
. . . . En #2, el recuento 9
En #1, el recuento 9
Terminando #1
Terminando #2
En #3, el recuento 9
Terminando #3
. . . . . . . . . . Hilo principal finalizado.
```
>