#include <iostream>

int main() {
	int num,answer = 0;
	int number[3] = { 0 };
	scanf("%d", &num);
	if (num <= 99) {
		answer = num;
	}
	else if (num <= 1000) {
		answer = 99;
		for (int i = 100; i <= num; i++) {
			number[0] = i / 100;
			number[1] = (i - number[0] * 100) / 10;
			number[2] = (i - number[0] * 100 - number[1] * 10);
			//printf("%d %d %d", number[0], number[1], number[2]);

			if (number[0] - number[1] == number[1] - number[2]) {
				answer++;
			}
		}
	}
	printf("%d", answer);
}
