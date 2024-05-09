#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;

        if (std::max(a, b) > 2*std::min(a, b) || (a+b) % 3) cout << "NO\n";
        else cout << "YES\n";
    }
}