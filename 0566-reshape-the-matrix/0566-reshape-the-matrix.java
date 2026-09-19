class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        
        if (rows * cols != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int k = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                ans[k / c][k % c] = mat[i][j];

                k++;
            }
        }

        return ans;
    }
}