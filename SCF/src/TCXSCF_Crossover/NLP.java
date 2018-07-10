
package TCXSCF_Crossover;


public class NLP {
    
    double d[];
    double h[];
    double PI;
    double c;
    double f;
    double o[];
    
    
    public void setParameter(double d[],double h[],double PI,double c){
    this.d = d;
    this.h = h;
    this.PI = PI;
    this.c = c;
    }
    
    /*變數*/
    void Variable(){
    for (int i = 0; i < d.length; i++) {
        for(int j = 0 ; j < h.length ; j++){
        d[i] = (double) (Math.random() * d.length + 1);   
        h[j] = (double) (Math.random() * h.length + 1);  
        }
    }
    for (int i = 0; i < d.length; i++) {  
    System.out.printf("%.1f\t",d[i]);   
    }System.out.printf("\n");
    for(int j = 0 ; j < h.length ; j++){
    System.out.printf("%.1f\t",h[j] );     
    }System.out.printf("\n");
    }
    
    void function(){
    f = 0;
    for (int i = 0; i < d.length; i++) {
        for(int j = 0 ; j < h.length ; j++){
        f = c*((PI* Math.pow(d[i],2)/2)+(PI*d[i]*h[j]));    
        System.out.printf("");
        System.out.printf("%.1f\n",f);
        }
     
    }
    
    }
    
    public static void main(String[] args) {
    NLP N = new NLP();
    double d[] = new double[5];
    double h[] = new double[10];
    N.setParameter(d,h,3.14,1.5);
    N.Variable();
    N.function();
    }
    
}
