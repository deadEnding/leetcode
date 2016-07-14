#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next)
            return head;

        ListNode* p = head->next;
        if (head->val == p->val) {
            while (p && head->val == p->val) {
                ListNode* tmp = p;
                p = p->next;
                delete tmp;
            }
            delete head;
            return deleteDuplicates(p);
        } else {
            head->next = deleteDuplicates(head->next);
            return head;
        }
    }
};


int main()
{
    ListNode *head = NULL, *curr;

    /* 生成链表 */
    for (int i = 0; i < 2; ++i) {
        ListNode* node = new ListNode(1);

        if (head == NULL) {
            head = node;
            curr = node;
        } else {
            curr->next = node;
            curr = curr->next;
        }
    }

    Solution so;
    curr = so.deleteDuplicates(head);

    /* 打印并释放链表 */
    ListNode* tmp;
    while (curr != NULL) {
        tmp = curr;
        cout << curr->val << " ";
        curr = curr->next;
        delete tmp;
    }
    cout << endl;

    return 0;
}
