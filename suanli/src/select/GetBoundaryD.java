package select;

import method.ComplexNumber;
import method.Electricity;
import method.Gas;

import java.util.HashMap;
import java.util.Set;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class GetBoundaryD {
    public static double[][] calculationLowBoundary(){
        double[][] array = new double[100000][6];

        Gas gas =new Gas(0,0);
        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        ComplexNumber complexNumber1 = new ComplexNumber(0, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);
        int k=0;
        for(double j2=0;j2<75;j2=j2+7.5) {
            complexNumber1.setReal(j2 * 0.9);
            complexNumber1.setImag(j2 * 0.43);
            electricity.setSpowerLoadC(complexNumber1);

            for (double j1 = 0; j1 < 75; j1 = j1 + 7.5) {
                //    complexNumber.setReal(i/Math.sqrt(2));
                //    complexNumber.setImag(i/Math.sqrt(2));
                complexNumber.setReal(j1 * 0.9);
                complexNumber.setImag(j1 * 0.43);
                electricity.setSpowerLoadB(complexNumber);
                for (double i2 = 1; i2 < 2; i2 += 0.1) {
                    gas.setCompressionRatio(i2);

                    ComplexNumber complexNumber3 = new ComplexNumber((Math.pow(i2,0.236)-1)*24.09,0);
                    electricity.setSpowerLoadC2compression(complexNumber3);

                    for (double i1 = 0; i1 <10; i1 +=1) {

                        gas.setFlowNode4(i1);

                        for (double i = 0; i < 10; i += 1) {
                            gas.setFlowNode1(i);
                            double j = 0;
                            do {

                                gas.setFlowtoGenerator(j);

                                ComplexNumber complexNumber2 = new ComplexNumber(4.3*j,0);
                                electricity.setSpowerLoadG2B(complexNumber2);

                                gas.naturalGasFlowCalculation();
                                electricity.powerSystemsFlowCalculation();
                                j +=1;
                                if (j >i1) {
                                    // System.out.println("当节点1的值为"+gas.getFlowNode1()+"时，不存在边界");
                                    break;
                                }
                            } while ((!gas.constraintCheck())||(!electricity.constraintCheck()));

                            if (gas.constraintCheck()&& electricity.constraintCheck()) {
                                array[k][0]=j;
                                array[k][1]=i;
                                array[k][2]=i1;
                                array[k][3]=(Math.pow(i2,0.236)-1)*24.09;
                                array[k][4]=j1;
                                array[k][5]=j2;
                                k++;

                            }
                        }
                    }
                }
            }
        }
        return array;
    }
    public static double[][] calculationUpBoundary(){
        double[][] array = new double[10000000][6];

        Gas gas =new Gas(0,0);
        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        ComplexNumber complexNumber1 = new ComplexNumber(0, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);
        int k=0;
        for(double j2=75;j2>0;j2=j2-5) {
            complexNumber1.setReal(j2 * 0.9);
            complexNumber1.setImag(j2 * 0.43);
            electricity.setSpowerLoadC(complexNumber1);

            for (double j1=75; j1 >0; j1 = j1 - 5) {
                //    complexNumber.setReal(i/Math.sqrt(2));
                //    complexNumber.setImag(i/Math.sqrt(2));
                complexNumber.setReal(j1 * 0.9);
                complexNumber.setImag(j1 * 0.43);
                electricity.setSpowerLoadB(complexNumber);
                for (double i2 = 2; i2 > 1; i2 -= 0.1) {
                    gas.setCompressionRatio(i2);

                    ComplexNumber complexNumber3 = new ComplexNumber((Math.pow(i2,0.236)-1)*24.09,0);
                    electricity.setSpowerLoadC2compression(complexNumber3);

                    for (double i1 = 10; i1 > 0; i1 -=1) {
                        gas.setFlowNode4(i1);



                        for (double i = 10; i > 0; i -= 1) {
                            gas.setFlowNode1(i);
                            double j =i1;
                            do {

                                gas.setFlowtoGenerator(j);

                                ComplexNumber complexNumber2 = new ComplexNumber(4.3*j,0);
                                electricity.setSpowerLoadG2B(complexNumber2);


                                gas.naturalGasFlowCalculation();
                                electricity.powerSystemsFlowCalculation();
                                j -=1;
                                if (j <=0) {
                                    // System.out.println("当节点1的值为"+gas.getFlowNode1()+"时，不存在边界");
                                    break;
                                }
                            } while ((!gas.constraintCheck())||(!electricity.constraintCheck()));
                            if (gas.constraintCheck()&& electricity.constraintCheck()) {
                                array[k][0]=j;
                                array[k][1]=i;
                                array[k][2]=i1;
                                array[k][3]=(Math.pow(i2,0.236)-1)*24.09;
                                array[k][4]=j1;
                                array[k][5]=j2;
                                k++;
                            }
                        }
                    }
                }
            }
        }
        return array;
    }



/*    public static HashMap calculationUpBoundary(HashMap map1){
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
    }*/
}