/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp2;
/**
 *
 * @author User
 */
public class Swap{
    public static void swap(){
//        TSP2 tp = new TSP2();
        int temp;
//         squence[i] = ran.nextInt((totalSequence) -1)+0;
        int [] swap = new int []{1,2,3,4,5}; //=1 4 3 2 5
        temp = swap [2];
        swap [2] = swap [4];
        swap [4] =temp;
        System.out.println(temp);        
    }   
}
//int temp; a=4 b=5
        //temp = a; temp = swap[4]
        //a = b;    swap[4] = swap[5]
        //b = temp; swap[5] = temp;
	