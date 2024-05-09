#include <iostream>
using namespace std;

typedef long long ll;
const long MOD = 1e9 + 7;

int main() {
    int n;
    cin >> n;

    ll res = 1;

    for (int i = 1; i <= n; i++) {
        res = (2*res) % MOD;
    }

    cout << res;
}