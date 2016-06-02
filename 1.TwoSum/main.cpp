#include <iostream>
#include <vector>
#include <map>

using namespace std;


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> m;
        vector<int> indices;

        for (vector<int>::size_type ix = 0; ix < nums.size(); ++ix) {
            if (m.find(target - nums[ix]) == m.end()) {
                m[nums[ix]] = ix;
            } else {
                indices.push_back(m[target - nums[ix]]);
                indices.push_back(ix);
                break;
            }
        }

        return indices;
    }
};


int main() {
    vector<int> nums;
    int n, sum, ele;

    cin >> n >> sum;
    while (n--) {
        cin >> ele;
        nums.push_back(ele);
    }

    Solution solu;
    vector<int> result = solu.twoSum(nums, sum);

    cout << result[0] << endl;
    cout << result[1] << endl;

    return 0;
}
