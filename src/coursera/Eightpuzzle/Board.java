package coursera.Eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private int[][] tiles;
    private int hamming;
    private int manhattan;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {

        this.tiles = new int[tiles.length][tiles.length];
        int hammingSum = 0;
        int manhattanSum = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] != 0) {
                    int target = tiles[i][j] - 1;
                    int nowAt = i * tiles.length + j;
                    hammingSum += target != nowAt ? 1 : 0;
                    int vertical = Math.abs(i - target / tiles.length);
                    int horizontal = Math.abs(j - target % tiles.length);
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
        sb.append(tiles.length).append("\n");
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                sb.append(tiles[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
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
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] direction : directions) {
            int xx = x + direction[0];
            int y1 = y + direction[1];
            if (isValid(xx, y1)) {
                neighbors.add(new Board(swap(x, y, xx, y1)));
            }
        }
        return neighbors;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles.length;
    }

    private int[][] swap(int x, int y, int x1, int y1) {
        int[][] newTiles = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            System.arraycopy(tiles[i], 0, newTiles[i], 0, tiles.length);
        }
        int temp = newTiles[x][y];
        newTiles[x][y] = newTiles[x1][y1];
        newTiles[x1][y1] = temp;
        return newTiles;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        Board b = null;
        for (int i = 0; i < tiles.length * tiles.length - 1; i++) {
            int x = i / tiles.length;
            int y = i % tiles.length;
            int x1 = (i + 1) / tiles.length;
            int y1 = (i + 1) % tiles.length;
            if (tiles[x][y] != 0 && tiles[x1][y1] != 0) {
                b = new Board(swap(x, y, x1, y1));
                break;
            }
        }
        return b;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }
}