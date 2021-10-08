package method;

import java.util.Objects;

/**
 * @ClassName ComplexNumber
 * @Description TODO
 * @Author dell5471
 * @DATE
 * @Version 1.0
 **/
public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber() {

    }

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return  real +
                "+" + imag +"i"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.real, real) == 0 && Double.compare(that.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
