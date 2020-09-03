#include <stdio.h>

int main() {
	int num1, num2, afterNum1 = 0, afterNum2 = 0;
	scanf("%d", &num1);
	scanf("%d", &num2);
	for (int i = 0; i < 3; i++) {
		afterNum1 *= 10;
		afterNum1 += num1 % 10;
		num1 /= 10;
	}
	for (int i = 0; i < 3; i++) {
		afterNum2 *= 10;
		afterNum2 += num2 % 10;
		num2 /= 10;
	}
	if (afterNum1 > afterNum2) {
		printf("%d", afterNum1);
	}
	else printf("%d", afterNum2);
}
