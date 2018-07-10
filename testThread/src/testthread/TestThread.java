
package testthread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestThread{
    
    String[] CTXT;
    String[] CTXT2;
    int length;
    String[] number;
    String[] name;
    String DiseaseName[];
    int dn[];
    int[] isDiseaseNameTemp;
    
     public void ReadFile() throws FileNotFoundException, IOException {

        /*read file*/
        FileReader fr = new FileReader("C:\\Github\\CSU_Program\\DataEntryComparison\\file\\Data_Entry_2017.csv");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("C:\\Github\\CSU_Program\\DataEntryComparison\\file\\test.txt");

        br.readLine();
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
        /*Image Index & Finding Labels 列的資料裝進兩個一維陣列裏*/
        int count = 0;
        number = new String[CTXT.length / 2]; //編號[]長度
        name = new String[CTXT.length / 2];  //疾病名稱[]長度
        length = CTXT.length / 2;

        for (int i = 0; i < CTXT.length; i = i + 2) {   //設定長度為CTXT，i+=2
            number[count] = CTXT[i].trim();//0 2 4 (i+2)
            name[count] = CTXT[i + 1].trim();//1 3 5 (i+2)
//          System.out.println(number[count]+" "+name[count]);
            count++;
        }
        /*String DiseaseName[]*/
        dn = new int[15];
        DiseaseName = new String[]{("No Finding"), ("Atelectasis"), ("Cardiomegaly"), ("Consolidation"), ("Edema"), ("Effusion"), ("Emphysema"), ("Fibrosis"),
            ("Hernia"), ("Infiltration"), ("Mass"), ("Nodule"), ("Pleural_Thickening"), ("Pneumonia"), ("Pneumothorax")};

        for (int i = 0; i < DiseaseName.length; i++) {
//       System.out.print(DiseaseName[i] +"  "); 
        }
    for (int i = 0; i < length; i++) {  //dataCount

            String[] temp = name[i].split("\\|"); //對疾病名稱有"|"做切割
//            System.out.print(temp+":");
            isDiseaseNameTemp = new int[DiseaseName.length];  //設定isDiseaseNameTemp長度為DiseaseName.length[13]
            System.out.print(number[i] + ",");
//            fw.write(number[i] + ",");

            for (int j = 0; j < temp.length; j++) //"|"Count
            {
                for (int k = 0; k < DiseaseName.length; k++) //DiseaseName.length
                {
                    /*trim省略字串有空白間隔、equals做字串比對*/
                    if (temp[j].trim().equals(DiseaseName[k].trim())) //temp[j] same DiseaseName[k] = true
                    {
                        isDiseaseNameTemp[k] = 1;
                        dn[k] += 1;
                    }
                }
            }

            for (int j = 0; j < isDiseaseNameTemp.length; j++) {
                if (j == isDiseaseNameTemp.length - 1) //如果當j=isDiseaseNameTemp.length-1，結果不加逗點，否則加逗點   
                {
//                      fw.write(isDiseaseNameTemp[j] +"\t\n");
//                      fw.flush();
                    System.out.print(isDiseaseNameTemp[j]); //沒逗點
                } else {
//                      fw.write(isDiseaseNameTemp[j] + ",");
//                      fw.flush();
                    System.out.print(isDiseaseNameTemp[j] + ",");   //逗點
                }
            }
            System.out.print("\n");
        }
        /*計算每個類別出現次數*/
        for (int i = 0; i < dn.length; i++) {
            System.out.print(DiseaseName[i] + ":" + dn[i] + "\n");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException{
        
        TestThread t = new TestThread();
        t.ReadFile();
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
    }
    
}
