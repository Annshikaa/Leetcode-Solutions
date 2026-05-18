class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        int x, y;
        for (int i = 0; i < m; i++) {
            y = m - 1 - i;
            x = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '.')
                    continue;
                else if (boxGrid[i][j] == '*') {
                    while (x > j)
                        ans[x--][y] = '.';
                    ans[x][y] = '*';
                    x--;
                } else
                    ans[x--][y] = '#';
            }
            while (x >= 0)
                ans[x--][y] = '.';
        }
        return ans;
    }
}