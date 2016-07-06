#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int c = 1;
        vector<int>::reverse_iterator it = digits.rbegin();

        while (c != 0 && it != digits.rend()) {
            *it += c;
            c = *it / 10;
            *it %= 10;
            ++it;
        }

        if (c > 0)
            digits.insert(digits.begin(), 1);

        return digits;
    }
};


int main()
{
    vector<int> digits {9,9,9};
    Solution so;
    for (auto i : so.plusOne(digits))
        cout << i << endl;

    return 0;
}
