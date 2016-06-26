#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;


class Solution {
public:
    vector<string> generateParenthesis(int n) {
        recursiveGenerate(0, 0, n, "");
        return result;
    }

private:
    vector<string> result;
    stack<char> stk;

    void recursiveGenerate(int i, int l, int n, string path) {
        if (i == 2*n) {
            result.push_back(path);
            return;
        }

        if (isLeftAvail(l, n)) {
            stk.push('(');
            recursiveGenerate(i+1, l+1, n, path + '(');
            stk.pop();
        }
        if (isRightAvail()) {
            stk.pop();
            recursiveGenerate(i+1, l, n, path + ')');
            stk.push('(');
        }
    }

    bool isLeftAvail(int l, int n) {
        if (l < n)
            return true;
        return false;
    }

    bool isRightAvail() {
        if (!stk.empty() && stk.top() == '(')
            return true;
        return false;
    }
};


int main()
{
    Solution so;
    vector<string> result = so.generateParenthesis(3);
    for (vector<string>::size_type ix = 0; ix < result.size(); ++ix)
        cout << result[ix] << endl;
    return 0;
}
