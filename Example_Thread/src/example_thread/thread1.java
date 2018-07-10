
package example_thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class thread1 {
    
    static int length;
    static int number[];

    public static void main(String[] args)throws FileNotFoundException, IOException{
    FileReader fr = new FileReader("C:\\Github\\CSU_Program\\Example_Thread\\file\\Random_10000.txt"); //read file
    BufferedReader br = new BufferedReader(fr);
    String message = "", eachLine = "";
       
    while ((eachLine = br.readLine()) != null)   {  
       message += eachLine + " ";   
    }
    /*字串輸出*/
    String[] STXT = message.split("\n| ");
       for(int i = 0 ; i < STXT.length ;i++)         
       {
//           System.out.print(STXT[i]+" ");              //display x,y coordinates value
       } 
    /*------------------------*/
    
    length = STXT.length;
    number = new int [length];
    int st = 0;
       for(int i = 0 ; i < length ; i++)
       {
       number[i] = Integer.parseInt(STXT[st]);
//       System.out.println(STXT[st]);
       st +=1;
       }  
    
    long StartTime = System.currentTimeMillis();
    //產生Example_Thread(class)物件並啟動執行緒
    Example_Thread h2 = new Example_Thread();
    thread1 t1 = new thread1();
    h2.setT(length, number);
    h2.start();
    h2.getlength();
    h2.getnumber();

    /*------------------------*/
    for (int i=0; i<length; i++){
      System.out.println("H1:"+number[i]);
    }
    long EndTime = System.currentTimeMillis();
    long memory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
    System.out.println("H1先到達終點"+"所用時間：" + (EndTime - StartTime));
    System.out.println("記憶體使用量：" + memory/1024/1024 + " MB");
    }
 
}
