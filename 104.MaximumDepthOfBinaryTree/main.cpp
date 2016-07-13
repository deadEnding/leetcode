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
    int maxDepth(TreeNode* root) {
        if (root) {
            return max(maxDepth(root->left), maxDepth(root->right)) + 1;
        }
        return 0;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
