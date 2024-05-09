#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

vector<string> solve(int n) {
    vector<string> res;

    if (n == 1) {
        res.push_back("0");
        res.push_back("1");
    }

    else {
        res = solve(n - 1);
        vector<string> rev;

        for (int i = res.size() - 1; i >= 0; i--) rev.push_back(res[i]);

        for (int i = 0; i < res.size(); i++) {
            res[i].append("0");
            rev[i].append("1");
        }

        res.insert(res.end(), rev.begin(), rev.end());
    }

    return res;
}

int main() {
    int n;
    cin >> n;

    vector<string> res = solve(n);
    for (auto code : res) cout << code << "\n";
}