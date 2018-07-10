package TCXSCF_Crossover;

public class Non_uniformMutation {

    static int[] x1, x2, x3, x4, x5;
    static int[] tau;
    static int G, Gmax;  //Generation
    static double a,r;
    static int b;

    public void setM(int[] x1, int[] x2, int[] x3, int[] x4, int[] x5) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
    }

    public void setParameter(int[] tau, int G, int Gmax,double r, int b) {
        this.tau = tau;
        this.G = G;
        this.Gmax = Gmax;
        this.r = r;
        this.b = b;
    }

    public int[] Mutation() {
        int[] result = new int[5];
        int height,age,weight,years,salary;
        height = (int) (Math.random() * (x1[1] - x1[0] + 1) + x1[0]); 
        age = (int) (Math.random() * (x2[1] - x2[0] + 1) + x2[0]);
        weight = (int) (Math.random() * (x3[1] - x3[0] + 1) + x3[0]);
        years = (int) (Math.random() * (x4[1] - x4[0] + 1) + x4[0]);
        salary = (int) (Math.random() * (x5[1] - x5[0] + 1) + x5[0]);
        
        System.out.println("M : "+height + " " + age + " " + weight + " " + years + " " + salary);
        
        int t;
        t = (int) (Math.random() * tau.length); //隨機產生0和1
        r = Math.random();  //產生0~1亂數
        
        System.out.printf("r : %.1f" , r);
        System.out.println();
        System.out.println("tau : " + tau[t]);
        
        //G-Gmax
        int Gene;
        Gene = (int) (Math.random() * (Gmax-G+1)) + G;
        System.out.println("Gene : " + Gene);
        
        //a
        a = ((double)Gene/(double)Gmax);
        System.out.println("a : " + a);
     
        if (tau[t] == 0) {
                result[0] = (int)(height + ((x1[1]-height)*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[1] = (int)(age + ((x2[1]-age)*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[2] = (int)(weight + ((x3[1]-weight)*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[3] = (int)(years + ((x4[1]-years)*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[4] = (int)(salary + ((x5[1]-salary)*(1-Math.pow(r,(Math.pow((1-a),b))))));
                return result;
        } else {
            
                result[0] = (int)(height + ((height-x1[0])*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[1] = (int)(age + ((age-x2[0])*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[2] = (int)(weight + ((weight-x3[0])*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[3] = (int)(years + ((years-x4[0])*(1-Math.pow(r,(Math.pow((1-a),b))))));
                result[4] = (int)(salary + ((salary-x5[0])*(1-Math.pow(r,(Math.pow((1-a),b))))));
                return result;
        }
    }
    
    public static void main(String[] args) {
        Non_uniformMutation N = new Non_uniformMutation();
        int[] x1 = {50, 250};
        int[] x2 = {20, 150};
        int[] x3 = {35, 150};
        int[] x4 = {5, 30};
        int[] x5 = {10000, 100000};
        int[] tau = {0, 1};
        N.setM(x1, x2, x3, x4, x5);
        N.setParameter(tau, 1, 1000,r,5);
        int[] result = N.Mutation();
        System.out.print("new M : ");
        for(int i = 0 ; i < result.length ; i++)  
            System.out.print(result[i]+" ");
    }

}
