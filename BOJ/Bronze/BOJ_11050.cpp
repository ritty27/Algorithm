#include <iostream>
#include <algorithm>

using namespace std;
int main(int argc, char* argv[]) {
	int n=0, k=0;
	cin >> n >> k;
	int ** combination = new int*[n+1];
	for(int i=0;i<n+1;i++){
		combination[i] = new int[k+1];
	}
	fill(&combination[0][0],&combination[n][k+1],1);
	
	for(int i=1;i<n+1;i++){
		for(int j=1;j<k+1;j++){
			if(j!=i && j != 0){
				
				combination[i][j] = combination[i-1][j-1] + combination[i-1][j]	;
			}
		}
	}
	cout << combination[n][k];
	
	
}
