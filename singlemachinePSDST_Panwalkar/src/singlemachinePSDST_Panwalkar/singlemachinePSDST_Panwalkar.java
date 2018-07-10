package singlemachinePSDST_Panwalkar;

public class singlemachinePSDST_Panwalkar {

    int r;
    double b;
    int n;
    int t[];
    int p[];
    double Gamma[];

    public void setParameter(int r, double b, int t[], int p[]) {
        this.r = r; //middle number jobs
        this.b = b;
        this.n = t.length; //jobs
        this.t = t; //processing time
        this.p = p; //penalties
    }

    public void math() {
        double equation1, equation2, equation3;
        Gamma = new double[n];
        for (int i = 1; i <= 7; i++) {
            if (i == 1) {       //1
                Gamma[0] = n * p[0];
            } else if (2 <= i && i <= r) {     //2-4
                equation1 = 0;
                for (int l = i + 1; l <= r; l++) {
                    equation1 += (l - 1);
                }
                equation2 = 0;
                for (int k = r + 1; k <= n; k++) {
                    equation2 += (n + 1 - k);
                }
                Gamma[i - 1] = n * p[0] + ((i - 1) + b * (equation1 + equation2)) * p[1];
            } else {      //5-7
                equation3 = 0;
                for (int l = i + 1; l <= n; l++) {
                    equation3 += (n + 1 - l);
                }
                Gamma[i - 1] = ((n + 1 - i) + b * (equation3)) * p[2];
            }
            System.out.println(Math.rint(Gamma[i - 1] * 100) / 100);
        }
    }

    public static void main(String[] args) {
        int t[] = new int[]{3, 4, 6, 9, 14, 18, 20};
        int p[] = new int[]{5, 11, 18};
        singlemachinePSDST_Panwalkar m = new singlemachinePSDST_Panwalkar();
        m.setParameter(4, 0.05, t, p);
        m.math();
    }

}
