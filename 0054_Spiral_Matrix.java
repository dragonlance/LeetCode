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
