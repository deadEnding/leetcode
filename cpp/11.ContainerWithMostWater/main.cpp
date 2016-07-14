#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        vector<int>::size_type pl = 0;
        vector<int>::size_type pr = height.size() - 1;
        int mArea = 0;

        while (pl < pr) {
            int area = min(height[pl], height[pr]) * (pr - pl);
            mArea = (area > mArea ? area : mArea);
            if (height[pl] < height[pr])
                pl++;
            else
                pr--;
        }
        return mArea;
    }
};


int main()
{
    vector<int> height;
    height.push_back(1);
    height.push_back(2);
    height.push_back(3);
    height.push_back(4);
    height.push_back(100);
    height.push_back(100);
    Solution so;
    cout << so.maxArea(height) << endl;

    return 0;
}
