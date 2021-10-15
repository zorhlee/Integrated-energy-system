package draw;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import select.GetBoundary;
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
public class ElectricityDiagram {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getCellRange("B1").setValue("SpowerLoadB");
        int i=2;
        HashMap map1= GetBoundaryForElectricity.calculationLowBoundary();
        Set<Double> keys = map1.keySet();
        for(Double key :keys){
            String b= String.valueOf(map1.get(key));
            sheet.getCellRange("B"+i).setValue(b);
            i++;
        }
        sheet.getCellRange("A1").setValue("SpowerLoadC");
        int j=2;
        for(Double key :keys){
            String b= String.valueOf(key);
            sheet.getCellRange("A"+j).setValue(b);
            j++;
        }

        sheet.getCellRange("D1").setValue("SpowerLoadB");
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



        workbook.saveToFile("ElectricityDiagram-test02.xlsx", ExcelVersion.Version2010);
        workbook.dispose();
    }
}
