#include <iostream>
#include <string>
#include <string.h>

using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        const int MAX_CHARS = 256; // 字符总个数
        int charIndex[MAX_CHARS];  // 记录字符最近一次出现的下标
        int maxLen = 0;            // 最大长度
        int curLen = 0;            // 当前长度

        memset(charIndex, -1, sizeof(charIndex));   // 初始化数组

        for (string::size_type ix = 0; ix != s.size(); ++ix) {
            // if (charIndex[s[ix]] == -1 || charIndex[s[ix]] < ix - curLen) {
            if (charIndex[s[ix]] < int(ix - curLen)) {
                curLen++;
            } else {
                curLen = ix - charIndex[s[ix]];
            }
            maxLen = curLen > maxLen ? curLen : maxLen;
            charIndex[s[ix]] = ix;
        }

        return maxLen;
    }
};


int main() {
    string s = "pwwkew";

    Solution solu;
    cout << solu.lengthOfLongestSubstring(s) << endl;

    return 0;
}
