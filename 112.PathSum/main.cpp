#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root)
            return false;

        sum -= root->val;
        return (sum == 0 && !root->left && !root->right) || hasPathSum(root->left, sum)
            || hasPathSum(root->right, sum);
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
