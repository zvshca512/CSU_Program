package equation;

public class Equation {

    int r;
    double b;
    int n;
    int p[];
    double Gamma[];

    public void setParameter(int r, double b, int p[]) {
        this.r = r; //middle number jobs
        this.b = b;
        this.n = p.length; //jobs
        this.p = p; //processing time
    }

    public void math() {
        double Equation1, Equation2, Equation3;
        Gamma = new double[n];
        for (int i = 1; i <= 7; i++) {
            if (1 <= i && i <= r) {
                Equation1 = 0;
                for (int l = i + 1; l <= r; l++) {
                    Equation1 += (l - 1);
                }
                Equation2 = 0;
                for (int k = r + 1; k <= n; k++) {
                    Equation2 += (n + 1 - k);
                }
                Gamma[i - 1] = (i - 1) + b * (Equation1 + Equation2);
            } else {
                Equation3 = 0;
                for (int l = i + 1; l <= n; l++) {
                    Equation3 += (n + 1 - l);
                }
                Gamma[i - 1] = (n + 1 - i) + b * (Equation3);             
            }
            System.out.println(Math.rint(Gamma[i - 1] * 100) / 100);
        }
    }

    public static void main(String[] args) {
        int p[] = new int[]{1, 3, 6, 8, 11, 15, 21};
        Equation m = new Equation();
        m.setParameter(4, 0.05, p);
        m.math();
    }

}
