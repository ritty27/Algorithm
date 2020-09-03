#include <stdio.h>

int main() {
	int num[3] = { 0 } ,count =0,max=1, answer=1;
	for (int i = 0; i < 3; i++) {
		scanf("%d", &num[i]);
	}
	for (int i = 0; i < 3; i++) {
		if (num[i] > max)
			max = num[i];
	}
	for (int i = 0; i < 3; i++) {
		if (num[i] == max)
			count = i;
	}
	num[count] = 0;
	for (int i = 0; i < 3; i++) {
		if (num[i] > answer)
			answer = num[i];
	}
	printf("%d", answer);
}
