#include <iostream>
#include <string>
#include <sstream>

using namespace std;


class Solution {
public:
    string countAndSay(int n) {
        string s = "1";

        while (--n)
            s = getNext(s);

        return s;
    }

private:
    string getNext(string s) {
        stringstream ss;
        int sum = 1;
        int ix = 1;

        while (ix < s.size()) {
            if (s[ix-1] == s[ix]) {
                ++sum;
            } else {
                ss << sum << s[ix-1];
                sum = 1;
            }
            ++ix;
        }
        ss << sum << s[ix-1];

        return ss.str();
    }
};


int main()
{
    Solution so;
    cout << so.countAndSay(3) << endl;
    return 0;
}
