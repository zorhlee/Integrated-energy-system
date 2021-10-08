package test;

import method.Gas;
import select.GetBoundary;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test04 {
    public static void main(String[] args) {
      HashMap map= GetBoundary.calculationLowBoundary();
      HashMap map2=new HashMap<Double, Double>();
        Set<Double> keys = map.keySet();
        Gas gas =new Gas(0,0);
        for(Double key : keys){
            gas.setFlowNode1(key);
            double j= (double) map.get(key);
            do{
                gas.setFlowNode4(j);
                gas.naturalGasFlowCalculation();
                j++;
                if (j>300){
                    map2.put(gas.getFlowNode1(),300);
                    System.out.println("("+gas.getFlowNode1()+"，"+300+")");
                    break;
                }
            }while(gas.constraintCheck());
            if(!gas.constraintCheck()){
                map2.put(gas.getFlowNode1(),gas.getFlowNode4());
                System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");}

        }

        }


}
