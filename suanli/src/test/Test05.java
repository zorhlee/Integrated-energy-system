package test;


import method.Gas;

import java.util.HashMap;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test05 {
    public static void main(String[] args) {
        HashMap<Double, Double> map1 = new HashMap<>();
        Gas gas =new Gas(0,0);
       //gas.setCompressionRatio(1.5);

           for(double i=0;i<=300;i++){
                  gas.setFlowNode1(i);
                 double j=50;
                 do{
                     gas.setFlowNode4(j);
                     gas.naturalGasFlowCalculation();
                     j++;
                     if (j>300){
                         System.out.println("当节点1的值为"+gas.getFlowNode1()+"时，不存在边界");
                         break;
                     }
                 }while(!gas.constraintCheck());
                 if(gas.constraintCheck()){
                       map1.put(gas.getFlowNode1(),gas.getFlowNode4());
                     System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");}

           }


    }
}
