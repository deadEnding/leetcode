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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return build(preorder.begin(), preorder.end(), inorder.begin(), inorder.end());
    }
private:
    template<typename Iter>
    TreeNode* build(Iter pfirst, Iter plast, Iter ifirst, Iter ilast) {
        if (pfirst == plast || ifirst == ilast)
            return NULL;

        Iter inRootPos = find(ifirst, ilast, *pfirst);
        int leftSize = distance(ifirst, inRootPos);

        TreeNode* root = new TreeNode(*pfirst);
        root->left = build(pfirst + 1, pfirst + leftSize + 1, ifirst, ifirst + leftSize);
        root->right = build(pfirst + leftSize + 1, plast, inRootPos + 1, ilast);

        return root;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
