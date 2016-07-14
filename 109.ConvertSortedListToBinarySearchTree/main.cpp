#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/* 自底向上 */
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        int len = 0;
        ListNode* p = head;

        while (p) {
            ++len;
            p = p->next;
        }
        return sortedListToBST(head, 0, len - 1);
    }
private:
    TreeNode* sortedListToBST(ListNode*& head, int start, int end) {
        if (start > end)
            return NULL;

        int mid = (start + end) / 2;
        TreeNode* left = sortedListToBST(head, start, mid - 1);
        TreeNode* root = new TreeNode(head->val);
        root->left = left;
        head = head->next;
        root->right = sortedListToBST(head, mid + 1, end);

        return root;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
