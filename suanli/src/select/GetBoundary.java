package select;

import method.Gas;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Draw
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class GetBoundary {
    public static HashMap calculationLowBoundary(){
        HashMap<Double, Double> map1 = new HashMap<>();
                Gas gas =new Gas(0,0);

                //给压缩机压缩比设值为1.5，给负荷4流量设值为6.96
                gas.setCompressionRatio(1.4);
                gas.setFlowtoGenerator(0);

                for(double i=0;i<=50;i+=0.05){
                    gas.setFlowNode1(i);
                    double j=0;
                    do{
                        gas.setFlowNode4(j);
                        gas.naturalGasFlowCalculation();
                j+=0.05;
                if (j>50){
                   // System.out.println("当节点1的值为"+gas.getFlowNode1()+"时，不存在边界");
                    break;
                }
            }while(!gas.constraintCheck());
            if(gas.constraintCheck()){
                map1.put(gas.getFlowNode1(),gas.getFlowNode4());
             //   System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");
                }
        }
        return map1;
    }
    public static HashMap calculationUpBoundary(HashMap map1){
        HashMap map2=new HashMap<Double, Double>();
        Set<Double> keys = map1.keySet();
        Gas gas =new Gas(0,0);

        //给压缩机压缩比设值为1.5，给负荷4流量设值为6.96
        gas.setCompressionRatio(1.4);
        gas.setFlowtoGenerator(0);

        for(Double key : keys){
            gas.setFlowNode1(key);
            double j= (double) map1.get(key);
            do{
                gas.setFlowNode4(j);
                gas.naturalGasFlowCalculation();
                j+=0.05;
                if (j>50){
                    map2.put(gas.getFlowNode1(),50);
                  //  System.out.println("("+gas.getFlowNode1()+"，"+300+")");
                    break;
                }
            }while(gas.constraintCheck());
            if(!gas.constraintCheck()){
                map2.put(gas.getFlowNode1(),gas.getFlowNode4());
               // System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");
                 }

        }
        return map2;
    }

}
