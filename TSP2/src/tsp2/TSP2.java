/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import tsp2.Swap;   //呼叫tsp底下的Swap.java 
/**
 *
 * @author User
 */
public class TSP2 {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int totalSequence;      //序列總合
        double[] originalPoint = new double[2];     
        double[][] coordinates ;
        Swap sp = new Swap();     //物件初始化，用Swap的方式建立實體
        String[] STXT ;
        
        FileReader fr = new FileReader("test10.txt"); //read file
        BufferedReader br = new BufferedReader(fr);
        String message = "", eachLine = "";
       
        while ((eachLine = br.readLine()) != null)   {  
          message += eachLine + " ";   
        }
        STXT = message.split("\n| ");
//        for(int i = 0 ; i < STXT.length ;i++)         
//        {
//            System.out.println(STXT[i]);              //display x,y coordinates value
//        }
        
        totalSequence = Integer.parseInt(STXT[0]);  //轉整數Int 10
//        System.out.println(totalSequence); 
        coordinates = new double[10][totalSequence -1];    //座標二維陣列 10*9
             
        originalPoint[0] = Double.parseDouble(STXT[2]);     //原點x
        originalPoint[1] = Double.parseDouble(STXT[3]);     //原點y
        int startX = 5;   //位置5
        int startY = 6;   //位置6
        for(int i = 0 ; i < (totalSequence) -1; i++)
        {
            coordinates[0][i] = Double.parseDouble(STXT[startX]);       //x 座標
//            System.out.println(Double.parseDouble(STXT[startX]));
            startX += 3;
            coordinates[1][i] = Double.parseDouble(STXT[startY]);       //y 座標
//            System.out.println(Double.parseDouble(STXT[startY]));
            startY += 3;       
        }
        
        int[] squence = new int[totalSequence-1];        //{9,6,4,5,3,1,7,2,8}; 序列
        double total = 0.0;                 //總和
        Random ran = new Random();          //亂數  
        double [][] s = new double [totalSequence-1][totalSequence-1];
       
       for(int i = 0 ; i < squence.length; i++)         // 前面有裝原點，所以上面扣除原點的值(squence.length -1)=>0-9
       {  
           squence[i] = ran.nextInt((totalSequence)-1);  // random 總數和 - 1 ,序列的值代入i                                                            
           for(int j = 0; j < i ; j++)                      // 排除相同的點，j必須小於i的squence。 Ex : 當 i  =5 時， j 必須為0.1.2.3.4 ，
           {                                                //
               if(squence[i] == squence[j])                 // 當i = j相同時，
               {                                            // 
                  i -= 1;                                   // i 就會 -1 ，
                  break;                                    // 從新 random一次， 就不會重覆。 
               }                                            //
           }
       }
       
        for(int i = 0 ; i < squence.length -1; i++)
       {     
           if(coordinates[i][i+1]==0 || coordinates[i+1][i]==0){        //ex: 假如[4][5]為0 和 [5][4]為0時
            coordinates[i][i+1] = distance (coordinates[0][squence[i]],coordinates[1][squence[i]],coordinates[0][squence[i+1]],coordinates[1][squence[i+1]]);   //[4][5] = distsnce計算的值
            coordinates[i+1][i] = coordinates[i][i+1];  //[5][4] = [4][5]
            total += coordinates[i][i+1];   //total = total + coordinates[i][i+1]
           }else
            total += coordinates[i][i+1];
//            System.out.println(total); //列印兩點之間的距離加總
       }
           if(coordinates[squence[0]][squence[squence.length-1]]==0 || coordinates[squence[0]][squence[squence.length-1]]==0){   //兩者數值相同||squence[0]為第一個顯示點 [squence.length-1]為尾點
            total = 0;  //當頭到尾一樣時，則total數值為0，避免再加一次的結果
//            System.out.println(squence[0]);  
           }else
            total = 0;

          total += distance (originalPoint[0],originalPoint[1],coordinates[0][squence[0]],coordinates[1][squence[0]]);     //原點到下一個點的位置
//        System.out.println(coordinates[0][squence[0]]); 
/*---------------------------------------------------------------------------------------------------------------*/
       System.out.printf("從原點到座標各個點的距離:");
       for(int i = 0 ; i < squence.length; i++ ){
          System.out.println(squence[i]+1);     //i從0開始，但要顯示的數值必須從1開始，所以每個數各+1 //顯示數字1-9
       }
/*---------------------------------------------------------------------------------------------------------------*/
       for(int i = 0 ; i < squence.length -1; i++)
       {
          total += distance (coordinates[0][squence[i]],coordinates[1][squence[i]],coordinates[0][squence[i+1]],coordinates[1][squence[i+1]]);    //座標x1第一個點,y1,x2,y2 
//          System.out.println(coordinates[0][squence[i]]);
       }      
          total += distance (coordinates[0][squence.length -1],coordinates[1][squence.length -1],originalPoint[0],originalPoint[1]);      //當最後一個點跑完時，回到原點
          System.out.printf("總合:");
          System.out.println(total);    //顯示計算總合的值        
    }

     public static double distance(double x1,double y1,double x2,double y2){
        double result = Math.pow(((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2))), 0.5);
        return result;
    }
     
}
/*****
 * * 1 2 3 4 5
 *   5 4 2 1 3
 *   4 5 3 1 2
 * *
 * * 1 2 3 4 
 * * 2 3 4 5
 * * 3 4 5
 * * 4 5
 * * 5
 * 
 * int[][] a = new int[10][10];
 * 
 * 
 * squence[0]=1
 * 
 * 
 *  if(a[i][i+1] ==0 || a[i+1][i] ==0) {
 *      a[i][i+1] = dis;
 *      a[i+1][i] = a[i][i+1];
 *      total += a[i][i+1];
 *   else
 *      total += a[i][i+1];
 * }
 * *
 * *
 * *
 * *http://programming.im.ncnu.edu.tw/J_Chapter3.htm
*/
 