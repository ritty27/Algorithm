#include <iostream>

int main() {
	int num;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		if (num % 2 == 1) {
			printf("* ");
		}
		for (int j = 0; j < num / 2; j++) {
			printf("* ");
		}
		printf("\n");
		for (int j = 0; j < num / 2; j++) {
			printf(" *");
		}
		if(num!=1)printf("\n");
	}
}
