#include <stdio.h>
int main() {
	int qq, answer, A, B, C;
	int count[10] = { 0 };
	scanf("%d %d %d", &A, &B, &C);
	answer = A * B* C;
	for (int i = 0; i < 10; i++) {
		qq = answer % 10;
		for (int j = 0; j < 10; j++) {
			if (qq == j) {
				count[j]++;
			}
		}
		answer /= 10;
		if (answer == 0)
			break;
	}
	for (int i = 0; i < 10; i++) {
		printf("%d\n",count[i]);
	}
}
