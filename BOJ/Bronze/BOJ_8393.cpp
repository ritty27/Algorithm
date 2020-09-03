#include <stdio.h>

int main() {
	int A, sum=0;
	scanf("%d", &A);
	for (int i = 1; i <= A; i++) {
		sum += i;
	}
	printf("%d", sum);
}
