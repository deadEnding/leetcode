#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector< vector<int> >& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<int> f(n, 0);

        f[0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j])
                    f[j] = 0;
                else if (j > 0)
                    f[j] += f[j-1];
            }
        }

        return f[n-1];
    }
};


int main()
{
    vector< vector<int> > obstacleGrid(2, vector<int>(2, 0));
    obstacleGrid[0][1] = 1;
    Solution so;
    cout << so.uniquePathsWithObstacles(obstacleGrid) << endl;
    return 0;
}
