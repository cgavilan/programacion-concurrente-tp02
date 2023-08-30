package ejercicio06;

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
