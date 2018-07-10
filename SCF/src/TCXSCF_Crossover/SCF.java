package TCXSCF_Crossover;

public class SCF {

    int mom[];
    int dad[];
    int SameGene[];
    int squence[];
    int subgenes[];
    /*產生2組1-9不重複基因*/
    void parent() {
        mom = new int[9];
        dad = new int[9];
        /*mom&dad random number*/
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
        }System.out.print("\n");
    }
    
    /*隨機抽取2數值陣列位置 Random Crossover*/
    void crossover() {
        squence = new int[mom.length];
        System.out.print("random抽取2數：");
        for (int i = 0; i < 2; i++) {
            squence[i] = (int) (Math.random() * mom.length);
            for (int j = 0; j < i; j++) {
                if (squence[i] == squence[j] && squence[j] == squence[i]) { //隨機2個亂數不重複
                    i -= 1;
                }
                if (squence[i] <= squence[j]) {
                    int temp = squence[i];
                    squence[i] = squence[j];
                    squence[j] = temp;
                    break;
                }
            }
        }
        
        for (int i = 0; i < 2; i++) {
            System.out.print(squence[i]+" ");
        }
    System.out.print("\n");
    }
    
    /*parent() mom與dad取相同基因 common locations*/
    void SameGene() {
        subgenes = new int[mom.length];
        System.out.print("common location：\n");
        for (int i = 0; i < mom.length; i++) {
            if (mom[i] == dad[i]) {
                subgenes[i] = mom[i];     //把值丟進SameGene[]
                System.out.print(subgenes[i] + "\t");
            } else {
                System.out.print(" " + "\t");
            }
        }
    System.out.print("\nsubsequent:"+"\n");
    }
    
    /*subsequent mom*/
    void subsequent() {
        for (int i = squence[0]; i <= squence[1]; i++) {
            subgenes[i] = mom[i];
        }

        for (int j = 0; j < mom.length; j++) {
            if (subgenes[j] == 0) {
                System.out.print(" " + "\t");
            } else {
                System.out.print(subgenes[j] + "\t");
            }
        }
        System.out.print("\nmiss:"+"\n");
    }
    
    /*copy dad other gene*/
    void order() {
        int s = 0;
        for (int j = 0; j < mom.length; j++) {
            for (int i = 0; i < dad.length; i++) {
                if (dad[j] != subgenes[i]) {
                    s++;
                }
            }
            if (s == dad.length) {
                for (int k = 0; k < mom.length; k++) {
                    if (subgenes[k] == 0) {
                        subgenes[k] = dad[j];
                        break;
                    }
                }
            }
            s = 0;
        }
        for (int i = 0; i < mom.length; i++) {
            System.out.print(subgenes[i] + "\t");
        }
   

    
    }
    
    
    public static void main(String[] args) {
        SCF scf = new SCF();
        scf.parent();
        scf.crossover();
        scf.SameGene();
        scf.subsequent();
        scf.order();
    }

}
