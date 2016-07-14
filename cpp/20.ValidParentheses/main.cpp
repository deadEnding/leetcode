#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
        if (s.size() % 2)
            return false;

        stack<char>  stk;

        for (string::size_type ix = 0; ix < s.size(); ++ix) {

            switch(s[ix]) {
            case '(':
            case '[':
            case '{':
                stk.push(s[ix]);
                break;
            case ')':
            case ']':
            case '}':
                if (stk.size() == 0)
                    return false;

                char c = stk.top();
                if (c == '(' && s[ix] != ')' || c == '[' && s[ix] != ']' || c == '{' && s[ix] != '}')
                    return false;
                stk.pop();
                break;
            }
        }
        return stk.empty();
    }
};


int main()
{
    string s = "]]";
    Solution so;
    cout << int(so.isValid(s)) << endl;
    return 0;
}
