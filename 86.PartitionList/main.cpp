#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode left_dummy(-1);
        ListNode right_dummy(-1);

        ListNode* left = &left_dummy;
        ListNode* right = &right_dummy;

        for(ListNode* cur = head; cur; cur = cur->next) {
            if (cur->val < x) {
                left->next = cur;
                left = left->next;
            } else {
                right->next = cur;
                right = right->next;
            }
        }

        left->next = right_dummy.next;
        right->next = NULL;

        return left_dummy.next;
    }
};


class OtherSolution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode dummy(-1);
        dummy.next = head;

        ListNode *p = &dummy;
        ListNode *q = NULL;
        ListNode *tmp = NULL;

        while (p->next) {
            if (p->next->val >= x)
                break;
            p = p->next;
        }

        q = p->next;
        while (q && q->next) {
            if (q->next->val < x) {
                tmp = q->next;
                q->next = q->next->next;
                tmp->next = p->next;
                p->next = tmp;
                p = p->next;
            } else {
                q = q->next;
            }
        }

        return dummy.next;
    }
};


int main()
{
    ListNode *head = NULL, *curr;
    int a[] = {3,1,2};

    /* 生成链表 */
    for (int i = 0; i < 3; ++i) {
        ListNode* node = new ListNode(a[i]);

        if (head == NULL) {
            head = node;
            curr = node;
        } else {
            curr->next = node;
            curr = curr->next;
        }
    }

    Solution so;
    curr = so.partition(head, 3);

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
