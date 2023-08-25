package ejercicio04;

public class RunnableEjemplo implements Runnable {
    private String name;
    
    // public RunnableEjemplo(String str) {
    //     this.name = str;
    // }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.name);
            System.out.println("Termina thread " + this.name);
        }
    }
    
    public static void main(String[] args) {
        RunnableEjemplo r1 = new RunnableEjemplo();
        RunnableEjemplo r2= new RunnableEjemplo();

        r1.setName("Maria Jose");
        r2.setName("Jose Maria");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        System.out.println("Termina thread main");
    }
}
