package geometry;

public interface GeometricCalculations {
    default double getPerimeter() {
        return 0.0;
    };
    default double getArea() {
        return 0.0;
    };
    void printInfo();
}
