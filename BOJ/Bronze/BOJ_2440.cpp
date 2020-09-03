#include <stdio.h>

int main() {
	int A;
	scanf("%d", &A);
	for (int i=0;i<A;i++) {
		for (int j = 0; j < A-i; j++) {
			printf("*");
		}
		printf("\n");
	}
}
