#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/* 自顶向下 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return build(nums, 0, nums.size());
    }
private:
    TreeNode* build(vector<int>& nums, int l, int r) {
        if (l == r)
            return NULL;

        int leftSize = (r - l) / 2;
        TreeNode* root = new TreeNode(nums[l + leftSize]);
        root->left = build(nums, l, l + leftSize);
        root->right = build(nums, l + leftSize + 1, r);

        return root;
    }
};

/* 自底向上 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return build(nums, 0, nums.size());
    }
private:
    TreeNode* build(vector<int>& nums, int start, int end) {
        if (start == end)
            return NULL;

        int mid = (start + end) / 2;
        TreeNode* left = build(nums, start, mid);
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = left;
        root->right = build(nums, mid + 1, end);

        return root;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
