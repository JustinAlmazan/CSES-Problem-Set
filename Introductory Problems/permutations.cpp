#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    int n;
    cin >> n;

    if (1 < n && n < 4) {
        cout << "NO SOLUTION";
        return 0;
    }

    for (int i = 2; i <= n; i++) {
        cout << i << " ";
        i++;
    }

    for (int i = 1; i <= n; i++) {
        cout << i << " ";
        i++;
    }

    return 0;
}