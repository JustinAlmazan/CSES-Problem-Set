#include <iostream>
#include <bits/stdc++.h>

using namespace std;

const int mod = 1e9 + 7;

int main() 
{
    int n;
    cin >> n;
    
    int perms [1000001];
    
    perms[0] = 1;
    for (int i = 1; i <= 6; i++)
    {
        perms[i] = pow(2, i-1);
    }
    
    for (int i = 7; i <= n; i++)
    {
        for (int j = i - 6; j < i; j++)
        {
            perms[i] = (perms[i] + perms[j]) % mod;
        }
    }
    
    cout << perms[n];
    
}
