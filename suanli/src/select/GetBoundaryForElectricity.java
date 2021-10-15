package select;

import method.ComplexNumber;
import method.Electricity;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName GetBoundaryForElectricity
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class GetBoundaryForElectricity {

    public static HashMap<Double,Double> calculationLowBoundary(){

        HashMap<Double, Double> map1 = new HashMap<>();
        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        ComplexNumber complexNumber1 = new ComplexNumber(0, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);

        //给B处燃气发电机设值，最大功率为30MW,给C处压缩机供电赋值，61MW
       ComplexNumber complexNumber2 = new ComplexNumber(50,0);
       electricity.setSpowerLoadG2B(complexNumber2);
        ComplexNumber complexNumber3 = new ComplexNumber(10,0);
        electricity.setSpowerLoadC2compression(complexNumber3);

        for(double i=0;i<=350;i=i+1){
        //    complexNumber.setReal(i/Math.sqrt(2));
        //    complexNumber.setImag(i/Math.sqrt(2));
            complexNumber.setReal(i);
            complexNumber.setImag(0);
            electricity.setSpowerLoadB(complexNumber);
            double j=0;
            do{
             //   complexNumber1.setReal(j/Math.sqrt(2));
           //     complexNumber1.setImag(j/Math.sqrt(2));
               complexNumber1.setReal(j);
                complexNumber1.setImag(0);
                electricity.setSpowerLoadC(complexNumber1);
                electricity.powerSystemsFlowCalculation();
                j=j+1;
                if (j>350){
                    //System.out.println("当负荷B的值为"+electricity.getSpowerLoadB()+"时，不存在边界");
                    break;
                }
            }while(!electricity.constraintCheck());
            if(electricity.constraintCheck()){
                map1.put(i,j);
              //  System.out.println("("+electricity.getSpowerLoadB()+"，"+electricity.getSpowerLoadC()+")");
                //System.out.println(i+","+j);
            }
        }
             return map1;
    }

    public static HashMap<Double,Double> calculationUpBoundary(HashMap map1) {

        HashMap<Double, Double> map2 = new HashMap<>();
        Set<Double> keys = map1.keySet();

        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        ComplexNumber complexNumber1 = new ComplexNumber(0, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);

        //给B处燃气发电机设值，最大功率为30MW,给C处压缩机供电赋值，61MW
        ComplexNumber complexNumber2 = new ComplexNumber(50,0);
        electricity.setSpowerLoadG2B(complexNumber2);
        ComplexNumber complexNumber3 = new ComplexNumber(10,0);
        electricity.setSpowerLoadC2compression(complexNumber3);

        for(Double key : keys){

            complexNumber.setReal(key);
            electricity.setSpowerLoadB(complexNumber);

            double j= (double) map1.get(key);

            do{

                complexNumber1.setReal(j);
                complexNumber1.setImag(0);
                electricity.setSpowerLoadC(complexNumber1);
                electricity.powerSystemsFlowCalculation();
                j=j+1;

                if (j>350){
                    //  System.out.println("("+gas.getFlowNode1()+"，"+300+")");
                    break;
                }

            }while(electricity.constraintCheck());
            if(!electricity.constraintCheck()){
                map2.put(key,j);
                // System.out.println("("+gas.getFlowNode1()+"，"+gas.getFlowNode4()+")");
            }

        }
        return map2;

    }


}
