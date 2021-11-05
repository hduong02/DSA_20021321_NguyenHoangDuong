package coursera.CollinearPoints;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    private Point[] pointsClone;
    private Point[] points;

    public FastCollinearPoints(Point[] points) {

        if (isInvalid(points)) {
            throw new java.lang.IllegalArgumentException();
        }
        if (points.length < 4) {
            return;
        }

        for (Point p : this.points) {
            pointsClone = this.points.clone();
            Arrays.sort(pointsClone, p.slopeOrder());
            int k = 2;
            int begin = 1;
            int end = 1;
            double slope1;
            double slope2 = p.slopeTo(pointsClone[1]);
            for (int i = 1; i < pointsClone.length - 1; i++) {
                slope1 = slope2;
                slope2 = p.slopeTo(pointsClone[i + 1]);

                if (Double.compare(slope1, slope2)  == 0) {
                    k++;
                    end = i + 1;
                    if (i + 1 < pointsClone.length - 1) { continue; }
                }

                if (k >= 4) {
                    addSegments(p, begin, end);
                }
                k = 2;
                begin = i + 1;

            }
        }

    }

    private void addSegments(Point point, int start, int end) {
        if (point.compareTo(pointsClone[start]) > 0) {
            return;
        }
        lineSegments.add(new LineSegment(point, pointsClone[end]));
    }

    private boolean isInvalid(Point[] points) {
        if (points == null) {
            return true;
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                return true;
            }
        }
        this.points = new Point[points.length];
        this.points = points.clone();
        Arrays.sort(this.points);
        for (int i = 0; i < this.points.length - 1; i++) {
            if (this.points[i].compareTo(this.points[i + 1]) == 0) {
                return true;
            }
        }
        pointsClone = new Point[points.length];
        return false;
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}