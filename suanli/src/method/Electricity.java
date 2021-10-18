package method;





/**
 * @ClassName Electricity
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class Electricity {
    private ComplexNumber SpowerLoadB;
    private ComplexNumber SpowerLoadG2B=new ComplexNumber(0,0);
    private ComplexNumber SpowerLoadBtol=new ComplexNumber(0,0);
    private ComplexNumber SpowerLoadC;
    private ComplexNumber SpowerLoadC2compression=new ComplexNumber(0,0);
    private ComplexNumber SpowerLoadCtol;
    private ComplexNumber SpowerGeneratorA=new ComplexNumber(0,0);
    private ComplexNumber SpowerGeneratorA1=new ComplexNumber(0,0);
    private ComplexNumber SpowerGeneratorA2=new ComplexNumber(0,0);
    private ComplexNumber SpowerA2B=new ComplexNumber(0,0);
    private ComplexNumber SpowerA2C=new ComplexNumber(0,0);
    private ComplexNumber SpowerC2B=new ComplexNumber(0,0);

    private double voltageA=110;
    private double voltageB=110;
    private double voltageB1=110;
    private double voltageC=110;


    public Electricity(ComplexNumber spowerLoadB, ComplexNumber spowerLoadC) {
        SpowerLoadB = spowerLoadB;
        SpowerLoadC = spowerLoadC;
    }

    public void powerSystemsFlowCalculation(){

        SpowerLoadBtol.setReal((SpowerLoadB.getReal()>SpowerLoadG2B.getReal())?(SpowerLoadB.getReal()-SpowerLoadG2B.getReal()):0);
        SpowerLoadBtol.setImag(SpowerLoadB.getImag());
        SpowerLoadCtol=new ComplexNumber(SpowerLoadC.getReal()+SpowerLoadC2compression.getReal(),SpowerLoadC.getImag());
        ComplexNumber SpowerLoadBtol2 =new ComplexNumber(SpowerLoadBtol.getReal(),SpowerLoadB.getImag()-1.123);
        ComplexNumber SpowerLoadCtol2 =new ComplexNumber(SpowerLoadCtol.getReal(),SpowerLoadC.getImag()-0.964);

        SpowerA2B.setReal((SpowerLoadBtol2.getReal()*60+SpowerLoadCtol2.getReal()*30)/100);
        SpowerA2B.setImag((SpowerLoadBtol2.getImag()*60+SpowerLoadCtol2.getImag()*30)/100);
        SpowerA2C.setReal((SpowerLoadBtol2.getReal()*40+SpowerLoadCtol2.getReal()*70)/100);
        SpowerA2C.setImag((SpowerLoadBtol2.getImag()*40+SpowerLoadCtol2.getImag()*70)/100);
        SpowerC2B.setReal(SpowerLoadBtol2.getReal()-SpowerA2B.getReal());
        SpowerC2B.setImag(SpowerLoadBtol2.getImag()-SpowerA2B.getImag());



            ComplexNumber DiffSpowerA2B =new ComplexNumber( (Math.pow(SpowerA2B.getReal(),2)+Math.pow(SpowerA2B.getImag(),2))*13.2/Math.pow(voltageB,2),(Math.pow(SpowerA2B.getReal(),2)+Math.pow(SpowerA2B.getImag(),2))*17.16/Math.pow(voltageB,2));
            SpowerGeneratorA1.setReal(SpowerA2B.getReal()+ DiffSpowerA2B.getReal());
            SpowerGeneratorA1.setImag(SpowerA2B.getImag()+ DiffSpowerA2B.getImag());
            ComplexNumber DiffVoltageA2B =new ComplexNumber((SpowerGeneratorA1.getReal()*13.2+SpowerGeneratorA1.getImag()*17.16)/voltageA, (SpowerGeneratorA1.getReal()*17.16-SpowerGeneratorA1.getImag()*13.2)/voltageA);
            voltageB=Math.pow(Math.pow((voltageA-DiffVoltageA2B.getReal()),2)+ Math.pow(DiffVoltageA2B.getImag(),2),0.5);

            SpowerGeneratorA1.setImag(SpowerGeneratorA1.getImag()-0.641);


              ComplexNumber DiffSpowerB2C = new ComplexNumber((Math.pow(SpowerC2B.getReal(), 2) + Math.pow(SpowerC2B.getImag(), 2)) * 9.9 / Math.pow(voltageB1, 2), (Math.pow(SpowerC2B.getReal(), 2) + Math.pow(SpowerC2B.getImag(), 2)) * 12.87 / Math.pow(voltageB1, 2));
              ComplexNumber SpowerC01 = new ComplexNumber(SpowerC2B.getReal() + DiffSpowerB2C.getReal(), SpowerC2B.getImag() + DiffSpowerB2C.getImag());

              SpowerA2C.setReal(SpowerC01.getReal() + SpowerLoadCtol2.getReal());
              SpowerA2C.setImag(SpowerC01.getImag() + SpowerLoadCtol2.getImag());

             // System.out.println(SpowerA2C);
              ComplexNumber DiffSpowerC2A = new ComplexNumber((Math.pow(SpowerA2C.getReal(), 2) + Math.pow(SpowerA2C.getImag(), 2)) * 9.9 / Math.pow(voltageB1, 2), (Math.pow(SpowerA2C.getReal(), 2) + Math.pow(SpowerA2C.getImag(), 2)) * 12.87 / Math.pow(voltageB1, 2));
              SpowerGeneratorA2.setReal(SpowerA2C.getReal() + DiffSpowerC2A.getReal());
              SpowerGeneratorA2.setImag(SpowerA2C.getImag() + DiffSpowerC2A.getImag());

              ComplexNumber DiffVoltageA2C = new ComplexNumber((SpowerGeneratorA2.getReal() * 9.9 + SpowerGeneratorA2.getImag() * 12.87) / voltageA, (SpowerGeneratorA2.getReal() * 12.87 - SpowerGeneratorA2.getImag() * 9.9) / voltageA);
              voltageC = Math.pow(Math.pow((voltageA - DiffVoltageA2C.getReal()), 2) + Math.pow(DiffVoltageA2C.getImag(), 2), 0.5);


              ComplexNumber DiffVoltageC2B = new ComplexNumber((SpowerC01.getReal() * 9.9 + SpowerC01.getImag() * 12.87) / voltageC, (SpowerC01.getReal() * 12.87 - SpowerC01.getImag() * 9.9) / voltageC);

              voltageB = Math.pow(Math.pow((voltageC - DiffVoltageC2B.getReal()), 2) + Math.pow(DiffVoltageC2B.getImag(), 2), 0.5);

              SpowerGeneratorA2.setImag(SpowerGeneratorA2.getImag()-0.482);

              SpowerGeneratorA.setReal(SpowerGeneratorA1.getReal() + SpowerGeneratorA2.getReal());
              SpowerGeneratorA.setImag(SpowerGeneratorA1.getImag() + SpowerGeneratorA2.getImag());
          /*  System.out.println("节点A发电机视在功率"+SpowerGeneratorA);
            System.out.println("节点B负载"+SpowerLoadB);
            System.out.println("节点C负载"+SpowerLoadC);
            System.out.println("节点A电压"+voltageA);
            System.out.println("节点B电压"+voltageB);
            System.out.println("节点C电压"+voltageC);*/
    }

    public boolean constraintCheck(){
        Boolean flag =true;
        if(voltageA>115.5||voltageA<104.5){
            flag=false;
         //   System.out.println("A点电压不满足约束");
        }
        if(voltageB>115.5||voltageB<104.5){
            flag=false;
          //  System.out.println("B点电压不满足约束");
        }
        if(voltageC>107||voltageC<99){
            flag=false;
          //  System.out.println("C点电压不满足约束");
        }
                                                                            //52.774
        if(Math.pow(Math.pow(SpowerA2B.getReal(),2)+Math.pow(SpowerA2B.getImag(),2),0.5)>50){
            flag=false;
          //  System.out.println("A2B的线路容量过载");
        }
        if(Math.pow(Math.pow(SpowerA2C.getReal(),2)+Math.pow(SpowerA2C.getImag(),2),0.5)>50){
            flag=false;
          //  System.out.println("A2C的线路容量过载");
        }
        if(Math.pow(Math.pow(SpowerC2B.getReal(),2)+Math.pow(SpowerC2B.getImag(),2),0.5)>50){
            flag=false;
          //  System.out.println("C2B的线路容量过载");
        }
        if(Math.pow(Math.pow(SpowerLoadB.getReal(),2)+Math.pow(SpowerLoadB.getImag(),2),0.5)>75){
            flag=false;
        }
        if(Math.pow(Math.pow(SpowerLoadCtol.getReal(),2)+Math.pow(SpowerLoadCtol.getImag(),2),0.5)>75){
            flag=false;
        }


        return flag;
    }


    public ComplexNumber getSpowerLoadB() {
        return SpowerLoadB;
    }

    public void setSpowerLoadB(ComplexNumber spowerLoadB) {
        SpowerLoadB = spowerLoadB;
    }

    public ComplexNumber getSpowerLoadG2B() {
        return SpowerLoadG2B;
    }

    public void setSpowerLoadG2B(ComplexNumber spowerLoadG2B) {
        SpowerLoadG2B = spowerLoadG2B;
    }

    public ComplexNumber getSpowerLoadBtol() {
        return SpowerLoadBtol;
    }

    public void setSpowerLoadBtol(ComplexNumber spowerLoadBtol) {
        SpowerLoadBtol = spowerLoadBtol;
    }

    public ComplexNumber getSpowerLoadC() {
        return SpowerLoadC;
    }

    public void setSpowerLoadC(ComplexNumber spowerLoadC) {
        SpowerLoadC = spowerLoadC;
    }

    public ComplexNumber getSpowerLoadC2compression() {
        return SpowerLoadC2compression;
    }

    public void setSpowerLoadC2compression(ComplexNumber spowerLoadC2compression) {
        SpowerLoadC2compression = spowerLoadC2compression;
    }

    public ComplexNumber getSpowerLoadCtol() {
        return SpowerLoadCtol;
    }

    public void setSpowerLoadCtol(ComplexNumber spowerLoadCtol) {
        SpowerLoadCtol = spowerLoadCtol;
    }

    public ComplexNumber getSpowerGeneratorA() {
        return SpowerGeneratorA;
    }

    public void setSpowerGeneratorA(ComplexNumber spowerGeneratorA) {
        SpowerGeneratorA = spowerGeneratorA;
    }

    public ComplexNumber getSpowerGeneratorA1() {
        return SpowerGeneratorA1;
    }

    public void setSpowerGeneratorA1(ComplexNumber spowerGeneratorA1) {
        SpowerGeneratorA1 = spowerGeneratorA1;
    }

    public ComplexNumber getSpowerGeneratorA2() {
        return SpowerGeneratorA2;
    }

    public void setSpowerGeneratorA2(ComplexNumber spowerGeneratorA2) {
        SpowerGeneratorA2 = spowerGeneratorA2;
    }

    public ComplexNumber getSpowerA2B() {
        return SpowerA2B;
    }

    public void setSpowerA2B(ComplexNumber spowerA2B) {
        SpowerA2B = spowerA2B;
    }

    public ComplexNumber getSpowerA2C() {
        return SpowerA2C;
    }

    public void setSpowerA2C(ComplexNumber spowerA2C) {
        SpowerA2C = spowerA2C;
    }

    public ComplexNumber getSpowerC2B() {
        return SpowerC2B;
    }

    public void setSpowerC2B(ComplexNumber spowerC2B) {
        SpowerC2B = spowerC2B;
    }

    public double getVoltageA() {
        return voltageA;
    }

    public void setVoltageA(double voltageA) {
        this.voltageA = voltageA;
    }

    public double getVoltageB() {
        return voltageB;
    }

    public void setVoltageB(double voltageB) {
        this.voltageB = voltageB;
    }

    public double getVoltageB1() {
        return voltageB1;
    }

    public void setVoltageB1(double voltageB1) {
        this.voltageB1 = voltageB1;
    }

    public double getVoltageC() {
        return voltageC;
    }

    public void setVoltageC(double voltageC) {
        this.voltageC = voltageC;
    }
}
