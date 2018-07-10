package TCXSCF_Crossover;

public class SimpleCrossover {

    int length;
    double mom[];
    double dad[];
    int squence[];
    int s;
    double m[];
    double d[];

    public void setParameter(int length) {
        this.length = length;
    }

    /*2組基因*/
    void parent() {
        mom = new double[]{1.25, 3.18, 4.35, 10.14, 2.30};
        dad = new double[]{7.35, 1.42, 6.05, -3.55, 7.86};
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

    /*隨機一個切點，並排除開頭和結尾*/
    void select() {
        squence = new int[length];
        for (int i = 0; i < length; i++) {
            squence[i] = (int) (Math.random() * length);
            s = squence[i];
            if (squence[i] == 0 || squence[i] == 5) {   //排除0和5
                i -= 1;
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.print("選擇切點 :" + s);
        }
        System.out.print("\n");
    }

    /*交換基因*/
    void SC() {
        double temp;
        m = new double[mom.length];
        d = new double[mom.length];
        for (int i = s; i < mom.length; i++) {
            m[i] = mom[i];
            d[i] = dad[i];
            if (m[i] != d[i]) {
                temp = m[i];
                m[i] = d[i];
                d[i] = temp;
            }
        }

        System.out.print("新基因 : ");
        for (int i = 0; i < mom.length; i++) {
            if (m[i] == 0) {
                System.out.print(mom[i] + "\t");
            } else {
                System.out.print(m[i] + "\t");
            }  
        }
        System.out.print("\n" + "新基因 : ");
        for (int i = 0; i < mom.length; i++) {
            if (d[i] == 0) {
                System.out.print(dad[i] + "\t");
            } else {
                System.out.print(d[i] + "\t");
            }  
        }
    }

    public static void main(String[] args) {
        SimpleCrossover sc = new SimpleCrossover();
        sc.setParameter(6);
        sc.parent();
        sc.select();
        sc.SC();
    }

}
