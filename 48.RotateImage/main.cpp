#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    void rotate(vector<vector<int> >& matrix) {
        const int n = matrix.size();

        /* 上下翻转 */
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < n; ++j)
                swap(matrix[i][j], matrix[n-1-i][j]);
        }

        /* 沿主对角线翻转 */
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }
};

class OtherSolution {
public:
    void rotate(vector<vector<int> >& matrix) {
        if (matrix.size() == 1)
            return;

        const int n = matrix.size();
        int low = n / 2 - 1;
        int high = n / 2 + n % 2;

        while (low >= 0 && high < n) {
            rotateCircle(matrix, low--, high++);
        }
    }

private:
    void rotateCircle(vector<vector<int> >& m, int low, int high) {
        int tmp;

        for (int i = low; i < high; ++i) {
            int dist = i - low;
            tmp = m[low][i];
            m[low][i] = m[high - dist][low];
            m[high - dist][low] = m[high][high - dist];
            m[high][high - dist] = m[low + dist][high];
            m[low + dist][high] = tmp;
        }
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
    // vector<vector<int> > m {{1,2}, {3,4}};
    // vector<vector<int> > m {{1,2,3}, {4,5,6}, {7,8,9}};
     vector<vector<int> > m {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

    Printer::print(m);
    cout << endl << endl;

    Solution so;
    so.rotate(m);
    Printer::print(m);

    return 0;
}
