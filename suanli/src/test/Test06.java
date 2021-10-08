package test;

import method.Gas;

/**
 * @ClassName Test06
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test06 {
    public static void main(String[] args) {
        Gas gas =new Gas(0,0);
        gas.naturalGasFlowCalculation();
        System.out.println(gas.constraintCheck());
    }
}
