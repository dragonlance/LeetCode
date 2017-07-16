public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int t = 0;
        int l = 0;
        int b = matrix.length - 1;
        int r = matrix[0].length - 1;

        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;

            // 如果就一行，这里有可能越界，需要检查一下
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    list.add(matrix[b][i]);
                }
                b--;
            }

            // 如果就一列，这里有可能越界，需要检查一下
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    list.add(matrix[i][l]);
                }
                l++;
            }
        }
        return list;
    }
}

// 从Solution的用上下左右4个变量，优化为只用2个变量。row和col的count，然后通过总的length计算边界
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int rc = 0;                     // row count
        int cc = 0;                     // col count
        int trc = matrix.length - 1;    // total row count
        int tcc = matrix[0].length - 1; // total col count

        while (rc * 2 <= trc && cc * 2 <= tcc) {
            for (int i = cc; i <= tcc - cc; i++) {
                list.add(matrix[rc][i]);
            }

            for (int i = rc + 1; i <= trc - rc; i++) {
                list.add(matrix[i][tcc - cc]);
            }

            if (rc * 2 + 1 <= trc) {
                for (int i = tcc - cc - 1; i >= cc; i--) {
                    list.add(matrix[trc - rc][i]);
                }
            }

            if (cc * 2 + 1 <= tcc) {
                for (int i = trc - rc - 1; i >= rc + 1; i--) {
                    list.add(matrix[i][cc]);
                }
            }

            rc++;
            cc++;
        }
        return list;
    }
}

// 从2个变量优化为只用一个变量的终极版本
public class Solution3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int count = 0; // 只用一个变量
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (count * 2 <= row && count * 2 <= col) {
            for (int i = count; i <= col - count; i++) {
                list.add(matrix[count][i]);
            }

            for (int i = count + 1; i <= row - count; i++) {
                list.add(matrix[i][col - count]);
            }

            if (count * 2 + 1 <= row) {
                for (int i = col - count - 1; i >= count; i--) {
                    list.add(matrix[row - count][i]);
                }
            }

            if (count * 2 + 1 <= col) {
                for (int i = row - count - 1; i >= count + 1; i--) {
                    list.add(matrix[i][count]);
                }
            }

            count++;
        }
        return list;
    }
}
