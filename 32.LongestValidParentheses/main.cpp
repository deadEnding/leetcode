#include <iostream>
#include <stack>
#include <string>
#include <algorithm>

using namespace std;


class Solution {
public:
    int longestValidParentheses(string s) {
        int maxLen = 0;
        int last = -1;      // 记录上一次括号匹配中断的位置
        stack<int> lefts;   // 存储未匹配左括号的下标

        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {  // 左括号
                lefts.push(i);
            } else {            // 后括号
                if (lefts.empty()) {  // 匹配失败，记录中断位置
                    last = i;
                } else {              // 匹配成功
                    lefts.pop();
                    if (lefts.empty())   // 上一次中断到现在全部匹配成功
                        maxLen = max(maxLen, i - last);
                    else                 // 上一次中断到现在部分匹配成功
                        maxLen = max(maxLen, i - lefts.top());
                }
            }
        }

        return maxLen;
    }
};



class OtherSolution {
public:
    int longestValidParentheses(string s) {
        int maxLen = 0;
        int last;     // 记录上一次括号匹配中断的位置
        int depth;    // 存储括号的嵌套深度

        // 从左向右扫描
        depth = 0;
        last = -1;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {   // 左括号
                ++depth;
            } else {             // 右括号
                --depth;
                if (depth < 0) {           // 匹配失败，记录中断位置，嵌套深度清零
                    last = i;
                    depth = 0;
                } else if (depth == 0) {   // 匹配成功，上一次中断到现在全部匹配成功
                    maxLen = max(maxLen, i - last);
                }                          // else 匹配成功，上一次中断到现在部分匹配成功
            }
        }

        // 从右向左扫描
        depth = 0;
        last = s.size();
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == ')') {
                ++depth;
            } else {
                --depth;
                if (depth < 0) {
                    last = i;
                    depth = 0;
                } else if (depth == 0) {
                    maxLen = max(maxLen, last - i);
                }
            }
        }
        return maxLen;
    }
};


int main()
{
    string s = "(()";

    Solution so;
    cout << so.longestValidParentheses(s) << endl;

    return 0;
}
