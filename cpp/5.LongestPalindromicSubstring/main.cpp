#include <iostream>
#include <string>

using namespace std;


class Solution {
public:
    string longestPalindrome(string s) {
        const string::size_type n = s.size();
        bool isPali[n][n];             // 标记s[i...j]是否为回文字符串
        string::size_type maxLen = 1;  // 最大回文字符串长度
        string::size_type start = 0;   // 最大回文字符串起始下标

        fill_n(&isPali[0][0], n * n, false); // 初始化
        for (string::size_type j = 0; j < n; j++) {
            isPali[j][j] = true;
            for (string::size_type i = 0; i < j; i++) {
                isPali[i][j] = (s[i] == s[j] && (i + 1 == j || isPali[i+1][j-1]));
                if (isPali[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substr(start, maxLen);
    }
};


int main()
{
    string s = "abac";

    Solution so;
    cout << so.longestPalindrome(s) << endl;

    return 0;
}
