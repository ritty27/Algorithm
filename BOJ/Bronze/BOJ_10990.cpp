#include <iostream>

int main() {
	int num;
	scanf("%d", &num);
	
	for (int i = 0; i < num; i++) {
		for (int j = 1; j < num-i; j++) {
			printf(" ");
		}
		printf("*");
		for (int j = 0; j < 2*i-1; j++) {
			printf(" ");
		}
		if (i == 0) printf("\n");
		else printf("*\n");
	}
}
