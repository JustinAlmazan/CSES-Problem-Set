#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

// Using unordered_set does not 

int main() {
    int n;
    vector<int> v;

    cin >> n;
    int cnt = n;

    while (n--) {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    int prev = 0;

    for (int a : v) {
        if (a == prev) cnt--;
        prev = a;
    }

    cout << cnt << endl;

    return 0;
}