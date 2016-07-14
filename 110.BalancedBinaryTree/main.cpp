#include <iostream>
#include <algorithm>
#include <math.h>


using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return height(root) >= 0;
    }
private:
    int height(TreeNode* root) {
        if (!root)
            return 0;

        int left = height(root->left);
        int right = height(root->right);

        if (left < 0 || right < 0 || abs(left - right) > 1)
            return -1;

        return max(left, right) + 1;
    }
};


class OtherSolution {
public:
    bool isBalanced(TreeNode* root) {
        int depth;
        return isBalanced(root, depth);
    }
private:
    bool isBalanced(TreeNode* root, int& depth) {
        if (root) {
            int left, right;
            if (isBalanced(root->left, left) && isBalanced(root->right, right))
                if (-1 <= left - right && left - right <= 1) {
                    depth = max(left, right) + 1;
                    return true;
                }

            return false;
        }
        depth = 0;
        return true;
    }
};


int main()
{
    TreeNode n1(1), n2(2), n3(3);
    n1.right = &n2;
    n2.right = &n3;
    Solution so;
    cout << so.isBalanced(&n1) << endl;
    return 0;
}
