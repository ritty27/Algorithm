#include <iostream>
#include <algorithm>

using namespace std;
int main(int argc, char* argv[]) {
	int n, m, count, myMin = 2501;
	char temp;
	cin >> n >> m;
	bool ** board = new bool*[n];
	for(int i=0;i<n;i++){
		board[i] = new bool[m];
	}
	for(int i=0; i< n;i++){
		for(int j=0;j<m;j++){
			cin >> temp;
			if(temp == 'B' || temp == 'b'){
				board[i][j] = 1;
			}
		}
	}
	
	
	for(int i=0;i<n-7;i++){
		for(int j=0;j<m-7;j++){
			count =0;
			for(int a=0;a<8;a++){
				for(int b=0;b<8;b++){
					if((a+b)%2==0){
						if(board[i+a][j+b] == 1){
						count++;
						} 
					}else{
						if(board[i+a][j+b] == 0){
							count++;
						}
					}
					
				}
			}
			count = min(count , 64-count);
			myMin = min(count, myMin);
		}
	}
	cout << myMin;
	
	
}
