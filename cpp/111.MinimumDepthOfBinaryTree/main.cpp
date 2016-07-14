#include <iostream>
#include <limits.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    int minDepth(TreeNode* root) {
        if (!root)
            return 0;

        int result = INT_MAX;
        minDepth(root, 1, result);
        return result;
    }
private:
    void minDepth(TreeNode* root, int depth, int& result) {
        if (!root->left && !root->right) {
            result = min(depth, result);
            return;
        }

        if (root->left)
            minDepth(root->left, depth + 1, result);
        if (root->right)
            minDepth(root->right, depth + 1, result);
    }
};

class OtherSolution {
public:
    int minDepth(TreeNode* root) {
        if (root) {
            long left = minDepth(root->left);
            long right = minDepth(root->right);
            if (left != 0 && right != 0) {
                return min(left, right) + 1;
            } else if (left != 0) {
                return left + 1;
            } else if (right != 0) {
                return right + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
};

int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
