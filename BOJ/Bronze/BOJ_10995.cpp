#include <iostream>

int main() {
	int num;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		if (i % 2 == 1) {
			printf(" ");
		}
		for (int j = 0; j < num; j++) {
			printf("* ");
		}
		printf("\n");
	}
}
