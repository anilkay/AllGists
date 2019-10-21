import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KNN {
    final int defaultK=1;
    final int howManyClass=10;
    List<String[]> xall;
    String[]yall;
    int k;
    public KNN(String[] yall, List<String[]> xall) {
        this.yall = yall;
        this.xall = xall;
        k=defaultK;
    }

    public KNN(String[] yall, List<String[]> xall, int k) {
        this.yall = yall;
        this.xall = xall;
        this.k = k;
    }
    public int predict(final String[]instance){
        //First Compete Distance Between our instance and all instances.
        final List<DistancewithClass> distancewithClasses=new ArrayList<>();
        final String[] yallfinal = yall;
        final int[]index=new int[1];
        index[0]=0;
        xall.forEach(x->{
            double distance=0;
            for(int i=0;i<x.length;i++){
               //Use Manhattan Distance
               double dist= Math.abs(Double.parseDouble(x[i]) - Double.parseDouble(instance[i]));
               distance+=dist;
            }
            distancewithClasses.add(new DistancewithClass(distance,Integer.parseInt(yallfinal[index[0]++])));
        });
      
        
        distancewithClasses.sort(new Comparator<DistancewithClass>() {
            @Override
            public int compare(DistancewithClass o1, DistancewithClass o2) {
                if(o1.distance==o2.distance)return 0;
                else if(o1.distance>o2.distance)return 1;
                else return -1;
            }
        });
        
        int []count=new int[howManyClass];
        for(int i=0;i<k;i++){
           int clas= distancewithClasses.get(i).classof;
           count[clas]++;
        }
        int maxindex=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>count[maxindex]){
                maxindex=i;
            }
        }
        System.out.println("Prediction: "+maxindex);
        return maxindex;
    }

}
class DistancewithClass {
    double distance;
    int classof;

    public DistancewithClass(double distance, int classof) {
        this.distance = distance;
        this.classof = classof;
    }
}
