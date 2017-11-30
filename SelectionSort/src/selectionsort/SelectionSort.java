
package selectionsort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelectionSort {
    
    public static void selectSort(int[] data) {  
        if (data == null || data.length == 0) {  
            return;  
        }  
  
        for (int i = 0; i < data.length - 1; i++) {  
            int min = i;// 将当前下标定为最小值下标  
            for (int j = i + 1; j < data.length; j++) {  
                if (data[j] < data[min]) {  
                    min = j;  
                }  
            }  
  
            if (i != min) {  
                int tmp = data[i];  
                data[i] = data[min];  
                data[min] = tmp;  
            }  
        }  
    }  
    
    public static void main(String[] args) throws FileNotFoundException, IOException {    
    FileReader fr = new FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\SelectionSort\\file\\Random_10000.txt"); //read file
        BufferedReader br = new BufferedReader(fr);
        String message = "", eachLine = "";
       
        while ((eachLine = br.readLine()) != null)   {  
          message += eachLine + " ";   
        }
        /*字串輸出*/
        String[] STXT = message.split("\n| ");
//        for(int i = 0 ; i < STXT.length ;i++)         
//        {
//            System.out.print(STXT[i]+" ");              //display x,y coordinates value
//        } 
        /*------------------------*/
        int length = STXT.length;
        int [] number= new int [length]; 
        int st = 0;
        for(int i = 0 ; i < length ; i++){
        number [i]  = Integer.parseInt(STXT[st]);
//        System.out.println(STXT[st]);
        st +=1;
        }
        
//        int[] p = { 34, 21, 54, 18, 23, 76, 38, 98, 45, 33, 27, 51, 11, 20, 79,  
//                   30, 89, 41 };  
        
        long start = System.currentTimeMillis();  
  
//        BubbleSort.bubbleSort(number);// 冒泡排序  
        SelectionSort.selectSort(number);// 选择排序  
//      Sort.selectSort2(p);// 选择排序2  
//        BubbleSort.quickSort(p, 0, p.length - 1);// 快速排序  
  
        System.out.println("所用时间：" + (System.currentTimeMillis() - start));  
        for (int i = 0; i < length; i++) {  
            System.out.print(number[i] + " ");  
        } 
        
    }
    
}
