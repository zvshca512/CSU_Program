/*繼承Thread類別,java.lang.Thread類別可以讓使用者向作業系統取得額外的執行緒。
方法較為簡單但彈性小，不允許多重繼承*/
package example_thread;

public class Example_Thread extends Thread{
    
  static int length;
  static int number[];
  
  public void run(){
      
    long StartTime = System.currentTimeMillis();
    for (int i=0; i<length; i++){
      System.out.println("H2:"+number[i]);
    }
    long EndTime = System.currentTimeMillis();
    long memory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
    System.out.println("H2先到達終點"+"所用時間：" + (EndTime - StartTime));
    System.out.println("記憶體使用量：" + memory/1024/1024 + " MB");
    
  }   
  
  public int getlength(){
    return length;
  }
  
  public int[] getnumber(){
    return number;
  }
  
  public void setT(int a,int b[]){
    length = a;
    number = b;
  }
  
  
    
  
}