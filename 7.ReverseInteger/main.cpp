#include <iostream>
#include <limits.h>

using namespace std;

class Solution {
public:
    int reverse(int x) {
        int xcp = (x > 0 ? x : -x);
        long result = 0;

        while (xcp != 0) {
            result = result * 10 + xcp % 10;
            xcp = xcp / 10;
        }
        if (int(result) != result) {
            return 0;
        }
        return (x > 0 ? int(result) : -int(result));
    }
};


int main()
{
    int x = 1534236469;
    Solution so;
    cout << so.reverse(x) << endl;
    return 0;
}
