#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    int n;
    cin >> n;

    bool a[n+1] = {false};

    for (int i = 0; i < n - 1; i++) {
        int cur;
        cin >> cur;

        a[cur] = true;
    }

    for (int i = 1; i <= n; i++) {
        if (!a[i]) {
            cout << i;
            break;
        }
    }

    return 0;
}