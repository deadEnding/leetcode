#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        const size_t size = 1 << n; // 1左移n位, 2^n
        for (int i = 0; i < size; ++i) {
            result.push_back(i^(i >> 1));
        }
        return result;
    }
};


int main()
{
    Solution so;
    vector<int> result = so.grayCode(3);
    for (int i : result) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}
