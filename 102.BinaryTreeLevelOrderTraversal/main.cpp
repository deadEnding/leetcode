#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
}


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        traverse(root, 0);
        return result;
    }
private:
    vector<vector<int>> result;

    void traverse(TreeNode* root, int level) {
        if (!root)
            return;

        if (level >= result.size())
            result.push_back(vector<int>{});

        result[level].push_back(root->val);
        traverse(root->left, level + 1);
        traverse(root->right, level + 1);
    }
};


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == NULL)
            return result;

        queue<TreeNode*> curr, next;
        curr.push(root);

        while (!curr.empty()) {
            vector<int> level;
            while (!curr.empty()) {
                TreeNode* node = curr.front();
                curr.pop();

                level.push_back(node->val);
                if (node->left)
                    next.push(node->left);
                if (node->right)
                    next.push(node->right);
            }
            result.push_back(level);
            swap(next, curr);
        }
        return result;
    }
};


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root)
            return result;

        int level = 0;
        int cur = 1;
        int next = 0;
        int counter = 0;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            TreeNode* n = q.front();
            q.pop();

            if (level >= result.size())
                result.push_back(vector<int>{});
            result[level].push_back(n->val);

            if (n->left) {
                q.push(n->left);
                ++next;
            }

            if (n->right) {
                q.push(n->right);
                ++next;
            }

            if (++counter == cur) {
                ++level;
                cur += next;
                next = 0;
            }
        }
        return result;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
