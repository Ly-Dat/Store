#include <bits/stdc++.h>
#include <vector>
using namespace std;
const int maxn =10000000;
vector<bool> nt(maxn+1,true);
void sang() {
    // memset(nt,true,sizeof(nt));
    nt[0]=nt[1]=false;
    for(int i=2; i<=sqrt(maxn);i++){
        if(nt[i]){
            for(int j=i*i; j<=maxn;j+=i){
                nt[j]=false;
            }
        }
    }
}
int main(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    
    // code
    sang();
    for(int i=0;i<=100;i++){
        if(nt[i]) {
            cout<<i<<" ";
        }
    }
    return 0;
}