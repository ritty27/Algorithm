#include <iostream>

int main() {
	long long num;
	scanf("%lld", &num);
	if (num % 2 == 0) {
		printf("CY");
	}
	else if (num % 2 == 1) {
		printf("SK");
	}
}
