#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.empty())
            return false;

        const int m = board.size();
        const int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(i, j, 0, board, visited, word))
                    return true;
            }
        }
        return false;
    }

private:
    bool dfs(int x, int y, int k, vector<vector<char>>& board, vector<vector<bool>>& visited, string& word) {
        if (k == word.size())
            return true;

        // 越界
        if (x < 0 || y < 0 || x >= board.size() || y >= board[0].size())
            return false;

        // 访问过 或 不匹配
        if (visited[x][y] || board[x][y] != word[k])
            return false;

        visited[x][y] = true;
        bool ret = dfs(x+1, y, k+1, board, visited, word) ||
                   dfs(x-1, y, k+1, board, visited, word) ||
                   dfs(x, y+1, k+1, board, visited, word) ||
                   dfs(x, y-1, k+1, board, visited, word);
        visited[x][y] = false;

        return ret;
    }
};


class OtherSolution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.empty())
            return false;

        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> used(m, vector<bool>(n, false));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exist(i, j, 0, board, used, word))
                    return true;
            }
        }
        return false;
    }

private:
    vector<vector<int>> d{{1,0}, {-1,0}, {0,1}, {0,-1}};

    bool exist(int i, int j, int k, vector<vector<char>>& board, vector<vector<bool>>& used, string& word) {
        if (board[i][j] != word[k])
            return false;

        used[i][j] = true;

        if (k+1 == word.size())
            return true;

        for (int ix = 0; ix < 4; ++ix) {
            int a = i + d[ix][0];
            int b = j + d[ix][1];
            if (a >= 0 && a < board.size() && b >= 0 && b < board[0].size() && !used[a][b]) {
                if (exist(a, b, k+1, board, used, word))
                    return true;
            }
        }
        used[i][j] = false;

        return false;
    }
};


int main()
{
    vector<vector<char>> board{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
    //vector<vector<char>> board{{'A'}};
    Solution so;
    cout << so.exist(board, "ABC") << endl;
    return 0;
}
