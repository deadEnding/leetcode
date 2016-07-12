#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode dummy(-1);
        dummy.next = head;

        ListNode* prev = &dummy;
        for (int i = 1; i < m; ++i)
            prev = prev->next;
        ListNode* const before = prev; // before为第m-1元素（dummy为第0元素）

        prev = prev->next; // prev为第m元素
        ListNode* cur = prev->next;
        // 头插法将第[m+1:n]的元素插入
        for (int i = m+1; i <= n; ++i) {
            prev->next = cur->next;
            cur->next = before->next;
            before->next = cur;
            cur = prev->next;
        }
        return dummy.next;
    }
};


int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
