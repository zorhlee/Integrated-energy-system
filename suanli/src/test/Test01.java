package test;

import method.Gas;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        Gas gas = new Gas(76,237);
        gas.naturalGasFlowCalculation();
        System.out.println(gas.getFlowNode5());
    }
}
