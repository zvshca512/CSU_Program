
package quicksort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort {
    
     public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);    // 递归调用，把key前面的完成排序
        qSort(arr, i, tail);    // 递归调用，把key后面的完成排序
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileReader fr = new FileReader("Random_10000.txt"); //read file
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
        
        long start = System.currentTimeMillis();

//        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        QuickSort.qSort(number, 0, number.length - 1);// 快速排序 
//        qSort(number, 0, number.length-1);
        
//        String out = "";
//        for (int digit : number) {
//            out += (digit + ",");
//        }
        System.out.println("所用时间：" + (System.currentTimeMillis() - start)); 
        for (int i = 0; i < length; i++) {  
            System.out.print(number[i] + " ");  
        } 
//        System.out.println(out);
    }
    
}

//int temp;
//int s [] = new int []{1,2,3,4,5}; //1 4 3 2 5
//temp = s [2];
//s [2] = s [4];
//s [4] =temp; 
//System.out.println(temp); 