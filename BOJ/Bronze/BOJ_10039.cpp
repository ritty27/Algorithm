#include <stdio.h>
int main() {
	int sum=0, average, score[5];
	for (int i = 0; i < 5; i++) {
		scanf("%d", &score[i]);
		if (40 > score[i]) {
			score[i] = 40;
		}
		sum += score[i];
	}
	average = sum / 5;
	printf("%d", average);
}
