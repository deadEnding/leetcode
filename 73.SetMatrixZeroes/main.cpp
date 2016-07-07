#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void setZeroes(vector< vector<int> >& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();

        bool row = false;
        bool col = false;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 1; --i) {
            if (matrix[i][0] == 0) {
                for (int k = 0; k < n; ++k)
                    matrix[i][k] = 0;
            }
        }

        for (int j = n - 1; j >= 0; --j) {
            if ((j > 0 && matrix[0][j] == 0) || (j == 0 && col)) {
                for (int k = 0; k < m; ++k)
                    matrix[k][j] = 0;
            }
        }

        if (row) {
            for (int k = 0; k < n; ++k)
                matrix[0][k] = 0;
        }
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


int main()
{
    vector< vector<int> > m{{1,0,3}, {0,5,6}, {7,8,9}, {10, 11, 12}};
    Printer::print(m);
    cout << endl;

    Solution so;
    so.setZeroes(m);

    Printer::print(m);
    cout << endl;

    return 0;
}
