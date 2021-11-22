package coursera.CollinearPoints;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    private Point[] points;

    public BruteCollinearPoints(Point[] points) {
        if (isInvalid(points)) {
            throw new java.lang.IllegalArgumentException();
        }
        double pq;
        double pr;
        double ps;

        for (int p = 0; p <= this.points.length - 4; p++) {
            for (int q = this.points.length - 3; q > p; q--) {
                for (int r = this.points.length - 2; r > q; r--) {
                    for (int s = this.points.length - 1; s > r; s--) {
                        pq = this.points[p].slopeTo(this.points[q]);
                        pr = this.points[p].slopeTo(this.points[r]);
                        if (Double.compare(pq, pr) == 0) {
                            ps = this.points[p].slopeTo(this.points[s]);
                            if (Double.compare(pq, ps) == 0) {
                                lineSegments.add(new LineSegment(this.points[p], this.points[s]));
                            }
                        }
                    }
                }
            }
        }
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
        System.arraycopy(points, 0, this.points, 0, points.length);
        Arrays.sort(this.points);
        for (int i = 0; i < points.length - 1; i++) {
            if (this.points[i].compareTo(this.points[i + 1]) == 0) { return true; }
        }
        return false;
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}