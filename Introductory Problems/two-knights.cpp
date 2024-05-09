#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    ll n;
    cin >> n;

    for (ll k = 1; k <= n; k++) {
        cout << (k*k*(k*k-1)/2) - (4*(k-2)*(k-1)) << "\n";
    }
}