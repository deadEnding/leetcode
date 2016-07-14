#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Item
{
    int index;
    int val;
};

bool comparison(const Item &a, const Item &b)
{
    return a.val < b.val;
}

class CmpClass
{
public:
   static struct _CompareIntField
   {
      bool operator() (const Item & left, int right)
      {
        return left.val < right;
      }
   } CompareIntField;
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<Item> items;
        buildAndSort(nums, items);
        int mini = target - items.back().val;
        int xy[2];
        vector<int> result;
        vector<Item>::iterator start, dest;
        start = items.begin();
        for (vector<Item>::size_type ix=0; ix!=(items.size() -1); ++ix)
        {
            if (items[ix].val >= mini)
            {
                dest = lower_bound(items.begin() + ix + 1, items.end(), target - items[ix].val, CmpClass::CompareIntField);
                if ((*dest).val + items[ix].val == target)
                {
                    result.push_back(items[ix].index);
                    result.push_back((*dest).index);
                    sort(result.begin(), result.end());
                    break;
                }
            }
        }
        return result;
    }

    void buildAndSort(vector<int>& nums, vector<Item>& items)
    {
        for (vector<int>::size_type ix=0; ix!=nums.size(); ++ix)
        {
            Item item;
            item.index = ix;
            item.val = nums[ix];
            items.push_back(item);
        }
        sort(items.begin(), items.end(), comparison);
    }
};


int main() {
    vector<int> nums;
    int n, sum, ele;

    cin >> n >> sum;
    while (n--) {
        cin >> ele;
        nums.push_back(ele);
    }

    Solution solu;
    vector<int> result = solu.twoSum(nums, sum);

    cout << result[0] << endl;
    cout << result[1] << endl;

    return 0;
}
