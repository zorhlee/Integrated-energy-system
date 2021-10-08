package test;

import select.GetBoundary;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Test07
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test07 {
    public static void main(String[] args) {

        HashMap map = GetBoundary.calculationLowBoundary();
        HashMap map1 =GetBoundary.calculationUpBoundary(map);
        Set<Double> keys = map1.keySet();
        for(Double key :keys){
            System.out.println(key+","+map1.get(key));
        }
    }
}
