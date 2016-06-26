#include <iostream>
#include <vector>
#include <string>
#include <ctime>

using namespace std;


class Solution {
public:
    vector<string> generateParenthesis(int n) {
        generate(n, 0, 0, "");
        return result;
    }

private:
    vector<string> result;

    void generate(int n, int l, int r, string path) {
        if (l == n) {
            string s(path);
            result.push_back(s.append(n - r, ')'));
            return;
        }

        generate(n, l + 1, r, path + '(');

        if (l > r) {
            generate(n, l, r + 1, path + ')');
        }
    }
};


/* 此方法效率很低 */
class OtherSolution {
public:
    vector<string> generateParenthesis(int n) {
        return generate(n);
    }

private:
    vector<string> generate(int n) {
        if (n == 0)
            return vector<string>(1, "");

        if (n == 1)
            return vector<string>(1, "()");

        vector<string> result;

        for (int i = 0; i < n; ++i) {
            vector<string> inners = generate(i);
            for (vector<string>::size_type m = 0; m < inners.size(); ++m) {
                vector<string> outers = generate(n - 1 - i);
                for (vector<string>::size_type n = 0; n < outers.size(); ++n) {
                    result.push_back("(" + inners[m] + ")" + outers[n]);
                }
            }
        }
        return result;
    }

};


int main()
{
    Solution so;
    OtherSolution oso;

    time_t t_start1 = clock();
    vector<string> result1 = so.generateParenthesis(9);
    time_t t_end1 = clock();

    time_t t_start2 = clock();
    vector<string> result2 = oso.generateParenthesis(9);
    time_t t_end2 = clock();
    //for (vector<string>::size_type ix = 0; ix < result.size(); ++ix)
    //    cout << result[ix] << endl;
    cout << result1.size() << endl;
    cout << result2.size() << endl;

    cout << (double)(t_end1 - t_start1)/CLOCKS_PER_SEC << endl;
    cout << (double)(t_end2 - t_start2)/CLOCKS_PER_SEC << endl;
    return 0;
}
