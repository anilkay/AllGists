import java.util.Arrays;
import java.util.OptionalDouble;

public class Normalization {
    public static double[] minmax(double[]f1,double newmin,double newmax){
        return getminmax(f1, newmin, newmax);
    }
    public static double[] minmax(double[]f1){
        double newmin=0;
        double newmax=1;
        return getminmax(f1, newmin, newmax);
    }

    private static double[] getminmax(double[] f1, double newmin, double newmax) {
        double[] normalized=new double[f1.length];
        double oldmin=getMin(f1);
        double oldmax=getMax(f1);
        for(int i=0;i<f1.length;i++){
            double v=f1[i];
            normalized[i]=(v-oldmin)/(oldmax-oldmin)*(newmax-newmin)+newmin;
        }
        return normalized;
    }

    private static double getMax(double[] array){
        OptionalDouble max=Arrays.stream(array).max();
      return  max.getAsDouble();
    }
    private static double getMin(double[] array){
        OptionalDouble min=Arrays.stream(array).min();
        return  min.getAsDouble();
    }
}
