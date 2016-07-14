#include <iostream>

using namespace std;

/* 注意溢出的边界情况 */

class Solution {
public:
    double myPow(double x, int n) {
        if (n < 0)
            return 1.0 / power(x, -n);
        else
            return power(x, -n);
    }
private:
    double power(double x, long long n) {
        if (n == 0)
            return 1;

        double half = power(x, n / 2);
        return half * half * (n % 2 ? x : 1);
    }
};


int main()
{
    Solution so;
    cout << so.myPow(2, -2147483648) << endl;

    return 0;
}
