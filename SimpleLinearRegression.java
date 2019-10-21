public class SimpleLinearRegression  {
    double[] x;
    double[]y; //Simple Linear Regression and because of these only use 1 variable each time.
    private boolean isfit;
    private  double a;
    private double b;

    public SimpleLinearRegression(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public boolean fit() {
        isfit=true;
        double xsquare=squaresum(x);
        double ysum=sum(y);
        double xsum=sum(x);
        double sumxy=summultiple(x,y);
        double n=x.length;
        a=((ysum*xsquare)-(xsum*sumxy))/(n*xsquare-xsum*xsum);
        b=(n*sumxy-xsum*ysum)/(n*xsquare-xsum*xsum);
        //System.out.println("a: "+a);
        //System.out.println("b: "+b);
        return true;
    }


    public int pred(double x) throws IllegalAccessException {
        if(!isfit)throw new IllegalAccessException("Can't Fit with data");
        double y=a*x+b;
        long yint=Math.round(y);
        return (int)yint;
    }
    private double squaresum(double[]i){
        double isquare=0;
        for(double one:i){
            isquare+=one*one;
        }
        return isquare;
    }
    private double sum(double[]i){
        double sum=0;
        for(double one:i){
            sum+=one;
        }
        return sum;
    }
    private double summultiple(double[]a,double[]b){
        double sum=0;
        for(int i=0;i<a.length;i++){
            sum+=(a[i]*b[i]);
        }
        return sum;
    }
}