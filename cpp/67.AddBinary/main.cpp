#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string result;
        const int n = a.size() > b.size() ? a.size() : b.size();
        int carry = 0;

        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        for (int i = 0; i < n; ++i) {
            const int ai = i < a.size() ? a[i] - '0' : 0;
            const int bi = i < b.size() ? b[i] - '0' : 0;
            const int val = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            result.insert(result.begin(), val + '0');
        }

        if (carry == 1)
            result.insert(result.begin(), '1');
        return result;
    }
};


int main()
{
    Solution so;
    cout << so.addBinary("110", "11") << endl;

    return 0;
}
