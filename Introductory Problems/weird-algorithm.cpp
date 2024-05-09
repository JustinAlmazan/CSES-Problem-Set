#include <iostream> 
using namespace std; 

typedef long long ll;
  
int main() 
{ 
    ll n;
    cin >> n;

    while (n > 1) {
        cout << n << " ";
        n = (n%2 ? 3*n+1 : n/2);
    }

    cout << 1;
    return 0; 
} 