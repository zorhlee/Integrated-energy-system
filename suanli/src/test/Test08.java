package test;

import com.spire.xls.*;
import com.spire.xls.core.IChartTrendLine;
import com.spire.xls.core.spreadsheet.XlsWorksheet;
import select.GetBoundary;

import java.util.HashMap;
import java.util.Set;


/**
 * @ClassName Test08
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Test08 {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);
        //设置列宽,工作表名
        sheet.getCellRange("A1:B1").setColumnWidth(15f);
        sheet.setName("散点图");


        sheet.getCellRange("A1").setValue("flowNode4");
        int i=2;
        HashMap map1= GetBoundary.calculationLowBoundary();
        Set<Double> keys = map1.keySet();
        for(Double key :keys){
            String b= String.valueOf(map1.get(key));
             sheet.getCellRange("A"+i).setValue(b);
             i++;
        }
        sheet.getCellRange("B1").setValue("flowNode1");
           int j=2;
        for(Double key :keys){
            String b= String.valueOf(key);
            sheet.getCellRange("B"+j).setValue(b);
            j++;
        }
//创建散点图
        Chart chart = sheet.getCharts().add(ExcelChartType.ScatterMarkers);
        chart.setDataRange(sheet.getCellRange("B2:B"+j));
        chart.setSeriesDataFromRange(false);
//指定散点图在sheet中的位置
        chart.setLeftColumn(4);
        chart.setTopRow(1);
        chart.setRightColumn(15);
        chart.setBottomRow(25);
//添加图表标题、系列标签
        chart.setChartTitle("运行域二维视图");
        chart.getChartTitleArea().isBold(true);;
        chart.getChartTitleArea().setSize(12);
        chart.getSeries().get(0).setCategoryLabels(sheet.getCellRange("B2:B"+j));
        chart.getSeries().get(0).setValues(sheet.getCellRange("A2:A"+i));
        sheet.getCellRange("A1:B"+j).getStyle().setHorizontalAlignment(HorizontalAlignType.Center);
        sheet.getCellRange("A1:B1").getStyle().getFont().isBold(true);

        //添加趋势线
        IChartTrendLine trendLine = chart.getSeries().get(0).getTrendLines().add(TrendLineType.Exponential);
        trendLine.setName("趋势线");

        //添加坐标轴名称
        chart.getPrimaryValueAxis().setTitle("flowNode4");
        chart.getPrimaryCategoryAxis().setTitle("flowNode1");

        workbook.saveToFile("ScatterChart.xlsx",ExcelVersion.Version2010);
        workbook.dispose();

    }


}
