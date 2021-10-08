package test;

import method.Gas;

/**
 * @ClassName Test10
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test10 {
    public static void main(String[] args) {
        Gas gas =new Gas(219,0);
        gas.naturalGasFlowCalculation();
        System.out.println(gas.constraintCheck());
    }
}
