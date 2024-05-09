#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    int n;
    cin >> n;

    int max = -1;
    ll res = 0;

    for (int i = 0; i < n; i++) {
        int cur;
        cin >> cur;

        if (cur < max) {
            res += max - cur;
        }

        else {
            max = cur;
        }
    }

    cout << res;
    return 0;
}