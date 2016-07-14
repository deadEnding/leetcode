#include <iostream>
#include <queue>

using namespace std;

struct TreeLinkNode {
    TreeLinkNode *left;
    TreeLinkNode *right;
    TreeLinkNode *next;
};


class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root)
            return;

        TreeLinkNode dummy(-1);
        for (TreeLinkNode *prev = &dummy, *curr = root; curr; curr = curr->next) {
            if (curr->left) {
                prev->next = curr->left;
                prev = prev->next;
            }
            if (curr->right) {
                prev->next = curr->right;
                prev = prev->next;
            }
        }
        connect(dummy.next);
    }
};


class IterSolution {
public:
    void connect(TreeLinkNode *root) {
        while (root) {
            TreeLinkNode* next = NULL;
            TreeLinkNode* prev = NULL;

            for (; root; root = root->next) {
                if (!next)
                    next = root->left ? root->left : root->right;

                if (root->left) {
                    if (prev)
                        prev->next = root->left;
                    prev = root->left;
                }

                if (root->right) {
                    if (prev)
                        prev->next = root->right;
                    prev = root->right;
                }
            }
            root = next;
        }
    }
};


class OtherSolution {
public:
    void connect(TreeLinkNode *root) {
        if (!root)
            return;

        TreeLinkNode* prev = NULL;
        TreeLinkNode* curr = NULL;
        queue<TreeLinkNode*> q;
        q.push(NULL);
        q.push(root);

        while (!q.empty()) {
            curr = q.front();
            q.pop();

            if (prev)
                prev->next = curr;

            prev = curr;

            if (!curr) {
                if (q.empty()) {
                    break;
                } else {
                    q.push(NULL);
                    continue;
                }
            }

            if (curr->left)
                q.push(curr->left);
            if (curr->right)
                q.push(curr->right);
        }
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
