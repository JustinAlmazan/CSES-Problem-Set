#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    string s;
    cin >> s;

    char prev = 'x';
    int cnt = 1;
    int max = 1;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == prev) {
            cnt++;
            max = std::max(max, cnt);
        }

        else {
            prev = s[i];
            cnt = 1;
        }
    }

    cout << max;
    
    return 0;
}