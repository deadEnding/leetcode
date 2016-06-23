#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        const int m = nums1.size();
        const int n = nums2.size();
        int total = m + n;
        if (total % 2) {  // 奇数
            return findKth(nums1.begin(), m, nums2.begin(), n, total / 2 + 1);
        } else {          // 偶数
            return (findKth(nums1.begin(), m, nums2.begin(), n, total / 2) +
                        findKth(nums1.begin(), m, nums2.begin(), n, total / 2 + 1)) / 2.0;
        }
    }

private:
    int findKth(vector<int>::iterator a, int m, vector<int>::iterator b, int n, int k) {
        if (m > n) {
            return findKth(b, n, a, m, k);
        }

        if (m == 0) {
            return *(b+k-1);
        }

        if (k == 1) {
            return min(*a, *b);
        }

        int pa = min(k/2, m);
        int pb = k - pa;

        if (*(a + pa - 1) < *(b + pb - 1)) {
            return findKth(a + pa, m - pa, b, n, k - pa);
        } else if (*(a + pa - 1) > *(b + pb - 1)) {
            return findKth(a, m, b + pb, n - pb, k - pb);
        } else {
            return *(a + pa - 1);
        }
    }
};

int main() {
    vector<int> nums1;
    nums1.push_back(3);
    nums1.push_back(5);
    nums1.push_back(6);
    nums1.push_back(8);

    vector<int> nums2;
    nums2.push_back(0);
    nums2.push_back(1);
    nums2.push_back(2);
    nums2.push_back(4);
    nums2.push_back(7);
    nums2.push_back(9);
    nums2.push_back(10);
    nums2.push_back(11);

    Solution so;
    cout << so.findMedianSortedArrays(nums1, nums2) << endl;
}
