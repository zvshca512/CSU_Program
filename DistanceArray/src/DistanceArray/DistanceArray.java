
package DistanceArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DistanceArray {
    
    String [] STXT;
    int totalSequence;
    double [][] coordinates;
    double[] originalPoint;
    int [] number;
    int [] squence;
    int length;
    double[] x;
    double[] y;
    double answer;
    double result;
    double []o;
    double[][]t;
    
    public void  readFile() throws FileNotFoundException, IOException{
    /*read file*/
    FileReader fr = new FileReader("C:\\Github\\CSU_Program\\DistanceArray\\file\\test10.txt");
    BufferedReader br = new BufferedReader(fr);
    String message = "", eachLine = "";
    
        while ((eachLine = br.readLine()) != null)   {  
          message += eachLine + " ";   
        }
    STXT = message.split("\n| ");
//    System.out.println(STXT);
    /*---------*/
    totalSequence = Integer.parseInt(STXT[0]);
//    System.out.println(STXT[0]); //10
    coordinates = new double[10][totalSequence];
    /*Declare one array,originalPoint and every coordinates save*/
//    originalPoint = new double [totalSequence];
    /*1-10*/
    number = new int [totalSequence]; 
    int start = 1;
        for(int i = 0 ; i < totalSequence ; i++){
        number [i]  = Integer.parseInt(STXT[start]);
//        System.out.println(STXT[start]);
        start +=3;
        }
     /*x y coordinates*/
    int startX = 2 ;
//    System.out.println(startX); //2
    int startY = 3 ;   
        for(int i = 0 ; i < totalSequence; i++)
        {
          coordinates[0][i] = Double.parseDouble(STXT[startX]);      
//            System.out.println(Double.parseDouble(STXT[startX]));
          startX += 3;  
          coordinates[1][i] = Double.parseDouble(STXT[startY]);      
//            System.out.println(Double.parseDouble(STXT[startY]));
          startY += 3;       
        }
    length = totalSequence;
    squence = new int []{0,1,2,3,4,5,6,7,8,9};
    x = new double [length];
    y = new double [length];
    x = coordinates[0];
    y = coordinates[1];
    o = new double [length-1];
    t = new double[length-1][length-1];
    
    /*one array*/ //o[i-1] = distance (x[i],y[i],x[0],y[0]);
        for(int i = 1; i < length; i++){
          o[i-1] = Math.pow(((Math.pow((x[i] - x[0]), 2) + Math.pow((y[i] - y[0]), 2))), 0.5);
        System.out.print((int)o[i-1] +"\t");
        }
        System.out.println("\n");
    /*two array*/ //distasnce (coordinates[0][i],coordinates[1][i],coordinates[0][j],coordinates[1][j]);
        for(int j = 1; j < length; j++){
        for(int i = 1; i < length; i++){
            if(i != j){
            if(t[i-1][j-1] ==0 || t[j-1][i-1] ==0){
            t[i-1][j-1] = Math.pow(((Math.pow((coordinates[0][i] - coordinates[0][j]), 2) + Math.pow((coordinates[1][i] - coordinates[1][j]), 2))), 0.5);
            t[j-1][i-1] = t[i-1][j-1];
            }
            }
          System.out.print((int)t[i-1][j-1] +"\t");
        }    
        System.out.println(" ");
        }
    
    }
    
    public void distance(double x1,double y1,double x2,double y2) throws IOException{
        result = Math.pow(((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2))), 0.5);
//        System.out.print((int)result +"\t");
  
    }
    
    public static void main(String[] args) throws IOException {
    DistanceArray test = new DistanceArray();
    test.readFile();  
    }

}
