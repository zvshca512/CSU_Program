/*實做Runnable介面，必須執行run()方法。
Runnable介面建立的類別，只是一個準執行緒物件，需要藉由物件建構Thread類別的物件，啟動執行緒。*/
package example_runnable;

public class Example_Runnable implements Runnable {

    static int length;
    static int number[];

    public void run() {  
        long StartTime = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            System.out.println("H2:" + number[i]);
        }
        long EndTime = System.currentTimeMillis();
        long memory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
        System.out.println("H2先到達終點" + "所用時間：" + (EndTime - StartTime));
        System.out.println("記憶體使用量：" + memory/1024/1024 + " MB");
    }
    
    public int getlength() {
        return length;
    }

    public int[] getnumber() {
        return number;
    }

    public void setT(int a, int b[]) {
        length = a;
        number = b;
    }

}
