#include <stdio.h>
int main(void) {
	int A, B;
	scanf("%d", &A);
	B = A % 15;
	if (A == 4 | A == 7) {
		printf("-1");
	}
	else if (B == 1 | B == 3 | B == 5) {
		printf("%d", A / 15*3 + 1);
	}
	else if (B == 2 | B == 4 | B == 6 | B == 8 | B == 10) {
		printf("%d", A / 15 * 3 +2);
	}
	else if (B == 7 | B == 9 | B == 11 | B == 13) {
		printf("%d", A / 15 * 3 +3);
	}
	else if (B == 12 | B == 14) {
		printf("%d", A / 15 * 3 +4);
	}
	else if (B == 0) {
		printf("%d", A / 5);
	}
}
