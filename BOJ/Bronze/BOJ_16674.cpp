#include <stdio.h>

int main()
{
	int scanNum, num, printNum, num0=0, num1=0, num2=0, num8=0;
	scanf("%d", &scanNum);
	while (scanNum != 0) {
		num = scanNum % 10;
		scanNum /= 10;
		if (num == 0) {
			num0++;
		}
		else if (num == 1) {
			num1++;
		}
		else if (num == 2) {
			num2++;
		}
		else if (num == 8) {
			num8++;
		}
		else {
			printf("%d\n", 0);
			return 0;
		}
	}
	if (num0*num1*num2*num8 == 0) {
		printf("%d\n", 1);
		return 0;
	}
	if (!(num0 == num1 && num1 == num2 && num2 == num8)) {
		printf("%d\n", 2);
		return 0;
	}
	else
		printf("%d\n", 8);
}
