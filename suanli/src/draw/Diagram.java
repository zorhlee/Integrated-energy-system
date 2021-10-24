package draw;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import select.GetBoundaryD;
import select.GetBoundaryForElectricity;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName ElectricityDiagram
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Diagram {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getCellRange("A1").setValue("FlowtoGenerator");
        sheet.getCellRange("B1").setValue("FlowNode1");
        sheet.getCellRange("C1").setValue("FlowNode4");
        sheet.getCellRange("D1").setValue("CompressionRatio");
        sheet.getCellRange("E1").setValue("SpowerLoadB(");
        sheet.getCellRange("F1").setValue("SpowerLoadC");
        int i=2;
        double[][] doubles = GetBoundaryD.calculationLowBoundary();
        for(int k1=0;k1<20000;k1++){
            String b= String.valueOf(doubles[k1][0]);
            sheet.getCellRange("A"+i).setValue(b);
            b= String.valueOf(doubles[k1][1]);
            sheet.getCellRange("B"+i).setValue(b);
            b= String.valueOf(doubles[k1][2]);
            sheet.getCellRange("C"+i).setValue(b);
            b= String.valueOf(doubles[k1][3]);
            sheet.getCellRange("D"+i).setValue(b);
            b= String.valueOf(doubles[k1][4]);
            sheet.getCellRange("E"+i).setValue(b);
            b= String.valueOf(doubles[k1][5]);
            sheet.getCellRange("F"+i).setValue(b);
            i++;
        }

 /*       sheet.getCellRange("A1").setValue("SpowerLoadC");
        int j=2;
        for(Double key :keys){
            String b= String.valueOf(key);
            sheet.getCellRange("A"+j).setValue(b);
            j++;
        }
*/

      /*  sheet.getCellRange("D1").setValue("SpowerLoadB");
        int i1=2;
        HashMap map2= GetBoundaryForElectricity.calculationUpBoundary(map1);
        Set<Double> keys2 = map2.keySet();
        for(Double key :keys2){
            String b= String.valueOf(map2.get(key));
            sheet.getCellRange("D"+i1).setValue(b);
            i1++;
        }
        sheet.getCellRange("C1").setValue("SpowerLoadC");
        int j1=2;
        for(Double key :keys2){
            String b= String.valueOf(key);
            sheet.getCellRange("C"+j1).setValue(b);
            j1++;
        }
*/


        workbook.saveToFile("DiagramLow.xlsx", ExcelVersion.Version2010);
        workbook.dispose();
    }
}
