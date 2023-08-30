package ejercicio06;

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
