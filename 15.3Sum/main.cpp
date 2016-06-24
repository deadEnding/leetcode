#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int>& nums) {
        vector<vector<int> > result;
        if (nums.size() < 3) {
            return result;
        }

        sort(nums.begin(), nums.end());
        const int target = 0;
        vector<int>::iterator last = nums.end();

        for(vector<int>::iterator i = nums.begin(); i < last - 2; ++i) {
            if (i > nums.begin() && *(i-1) == *i)
                continue;

            vector<int>::iterator j = i + 1;
            vector<int>::iterator k = last - 1;

            while (j < k) {
                if (*i + *j + *k < target) {
                    ++j;
                    while (j < k && *(j-1) == *j)
                        ++j;
                } else if (*i + *j + *k > target) {
                    --k;
                    while (j < k && *k == *(k+1))
                        --k;
                } else {
                    result.push_back(build(*i, *j, *k));
                    ++j;
                    --k;
                    while (j < k && *(j-1) == *j && *k == *(k+1)) {
                        ++j;
                        --k;
                    }
                }
            }
        }
        return result;
    }

private:
    vector<int> build(int a, int b, int c) {
        vector<int> v;
        v.push_back(a);
        v.push_back(b);
        v.push_back(c);
        return v;
    }
};


int main()
{
    vector<int> v;
    v.push_back(-2);
    v.push_back(0);
    v.push_back(0);
    v.push_back(2);
    v.push_back(2);

    Solution so;
    vector<vector<int> > result = so.threeSum(v);
    cout << result.size() << endl;
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
