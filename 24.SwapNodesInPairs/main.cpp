#include <iostream>

using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head == NULL)
            return head;

        ListNode dummy(-1);
        dummy.next = head;

        ListNode *p = &dummy;
        ListNode *tmp = NULL;

        while (p->next != NULL && p->next->next != NULL) {
            tmp = p->next->next;
            p->next->next = tmp->next;
            tmp->next = p->next;
            p->next = tmp;
            p = p->next->next;
        }

        return dummy.next;
    }
};


int main()
{
    ListNode *head = NULL, *curr;

    /* 生成链表 */
    for (int i = 0; i < 6; ++i) {
        ListNode* node = new ListNode(i);

        if (head == NULL) {
            head = node;
            curr = node;
        } else {
            curr->next = node;
            curr = curr->next;
        }
    }

    Solution so;
    curr = so.swapPairs(head);

    /* 打印并释放链表 */
    ListNode* tmp;
    while (curr != NULL) {
        tmp = curr;
        cout << curr->val << endl;
        curr = curr->next;
        delete tmp;
    }

    return 0;
}
