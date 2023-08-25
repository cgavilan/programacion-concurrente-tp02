# 3. Ejecute el siguiente programa:
```java
public class ThreadEjemplo extends Thread {
    public ThreadEjemplo(String str) {
        super(str);
    }
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(i + " " + getName());
            System.out.println("Termina thread " + getName());
        }
    }
    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
}

```
a. Si lo ejecuto varias veces, ¿qué sucede?

> las salidas seran siempre distintas dado que los hilos compiten por la CPU con lo cual el orden de las impresiones no siempre seran las mismas.

```cmd
0 Maria Jose
Termina thread Maria Jose
1 Maria Jose
Termina thread Maria Jose
2 Maria Jose
Termina thread Maria Jose
3 Maria Jose
Termina thread Maria Jose
4 Maria Jose
Termina thread Maria Jose
5 Maria Jose
Termina thread Maria Jose
6 Maria Jose
Termina thread Maria Jose
7 Maria Jose
Termina thread Maria Jose
8 Maria Jose
Termina thread Maria Jose
9 Maria Jose
Termina thread Maria Jose
Termina thread main
0 Jose Maria
Termina thread Jose Maria
1 Jose Maria
Termina thread Jose Maria
2 Jose Maria
Termina thread Jose Maria
3 Jose Maria
Termina thread Jose Maria
4 Jose Maria
Termina thread Jose Maria
5 Jose Maria
Termina thread Jose Maria
6 Jose Maria
Termina thread Jose Maria
7 Jose Maria
Termina thread Jose Maria
8 Jose Maria
Termina thread Jose Maria
9 Jose Maria
Termina thread Jose Maria
```

```cmd
Termina thread main
0 Jose Maria
Termina thread Jose Maria
1 Jose Maria
Termina thread Jose Maria
2 Jose Maria
Termina thread Jose Maria
3 Jose Maria
0 Maria Jose
Termina thread Maria Jose
1 Maria Jose
Termina thread Maria Jose
2 Maria Jose
Termina thread Maria Jose
3 Maria Jose
Termina thread Maria Jose
4 Maria Jose
Termina thread Maria Jose
5 Maria Jose
Termina thread Maria Jose
6 Maria Jose
Termina thread Maria Jose
7 Maria Jose
Termina thread Maria Jose
8 Maria Jose
Termina thread Maria Jose
9 Maria Jose
Termina thread Maria Jose
Termina thread Jose Maria
4 Jose Maria
Termina thread Jose Maria
5 Jose Maria
Termina thread Jose Maria
6 Jose Maria
Termina thread Jose Maria
7 Jose Maria
Termina thread Jose Maria
8 Jose Maria
Termina thread Jose Maria
9 Jose Maria
Termina thread Jose Maria
```