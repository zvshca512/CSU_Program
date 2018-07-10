/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author U
 */
public class BubbleSort {
    
     public static void bubbleSort(int[] arr) {  
  
     int i, temp, len = arr.length;
     boolean changed;
     do {
      changed = false;
      for (i = 0; i < len - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
     
    }  
    
    public static void main(String[] args) throws FileNotFoundException, IOException {  
        
        FileReader fr = new FileReader("C:\\Github\\CSU_Program\\BubbleSort\\file\\Random_10000.txt"); //read file
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
  
        BubbleSort.bubbleSort(number);// 冒泡排序  
//      Sort.selectSort(p);// 选择排序  
//      Sort.selectSort2(p);// 选择排序2  
//        BubbleSort.quickSort(p, 0, p.length - 1);// 快速排序  
  
        System.out.println("所用时间：" + (System.currentTimeMillis() - start));  
        for (int i = 0; i < length; i++) {  
            System.out.println(number[i] + " ");  
        } 
        
    }  
    
}

//for (int i = 0; i < data.length - 1; i++) {// 控制趟数  
//            for (int j = 0; j < data.length - i - 1; j++) {  
//  
//                if (data[j] > data[j + 1]) {  
//                    int tmp = data[j];  
//                    data[j] = data[j + 1];  
//                    data[j + 1] = tmp;  
//                }  
//            }  
//        }  