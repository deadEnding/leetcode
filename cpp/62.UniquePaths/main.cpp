#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> f(n, 0);
        f[0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[j] += f[j-1];
            }
        }
        return f[n-1];
    }
};


class OtherSolution {
public:
    int uniquePaths(int m, int n) {
        vector< vector<int> > f(m, vector<int>(n, -1));
        return dfs(m-1, n-1, f);
    }

private:
    int dfs(int i, int j, vector< vector<int> >& f) {
        if (i == 0 || j == 0)
            return 1;

        if (f[i][j] == -1)
            f[i][j] = dfs(i-1, j, f) + dfs(i, j-1, f);

        return f[i][j];
    }
};


int main()
{
    OtherSolution so;
    cout << so.uniquePaths(3, 2) << endl;

    return 0;
}
