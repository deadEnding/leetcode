#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* rhead = NULL;
        ListNode* tmp = NULL;
        for (ListNode* cur = head; cur;) {
            tmp = cur;
            cur = cur->next;
            tmp->next = rhead;
            rhead = tmp;
        }
        return rhead;
    }
};


// 头插法
class OtherSolution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head)
            return NULL;

        ListNode dummy(-1);
        dummy.next = head;
        ListNode* last = head;
        ListNode* cur = head->next;

        while (cur) {
            last->next = cur->next;
            cur->next = dummy.next;
            dummy.next = cur;
            cur = last->next;
        }
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

    OtherSolution so;
    curr = so.reverseList(head);

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
