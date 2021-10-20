package select;

public class Test {

    public static void main(String[] args) {

        double[][] doubles = GetBoundaryD.calculationLowBoundary();
        for( double[] i :doubles){
            for (double j :i)
            {
                System.out.println(j);
            }
        }
    }
}
