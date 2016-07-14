#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector< vector<int> >& matrix) {
        vector<int> result;
        if (matrix.empty())
            return result;

        int rs = 0;
        int re = matrix.size() - 1;
        int cs = 0;
        int ce = matrix[0].size() - 1;

        while (true) {
            // 上
            for (int j = cs; j <= ce; ++j)  result.push_back(matrix[rs][j]);
            if (++rs > re)  break;
            // 右
            for (int i = rs; i <= re; ++i)  result.push_back(matrix[i][ce]);
            if (cs > --ce)  break;
            // 下
            for (int j = ce; j >= cs; --j)  result.push_back(matrix[re][j]);
            if (rs > --re)  break;
            // 左
            for (int i = re; i >= rs; --i)  result.push_back(matrix[i][cs]);
            if (++cs > ce)  break;
        }

        return result;
    }
};


class OtherSolution {
public:
    vector<int> spiralOrder(vector< vector<int> >& matrix) {
        vector<int> result;
        if (matrix.empty())
            return result;

        int ms = 0;
        int me = matrix.size() - 1;
        int ns = 0;
        int ne = matrix[0].size() - 1;

        while (ms <= me && ns <= ne) {
            if (ms < me && ns < ne) {
                // 上
                for (int i = ns; i < ne; ++i)
                    result.push_back(matrix[ms][i]);
                // 右
                for (int i = ms; i < me; ++i)
                    result.push_back(matrix[i][ne]);
                // 下
                for (int i = ne; i > ns; --i)
                    result.push_back(matrix[me][i]);
                // 左
                for (int i = me; i > ms; --i)
                    result.push_back(matrix[i][ns]);
                ++ms;
                ++ns;
                --me;
                --ne;
            } else if (ms < me && ns == ne) {
                for (int i = ms; i <= me; ++i)
                    result.push_back(matrix[i][ns]);
                break;
            } else if (ms == me && ns <= ne) {
                for (int i = ns; i <= ne; ++i)
                    result.push_back(matrix[ms][i]);
                break;
            }
        }

        return result;
    }
};


int main()
{
    // vector< vector<int> > m {{1,2,3},{4,5,6},{7,8,9}};
    vector< vector<int> > m {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    Solution so;
    vector<int> result = so.spiralOrder(m);
    for (auto i: result)
        cout << i << " ";
    cout << endl;

    return 0;
}
