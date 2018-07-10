package TCXSCF_Crossover;

public class TCX {

    int mom[];
    int dad[];
    int squence[];

    void parent() {
        mom = new int[9];
        dad = new int[9];
        /*mom&dad random number 隨機產生兩組亂數不重複基因*/
        System.out.print("mom:\n");
        for (int i = 0; i < mom.length; i++) {
            mom[i] = (int) (Math.random() * mom.length + 1);
            dad[i] = (int) (Math.random() * mom.length + 1);
            for (int j = 0; j < i; j++) {
                if (mom[i] == mom[j]) {
                    i -= 1;     //if same number i-1
                    break;
                }
                if (dad[i] == dad[j]) {
                    i -= 1;
                    break;
                }
            }
        }

        for (int i = 0; i < mom.length; i++) {
            System.out.print(mom[i] + "\t");
        }
        System.out.print("\n");
        System.out.print("dad:\n");
        for (int i = 0; i < mom.length; i++) {
            System.out.print(dad[i] + "\t");
        }
        System.out.print("\ncrossover:\n");
    }

    /*copy mom gene 抓mom位置[3-5]基因*/
    void crossover() {
        squence = new int[mom.length];
        /*mom值丟進squence[]*/
        for (int i = 3; i <= 5; i++) {
            squence[i] = mom[i];    
        }
        /*假如squence[j]裡面的值為0,輸出空格;反之則填入數值在適當位置*/
        for (int j = 0; j < mom.length; j++) {
            if (squence[j] == 0) {
                System.out.print(" " + "\t");
            } else {
                System.out.print(squence[j] + "\t");
            }
        }
        System.out.print("\nchild:\n");
    }

    /*把crossover基因給child，去比較dad不相同基因填補其餘位置*/
    void child() {
        int s = 0;  //設定s=0
        for (int j = 0; j < mom.length; j++) {
            for (int i = 0; i < dad.length; i++) {
                if (dad[j] != squence[i]) { //dad不等於squence gene,s+1
                    s++;
                }
            }
            if (s == dad.length) {  
                for (int k = 0; k < mom.length; k++) {
                    if (squence[k] == 0) {
                        squence[k] = dad[j];
                        break;
                    }
                }
            }
            s = 0; //重置child gene
        }
        /*印出結果*/
        for (int i = 0; i < mom.length; i++) {
            System.out.print(squence[i] + "\t");
        }
    }

    public static void main(String[] args) {
        TCX t = new TCX();
        t.parent();
        t.crossover();
        t.child();
    }

}
