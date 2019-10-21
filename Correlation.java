public class Correlation {
    public static double cortest(double[]x,double[]y){
        Statistics xstat=new Statistics(x);
        Statistics ystat=new Statistics(y);
        double stdx=xstat.getStdDev();
        double stdy=ystat.getStdDev();
        if(x.length!=y.length)throw new IllegalArgumentException("X and Y must have same length.");
        int n=x.length;
        double meanx=xstat.getMean();
        double meany=ystat.getMean();
        double xyproduct=0;
        for(int i=0;i<x.length;i++){
           double iteration= (x[i]-meanx)*(y[i]-meany);
           xyproduct+=iteration;
        }
        double correlation=xyproduct/(stdx*stdy)/(n-1);
        return correlation;
    }