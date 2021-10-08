package method;

/**
 * @ClassName Gas
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Gas {

   private double flowtoGenerator=0;
    private double pressureNode5=0;
    private double pressureNode4=0;
    private double pressureNode3=0;
    private double pressureNode2=0;
    private double pressureNode1=0;
    private double compressionRatio=1;
    private double length1=30*Math.pow(10,3);
    private double length2=30*Math.pow(10,3);
    private double length3=80*Math.pow(10,3);
    private double flowNode1;
    private double flowNode4;
    private double flowNode5;
    private double tolflowNode4;

    public Gas(double flowNode1, double flowNode4) {
        this.flowNode1 = flowNode1;
        this.flowNode4 = flowNode4;
    }

    public void naturalGasFlowCalculation(){

          tolflowNode4=flowtoGenerator+flowNode4;
          flowNode5 =flowNode1+tolflowNode4;

        pressureNode5=5.5*Math.pow(10,6);
        pressureNode4=Math.pow((Math.pow(pressureNode5,2)-Math.pow(flowNode5*Math.pow(length3,0.5)/0.0216,2)),0.5);
        pressureNode3=Math.pow((Math.pow(pressureNode4,2)-Math.pow(flowNode1*Math.pow(length2,0.5)/0.0216,2)),0.5);
        pressureNode2=pressureNode3*compressionRatio;
        pressureNode1=Math.pow((Math.pow(pressureNode2,2)-Math.pow(flowNode1*Math.pow(length1,0.5)/0.0216,2)),0.5);
/*        System.out.println("节点压力5:"+pressureNode5);
        System.out.println("节点压力4:"+pressureNode4);
        System.out.println("节点压力3:"+pressureNode3);
        System.out.println("节点压力2:"+pressureNode2);
        System.out.println("节点压力1:"+pressureNode1);
        System.out.println("节点5流量:"+flowNode5);
        System.out.println("节点4流量:"+flowNode4);
        System.out.println("节点1流量:"+flowNode1);*/
    }
    public boolean constraintCheck(){
        Boolean flag=true;
        if(pressureNode5>5.5*Math.pow(10,6)&&pressureNode5<5*Math.pow(10,6)){
            flag=false;
         //  System.out.println("节点5压力不满足约束");
        }
        if(pressureNode1>5*Math.pow(10,6)&&pressureNode1<3*Math.pow(10,6)){
            flag=false;
        //    System.out.println("节点1压力不满足约束");
        }
        if(pressureNode4>5*Math.pow(10,6)&&pressureNode4<3*Math.pow(10,6)){
            flag=false;
         //  System.out.println("节点4压力不满足约束");
        }
        if(flowNode1>300){
            flag=false;
         //   System.out.println("节点1流量不满足约束");
        }
        if(tolflowNode4>300){
            flag=false;
          //    System.out.println("节点4流量不满足约束");
        }
        if((Math.pow(pressureNode5,2)-Math.pow(flowNode5*Math.pow(length3,0.5)/0.0216,2))<0||(Math.pow(pressureNode4,2)-Math.pow(flowNode1*Math.pow(length2,0.5)/0.0216,2))<0 ||(Math.pow(pressureNode2,2)-Math.pow(flowNode1*Math.pow(length1,0.5)/0.0216,2)<0)){
            flag=false;
         //   System.out.println("无实数解");
        }

          return flag;
    }

    public double getFlowtoGenerator() {
        return flowtoGenerator;
    }

    public void setFlowtoGenerator(double flowtoGenerator) {
        this.flowtoGenerator = flowtoGenerator;
    }

    public double getPressureNode5() {
        return pressureNode5;
    }

    public void setPressureNode5(double pressureNode5) {
        this.pressureNode5 = pressureNode5;
    }

    public double getPressureNode4() {
        return pressureNode4;
    }

    public void setPressureNode4(double pressureNode4) {
        this.pressureNode4 = pressureNode4;
    }

    public double getPressureNode3() {
        return pressureNode3;
    }

    public void setPressureNode3(double pressureNode3) {
        this.pressureNode3 = pressureNode3;
    }

    public double getPressureNode2() {
        return pressureNode2;
    }

    public void setPressureNode2(double pressureNode2) {
        this.pressureNode2 = pressureNode2;
    }

    public double getPressureNode1() {
        return pressureNode1;
    }

    public void setPressureNode1(double pressureNode1) {
        this.pressureNode1 = pressureNode1;
    }

    public double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public double getLength1() {
        return length1;
    }

    public void setLength1(double length1) {
        this.length1 = length1;
    }

    public double getLength2() {
        return length2;
    }

    public void setLength2(double length2) {
        this.length2 = length2;
    }

    public double getLength3() {
        return length3;
    }

    public void setLength3(double length3) {
        this.length3 = length3;
    }

    public double getFlowNode1() {
        return flowNode1;
    }

    public void setFlowNode1(double flowNode1) {
        this.flowNode1 = flowNode1;
    }

    public double getFlowNode4() {
        return flowNode4;
    }

    public void setFlowNode4(double flowNode4) {
        this.flowNode4 = flowNode4;
    }

    public double getFlowNode5() {
        return flowNode5;
    }

    public void setFlowNode5(double flowNode5) {
        this.flowNode5 = flowNode5;
    }

    public double getTolflowNode4() {
        return tolflowNode4;
    }

    public void setTolflowNode4(double tolflowNode4) {
        this.tolflowNode4 = tolflowNode4;
    }
}
