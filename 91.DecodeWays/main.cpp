#include <iostream>

using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0')
            return 0;

        int prev = 0;
        int cur = 1;
        // 长度为n的字符串，有n+1个阶梯
        for (int i = 1; i <= s.size(); ++i) {
            if (s[i-1] == '0')
                cur = 0;

            if (!(i >= 2 && (s[i-2] == '1' || (s[i-2] == '2' && s[i-1] <= '6'))))
                prev = 0;

            int tmp = cur;
            cur += prev;
            prev = tmp;
        }
        return cur;
    }
};


int main()
{
    string s = "1212";
    Solution so;
    cout << so.numDecodings(s) << endl;

    return 0;
}
