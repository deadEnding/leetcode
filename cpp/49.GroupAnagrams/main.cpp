#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <set>

using namespace std;


class Solution {
public:
    vector< vector<string> > groupAnagrams(vector<string>& strs) {
        vector< vector<string> > result;
        unordered_map<string, int > m;

        for (int i = 0; i < strs.size(); ++i) {
            string word = strs[i];
            sort(word.begin(), word.end());
            if (m.find(word) == m.end()) {
                vector<string> vec;
                vec.push_back(strs[i]);
                result.push_back(vec);
                m[word] = result.size() - 1;
            } else {
                result[m[word]].push_back(strs[i]);
            }
        }
        return result;
    }
};

/* 使用multiset */
class MultisetSolution {
public:
    vector< vector<string> > groupAnagrams(vector<string>& strs) {
        vector< vector<string> > result;
        unordered_map<string, multiset<string> > m;

        for (auto str: strs) {
            string word = str;
            sort(word.begin(), word.end());
            m[word].insert(str);
        }

        for (auto item: m) {
            vector<string> v(item.second.begin(), item.second.end());
            result.push_back(v);
        }
        return result;
    }
};


int main()
{
    vector<string> strs {"eat", "tea", "tan", "ate", "nat", "bat"};

    Solution so;
    vector< vector<string> > result = so.groupAnagrams(strs);

    for (auto v: result) {
        for (auto s: v) {
            cout << s << " ";
        }
        cout << endl;
    }


    return 0;
}
