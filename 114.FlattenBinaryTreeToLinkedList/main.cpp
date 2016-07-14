#include <iostream>
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
    void flatten(TreeNode* root) {
        flatten(root, NULL);
    }
private:
    TreeNode* flatten(TreeNode* root, TreeNode* tail) {
        if (!root)
            return tail;

        root->right = flatten(root->left, flatten(root->right, tail));
        root->left = NULL;

        return root;
    }
};


class OtherSolution1 {
public:
    void flatten(TreeNode* root) {
        if (!root)
            return;

        flatten(root->left);
        flatten(root->right);

        if (!root->left)
            return;

        // 将左子树形成的链表插入到root和root->right之间
        TreeNode* p = root->left;
        while (p->right)  // 寻找左链表最后一个结点
            p = p->right;
        p->right = root->right;
        root->right = root->left;
        root->left = NULL;
    }
};


class OtherSolution2 {
public:
    void flatten(TreeNode* root) {
        doFlatten(root);
    }
private:
    TreeNode* doFlatten(TreeNode* root) {
        if (!root)
            return NULL;

        TreeNode* left = doFlatten(root->left);
        TreeNode* right = doFlatten(root->right);
        if (left) {
            left->right = root->right;
            root->right = root->left;
            root->left = NULL;
        }

        if (right)
            return right;
        else if (left)
            return left;
        else
            return root;
    }
};


class OtherSolution3 {
public:
    void flatten(TreeNode* root) {
        stack<TreeNode*> stk;
        TreeNode* p = root;

        while (p || !stk.empty()) {
            if (p) {
                stk.push(p);
                p = p->left;
            } else {
                p = stk.top();
                stk.pop();
                if (p->left) {
                    TreeNode* tmp = p->left;
                    while (tmp->right)
                        tmp = tmp->right;
                    tmp->right = p->right;
                    p->right = p->left;
                    p->left = NULL;
                    p = tmp->right;
                } else {
                    p = p->right;
                }

            }
        }
    }
};

class OtherSolution4 {
public:
    void flatten(TreeNode* root) {
        if (!root)
            return;

        stack<TreeNode*> stk;
        stk.push(root);

        while (!stk.empty()) {
            TreeNode* p = stk.top();
            stk.pop();

            if (p->right)
                stk.push(p->right);
            if (p->left)
                stk.push(p->left);

            p->left = NULL;
            if (!stk.empty())
                p->right = stk.top();
        }
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
