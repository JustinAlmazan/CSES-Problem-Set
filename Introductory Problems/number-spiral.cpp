#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    int T;
    cin >> T;

    while (T--) {
        ll x, y;
        cin >> x >> y;

        ll max = std::max(x, y);
        ll diag = max*max - max + 1;

        if (x == y) {
            cout << diag;
        }

        else if (x < y) {
            if (y%2) cout << diag + (y - x);
            else cout << diag - (y - x);
        }

        else {
            if (x%2) cout << diag - (x - y);
            else cout << diag + (x - y);
        }

        cout << "\n";
    }
}