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

/*
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        rm(head, NULL, head, n);
        return head;
    }

private:
    int r = 0;

    void rm(ListNode*& head, ListNode* prev, ListNode* curr, int n) {
        if (curr == NULL) {
            return;
        }

        rm(head, curr, curr->next, n);
        if ((++r) == n) {
            if (prev == NULL)  // 删除首节点
                head = curr->next;
            else
                prev->next = curr->next;
        }
    }
};
*/

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy(-1);
        dummy.next = head;

        ListNode *p = &dummy;
        ListNode *q = &dummy;

        for (int i = 0; i < n; ++i) {
            p = p->next;
        }

        while (p->next) {
            p = p->next;
            q = q->next;
        }

        ListNode *tmp = q->next;
        q->next = q->next->next;
        delete tmp;

        return dummy.next;
    }
};


int main()
{
    ListNode *head = NULL, *curr;

    /* 生成链表 */
    for (int i = 0; i < 5; ++i) {
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
    curr = so.removeNthFromEnd(head, 5);

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
