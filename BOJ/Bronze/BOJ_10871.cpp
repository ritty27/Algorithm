#include <stdio.h>
int main() {
	int N = 0, X = 0, A[10001] = { 0 };
	scanf("%d %d", &N, &X);
	for (int i = 0; i < N; i++) {
		scanf("%d", &A[i]);
		if (X > A[i]) {
			printf("%d ", A[i]);
		}
	}
}
