
package equation;

public class Equation2 {

    int r;
    double b;
    int n;
    int t[];
    int p[];
    double Gamma[];
    
    public void setParameter(int r, double b, int t[],int p[]) {
        this.r = r; //middle number jobs
        this.b = b;
        this.n = t.length; //jobs
        this.t = t; //processing time
        this.p = p;
    }
    
    public void math() {
    double equation1, equation2, equation3;
    double G;//[] = new double[n];
    Gamma = new double[n]; 
    for (int i = 1; i <= 7; i++) {
            if (1 <= i && i <= r) {     //條件
                equation1 = 0;
                for (int l = i + 1; l <= r; l++) {
                    equation1 += (l - 1);
                }
                equation2 = 0;
                for (int k = r + 1; k <= n; k++) {
                    equation2 += (n + 1 - k);
                }
                G = (i - 1) + b * (equation1 + equation2);
                Gamma[i - 1] = n * p[0] +G *p[1];
                 
            } 
//                else {
//                equation3 = 0;
//                for (int l = i + 1; l <= n; l++) {
//                    equation3 += (n + 1 - l);
//                }
//                Gamma[i - 1] = (n + 1 - i) + b * (equation3);             
//            }
            System.out.println(Math.rint(Gamma[i - 1] * 100) / 100);
        }
        
    }
    
    public static void main(String[] args) {
    int t[] = new int[]{3, 4, 6, 9, 14, 18, 20};
    int p[] = new int[]{5,11,18};
    Equation2 m = new Equation2();
    m.setParameter(4, 0.05, t ,p);
    m.math();    
    }
    
}
