#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <limits.h>

using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());

        int closestDistance = INT_MAX;
        vector<int>::iterator last = nums.end();

        for(vector<int>::iterator i = nums.begin(); i < last - 2; ++i) {
            vector<int>::iterator j = i + 1;
            vector<int>::iterator k = last - 1;

            while (j < k) {
                int distance = *i + *j + *k - target;

                if (abs(distance) < abs(closestDistance))
                    closestDistance = distance;

                if (distance < 0)
                    ++j;
                else
                    --k;
            }
        }
        return closestDistance + target;
    }
};


int main()
{
    vector<int> v;
    v.push_back(-1);
    v.push_back(2);
    v.push_back(1);
    v.push_back(-4);

    Solution so;
    cout << so.threeSumClosest(v, 1) << endl;


    return 0;
}
