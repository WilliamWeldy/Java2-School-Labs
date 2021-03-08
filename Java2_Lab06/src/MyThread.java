/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #6
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class MyThread {
    public static void main(String[] args) {
        /*One: lt1 will keep looping through until it finishes and then lt2 will begin. */
            LabThread lt1 = new LabThread(250);
            LabThread lt2 = new LabThread(300);
                lt1.start();
                lt2.start();
        /*Two: The 'LabThreadImplements' code runs when 'lt3' is initialized, and executes
                again when run() is ran. */
            LabThreadImplements lt3 = new LabThreadImplements(200);
                lt3.run();
        /*Three: 4 different threads are started and executed in sequential order. */
            LabThread lt4 = new LabThread(300);
            LabThread lt5 = new LabThread(325);
            LabThread lt6 = new LabThread(350);
            LabThread lt7 = new LabThread(375);
                lt4.start();
                lt5.start();
                lt6.start();
                lt7.start();
    }
}

class LabThread extends Thread {
    private int loops = 0;

    public LabThread() { printInt(); } //Goes straight to printInt() if no integer is specified.
    public LabThread(int numberOfLoops) {
        loops = numberOfLoops; //This sets the private loop count integer to the parameter.
        printInt();
    }

    private void printInt() {
        System.out.println("Thread Running..." + loops + "\nGO!\n ");
        for(int i = 0 ; i <= loops ; i++) { System.out.println(i); }
    }
}

class LabThreadImplements implements Runnable {
    private int loops = 0;

    public LabThreadImplements() { run(); } //Goes straight to printInt() if no integer is specified.
    public LabThreadImplements(int numberOfLoops) {
        loops = numberOfLoops; //This sets the private loop count integer to the parameter.
        run();
    }

    public void run() { //run() is made into a concrete method the same as 'LabThreadExtends' printInt().
        System.out.println("Thread Running..." + loops + "\nGO!\n ");
        for(int i = 0 ; i <= loops ; i++) { System.out.println(i); }
    }
}