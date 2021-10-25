package test;

import method.ComplexNumber;
import method.Electricity;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test03 {
    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumber(0,0);
        ComplexNumber complexNumber1 = new ComplexNumber(500, 0);
        Electricity electricity = new Electricity(complexNumber,complexNumber1);
        ComplexNumber complexNumber2 = new ComplexNumber(30000,0);
        electricity.setSpowerLoadG2B(complexNumber2);
        electricity.powerSystemsFlowCalculation();
        System.out.println(electricity.constraintCheck());
    }
}
