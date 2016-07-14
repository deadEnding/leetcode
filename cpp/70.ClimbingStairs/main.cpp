#include <iostream>
#include <vector>

using namespace std;

/* 递归　f(n) = f(n-1) + f(n-2) */
class Solution {
public:
    int climbStairs(int n) {
        vector<int> f(n, -1);
        return climb(n, f);
    }
private:
    int climb(int i, vector<int>& f) {
        if (i == 1 || i == 2)
            return i;

        if (f[i-1] == -1)
            f[i-1] = climb(i-1, f) + climb(i-2, f);

        return f[i-1];
    }
};

/* 迭代 f(n) = f(n-1) + f(n-2) */
class OtherSolution {
public:
    int climbStairs(int n) {
        int prev = 0;
        int cur = 1;

        for(int i = 1; i <= n ; ++i){
            int tmp = cur;
            cur += prev;
            prev = tmp;
        }
        return cur;
    }
};


int main()
{
    OtherSolution so;
    cout << so.climbStairs(4) << endl;
    return 0;
}
