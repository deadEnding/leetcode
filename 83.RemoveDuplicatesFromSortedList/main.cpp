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
        if (head == NULL)
            return head;

        for (ListNode *prev = head, *cur = head->next; cur; cur = prev->next) {
            if (prev->val == cur->val) {
                prev->next = cur->next;
                delete cur;
            } else {
                prev = cur;
            }
        }
        return head;
    }
};


class OtherSolution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == NULL)
            return head;

        ListNode* ptr = head;
        ListNode* last = head;
        ListNode* tmp = NULL;
        while (ptr->next) {
            if (ptr->next->val != ptr->val) {
                last->next = ptr->next;
                last = last->next;
                ptr = ptr->next;
            } else {
                tmp = ptr->next;
                ptr->next = ptr->next->next;
                delete tmp;
            }

        }
        last->next = NULL;

        return head;
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
