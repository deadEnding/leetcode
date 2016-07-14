#include <iostream>
#include <limits.h>
#include <vector>

using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
};


class OtherSolution1 {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size() - 1;
        vector<int> v = triangle[m];
        for (int i = m-1; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                v[j] = min(v[j], v[j+1]) + triangle[i][j];
            }
        }
        return v[0];
    }
};


/* 超时 */
class OtherSolution2 {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        dfs(triangle, 0, 0, 0);
        return minSum;
    }
private:
    int minSum = INT_MAX;

    void dfs(vector<vector<int>>& triangle, int sum, int row, int col) {
        if (row == triangle.size()) {
            minSum = min(minSum, sum);
            return;
        }

        dfs(triangle, sum + triangle[row][col], row + 1, col);
        dfs(triangle, sum + triangle[row][col], row + 1, col + 1);
    }
};


int main()
{
    vector<vector<int>> t{{2}};

    Solution so;
    cout << so.minimumTotal(t) << endl;
    return 0;
}
