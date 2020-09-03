#include <stdio.h>

int fibonacci(int n) {
	static int num[41] = { 0 };
	if (num[n] > 0) return num[n];
	if (n == 0) return 0;
	if (n == 1 || n == 2) return 1;
	return num[n] = fibonacci(n - 2) + fibonacci(n - 1);
}


int main() {
	int count, input;
	scanf("%d", &count);

	for (int i = 0; i < count; ++i) {
		scanf("%d", &input);
		if (input == 0) printf("1 0\n");
		else printf("%d %d\n", fibonacci(input - 1), fibonacci(input));
	}

	
}
