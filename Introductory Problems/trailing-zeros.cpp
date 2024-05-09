#include <iostream>
using namespace std;

typedef long long ll;

int main() {
    ll n;
    cin >> n;

    ll n1 = n, twos = 0, fives = 0, numIter = 1;

    while (n1/2) {
        n1/=2;
        twos += n1*numIter;
        numIter++;
    }

    n1 = n;
    numIter = 1;

    while (n1/5) {
        n1/=5;
        fives += n1*numIter;
    }

    cout << std::min(twos, fives);
}