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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root)
            return result;

        stack<TreeNode*> curr, next;
        curr.push(root);

        while (!curr.empty()) {
            vector<int> level;
            while (!curr.empty()) {
                TreeNode* p = curr.top();
                curr.pop();

                level.push_back(p->val);
                if (result.size() % 2) {
                    if (p->right)
                        next.push(p->right);
                    if (p->left)
                        next.push(p->left);
                } else {
                    if (p->left)
                        next.push(p->left);
                    if (p->right)
                        next.push(p->right);
                }
            }
            result.push_back(level);
            swap(curr, next);
        }

        return result;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
