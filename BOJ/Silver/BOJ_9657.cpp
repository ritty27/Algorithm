#include <iostream>

int main() {
	int num;
	scanf("%d", &num);
	if (num % 7 == 1 || num % 7 == 3 || num % 7 == 4 || num % 7 == 5 || num % 7 == 6) {
		printf("SK");
	}
	else if (num % 7 == 0 || num % 7 == 2) {
		printf("CY");
	}
}
