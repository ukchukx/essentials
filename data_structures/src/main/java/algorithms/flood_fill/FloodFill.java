import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FloodFill {
    // Below arrays details all 8 possible movements
    private static final int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // check if it is possible to go to pixel (x, y) from
    // current pixel. The function returns false if the pixel
    // has different color or it is not a valid pixel
    public static boolean isSafe(char[][] M, int m, int n, int x, int y, char target) {
        return x >= 0 && x < m && y >= 0 && y < n && M[x][y] == target;
    }

    // Flood fill using BFS
    public static void bfsFloodFill(char[][] M, int x, int y, char replacement) {
        int m = M.length;
        int n = M[0].length;

        // create a queue and enqueue starting pixel
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));

        // get target color
        char target = M[x][y];

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            Pair node = q.poll();

            // (x, y) represents current pixel
            x = node.x;
            y = node.y;

            // replace current pixel color with that of replacement
            M[x][y] = replacement;

            // process all 8 adjacent pixels of current pixel and
            // enqueue each valid pixel
            for (int k = 0; k < row.length; k++) {
                // if adjacent pixel at position (x + row[k], y + col[k]) is
                // a valid pixel and have same color as that of current pixel
                if (isSafe(M, m, n, x + row[k], y + col[k], target)) {
                    // enqueue adjacent pixel
                    q.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    // Flood fill using DFS
    public static void dfsFloodFill(char[][] M, int x, int y, char replacement) {
      // get target color
      char target = M[x][y];

      // replace current pixel color with that of replacement
      M[x][y] = replacement;

      // process all 8 adjacent pixels of current pixel and
      // recur for each valid pixel
      for (int k = 0; k < row.length; k++) {
        // if the adjacent pixel at position (x + row[k], y + col[k]) is
        // a valid pixel and have same color as that of the current pixel
        if (isSafe(M, x + row[k], y + col[k], target))
          dfsFloodFill(M, x + row[k], y + col[k], replacement);
      }
    }

    public static void main(String[] args) {
        // matrix showing portion of the screen having different colors
        char[][] M = {
            "YYYGGGGGGG".toCharArray(),
            "YYYYYYGXXX".toCharArray(),
            "GGGGGGGXXX".toCharArray(),
            "WWWWWGGGGX".toCharArray(),
            "WRRRRRGXXX".toCharArray(),
            "WWWRRGGXXX".toCharArray(),
            "WBWRRRRRRX".toCharArray(),
            "WBBBBRRXXX".toCharArray(),
            "WBBXBBBBXX".toCharArray(),
            "WBBXXXXXXX".toCharArray()
        };
        char[][] M1 = {
            "YYYGGGGGGG".toCharArray(),
            "YYYYYYGXXX".toCharArray(),
            "GGGGGGGXXX".toCharArray(),
            "WWWWWGGGGX".toCharArray(),
            "WRRRRRGXXX".toCharArray(),
            "WWWRRGGXXX".toCharArray(),
            "WBWRRRRRRX".toCharArray(),
            "WBBBBRRXXX".toCharArray(),
            "WBBXBBBBXX".toCharArray(),
            "WBBXXXXXXX".toCharArray()
        };

        // start node
        int x = 3, y = 9;   // target color = "X"

        // replacement color
        char replacement = 'C';

        // replace target color with replacement color
        bfsFloodFill(M, x, y, replacement);
        // replace target color with replacement color using DFS
        dfsFloodFill(M1, x, y, replacement);

        // print the colors after replacement
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }

        for (int i = 0; i < M1.length; i++) {
          System.out.println(Arrays.toString(M1[i]));
        }
    }
}
