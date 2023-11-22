package geometry;

public class Triangle implements ShapeCharacteristics, GeometricCalculations {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;
    private final String fillColor;
    private final String borderColor;

    public Triangle(double firstSide, double secondSide, double thirdSide, String fillColor, String borderColor) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double getArea() {
        double s = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
    }

    @Override
    public void printInfo() {
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
        System.out.println("Fill color: " + getFillColor());
        System.out.println("Border color: " + getBorderColor());
    }
}
