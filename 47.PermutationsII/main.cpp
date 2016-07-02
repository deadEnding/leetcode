#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

/* 由于用到了unordered_ma，编译时要求指定 -std=c++11 */

/* 打印 */
class Printer {
public:
    template <typename T>
    static void print(T c) {
        for (typename T::size_type ix = 0; ix != c.size(); ++ix) {
            cout << c[ix] << " ";
        }
        cout << endl;
    }
};


class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<pair<int, int> > elems = countElems(nums);
        vector<int> path;
        perm(elems, nums.size(), path);
        return result;
    }

private:
    vector<vector<int> > result;

    /* 统计各元素出现的次数 */
    vector<pair<int, int> > countElems(vector<int>& nums) {
        unordered_map<int, int> count_map;
        for (int ix = 0; ix != nums.size(); ++ix) {
            if (count_map.find(nums[ix]) == count_map.end()) {
                count_map[nums[ix]] = 1;
            } else {
                count_map[nums[ix]]++;
            }
        }

        vector<pair<int, int> > elems;
        unordered_map<int,int>::iterator it = count_map.begin();
        while (it != count_map.end()) {
            elems.push_back(*(it++));
        }

        return elems;
    }


    /* 回溯法求解 */
    void perm(vector<pair<int, int> > elems, int n, vector<int>& path) {
        if (path.size() == n) {
            // Printer::print(path);
            result.push_back(path);
            return;
        }

        vector<pair<int, int> >::iterator it = elems.begin();
        while (it != elems.end()) {
            if (it->second > 0) {
                path.push_back(it->first);
                --(it->second);
                perm(elems, n, path);
                ++(it->second);
                path.pop_back();
            }
            ++it;
        }
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);

    Solution so;
    so.permuteUnique(nums);

    return 0;
}
