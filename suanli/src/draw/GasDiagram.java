package draw;

import com.spire.xls.*;
import com.spire.xls.core.IChartTrendLine;
import select.GetBoundary;
import select.GetBoundaryForGas;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName GasDiagram
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class GasDiagram {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);


        sheet.getCellRange("B1").setValue("flowNode4");
        int i=2;
        HashMap map1= GetBoundaryForGas.calculationBoundary();
        Set<Double> keys = map1.keySet();
        for(Double key :keys){
            String b= String.valueOf(map1.get(key));
            sheet.getCellRange("B"+i).setValue(b);
            i++;
        }
        sheet.getCellRange("A1").setValue("flowNode1");
        int j=2;
        for(Double key :keys){
            String b= String.valueOf(key);
            sheet.getCellRange("A"+j).setValue(b);
            j++;
        }

/*
        sheet.getCellRange("D1").setValue("flowNode4");
        int i1=2;
        HashMap map2= GetBoundary.calculationUpBoundary(map1);
        Set<Double> keys2 = map2.keySet();
        for(Double key :keys2){
            String b= String.valueOf(map2.get(key));
            sheet.getCellRange("D"+i1).setValue(b);
            i1++;
        }
        sheet.getCellRange("C1").setValue("flowNode1");
        int j1=2;
        for(Double key :keys2){
            String b= String.valueOf(key);
            sheet.getCellRange("C"+j1).setValue(b);
            j1++;
        }*/

        workbook.saveToFile("GasDiagram-test.xlsx",ExcelVersion.Version2010);
        workbook.dispose();
    }
}
