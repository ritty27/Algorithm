#include <iostream>

int memo[1004] = { 0 };
int fibonacci1(int n) {
	if (n <= 3)
		return n;
	else if (memo[n] != 0) {
		memo[n] %= 10007;
		return memo[n];
	}
	else {
		memo[n] = 2 * fibonacci1(n - 2) + fibonacci1(n - 3);
		memo[n] %= 10007;
		return memo[n];
	}
}

int main() {
	int size, answer;
	scanf("%d", &size);
	answer = fibonacci1(size);
	answer %= 10007;
	printf("%d", answer);
}
