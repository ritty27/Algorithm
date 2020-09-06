#include <iostream>
#include <algorithm>


using namespace std;
int main(int argc, char* argv[]) {
	int n,m,repeat;
	int member[15][15] = {0};
	for(int i=0;i<14;i++){
		member[0][i+1] = i+1;
		member[i][1] = 1;
	}
	
	for(int i=1;i<15;i++){
		for(int j=1;j<15;j++){
			member[i][j] = member[i][j-1] + member[i-1][j];
		}
	}
	
	cin >> repeat;
	for(int i =0; i < repeat ;i++){
		cin >> n >> m;
		cout << member[n][m] << endl;
	}
	
}
