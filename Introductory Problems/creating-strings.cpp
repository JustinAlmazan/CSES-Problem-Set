#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
set<string> perms;

void solve(string cur, string rem) {
    if (!rem.length()) {
        perms.insert(cur);
        return;
    }

    for (int i = 0; i < rem.length(); i++) {
        solve(cur + rem[i], rem.substr(0, i) + rem.substr(i + 1));
    }

}

int main() {
    string s;
    cin >> s;

    solve("", s);
    cout << perms.size() << "\n";

    for (auto perm : perms) {
        cout << perm << endl;
    }
}