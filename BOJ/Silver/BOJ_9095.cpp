#include <iostream>

int fibo(int n) {
	if (n == 1 || n == 2) {
		return n;
	}
	else if (n == 3) {
		return 4;
	}
	else {
		return fibo(n - 1) + fibo(n - 2) + fibo(n - 3);
	}
}

int main() {
	int testNum,num,answer;
	scanf("%d", &testNum);
	for (int i = 0; i < testNum; i++) {
		scanf("%d", &num);
		answer = fibo(num);
		printf("%d\n", answer);
	}
}
