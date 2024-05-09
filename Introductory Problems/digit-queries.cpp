#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int solve(ll k) {
    ll d = 9;
    ll numDigits = 1;

    while (k - d*numDigits > 0) {
        k -= d*numDigits;
        d *= 10;
        numDigits++;
    }

    ll index = k % numDigits;
    ll res = pow(10, numDigits - 1) + (k - 1)/numDigits;

    if (index != 0) res /= pow(10, numDigits - index);
    return (res % 10);
}

int main() {
    int q;
    cin >> q;

    while (q--) {
        ll k;
        cin >> k;

        cout << solve(k) << endl;
    }

    return 0;
}