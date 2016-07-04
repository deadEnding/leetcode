#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector< vector<int> > matrix(n, vector<int>(n));

        int rs = 0, cs = 0;
        int re = n - 1, ce = n - 1;
        int ix = 1;

        while (true) {
            // 上
            for (int j = cs; j <= ce; ++j)  matrix[rs][j] = ix++;
            if (++rs > re)  break;
            // 右
            for (int i = rs; i <= re; ++i)  matrix[i][ce] = ix++;
            if (cs > --ce)  break;
            // 下
            for (int j = ce; j >= cs; --j)  matrix[re][j] = ix++;
            if (rs > --re)  break;
            // 左
            for (int i = re; i >= rs; --i)  matrix[i][cs] = ix++;
            if (++cs > ce)  break;
        }
        return matrix;
    }
};


class Printer {
public:
    static void print(vector<vector<int> > m) {
        for (vector<vector<int> >::size_type i = 0; i != m.size(); ++i) {
            for (vector<int>::size_type j = 0; j!= m.size(); ++j) {
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main()
{
    Solution so;
    vector< vector<int> > matrix = so.generateMatrix(4);
    Printer::print(matrix);

    return 0;
}
