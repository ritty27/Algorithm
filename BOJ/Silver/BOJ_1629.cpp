#include <stdio.h>

int multiply(long long num1, long long num2, long long  num3) {
	if (num2 == 0) {
		return 1;
	}
	else if (num2 % 2 == 0) {
		return multiply(num1*num1%num3, num2 / 2, num3) % num3;
	}
	else {
		return num1 * multiply(num1*num1% num3, num2 / 2, num3) % num3;
	}
}

int main() {
	long long  numA, numB, numC, answer;
	scanf("%lld %lld %lld", &numA, &numB, &numC);
	answer = multiply(numA, numB, numC) % numC;
	printf("%lld", answer);
}

