#include <iostream>

using namespace std;

class Solution {
public:
    int mySqrt(int x) {
        if (x < 2)
            return x;

        int left = 1;
        int right = x / 2;
        int lastMid;

        while (left <= right) {
            const int mid =  (left + right) / 2;
            if (x / mid > mid) {   // 不要使用 x > mid * mid，否则会溢出
                left = mid + 1;
                lastMid = mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return lastMid;
    }
};


int main()
{
    Solution so;
    cout << so.mySqrt(183692038) << endl;
    return 0;
}
