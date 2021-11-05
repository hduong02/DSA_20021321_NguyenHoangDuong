package coursera.Eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private int[][] tiles;
    private int n;
    private int hamming;
    private int manhattan;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        n = tiles.length;
        this.tiles = new int[n][n];
        int hammingSum = 0;
        int manhattanSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] != 0) {
                    int target = tiles[i][j] - 1;
                    int nowAt = i * n + j;
                    hammingSum += target != nowAt ? 1 : 0;
                    int vertical = Math.abs(i - target / n);
                    int horizontal = Math.abs(j - target % n);
                    manhattanSum += vertical + horizontal;
                }
            }
        }
        this.hamming = hammingSum;
        this.manhattan = manhattanSum;
    }

    // string representation of this board
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(tiles[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    @Override
    public boolean equals(Object y) {
        if (y == null) {
            return false;
        }
        if (this == y) {
            return true;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }
        Board board = (Board) y;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] direction : directions) {
            int xx = x + direction[0];
            int yy = y + direction[1];
            if (isValid(xx, yy)) {
                neighbors.add(new Board(swap(x, y, xx, yy)));
            }
        }
        return neighbors;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private int[][] swap(int x, int y, int xx, int yy) {
        int[][] newTiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(tiles[i], 0, newTiles[i], 0, n);
        }
        int tmp = newTiles[x][y];
        newTiles[x][y] = newTiles[xx][yy];
        newTiles[xx][yy] = tmp;
        return newTiles;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        Board b = null;
        for (int i = 0; i < n * n - 1; i++) {
            int x = i / n;
            int y = i % n;
            int xx = (i + 1) / n;
            int yy = (i + 1) % n;
            if (tiles[x][y] != 0 && tiles[xx][yy] != 0) {
                b = new Board(swap(x, y, xx, yy));
                break;
            }
        }
        return b;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }
}