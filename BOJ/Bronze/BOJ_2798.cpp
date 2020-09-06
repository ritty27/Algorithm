#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
	int n,m,max=0,temp=0;
	cin >> n >> m;
	int * card = new int[n];
	for(int i=0;i<n;i++){
		cin >> card[i];
	}
	
	for(int i =0;i<n-2;i++){
		for(int j=i+1;j<n-1;j++){
			for(int k=j+1;k<n;k++){
				temp = card[i] + card[j] + card[k];
				if(max < temp && temp <= m){
					max = temp;
				}
			}
		}
	}
	cout << max;
	
}
