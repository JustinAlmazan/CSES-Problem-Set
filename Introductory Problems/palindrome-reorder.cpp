#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    string s;
    cin >> s;

    int freq[26] = {0};

    for (int i = 0; i < s.length(); i++) {
        freq[s[i] - 'A']++;
    }

    char mid = s.length()%2 ? '1' : '0';

    if (mid == '1') {
        int oddCnt = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2) {
                if (oddCnt) {
                    cout << "NO SOLUTION";
                    return 0;
                }

                oddCnt++;
            }
        }

        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2) {
                oddIndex = i;
                continue;
            }

            for (int j = 1; j <= freq[i]/2; j++) {
                cout << char('A' + i);
            }
        }

        while (freq[oddIndex]--) cout << char('A' + oddIndex);

        for (int i = 25; i >= 0; i--) {
            if (i == oddIndex) continue;
            for (int j = 1; j <= freq[i]/2; j++) {
                cout << char('A' + i);
            }
        }
    }

    else {
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2) {
                cout << "NO SOLUTION";
                return 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= freq[i]/2; j++) {
                cout << char('A' + i);
            }
        }

        for (int i = 25; i >= 0; i--) {
            for (int j = 1; j <= freq[i]/2; j++) {
                cout << char('A' + i);
            }
        }
    }

    return 0;
}