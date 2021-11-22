package coursera.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static int top = 0;
    private int bottom;
    private boolean[][] opened;
    private int size;
    private int openSites;
    private WeightedQuickUnionUF union;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        bottom = size * size + 1;
        opened = new boolean[size][size];
        openSites = 0;
        union = new WeightedQuickUnionUF(size * size + 2);

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        isValid(row, col);
        opened[row - 1][col - 1] = true;
        openSites++;

        if (row == size) {
            union.union(index(row, col), bottom);
        }

        if (row == 1) {
            union.union(index(row, col), top);
        }

        if (col > 1 && isOpen(row, col - 1)) {
            union.union(index(row, col), index(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            union.union(index(row, col), index(row, col + 1));
        }

        if (row > 1 && isOpen(row - 1, col)) {
            union.union(index(row, col), index(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            union.union(index(row, col), index(row + 1, col));
        }

    }

    private void isValid(int row, int col) {
        if (col <= 0 || col > size || row <= 0 || row > size ) {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row, col);
        return opened[row - 1][col - 1];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return union.find(top) == union.find(index(row, col));
        }
        else throw new IllegalArgumentException();
    }

    //địa chỉ union find của ô
    private int index(int row, int col) {
        return size * (row - 1) + col;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(top) == union.find(bottom);
    }

    public static void main(String[] args) {

    }
}