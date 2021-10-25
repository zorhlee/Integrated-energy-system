package select;

import method.Gas;

import java.util.HashMap;

/**
 * @ClassName GetBoundaryForGas
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class GetBoundaryForGas {
    public static HashMap<Double,Double> calculationBoundary(){
        HashMap<Double, Double> map1 = new HashMap<>();
        Gas gas =new Gas(0,0);

        //给压缩机压缩比设值为1.5，给负荷4流量设值为6.96
        gas.setCompressionRatio(2);
        gas.setFlowtoGenerator(0);

        for(double i=0;i<=300;i++){
            gas.setFlowNode1(i);
            double j=0;
            do{
                gas.setFlowNode4(j);
                gas.naturalGasFlowCalculation();
                j++;
                if (j>300){
                    // System.out.println("当节点1的值为"+gas.getFlowNode1()+"时，不存在边界");
                    break;
                }
            }while(gas.constraintCheck());
            if(!gas.constraintCheck()&&j!=1){
                map1.put(gas.getFlowNode1(),gas.getFlowNode4());
                //   System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");
            }
        }
        return map1;
    }
}
