package test;

import method.ComplexNumber;
import method.Electricity;
import method.Gas;

import java.util.HashMap;

/**
 * @ClassName Test09
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test09 {
    public static void main(String[] args) {
        HashMap<Double, Double> map1 = new HashMap<>();
        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        ComplexNumber complexNumber1 = new ComplexNumber(0, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);

        for(double i=0;i<=150;i++){
               complexNumber.setReal(i/Math.sqrt(2));
               complexNumber.setImag(i/Math.sqrt(2));
               electricity.setSpowerLoadB(complexNumber);
            double j=0;
            do{
                complexNumber1.setReal(j/Math.sqrt(2));
                complexNumber1.setImag(j/Math.sqrt(2));
                electricity.setSpowerLoadC(complexNumber1);
                electricity.powerSystemsFlowCalculation();
                j++;
                if (j>100){
                    System.out.println("当负荷B的值为"+electricity.getSpowerLoadB()+"时，不存在边界");
                    break;
                }
            }while(electricity.constraintCheck());
            if(!electricity.constraintCheck()){
                    map1.put(i,j);
                   System.out.println("("+electricity.getSpowerLoadB()+"，"+electricity.getSpowerLoadC()+")");
                      System.out.println(i+","+j);
            }
        }



    }
}
