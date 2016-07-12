#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int ix = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            nums1[ix--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }

        while (j >= 0) {
            nums1[ix--] = nums2[j--];
        }
    }
};


int main()
{
    vector<int> nums1{5,7,0,0,0,0};
    vector<int> nums2{2,4,6,8};
    Solution so;
    so.merge(nums1,2, nums2,4);
    for (auto i : nums1) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}
