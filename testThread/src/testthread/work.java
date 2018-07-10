package testthread;

public class work implements Runnable {

    public void run() {
    long StartTime = System.currentTimeMillis();
    long EndTime = System.currentTimeMillis();
    System.out.println("到達終點" + "所用時間：" + (EndTime - StartTime));
    
    }
    
}
