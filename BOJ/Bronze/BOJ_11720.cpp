#include <stdio.h>
int main() {
	int A, B, sum=0;
	scanf("%d", &A);
	for (int i = 0; i < A; i++) {
		scanf("%1d", &B);
		sum += B;
	}
	printf("%d", sum);
}
