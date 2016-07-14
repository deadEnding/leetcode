#include <iostream>
#include <limits.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
}

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return isValidBST(root, LONG_MIN, LONG_MAX);
    }
private:
    bool isValidBST(TreeNode* root, long lower, long upper) {
        if (root) {
            return root->val > lower && root->val < upper
                && isValidBST(root->left, lower, root->val)
                && isValidBST(root->right, root->val, upper);
        }
        return true;
    }
};


class OtherSolution {
public:
    bool isValidBST(TreeNode* root) {
        return preOrder(root, LONG_MIN, LONG_MAX);
    }
private:
    bool preOrder(TreeNode* root, long minv, long maxv) {
        if (root) {
            if (!(minv < root->val && root->val < maxv))
                return false;
            if (!preOrder(root->left, minv, root->val) || (!preOrder(root->right, root->val, maxv)))
                return false;
        }
        return true;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
