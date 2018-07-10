/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

public class test20180705 {

    public void equals() {
        int[] obj = new int[]{50, 60, 40, 70, 65, 45};
        int[] pre = new int[]{55, 50, 45, 85, 90, 80};
        boolean[] a = new boolean[obj.length];
        for (int i = 0; i < obj.length - 1; i++) {
            for (int j = i + 1; j < obj.length; j++) {
                if (obj[i] > obj[j] && pre[i] > pre[j] || obj[i] < obj[j] && pre[i] < pre[j]) {
                    a[i] = true;
                }
                System.out.println(obj[i] + "," + obj[j] + " &&& " + pre[i] + "," + pre[j]);
                System.out.println(a[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        test20180705 t = new test20180705();
        t.equals();
    }
    
}
