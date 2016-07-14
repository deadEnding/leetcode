#include <iostream>
#include <vector>
#include <limits.h>

using namespace std;

class Solution {
public:
    int minPathSum(vector< vector<int> >& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> f(n, INT_MAX);

        f[0] = 0;
        for (int i = 0; i < m; ++i) {
            f[0] += grid[i][0];
            for (int j = 1; j < n; ++j) {
                f[j] = min(f[j-1], f[j]) + grid[i][j];
            }
        }

        return f[n-1];
    }
};


class OtherSolution {
public:
    int minPathSum(vector< vector<int> >& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector< vector<int> > f(m, vector<int>(n, -1));
        return dfs(m - 1, n - 1, grid, f);
    }
private:
    int dfs(int i, int j, vector< vector<int> >& grid, vector< vector<int> >& f) {
        if (i == 0 && j == 0)
            return grid[0][0];

        if (i < 0 || j < 0)
            return INT_MAX;

        if (f[i][j] == -1)
            f[i][j] = min(dfs(i, j-1, grid, f), dfs(i-1, j, grid, f)) + grid[i][j];

        return f[i][j];
    }
};


class Printer {
public:
    static void print(vector<vector<int> > m) {
        for (vector<vector<int> >::size_type i = 0; i != m.size(); ++i) {
            for (vector<int>::size_type j = 0; j!= m[i].size(); ++j) {
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};

/* 同时输出路径 */
class ExtendedSolution {
public:
    int minPathSum(vector< vector<int> >& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> f(n, INT_MAX);
        vector< vector<int> > d(m, vector<int>(n));  // 记录每个元素到来的方向

        f[0] = 0;
        for (int i = 0; i < m; ++i) {
            f[0] += grid[i][0];
            d[i][0] = 1;
            for (int j = 1; j < n; ++j) {
                if (f[j-1] < f[j]) {
                    f[j] = f[j-1] + grid[i][j];
                    d[i][j] = 0;
                } else {
                    f[j] += grid[i][j];
                    d[i][j] = 1;
                }
            }
        }

        Printer::print(getPath(d));

        return f[n-1];
    }

private:
    /* 获取路径 */
    vector< vector<int> > getPath(vector< vector<int> > d) {
        vector< vector<int> > p;
        if (d.empty())
            return p;

        get(d.size() - 1, d[0].size() - 1, d, p);
        return p;
    }

    /* 反序 */
    void get(int i, int j, vector< vector<int> > d, vector< vector<int> >& p) {
        if (i != 0 || j != 0) {
            if (d[i][j]) {
                get(i-1, j, d, p);
            } else {
                get(i, j-1, d, p);
            }
        }
        p.push_back(vector<int>{i, j});
    }
};




int main()
{
    vector< vector<int> > grid(3, vector<int>(2, 0));
    grid[0][0] = 2;
    grid[0][1] = 1;
    grid[1][0] = 2;
    grid[1][1] = 3;
    Printer::print(grid);
    cout << endl << endl;
    ExtendedSolution so;
    cout << so.minPathSum(grid) << endl;
    return 0;
}
