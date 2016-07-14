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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return build(inorder.begin(), inorder.end(), postorder.begin(), postorder.end());
    }
private:
    template<typename Iter>
    TreeNode* build(Iter ifirst, Iter ilast, Iter pfirst, Iter plast) {
        if (ifirst == ilast || pfirst == plast)
            return NULL;

        Iter inRootPos = find(ifirst, ilast, *(plast-1));
        int leftSize = distance(ifirst, inRootPos);

        TreeNode* root = new TreeNode(*(plast-1));
        root->left = build(ifirst, ifirst + leftSize, pfirst, pfirst + leftSize);
        root->right = build(inRootPos + 1, ilast, pfirst + leftSize, plast - 1);

        return root;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
