#include <iostream>
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(int n, int start, int end);

int main() {
    int n;
    cin >> n;

    cout << pow(2, n) - 1 << "\n";
    solve(n, 1, 3);
}

void solve(int n, int start, int end) {
    if (n == 1) cout << start << " " << end << "\n";
    else {
        int other = 6 - start - end;
        solve(n - 1, start, other);
        cout << start << " " << end << "\n";
        solve(n - 1, other, end);
    }
}