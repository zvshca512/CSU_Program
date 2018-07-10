package TCXSCF_Crossover;

public class ArithmeticCrossover {

    int length;
    int index2;
    double mom[];
    double dad[];
    int squence[];
    int cp;
    double p;
    double alpha[];
    int m, m2;

    public void setParameter(int length,int point,double alpha[]) {
        this.length = length;
        this.index2 = point;
        this.alpha = alpha;
    }

    /*產生2組不重複基因*/
    void parent() {
        mom = new double[length];
        dad = new double[length];
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
        //印出兩者基因
        System.out.print("mom :" + "\t");
        for (int i = 0; i < mom.length; i++) {
            System.out.print(mom[i] + "\t");
        }
        System.out.print("\n" + "dad :" + "\t");
        for (int i = 0; i < dad.length; i++) {
            System.out.print(dad[i] + "\t");
        }
        System.out.print("\n");
    }

    /*隨機一個位置*/
    void select() {
        squence = new int[index2];
        for (int i = 0; i < 2; i++) {
            squence[i] = (int) (Math.random() * index2);
            cp = squence[i];
            if (squence[i] == 0 || squence[i] == 6) {   //排除0和6
                i -= 1;
                }
            for (int j = 0; j < i; j++) {
            if (squence[i] == squence[j] && squence[j] == squence[i]) { //隨機2個亂數不重複
                    i -= 1;
                }
                if (squence[i] <= squence[j]) {     //數字由小到大
                    int temp = squence[i];
                    squence[i] = squence[j];
                    squence[j] = temp;
                    break;
                }
            }
        }
        //印出抽取的位置
        System.out.print("select :");
        for (int i = 0; i < 2; i++) {
            System.out.print(squence[i]+" ");
        }
        System.out.print("\n");
    }
    
    /*運算選擇基因*/
    void AC() {
        System.out.print("mom基因 : ");
        p = 0;
        for (int i = squence[0]; i < squence[1]; i++) {
            System.out.print(mom[i] + "  "); 
        }System.out.print("\n"+"dad基因 : ");
        for (int i = squence[0]; i < squence[1]; i++) {
        System.out.print(dad[i] + "  ");    
        }
        //運算
        m = (int) (Math.random() * alpha.length);
        m2 = (int) (Math.random() * alpha.length);
        System.out.print("\n隨機變數 :" + alpha[m] + " ");
        System.out.print(alpha[m2] + "\n"+ "運算結果 : ");
        for (int i = squence[0]; i < squence[1]; i++) {
            p = (alpha[m] * mom[i]) + ((1-alpha[m2]) * dad[i]);
        System.out.printf("%.1f  ", p);    
        }
        
    }

    public static void main(String[] args) {
        ArithmeticCrossover ac = new ArithmeticCrossover();
        double alpha[] = {0.3, 0.5};
        ac.setParameter(6,7, alpha);
        ac.parent();
        ac.select();
        ac.AC();
        

    }
}
