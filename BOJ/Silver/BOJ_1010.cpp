#include <iostream>

int comb(int n, int m){
	int answer=1;
	if (n == 0 || m == 0 || n == m){
		answer = 1;
	}
	else{
		for (int i = 0; i < n - m; i++){
			answer = answer *  (n - i) / (i + 1);
		}
	}
	return answer;
}


int main(){
	int testNum, N, M;
	scanf("%d", &testNum);
	for (int i = 0; i < testNum; i++){
		scanf("%d %d", &N, &M);
		printf("%d\n", comb(M,N));
	}
}
