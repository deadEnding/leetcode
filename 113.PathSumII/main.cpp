#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> path;
        dfs(root, sum, path);
        return result;
    }
private:
    vector<vector<int>> result;

    void dfs(TreeNode* root, int sum, vector<int>& path) {
        if (!root)
            return;

        sum -= root->val;
        path.push_back(root->val);
        if (sum == 0 && !root->left && !root->right)
            result.push_back(path);

        dfs(root->left, sum, path);
        dfs(root->right, sum, path);
        path.pop_back();
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
