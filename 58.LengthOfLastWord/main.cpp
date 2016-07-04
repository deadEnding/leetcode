#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = 0;
        int ix = s.size() - 1;

        while (ix >= 0 && s[ix] == ' ')
            --ix;

        while (ix >= 0 && s[ix--] != ' ') {
            ++len;
        }

        return len;
    }
};


int main()
{
    Solution so;
    cout << so.lengthOfLastWord("   ") << endl;
    return 0;
}
