#include <iostream>

int main() {
	int num;
	int answer = 0;
	scanf("%d", &num);
	if (num == 1) {
		answer = 1;
	}
	while (num > 1) {
		if (num % 2 == 0) {
			num /= 2;
			if (num == 1) {
				answer = 1;
				break;
			}
		} 
		else{
			answer = 0;
			break;
		}
	}
	printf("%d", answer);
}
