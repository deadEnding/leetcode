#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector< vector<int> > combine(int n, int k) {
        vector<int> path;
        dfs(k, n, path);
        return result;
    }
private:
    vector< vector<int> > result;

    void dfs(int ix, int n, vector<int>& path) {
        if (ix == 0) {
            result.push_back(path);
            return;
        }

        for (int i = n; i >= 1; --i) {
            path.push_back(i);
            dfs(ix-1, i-1, path);
            path.pop_back();
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
    Solution so;
    vector< vector<int> > result = so.combine(4, 2);
    Printer::print(result);

    return 0;
}
