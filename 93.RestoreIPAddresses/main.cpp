#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> ip;
        dfs(0, s, ip);
        return result;
    }
private:
    vector<string> result;

    void dfs(int ix, string& s, vector<string>& ip) {
        if (ip.size() ==  4 && ix == s.size()) {
            result.push_back(ip[0] + '.' + ip[1] + '.' + ip[2] + '.' + ip[3]);
            return;
        }

        // 剪枝
        if ((s.size() - ix > (4 - ip.size()) * 3) || (s.size() - ix < (4 - ip.size())))
            return;

        int num = 0;
        for (int i = ix; i < ix + 3; ++i) {
            num = num * 10 + (s[i] - '0');

            if (num < 0 || num > 255)
                break;

            ip.push_back(s.substr(ix, i - ix + 1));
            dfs(i+1, s, ip);
            ip.pop_back();

            if (num == 0)  // 不允许多位数前缀为0，但允许单个0
                break;
        }
    }
};


class OtherSolution {
public:
    vector<string> restoreIpAddresses(string s) {
        string path;
        dfs(4, 0, s, path);
        return result;
    }

private:
    vector<string> result;

    void dfs(int k, int ix, string& s, string& path) {
        if (k == 1) {
            string sub = s.substr(ix, s.size() - ix);
            if (ix < s.size() && valid(sub)) {
                result.push_back(path + sub);
            }
            return;
        }

        for (int i = 1; i <= 3; ++i) {
            if (ix + i >= s.size())
                continue;

            string sub = s.substr(ix, i);
            if (valid(sub)) {
                string tmp = path + sub + ".";
                dfs(k-1, ix+i, s, tmp);
            }
        }
    }

    bool valid(string& s) {
        int n = s.size();
        if (n <= 3 && n > 0) {
            if (s[0] == '0' && n > 1)
                return false;
            int sum = 0;
            for(int i = 0; i < n; ++i)
                sum = sum * 10 + (s[i] - '0');
            if (0 <= sum && sum <= 255)
                return true;
            return false;
        }
        return false;
    }
};


int main()
{
    string s = "01234";
    Solution so;
    vector<string> result = so.restoreIpAddresses("010010");
    for(string s: result)
        cout << s << endl;

    return 0;
}
