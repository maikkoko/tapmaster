package ph.droidhero.tapmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by droidhero on 29/11/2017.
 */

public class TapIdentity {

    private Boolean isValid = false;
    private ArrayList<PointCoordinates> pointCoordinates;
    private ArrayList<Triangle> triangles;

    public TapIdentity(ArrayList<PointCoordinates> pointCoordinates) {

        if (pointCoordinates.size() == 5) {
            this.isValid = true;
            this.pointCoordinates = pointCoordinates;
            this.triangles = getTriangleSides();
        }

    }

    public Boolean isValid() {
        return this.isValid;
    }

    private ArrayList<Triangle> getTriangleSides() {
        ArrayList<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < pointCoordinates.size() - 2; i++) {
            PointCoordinates point1 = pointCoordinates.get(i);

            for (int j = i + 1; j < pointCoordinates.size() - 1; j++) {
                PointCoordinates point2 = pointCoordinates.get(j);

                for (int k = j + 1; k < pointCoordinates.size(); k++) {
                    PointCoordinates point3 = pointCoordinates.get(k);

                    ArrayList<Double> sides =  new ArrayList<>();

                    sides.add(getDistance(point1, point2));
                    sides.add(getDistance(point1, point3));
                    sides.add(getDistance(point2, point3));

                    Collections.sort(sides, new Comparator<Double>() {
                        @Override
                        public int compare(Double sideA, Double sideB) {
                            return Double.compare(sideA, sideB);
                        }
                    });

                    Triangle triangle = new Triangle(sides);

                    triangles.add(triangle);
                }
            }
        }

        Collections.sort(triangles, new Comparator<Triangle>() {

            @Override
            public int compare(Triangle triangleA, Triangle triangleB) {
                return Double.compare(triangleA.getArea(), triangleB.getArea());
            }
        });

        return triangles;
    }

    private Double getDistance (PointCoordinates coordsA, PointCoordinates coordsB) {
        return Math.sqrt(Math.pow(coordsA.getxCoord() - coordsB.getxCoord(), 2) + Math.pow(coordsA.getyCoord() - coordsB.getyCoord(), 2));
    }

    public ArrayList<Double> getAreas() {
        ArrayList<Double> areas = new ArrayList<>();

        for (Triangle t: triangles) {
            areas.add(t.getArea());
        }

        return areas;
    }

    public ArrayList<ArrayList<Double>> getSides() {
        ArrayList<ArrayList<Double>> sides = new ArrayList<>();

        for(Triangle t: triangles) {
            sides.add(t.getSides());
        }

        return sides;
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setTriangles(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }
}
