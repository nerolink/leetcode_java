package Medium;

import java.util.LinkedList;
import java.util.List;

public class _54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] mask = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new LinkedList<Integer>();
        int r = 0;
        int c = 0;
        int t = matrix.length * matrix[0].length;
        while (t > 0) {
            mask[r][c] = true;

        }
    }
}
