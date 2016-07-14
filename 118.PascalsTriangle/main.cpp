#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result;

        if (numRows == 0)
            return result;

        result.push_back(vector<int>(1,1));
        for (int i = 2; i <= numRows; ++i) {
            vector<int> curr(i, 1);
            const vector<int>& prev = result[i-2];

            for (int j = 1; j < i - 1; ++j) {
                curr[j] = prev[j-1] + prev[j];
            }
            result.push_back(curr);
        }

        return result;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
