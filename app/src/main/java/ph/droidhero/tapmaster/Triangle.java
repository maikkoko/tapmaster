package ph.droidhero.tapmaster;

import java.util.ArrayList;

/**
 * Created by maikkompyutir on 12/13/2017.
 */

public class Triangle {

    private Boolean isTriangle = false;
    private Double area;
    private ArrayList<Double> sides;

    public Triangle(ArrayList<Double> sides) {
        if (sides.size() == 3) {
            this.sides = sides;
            this.area = getArea(sides);
            this.isTriangle = true;
        }
    }

    public Boolean isTriangle() {
        return isTriangle;
    }

    private Double getArea(ArrayList<Double> sides) {
        Double p = getPerimeter(sides);

        return Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
    }

    private Double getPerimeter(ArrayList<Double> sides) {
        Double perimeter = 0.0;

        for(Double s: sides) {
            perimeter += s;
        }

        return perimeter / 2;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public ArrayList<Double> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Double> sides) {
        this.sides = sides;
    }
}
