#include <iostream>
#include <vector>
#include <string>

using namespace std;


class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (!digits.empty())
            DFS(digits, 0, "");
        return result;
    }

private:
    const string keyboard[10] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    vector<string> result;

    void DFS(string& digits, int cur, string path) {
        if (cur == digits.size()) {
            result.push_back(path);
            return;
        }

        string letters = keyboard[digits[cur] - '0'];
        for (string::size_type j = 0; j < letters.size(); ++j) {
            DFS(digits, cur+1, path + letters[j]);
        }
    }
};


int main()
{
    string digits = "239";
    Solution so;
    vector<string> result = so.letterCombinations(digits);
    cout << result.size() << endl;
    for (vector<string>::size_type ix = 0; ix < result.size(); ++ix) {
        cout << result[ix] << endl;
    }

    return 0;
}
