#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
    ll n;
    cin >> n;

    if ((n*(n+1)/2)%2) cout << "NO";
    else {
        cout << "YES\n";

        vector<int> s1;
        vector<int> s2;

        ll half = (n*(n+1))/4;

        while (n) {
            if (half - n >= 0) {
                s1.push_back(n);
                half -= n;
            }

            else {
                s2.push_back(n);
            }

            n--;
        }

        cout << s1.size() << "\n";
        for (int i = s1.size() - 1; i >= 0; i--) cout << s1[i] << " ";
        cout << "\n";

        cout << s2.size() << "\n";
        for (int i = s2.size() - 1; i >= 0; i--) cout << s2[i] << " ";
    }
}