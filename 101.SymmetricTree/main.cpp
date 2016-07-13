#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
}


class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == NULL)
            return true;
        return isSymmetric(root->left, root->right);
    }
private:
    bool isSymmetric(TreeNode* p, TreeNode* q) {
        if (p == NULL && q == NULL)
            return true;
        if (p == NULL || q == NULL)
            return false;
        return p->val == q->val && isSymmetric(p->left, q->right)
            && isSymmetric(p->right, q->left);
    }
};

class OtherSolution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == NULL)
            return true;

        stack<TreeNode*> stk;
        TreeNode* p = NULL;
        TreeNode* q = NULL;

        stk.push(root->right);
        stk.push(root->left);
        while (!stk.empty()) {
            p = stk.top();
            stk.pop();
            q = stk.top();
            stk.pop();

            if ((!p && q) || (p && !q))
                return false;

            if (p && q) {
                if (p->val != q->val)
                    return false;
                stk.push(q->left);
                stk.push(p->right);
                stk.push(q->right);
                stk.push(p->left);
            }
        }
        return true;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
