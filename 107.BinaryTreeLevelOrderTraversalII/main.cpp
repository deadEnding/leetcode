#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        traverse(root, 0);
        reverse(result.begin(), result.end());
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


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
