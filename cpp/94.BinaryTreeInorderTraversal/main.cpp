#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> stk;
        TreeNode* p = root;

        while (!stk.empty() || p != NULL) {
            if (p != NULL) {
                stk.push(p);
                p = p->left;
            } else {
                p = stk.top();
                stk.pop();
                result.push_back(p->val);
                p = p->right;
            }
        }
        return result;
    }
};


class RecusiveSolution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        inorder(root);
        return result;
    }
private:
    vector<int> result;

    void inorder(TreeNode* root) {
        if (root) {
            inorder(root->left);
            result.push_back(root->val);
            inorder(root->right);
        }
    }
};

int main()
{
    Solution so;
    so.inorderTraversal(NULL);
    return 0;
}
