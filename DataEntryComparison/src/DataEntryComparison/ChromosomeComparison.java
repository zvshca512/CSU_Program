package DataEntryComparison;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ChromosomeComparison {

    static String[] CTXT,objective,ScoredLabels;
    static int length;
    static double[] obj,predict;

    
    public void readfile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\Github\\CSU_Program\\DataEntryComparison\\file\\Chromosome(90).csv");
        BufferedReader br = new BufferedReader(fr);
        String message = "", eachLine = "";
        while ((eachLine = br.readLine()) != null) {
            message += eachLine + "\n";
//        System.out.println(br.readLine()); //read .csv file result
        }
//        System.out.println(message);  

        /*CTXT cut String*/
        CTXT = message.split(",|\n");
        for (int i = 0; i < CTXT.length; i++) {
//       System.out.println(CTXT[i]); 
        }

        /*objective,Scored Labels 列的資料裝進兩個一維陣列裏*/
        objective = new String[CTXT.length]; //objective長度
        ScoredLabels = new String[CTXT.length];  //ScoredLabels長度
        length = CTXT.length;
        /*-------------------------------------------------------*/
        int count = 0;
        obj = new double[length/2-1];
        predict = new double[length/2-1];
        
        for (int i = 2; i < length; i = i + 2) {   //設定長度為CTXT，i+=2
            obj[count] = Double.parseDouble(CTXT[i]);//0 2 4 (i+2)
            predict[count] = Double.parseDouble(CTXT[i + 1]);//1 3 5 (i+2)
//          System.out.println(obj[count]+" "+predict[count]);
            count++;
        }    
    }

    public void equals() {
        boolean a = true;
        int correct = 0; //正確次數
        int total = 0;  //總執行次數
        for (int i = 0; i < obj.length - 1; i++) {
            for (int j = i + 1; j < obj.length; j++) {
                if (obj[i] >= obj[j] && predict[i] >= predict[j]) {
                    a = true;    //true判斷為正確            
                    correct++;   //判斷為true遞增
                }
                if(obj[i] <= obj[j] && predict[i] <= predict[j]){
                    a = true;    //true判斷為正確            
                    correct++;   //判斷為true遞增
                }
                total++;    //每執行一次遞增
                System.out.println("obj : " + obj[i] + " 比 " + obj[j] + " &&& " + "predict : " + predict[i] + " 比 " + predict[j]);
                System.out.println(a);
//                System.out.println(correct);
//                System.out.println(total);
            }
        }
        System.out.println((double) correct / total * 100);
    }

    public static void main(String[] args) throws IOException {
        ChromosomeComparison cc = new ChromosomeComparison();
        cc.readfile();
        cc.equals();
    }

}
