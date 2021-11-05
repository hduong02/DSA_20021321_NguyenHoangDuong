package coursera.CollinearPoints;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }


    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }


    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }

        if (this.y == that.y) {
            return +0.0;
        }

        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }

        return (double) (that.y - this.y) / (that.x - this.x);
    }


    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y - that.y == 0) {
            return this.x - that.x;
        }
        return this.y - that.y;
    }


    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        return new slopeOrder1();
    }

    private class slopeOrder1 implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return Double.compare(slopeTo(p1), slopeTo(p2));
        }
    }


    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
}