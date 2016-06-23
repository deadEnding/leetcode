#include <iostream>
#include <string>
#include <assert.h>

using namespace std;


class Solution {
public:
    string convert(string s, int numRows) {
        const int len = s.length();
        if (numRows == 1 || len == 1)
            return s;

        const int circle = numRows * 2 - 2;  // 周期
        string r = "";

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += circle) {
                r += s[j];
                if (i > 0 && i < numRows - 1) {
                    int dist = circle - 2 * i;
                    if ((j + dist) < len)
                        r += s[j + dist];
                }
            }
        }
        return r;
    }
};

int main()
{
    string s = "AB";
    Solution so;
    cout << so.convert(s, 3) << endl;

    return 0;
}
