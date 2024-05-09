#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll solve(int index, vector<ll> v, ll s1, ll s2, int n);

int main() {
    int n;
    cin >> n;

    vector<ll> v;
    while (n--) {
        ll a;
        cin >> a;
        v.push_back(a);
    }

    cout << solve(0, v, 0, 0, v.size());
}

ll solve(int index, vector<ll> v, ll s1, ll s2, int n) {
    if (index == n) return std::abs(s1 - s2);

    ll select = solve(index + 1, v, s1 + v[index], s2, n);
    ll leave = solve(index + 1, v, s1, s2 + v[index], n);

    return (ll) std::min(select, leave);
}