#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty())
            return "";

        const string::size_type slen =  strs[0].size();
        const vector<string>::size_type vlen = strs.size();

        for (string::size_type i = 0; i < slen; ++i) {
            for (vector<string>::size_type j = 1; j < vlen; ++j) {
                if (strs[0][i] != strs[j][i])
                    return strs[0].substr(0, i);
            }
        }
        return strs[0];
    }
};


int main()
{
    vector<string> strs;
    strs.push_back("123");
    strs.push_back("1234");
    strs.push_back("12");

    Solution so;
    cout << so.longestCommonPrefix(strs) << endl;
    return 0;
}
