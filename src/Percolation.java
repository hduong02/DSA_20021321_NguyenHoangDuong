import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int top = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
        openSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkException(row, col);
        opened[row - 1][col - 1] = true;
        openSites++;

        if (row == 1) {
            qf.union(qfIndex(row, col), top);
        }

        if (row == size) {
            qf.union(qfIndex(row, col), bottom);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(qfIndex(row, col), qfIndex(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            qf.union(qfIndex(row, col), qfIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(qfIndex(row, col), qfIndex(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            qf.union(qfIndex(row, col), qfIndex(row, col + 1));
        }
    }

    private void checkException(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return qf.find(top) == qf.find(qfIndex(row, col));
        }
        else throw new IllegalArgumentException();
    }

    //địa chỉ union find của ô
    private int qfIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.find(top) == qf.find(bottom);
    }

    public static void main(String[] args) {
        Percolation a = new Percolation(4);
        for(int i=1; i<=4; i++){
            a.open(i,1);
        }
        System.out.println(a.percolates());
    }
}