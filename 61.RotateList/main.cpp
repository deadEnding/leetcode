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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL || k == 0)
            return head;

        ListNode* p = head;

        /* 求链表长度 */
        int len = 1;
        while (p->next) {
            ++len;
            p = p->next;
        }


        k = len - k % len;
        p->next = head;  // 首尾相连
        while (k--)
            p = p->next;

        head = p->next;
        p->next = NULL;

        return head;
    }
};

class OtherSolution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL)
            return head;

        int len = 0;
        ListNode* p = head;

        while (p) {
            ++len;
            p = p->next;
        }

        k = k % len;

        p = head;
        ListNode* q = head;
        while (k--)
            p = p->next;

        while (p->next) {
            p = p->next;
            q = q->next;
        }
        p->next = head;
        head = q->next;
        q->next = NULL;

        return head;
    }
};


int main()
{
    ListNode *head = NULL, *curr;

    /* 生成链表 */
    for (int i = 1; i <= 10; ++i) {
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
    curr = so.rotateRight(head, 2);

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
