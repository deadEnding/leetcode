#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(rowIndex + 1, 1);

        for (int i = 1; i <= rowIndex + 1; ++i) {
            result[i-1] = 1;
            for (int j = i - 2; j >= 1; --j) {
                result[j] = result[j-1] + result[j];
            }
        }
        return result;
    }
};


int main()
{
    Solution so;
    vector<int> result = so.getRow(0);
    for (int i : result)
        cout << i << " ";
    cout << endl;

    return 0;
}
