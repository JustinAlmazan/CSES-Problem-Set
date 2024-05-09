#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

char c[8][8];

int solve(int row, bool col[], bool pd[], bool nd[]) {
    if (row == 8) return 1;

    int res = 0;

    for (int i = 0; i < 8; i++) {
        if (c[row][i] == '.' && !col[i] && !pd[i-row+7] && !nd[i+row]) {
            col[i] = true;
            pd[i-row+7] = true;
            nd[i+row] = true;

            res += solve(row + 1, col, pd, nd);

            col[i] = false;
            pd[i-row+7] = false;
            nd[i+row] = false;
        }
    }

    return res;
}

int main() {
    for (int i = 0; i < 8; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < 8; j++) {
            c[i][j] = s[j];
        }
    }

    bool col[8] = {false}, pd[15] = {false}, nd[15] = {false};

    cout << solve(0, col, pd, nd);
}